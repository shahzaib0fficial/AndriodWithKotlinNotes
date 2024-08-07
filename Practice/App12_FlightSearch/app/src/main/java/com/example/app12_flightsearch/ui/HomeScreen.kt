package com.example.app12_flightsearch.ui

import android.content.pm.PackageManager
import android.speech.SpeechRecognizer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.core.content.ContextCompat
import android.Manifest.permission.RECORD_AUDIO
import android.content.Intent
import android.os.Bundle
import android.speech.RecognitionListener
import android.speech.RecognizerIntent
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import androidx.compose.foundation.layout.size
import androidx.compose.ui.res.painterResource
import com.example.app12_flightsearch.R

@Composable
fun HomeScreen(requestPermissionLauncher: ActivityResultLauncher<String>){
    var searchValue by rememberSaveable {
        mutableStateOf("")
    }

    val context = LocalContext.current

    fun startListening() {
        if (ContextCompat.checkSelfPermission(context, RECORD_AUDIO) == PackageManager.PERMISSION_GRANTED) {
            Toast.makeText(context, "Speak now", Toast.LENGTH_SHORT).show()
            val intent = Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH).apply {
                putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, RecognizerIntent.LANGUAGE_MODEL_FREE_FORM)
                putExtra(RecognizerIntent.EXTRA_PROMPT, "Speak now")
            }
            val speechRecognizer = SpeechRecognizer.createSpeechRecognizer(context)
            speechRecognizer.setRecognitionListener(object : RecognitionListener {
                override fun onReadyForSpeech(params: Bundle?) {}
                override fun onBeginningOfSpeech() {}
                override fun onRmsChanged(rmsdB: Float) {}
                override fun onBufferReceived(buffer: ByteArray?) {}
                override fun onEndOfSpeech() {}
                override fun onError(error: Int) {
                    Toast.makeText(context, "Speech recognition error: $error", Toast.LENGTH_SHORT).show()
                }
                override fun onResults(results: Bundle?) {
                    val matches = results?.getStringArrayList(SpeechRecognizer.RESULTS_RECOGNITION)
                    searchValue = matches?.firstOrNull() ?: ""
                }
                override fun onPartialResults(partialResults: Bundle?) {}
                override fun onEvent(eventType: Int, params: Bundle?) {}
            })
            speechRecognizer.startListening(intent)
        } else {
            // Request permission
            requestPermissionLauncher.launch(RECORD_AUDIO)
        }
    }

    TextField(
        value = searchValue,
        onValueChange = {
            searchValue = it
        },
        singleLine = true,
//        maxLines = 1,
        placeholder = {
            Text(
                text = "Search Flight Here...",
                color = Color(0xFFFFFFFF)
            )
        },
        leadingIcon = {
            IconButton(onClick = { /* TODO */ }) {
                Icon(
                    imageVector = Icons.Default.Search,
                    contentDescription = null,
                    tint = Color(0xFFFFFFFF),
                    modifier = Modifier
                        .size(24.dp)
                )
            }
        },
        trailingIcon = {
            IconButton(onClick = { startListening() }) {
                Icon(
                    painter = painterResource(id = R.drawable.microphoneicon),
                    contentDescription = null,
                    tint = Color(0xFFFFFFFF),
                    modifier = Modifier
                        .size(24.dp)
                )
            }
        },
        colors = TextFieldDefaults.colors(
            unfocusedContainerColor = Color(0xFF87CEEB),
            focusedContainerColor = Color(0xFF87CEEB),
            unfocusedTextColor = Color(0xFFFFFFFF),
            focusedTextColor = Color(0xFFFFFFFF),
            cursorColor = Color(0xFFFFFFFF),
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent
        ),
        shape = RoundedCornerShape(30.dp),
        modifier = Modifier
            .padding(10.dp)
            .fillMaxWidth()
    )
}
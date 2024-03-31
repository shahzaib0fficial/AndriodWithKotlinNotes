package com.example.app1_imageandtext

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.Role.Companion.Image
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.app1_imageandtext.ui.theme.App1_ImageAndTextTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            App1_ImageAndTextTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    App()
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Composable
fun ContentOfComputerScience(){
    val IntroHeading = "What is Computer Science?"
    val ComputerText = AnnotatedString.Builder().apply {
        append("Computing is part of everything we do. Computing drives innovation in engineering, business, entertainment, education, and the sciences—and it provides solutions to complex, challenging problems of all kinds.\n\n")
        pushStyle(SpanStyle(fontWeight = FontWeight.Bold , color = Color.DarkGray))
        append("Computer science")
        pop()
        append(" is the study of computers and computational systems. It is a broad field which includes everything from the algorithms that make up software to how software interacts with hardware to how well software is developed and designed. ")
        pushStyle(SpanStyle(fontWeight = FontWeight.Bold , color = Color.DarkGray))
        append("Computer scientists")
        pop()
        append(" use various mathematical algorithms, coding procedures, and their expert programming skills to study computer processes and develop new software and systems.")
    }.toAnnotatedString()

    Column() {
        Text(
            text = IntroHeading,
            fontSize = 24.sp,
            lineHeight = 24.sp,
            color = Color.DarkGray,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .padding(16.dp)
        )
        Text(
            text = ComputerText,
            fontSize = 16.sp,
            lineHeight = 16.sp,
            color = Color.LightGray,
            textAlign = TextAlign.Justify,
            modifier = Modifier
                .padding(16.dp)
        )
    }
}

@Composable
fun App(){
    val image = painterResource(R.drawable.computer)
    Column {
        Image(
            painter = image,
            contentDescription = null,
            contentScale = ContentScale.FillWidth
        )
        ContentOfComputerScience()
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    App1_ImageAndTextTheme {
        App()
    }
}
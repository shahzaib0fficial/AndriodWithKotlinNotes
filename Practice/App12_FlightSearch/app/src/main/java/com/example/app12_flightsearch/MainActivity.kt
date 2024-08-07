package com.example.app12_flightsearch

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.app12_flightsearch.ui.theme.App12_FlightSearchTheme
import com.example.app12_flightsearch.ui.theme.FlightApp

class MainActivity : ComponentActivity() {
    private lateinit var requestPermissionLauncher: ActivityResultLauncher<String>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        requestPermissionLauncher = registerForActivityResult(
            ActivityResultContracts.RequestPermission()
        ) { isGranted: Boolean ->
            if (isGranted) {
                // Permission granted
            } else {
                // Permission denied
                Toast.makeText(this, "Go to Settings>Permissions and allow access to microphone", Toast.LENGTH_LONG).show()
            }
        }
        setContent {
            App12_FlightSearchTheme {
                FlightApp(requestPermissionLauncher = requestPermissionLauncher)
            }
        }
    }
}
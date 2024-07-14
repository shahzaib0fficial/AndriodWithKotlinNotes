package com.example.app9_sports

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.Surface
import androidx.compose.material3.windowsizeclass.ExperimentalMaterial3WindowSizeClassApi
import androidx.compose.material3.windowsizeclass.calculateWindowSizeClass
import com.example.app9_sports.ui.theme.App9_SportsTheme

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3WindowSizeClassApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            App9_SportsTheme {
                Surface(onClick = { /*TODO*/ }) {
                    val windowSize = calculateWindowSizeClass(this)
                    SportApp(windowWidth = windowSize.widthSizeClass)
                }
            }
        }
    }
}
package com.example.app14_testadapp

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.app14_testadapp.ui.theme.App14_TestAdAppTheme
import com.google.android.gms.ads.AdError
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.FullScreenContentCallback
import com.google.android.gms.ads.LoadAdError
import com.google.android.gms.ads.interstitial.InterstitialAd
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback

class MainActivity : ComponentActivity() {
    private var interstitialAd: InterstitialAd? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        // Load the ad
        loadInterstitialAd()
        setContent {
            App14_TestAdAppTheme{

            }
        }
    }

    private fun loadInterstitialAd() {
        InterstitialAd.load(
            this,
            "ca-app-pub-3940256099942544/1033173712", // Replace with your actual Ad Unit ID
            AdRequest.Builder().build(),
            object : InterstitialAdLoadCallback() {
                override fun onAdLoaded(ad: InterstitialAd) {
                    Log.e("AdMob", "Ad successfully show")
                    interstitialAd = ad
                    showAd()
                }

                override fun onAdFailedToLoad(adError: LoadAdError) {
                    Log.e("AdMob", "Ad failed to show: ${adError.message}")
                    interstitialAd = null
                    // Proceed with main content if ad fails to load
                    proceedToMainContent()
                }
            }
        )
    }

    private fun showAd() {
        interstitialAd?.let { ad ->
            ad.fullScreenContentCallback = object : FullScreenContentCallback() {
                override fun onAdDismissedFullScreenContent() {
                    // Continue to main content
                    proceedToMainContent()
                }

                override fun onAdFailedToShowFullScreenContent(adError: AdError) {
                    // Handle ad failure
                    proceedToMainContent()
                }
            }
            ad.show(this)
        } ?: run {
            // If ad is not loaded, proceed to main content
            proceedToMainContent()
        }
    }

    private fun proceedToMainContent() {
        setContent {
            App14_TestAdAppTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = "Users Welcome to my Test Ad app",
                        modifier = Modifier.padding(innerPadding)
                    )
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

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    App14_TestAdAppTheme {
        Greeting("Android")
    }
}
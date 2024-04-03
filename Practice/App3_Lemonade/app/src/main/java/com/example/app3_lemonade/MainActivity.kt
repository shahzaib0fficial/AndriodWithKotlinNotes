package com.example.app3_lemonade

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.app3_lemonade.ui.theme.App3_LemonadeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            App3_LemonadeTheme {
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
fun ImageAndText(modifier: Modifier = Modifier){
    var imageNumber by remember {
        mutableStateOf(1)
    }
    var random by remember {
        mutableStateOf(3)
    }
    var text = "Tap Tree to Get Lemon"
    var image = R.drawable.lemon_tree

    if (imageNumber == 1){
        text = "Tap the Lemon Tree to Select a Lemon"
        image = R.drawable.lemon_tree
    }
    else if (imageNumber == random){
        text = "Tap the Lemonade to Drink it"
        image = R.drawable.lemon_drink
    }
    else if (imageNumber == random+1){
        text = "Tap the Empty Glass to Start Again"
        image = R.drawable.lemon_restart
    }
    else{
        text = "Keep Tapping the Lemon to Squeeze"
        image = R.drawable.lemon_squeeze
    }

    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
            Text(
                text = "Lemonade",
                fontSize = 32.sp,
                color = Color.DarkGray,
                modifier = modifier
                    .background(color = Color.Yellow)
                    .fillMaxWidth(),
                textAlign = TextAlign.Center
            )
        Column(
            modifier = Modifier.fillMaxHeight(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Box(
                modifier = Modifier
                    .clip(RoundedCornerShape(15.dp))
            ) {
                Image(
                    painter = painterResource(image),
                    contentDescription = null,
                    modifier = Modifier
                        .background(color = Color.Cyan)
                        .clickable {
                            if (imageNumber == 2) {
                                random = (4..6).random()
                            }
                            if (imageNumber == random + 1) {
                                imageNumber = 0
                            }
                            imageNumber++
                        }
                )
            }
            Spacer(
                modifier = Modifier
                    .height(16.dp)
            )
            Text(
                text = text,
                color = Color.Gray,
                fontSize = 16.sp
            )
        }
    }
}

@Composable
fun App(){
    ImageAndText()
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    App3_LemonadeTheme {
        App()
    }
}
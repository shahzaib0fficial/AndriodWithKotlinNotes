package com.example.app2_birthdaywish

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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.app2_birthdaywish.ui.theme.App2_BirthdayWishTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            App2_BirthdayWishTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    BirthdayWish(
                        message = "Happy Birthday Abdul Aleem!",
                        from = "From Shahzaib",
                        modifier = Modifier.padding(8.dp))
                }
            }
        }
    }
}

@Composable
fun BirthdayWish(message : String , from : String , modifier: Modifier = Modifier){
    Column(
        verticalArrangement = Arrangement.Center,
        modifier = modifier) {
        Text(
            text = message,
            fontSize = 50.sp,
            lineHeight = 50.sp,
            textAlign = TextAlign.Center
        )
        Text(
            text = from,
            fontSize = 16.sp,
            modifier = Modifier
                .padding(5.dp)
                .align(alignment = Alignment.End)
        )
    }
}

@Composable
fun BackGroundImage(message: String,from: String,modifier: Modifier=Modifier){
    val image = painterResource(R.drawable.androidparty)
    Image(
        painter = image,
        contentDescription = null
    )
}

@Preview(showBackground = true)
@Composable
fun BirthdayWishPreview(){
    App2_BirthdayWishTheme {
//        BirthdayWish(message = "Happy Birthday Abdul Aleem!",from = "From Shahzaib",modifier = Modifier.padding(8.dp))
        BackGroundImage(message = "Happy Birthday Abdul Aleem!",from = "From Shahzaib")
    }
}
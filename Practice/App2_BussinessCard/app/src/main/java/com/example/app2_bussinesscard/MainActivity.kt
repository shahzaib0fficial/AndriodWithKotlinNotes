package com.example.app2_bussinesscard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.app2_bussinesscard.ui.theme.App2_BussinessCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            App2_BussinessCardTheme {
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
fun IntroSection(){
    val image = painterResource(R.drawable.icon)
    Column {
        Image(
            painter = image,
            contentDescription = null,
            modifier = Modifier
                .padding(1.dp)
                .align(alignment = Alignment.CenterHorizontally)
        )
        Text(
            text = "My Business",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            color = Color.DarkGray,
            modifier = Modifier
                .padding(1.dp)
                .align(alignment = Alignment.CenterHorizontally)
        )
        Text(
            text = "Here join My Business to get more Profit",
            color = Color.Gray,
            fontSize = 10.sp,
            modifier = Modifier
                .padding(1.dp)
                .align(alignment = Alignment.CenterHorizontally)
        )
    }
}

@Composable
fun ContactSection(){
    Column {
        Row {
            Icon(Icons.Filled.Phone, contentDescription = "Phone Icon", tint = Color.DarkGray)
            Spacer(modifier = Modifier.width(15.dp))
            Text(
                text = "+92 300 0000000",
                color = Color.Gray
            )
        }
        Spacer(modifier = Modifier.height(10.dp))
        Row {
            Icon(Icons.Filled.Share, contentDescription = "Phone Icon", tint = Color.DarkGray)
            Spacer(modifier = Modifier.width(15.dp))
            Text(
                text = "@MyBusiness",
                color = Color.Gray
            )
        }
        Spacer(modifier = Modifier.height(10.dp))
        Row {
            Icon(Icons.Filled.Email, contentDescription = "Phone Icon", tint = Color.DarkGray)
            Spacer(modifier = Modifier.width(15.dp))
            Text(
                text = "mybussiness@gmail.com",
                color = Color.Gray
            )
        }
    }
}

@Composable
fun App(){
    Box(modifier = Modifier.background(color = Color.LightGray)){
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(bottom = 26.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Spacer(modifier = Modifier.weight(1f))
            IntroSection()
            Spacer(modifier = Modifier.weight(1f))
            ContactSection()
        }
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    App2_BussinessCardTheme {
        App()
    }
}
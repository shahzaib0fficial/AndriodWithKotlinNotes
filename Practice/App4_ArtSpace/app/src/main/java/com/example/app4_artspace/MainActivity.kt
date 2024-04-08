package com.example.app4_artspace

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.app4_artspace.ui.theme.App4_ArtSpaceTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            App4_ArtSpaceTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ArtSpaceApp()
                }
            }
        }
    }
}

@Composable
fun ArtSpaceApp(){
    Column(
        modifier = Modifier
            .padding(15.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
            ImageSection(imageId = R.drawable.spyxfamily)
            InfoSection(name = "Spy x Family", date = "April 9, 2022" )
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            ButtonSection("Previous",{})
            ButtonSection("Next",{})
        }
        }
}

@Composable
fun ImageSection(@DrawableRes imageId:Int,modifier: Modifier = Modifier){
        Column(
            modifier = modifier
                .size(150.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Image(
                painter = painterResource(id = imageId),
                contentDescription = null,
                modifier = modifier
                    .size(140.dp)
            )
        }
}

@Composable
fun InfoSection(name:String,date:String,modifier: Modifier = Modifier){
    Column(
        modifier = modifier
            .width(150.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = name,
            fontSize = 18.sp
        )
        Text(
            text = date,
            fontSize = 11.sp
        )
    }
}

@Composable
fun ButtonSection(name: String,onClick : () -> Unit,modifier: Modifier = Modifier){
    Button(
        onClick = onClick,
        modifier = modifier
            .size(width = 70.dp, height = 25.dp),
        contentPadding = PaddingValues(0.dp)
    ) {
        Box(
            contentAlignment = Alignment.Center
        ) {
           Text(
                text = name,
                fontSize = 11.sp
           )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    App4_ArtSpaceTheme {
        ArtSpaceApp()
    }
}
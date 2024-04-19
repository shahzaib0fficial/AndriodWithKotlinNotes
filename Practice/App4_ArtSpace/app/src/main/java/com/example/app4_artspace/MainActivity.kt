package com.example.app4_artspace

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
//import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
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
                    color = Color(0xFFFFFFFF)
                ) {
                    ArtSpaceApp()
                }
            }
        }
    }
}

@Composable
fun ArtSpaceApp(){
    var animeId by remember { mutableIntStateOf(1) }
    var imageId = R.drawable.spyxfamily
    var animeName = "SPY x Family"
    var date = "April 9, 2022"
    if(animeId == 1){
        imageId = R.drawable.spyxfamily
        animeName = "SPY x Family"
        date = "April 9, 2022"
    }
    else if(animeId == 2){
        imageId = R.drawable.blackclover
        animeName = "Black Clover"
        date = "October 3, 2017"
    }
    else if(animeId == 3) {
        imageId = R.drawable.mashle
        animeName = "Mashle"
        date = "April 8, 2023"
    }
    Column(
        modifier = Modifier
            .padding(15.dp)
            .verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Box(modifier = Modifier.shadow(3.dp)) {
            ImageSection(imageId = imageId)

        }
            Spacer(modifier = Modifier.height(15.dp))
            InfoSection(animeName = animeName, date = date )
            Spacer(modifier = Modifier.height(15.dp))
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            ButtonSection(
                "Previous",
                onClick = {
                    if (animeId>1){
                        animeId--
                    }else{
                        animeId = 3
                    }
                }
            )
            ButtonSection(
                "Next",
                onClick = {
                    if (animeId<3){
                        animeId++
                    }else{
                        animeId = 1
                    }
                }
            )
        }
        }
}

@Composable
fun ImageSection(@DrawableRes imageId:Int,modifier: Modifier = Modifier){
        Column(
            modifier = modifier.padding(35.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Image(
                painter = painterResource(id = imageId),
                contentDescription = null,
                contentScale = ContentScale.FillWidth,
                modifier = modifier
                    .fillMaxWidth()
            )
        }
}

@Composable
fun InfoSection(animeName:String,date:String,modifier: Modifier = Modifier){
    Column(
        modifier = modifier
            .background(color = Color(0xFFd3d3d3)),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text(
            text = animeName,
            fontSize = 18.sp,
        )
        Text(
            text = date,
            fontSize = 11.sp,
        )
    }
}

@Composable
fun ButtonSection(name: String,onClick: () -> Unit ,modifier: Modifier = Modifier) {
    Button(
        onClick = onClick,
        modifier = modifier
//            .size(width = 70.dp, height = 25.dp),
//        contentPadding = PaddingValues(0.dp)
    ) {
        Box(
            contentAlignment = Alignment.Center
        ) {
           Text(
                text = name,
//                fontSize = 11.sp
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
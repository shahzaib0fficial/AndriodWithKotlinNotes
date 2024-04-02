package com.example.app3_diceroller

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Button
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.app3_diceroller.ui.theme.App3_DiceRollerTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            App3_DiceRollerTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    DiceRollerApp()
                }
            }
        }
    }
}

@Composable
fun ButtonAndImage(modifier:Modifier = Modifier){
    var rollValue by remember {
     mutableStateOf(1)
    }
    val imageResource = when(rollValue){
        1-> R.drawable.dice_1
        2-> R.drawable.dice_2
        3-> R.drawable.dice_3
        4-> R.drawable.dice_4
        5-> R.drawable.dice_5
        else-> R.drawable.dice_6
    }
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(imageResource),
            contentDescription = rollValue.toString()
        )
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = { rollValue = (1..6).random() }) {
            Text(stringResource(R.string.roll))
        }

    }
}

@Composable
fun DiceRollerApp(){
    ButtonAndImage(
        modifier = Modifier
            .fillMaxSize()
            .wrapContentSize(Alignment.Center)
    )
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    App3_DiceRollerTheme {
        DiceRollerApp()
    }
}
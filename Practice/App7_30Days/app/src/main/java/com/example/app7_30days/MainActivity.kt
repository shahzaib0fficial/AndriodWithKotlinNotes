@file:OptIn(ExperimentalMaterial3Api::class, ExperimentalMaterial3Api::class)

package com.example.app7_30days

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.app7_30days.ui.theme.App7_30DaysTheme
import androidx.compose.ui.unit.dp
import com.example.app7_30days.data.DataSource
import com.example.app7_30days.model.CookingClass

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            App7_30DaysTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    CookingApp()
                }
            }
        }
    }
}

@Composable
fun CookingCard(cook: CookingClass,modifier: Modifier = Modifier) {
    Card(
        modifier = modifier
            .padding(8.dp)
    ) {
        Column(
            modifier = modifier
                .padding(12.dp)
        ) {
            Text(
                text = stringResource(id = cook.day),
                style = MaterialTheme.typography.titleMedium
            )
            Text(
                text = stringResource(id = cook.title),
                style = MaterialTheme.typography.titleLarge
            )
            Image(
                painter = painterResource(id = cook.image),
                contentDescription = "Here Recipe Name",
                contentScale = ContentScale.Crop,
                modifier = modifier
                    .fillMaxWidth()
            )
            Text(
                text = stringResource(id = cook.description),
                style = MaterialTheme.typography.bodyLarge
            )
        }
    }
}

@Composable
fun CookingList(cookingList: List<CookingClass>) {
    Scaffold(
        topBar = {
            TopAppBar()
        }
    ) { it->
        LazyColumn(contentPadding = it) {
            items(cookingList) {
                CookingCard(cook = it)
            }
        }
    }
}

@Composable
fun TopAppBar() {
    CenterAlignedTopAppBar(
        title = {
            Text(
                text = "Cooking App"
            )
        }
    )
}

@Composable
fun CookingApp() {
    CookingList(cookingList = DataSource().listOfCooking())
}

@Preview(showBackground = true)
@Composable
fun CookingPreview() {
    App7_30DaysTheme {
        CookingApp()
    }
}
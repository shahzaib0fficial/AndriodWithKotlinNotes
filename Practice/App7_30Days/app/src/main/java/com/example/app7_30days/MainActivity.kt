package com.example.app7_30days

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.app7_30days.ui.theme.App7_30DaysTheme
import androidx.compose.ui.unit.dp

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
                    CookingCard()
                }
            }
        }
    }
}

@Composable
fun CookingCard(modifier: Modifier = Modifier) {
    Card(
        modifier = modifier
            .padding(8.dp)
    ) {
        Column(
            modifier = modifier
                .padding(12.dp)
        ) {
            Text(
                text = "Day1",
                style = MaterialTheme.typography.titleMedium
            )
            Text(
                text = "Here Recipe Name",
                style = MaterialTheme.typography.titleLarge
            )
            Image(
                painter = painterResource(id = R.drawable.day1_dish_image),
                contentDescription = "Here Recipe Name",
                contentScale = ContentScale.Crop,
                modifier = modifier
                    .fillMaxWidth()
            )
            Text(
                text = "Here Description of Recipe. Here Description of Recipe. Here Description of Recipe. Here Description of Recipe. Here Description of Recipe. Here Description of Recipe. Here Description of Recipe. Here Description of Recipe. Here Description of Recipe. Here Description of Recipe. Here Description of Recipe. Here Description of Recipe. Here Description of Recipe. Here Description of Recipe. Here Description of Recipe. Here Description of Recipe. Here Description of Recipe. Here Description of Recipe. Here Description of Recipe. Here Description of Recipe. Here Description of Recipe. Here Description of Recipe. ",
                style = MaterialTheme.typography.bodyLarge
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun CookingPreview() {
    App7_30DaysTheme {
        CookingCard()
    }
}
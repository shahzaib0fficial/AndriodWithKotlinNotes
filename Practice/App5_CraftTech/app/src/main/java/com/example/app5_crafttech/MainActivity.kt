package com.example.app5_crafttech

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.app5_crafttech.ui.theme.App5_CraftTechTheme
import androidx.compose.ui.unit.dp
import com.example.app5_crafttech.data.listOfCraftTech
import com.example.app5_crafttech.model.CraftTech

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            App5_CraftTechTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    CraftApp()
                }
            }
        }
    }
}

@Composable
fun Craft(craft: CraftTech,modifier: Modifier = Modifier) {
    Card(
        modifier = modifier
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Image(
                painter = painterResource(id = craft.image),
                contentDescription = null,
                modifier = Modifier
                    .size(68.dp)
            )
            Column(
                modifier = Modifier
                    .padding(start = 16.dp,top = 16.dp,end = 16.dp)
            ) {
                Text(
                    text = stringResource(id = craft.name),
                    style = MaterialTheme.typography.bodySmall,
                )
                Spacer(modifier = Modifier.height(8.dp))
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.ic_grain),
                        contentDescription = null
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(
                        text = "${craft.view}",
                        style = MaterialTheme.typography.bodySmall
                    )
                }
            }
        }
    }
}

@Composable
fun CraftList(craftList: List<CraftTech>,modifier: Modifier=Modifier) {
    LazyVerticalGrid(columns = GridCells.Fixed(2)) {
        items(craftList) {
            craft ->
                Craft(craft= craft,modifier=modifier.padding(8.dp))
        }
    }
}

@Composable
fun CraftApp() {
    CraftList(craftList = listOfCraftTech())
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    App5_CraftTechTheme {
        CraftApp()
    }
}
package com.example.app13_waterme.ui.theme

import android.util.Log
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.app13_waterme.data.itemsData
import com.example.app13_waterme.data.itemsDataClass
import com.example.app13_waterme.ui.HomeScreenViewModel
import androidx.lifecycle.viewmodel.compose.viewModel


@Composable
fun HomeScreen(homeScreenViewModel: HomeScreenViewModel = viewModel(factory = HomeScreenViewModel.Factory)){
    val data = itemsData().data()
    var showDialog by rememberSaveable {
        mutableStateOf(false)
    }
    var selectedItem by rememberSaveable {
        mutableStateOf<itemsDataClass?>(null)
    }
    LazyColumn {
        items(data){ item->
            Spacer(modifier = Modifier.height(100.dp))
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable {
                        showDialog = true
                        selectedItem = item
                    }
            ) {
                Column {
                    Text(
                        text = item.name
                    )
                    Text(
                        text = item.description
                    )
                }
            }
        }
    }
    if(showDialog){
        ShowDialog(selectedItem!!, onDismiss = {showDialog = false}, homeScreenViewModel = homeScreenViewModel)
    }
}

@Composable
fun ShowDialog(item: itemsDataClass,onDismiss: ()-> Unit,homeScreenViewModel: HomeScreenViewModel){
    AlertDialog(
        onDismissRequest = {
//            onDismiss()
        },
        confirmButton = {
            TextButton(onClick = {
                onDismiss()
            }) {
                Text(text = "Cancel")
            }
            TextButton(onClick = {
                onDismiss()
                homeScreenViewModel.setReminder(item.name)
            }) {
                Text(text = "Set Reminder")
            }
        },
        title = {
            Text(text = "${item.name}")
        },
        text = {
            Text(text = "${item.description}")
        }
    )
}
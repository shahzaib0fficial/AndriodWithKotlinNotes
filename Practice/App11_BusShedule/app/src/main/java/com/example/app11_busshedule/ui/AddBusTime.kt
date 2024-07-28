package com.example.app11_busshedule.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.app11_busshedule.ui.viewModel.HomeScreenViewModel


@Composable
fun AddBusTime(
    onAddClick: ()-> Unit
){
    val viewModel: HomeScreenViewModel = viewModel()
    var stopFieldText by rememberSaveable { mutableStateOf("") }
    var timeText by rememberSaveable { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 15.dp, end = 15.dp)
    ) {
        TextField(
            value = stopFieldText, onValueChange = { stopFieldText = it },
            modifier = Modifier
                .fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(10.dp))
        TextField(
            value = timeText, onValueChange = { timeText = it },
            modifier = Modifier
                .fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(15.dp))

        Button(
            onClick = {
                viewModel.addBusData(stopFieldText,timeText)
                onAddClick()
            },
            enabled = stopFieldText.isNotBlank() && timeText.isNotBlank(),
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(
                text = "Add Schedule",
                fontSize = 18.sp
            )
        }
    }
}
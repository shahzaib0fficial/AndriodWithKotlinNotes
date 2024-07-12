package com.example.app8_lunchtrayapp.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Divider
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ChooseOption(
    modifier: Modifier = Modifier,
    OnNextClick: ()-> Unit,
    onSelectionChange: (Triple<String,String,String>)-> Unit,
    onCancelClick: ()-> Unit,
    options:List<Triple<String, String, String>>
){
//    Text(text = "Next Screen")
    var selectedValue by rememberSaveable {
        mutableStateOf("")
    }

    val scrollState = rememberScrollState()

    Column(
        modifier = Modifier
            .verticalScroll(scrollState)
            .padding(20.dp)
    ) {
        options.forEach{ item->
            Column {
                Text(
                    text = item.first,
                    fontSize = 20.sp,
                    modifier = Modifier
                        .padding(start = 45.dp)
                )
                Spacer(modifier = Modifier.height(10.dp))
                Row(
                    modifier = Modifier.selectable(
                        selected = selectedValue == item.first,
                        onClick = {
                            selectedValue = item.first
                            onSelectionChange(item)
                        }
                    )
                ) {
                    RadioButton(
                        selected = selectedValue == item.first,
                        onClick = {
                            selectedValue = item.first
                            onSelectionChange(item)
                        }
                    )
                    Text(
                        fontSize = 15.sp,
                        text = item.second
                    )
                }
                Spacer(modifier = Modifier.height(10.dp))
                Text(
                    text = "$${item.third}",
                    fontSize = 15.sp,
                    modifier = Modifier
                            .padding(start = 45.dp)
                )
                Spacer(modifier = Modifier.height(5.dp))
                Divider(
                    thickness = 1.dp
                )
                Spacer(modifier = Modifier.height(20.dp))
            }
        }
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            OutlinedButton(
//                modifier = Modifier.width(150.dp),
                modifier = Modifier.weight(1f),
                onClick = { onCancelClick() }
            ) {
                Text(
                    text = "CANCEL"
                )
            }
            Spacer(modifier = Modifier.width(15.dp))
            Button(
//                modifier = Modifier.width(150.dp),
                modifier = Modifier.weight(1f),
                enabled = selectedValue.isNotEmpty(),
                onClick = { OnNextClick() }
            ) {
                Text(text = "NEXT")
            }
        }
    }
}
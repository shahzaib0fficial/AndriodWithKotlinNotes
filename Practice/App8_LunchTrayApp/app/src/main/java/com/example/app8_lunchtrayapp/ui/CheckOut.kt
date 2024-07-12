package com.example.app8_lunchtrayapp.ui

import android.util.Log
import androidx.compose.foundation.horizontalScroll
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.ui.unit.sp
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Divider
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import com.example.app8_lunchtrayapp.R
import com.example.app8_lunchtrayapp.data.LunchUiState

@Composable
fun CheckOut(
    modifier: Modifier= Modifier,
    uiState: LunchUiState,
    onCancelClick: ()-> Unit,
    onSubmitClick: (String)-> Unit
){
    val orderSummary = stringResource(
        R.string.order_detail,
        uiState.Entree,
        uiState.SideDish,
        uiState.Accompanient,
        uiState.TotalPrice
    )
    val vericalScroll = rememberScrollState()

    val totalPriceText = if (uiState.TotalPrice.isNotEmpty()) {
        "Total: $${uiState.TotalPrice.toFloat() + 0.84f}"
    } else {
        "Total: $0.84" // Default text when TotalPrice is empty
    }

    Column(
        modifier = Modifier
            .padding(20.dp)
            .verticalScroll(vericalScroll)
    ) {
        Text(
            text = "Order Summary",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold
        )
        Spacer(modifier = Modifier.height(10.dp))
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = uiState.Entree,
                fontSize = 20.sp
                )
            Text(
                text = "$${uiState.EntreePrice}",
                fontSize = 20.sp
            )
        }
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = "$${uiState.SideDish}",
                fontSize = 20.sp
            )
            Text(
                text = "$${uiState.SideDishPrice}",
                fontSize = 20.sp
            )
        }
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = "$${uiState.Accompanient}",
                fontSize = 20.sp
            )
            Text(
                text = uiState.AccompanientPrice,
                fontSize = 20.sp
            )
        }

        Spacer(modifier = Modifier.height(10.dp))
        Divider(thickness = 1.dp)
        Spacer(modifier = Modifier.height(10.dp))

        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.End
        ) {
            Text(
                text = "Subtotal: $${uiState.TotalPrice}",
                fontSize = 20.sp
            )
            Text(
                text = "Tax: $0.84",
                fontSize = 20.sp
            )
            Text(
                text = totalPriceText,
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp
            )
        }
        Spacer(modifier = Modifier.height(20.dp))
        Row(
            Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            Spacer(modifier = Modifier.width(10.dp))
            OutlinedButton(
                modifier = Modifier.weight(1f),
                onClick = { onCancelClick() }
            ) {
                Text(
                    text = "Cancel"
                )
            }
            Spacer(modifier = Modifier.width(10.dp))
            Button(
                modifier = Modifier.weight(1f),
                onClick = { onSubmitClick(orderSummary) }
            ) {
                Text(
                    text = "Submit"
                )
            }
            Spacer(modifier = Modifier.width(10.dp))
        }
    }
}
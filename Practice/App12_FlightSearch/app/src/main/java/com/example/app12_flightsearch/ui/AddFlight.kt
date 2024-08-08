package com.example.app12_flightsearch.ui

import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.app12_flightsearch.R
import com.example.app12_flightsearch.data.FlightData
import com.example.app12_flightsearch.ui.viewModels.HomeScreenViewModel

@Composable
fun AddFlight(){
    val homeScreenViewModel: HomeScreenViewModel = viewModel()

    val context = LocalContext.current

    var fromAirportName by rememberSaveable {
        mutableStateOf("")
    }
    var fromAirportDescription by rememberSaveable {
        mutableStateOf("")
    }
    var toAirportName by rememberSaveable {
        mutableStateOf("")
    }
    var toAirportDescription by rememberSaveable {
        mutableStateOf("")
    }

    Column {
        TextField(
            value = fromAirportName,
            onValueChange = {
                fromAirportName = it
            },
            singleLine = true,
            placeholder = {
                Text(
                    text = "From Destination (KRH/CHT)",
                )
            },
            modifier = Modifier
                .padding(10.dp)
                .fillMaxWidth()
        )
        TextField(
            value = fromAirportDescription,
            onValueChange = {
                fromAirportDescription = it
            },
            singleLine = true,
            placeholder = {
                Text(
                    text = "Description (KRH is largest Airport...)",
                )
            },
            modifier = Modifier
                .padding(10.dp)
                .fillMaxWidth()
        )
        TextField(
            value = toAirportName,
            onValueChange = {
                toAirportName = it
            },
            singleLine = true,
            placeholder = {
                Text(
                    text = "To Destination (KRH/CHT)",
                )
            },
            modifier = Modifier
                .padding(10.dp)
                .fillMaxWidth()
        )
        TextField(
            value = toAirportDescription,
            onValueChange = {
                toAirportDescription = it
            },
            singleLine = true,
            placeholder = {
                Text(
                    text = "Description (CHT is smallest Airport...)",
                )
            },
            modifier = Modifier
                .padding(10.dp)
                .fillMaxWidth()
        )

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp, vertical = 10.dp),
            horizontalArrangement = Arrangement.Center
        ) {
            Button(
                colors = ButtonDefaults.buttonColors(
                    contentColor = Color(0xFFFFFFFF),
                    containerColor = Color(0xFF87CEEB),
                ),
                enabled = fromAirportName.isNotBlank() && fromAirportDescription.isNotBlank() && toAirportName.isNotBlank() && toAirportDescription.isNotBlank(),
                onClick = {
                    val flightData: FlightData = FlightData(
                        fromAirportName = fromAirportName,
                        fromAirportDescription = fromAirportDescription,
                        toAirportName = toAirportName,
                        toAirportDescription = toAirportDescription
                    )
                    homeScreenViewModel.addFlight(flightData)
                    fromAirportName = ""
                    fromAirportDescription = ""
                    toAirportName = ""
                    toAirportDescription = ""
                    Toast.makeText(context, "Added Successfully", Toast.LENGTH_SHORT).show()
                }
            ) {
                Text(
                    text = "Add Flight",
                    fontSize = 16.sp,
                    modifier = Modifier
                        .fillMaxWidth(),
                    textAlign = TextAlign.Center
                )
            }
        }
    }

}
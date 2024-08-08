package com.example.app12_flightsearch.ui

import android.inputmethodservice.Keyboard.Row
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.app12_flightsearch.ui.viewModels.HomeScreenViewModel

@Composable
fun FlightScreen(fromAirportName: String){
    val homeScreenViewModel:HomeScreenViewModel = viewModel()
    val data = homeScreenViewModel.getRelatedFlight(fromAirportName).collectAsState()

    Column {
        Row(
            modifier = Modifier.padding(horizontal = 15.dp, vertical = 20.dp)
        ){
            Text(
                text = "Flights from $fromAirportName",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold
            )
        }
        LazyColumn {
            items(data.value){item->
                Card(
                    shape = RoundedCornerShape(topStart = 0.dp, topEnd = 20.dp, bottomStart = 20.dp, bottomEnd = 0.dp),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 15.dp, end = 15.dp, bottom = 20.dp, top = 0.dp)
                ) {
                    Column(
                        modifier = Modifier.padding(10.dp)
                    ) {
                        Text(
                            text = "FROM",
                            fontSize = 14.sp,
                            fontWeight = FontWeight.Bold
                        )
                        Row {
                            Text(
                                text = buildAnnotatedString {
                                    withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)){
                                        append(item.fromAirportName)
                                    }
                                    append(" ")
                                    append(item.fromAirportDescription)
                                },
                                fontSize = 18.sp
                            )
                        }
                        Spacer(modifier = Modifier.height(10.dp))
                        Text(
                            text = "TO",
                            fontSize = 14.sp,
                            fontWeight = FontWeight.Bold
                        )
                        Row {
                            Text(
                                text = buildAnnotatedString {
                                    withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)){
                                        append(item.toAirportName)
                                    }
                                    append(" ")
                                    append(item.toAirportDescription)
                                },
                                fontSize = 18.sp
                            )
                        }
                    }
                }
            }
        }
    }
}
package com.example.app12_flightsearch.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "flight_data")
data class FlightData(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val fromAirportName:String,
    val fromAirportDescription:String,
    val toAirportName: String,
    val toAirportDescription:String,
)
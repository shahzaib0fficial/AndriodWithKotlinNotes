package com.example.app11_busshedule.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "bus_detail")
data class BusEntity (
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val stopName: String,
    val busTime: String
)
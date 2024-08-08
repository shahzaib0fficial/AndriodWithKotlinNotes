package com.example.app12_flightsearch

import android.app.Application
import com.example.app12_flightsearch.data.AppContainer
import com.example.app12_flightsearch.data.AppDataContainer

class FlightApplication: Application() {

    lateinit var container: AppContainer

    override fun onCreate() {
        super.onCreate()
        container = AppDataContainer(this)
    }
}
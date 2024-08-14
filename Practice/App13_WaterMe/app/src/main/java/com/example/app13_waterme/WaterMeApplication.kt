package com.example.app13_waterme

import android.app.Application
import com.example.app13_waterme.data.AppContainer
import com.example.app13_waterme.data.DefaultContainer

class WaterMeApplication : Application() {
    lateinit var container: AppContainer
    override fun onCreate() {
        super.onCreate()
        container = DefaultContainer(this)
    }
}
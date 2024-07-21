package com.example.app10_amphibians

import android.app.Application
import com.example.app10_amphibians.data.AppContainer
import com.example.app10_amphibians.data.DefaultAppContainer

class AmphibianApplication: Application() {
    lateinit var container: AppContainer
    override fun onCreate() {
        super.onCreate()
        container = DefaultAppContainer()
    }
}
package com.example.app11_busshedule

import android.app.Application
import com.example.app11_busshedule.data.AppContainer
import com.example.app11_busshedule.data.AppDataContainer
import com.example.app11_busshedule.data.AppDatabase


class BusScheduleApplication : Application() {

    lateinit var container: AppContainer


    override fun onCreate() {
        super.onCreate()
        container = AppDataContainer(this)
    }
}
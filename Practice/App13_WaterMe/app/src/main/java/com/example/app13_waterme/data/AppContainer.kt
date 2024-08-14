package com.example.app13_waterme.data

import android.content.Context

interface AppContainer{
    val repository: Repository
}

class DefaultContainer(context: Context): AppContainer {
    override val repository = WorkManagerRepository(context)
}
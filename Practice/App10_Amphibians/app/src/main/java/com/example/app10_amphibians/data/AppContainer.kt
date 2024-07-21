package com.example.app10_amphibians.data

import com.example.app10_amphibians.network.ApiService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

interface AppContainer {
    val appRepository: AppRepository
}

class DefaultAppContainer: AppContainer{
    private val BASE_URL = "https://android-kotlin-fun-mars-server.appspot.com"

    // Create Retrofit instance with GsonConverterFactory
    val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    private val retrofitService: ApiService by lazy {
        retrofit.create(ApiService::class.java)
    }

    override val appRepository: AppRepository by lazy {
        NetworkRepository(retrofitService)
    }

}
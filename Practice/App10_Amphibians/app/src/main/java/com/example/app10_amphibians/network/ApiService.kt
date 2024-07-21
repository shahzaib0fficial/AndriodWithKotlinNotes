package com.example.app10_amphibians.network

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

sealed interface AppUiState {
    data class Success(val data: List<DataFormatClass>): AppUiState
    data object Loading: AppUiState
    data object Error: AppUiState
}

//private val BASE_URL = "https://android-kotlin-fun-mars-server.appspot.com"
//
//// Create Retrofit instance with GsonConverterFactory
//val retrofit: Retrofit = Retrofit.Builder()
//    .baseUrl(BASE_URL)
//    .addConverterFactory(GsonConverterFactory.create())
//    .build()

interface ApiService{
    @GET("amphibians")
    suspend fun getData(): List<DataFormatClass>
}

//object AmphibianApi{
//    val retrofitService: ApiService by lazy {
//        retrofit.create(ApiService::class.java)
//    }
//}
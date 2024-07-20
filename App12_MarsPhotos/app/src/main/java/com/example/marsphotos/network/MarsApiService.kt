package com.example.marsphotos.network

import android.provider.ContactsContract.Contacts.Photo
import android.util.Log
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.google.gson.reflect.TypeToken
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonConfiguration
import kotlinx.serialization.json.JsonElement
import kotlinx.serialization.json.JsonObject
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Call
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

sealed interface MarsUiState {
    data class Success(val photos: List<MarsPhoto>) : MarsUiState
    data object Error : MarsUiState
    data object Loading : MarsUiState
}

//private const val BASE_URL = "https://android-kotlin-fun-mars-server.appspot.com"

//private val retrofit = Retrofit.Builder()
//    .addConverterFactory(Json.asConverterFactory("application/json".toMediaType()))
//    .baseUrl(BASE_URL)
//    .build()

//// Create Gson instance
//val gson: Gson = GsonBuilder().create()
//
// Create Retrofit instance with GsonConverterFactory
//val retrofit: Retrofit = Retrofit.Builder()
//    .baseUrl(BASE_URL)
//    .addConverterFactory(GsonConverterFactory.create())
//    .build()

interface MarsApiService{
    @GET("photos")
    suspend fun getPhotos(): List<MarsPhoto>
}

//object MarsApi{
//    val retrofitService: MarsApiService by lazy {
//        retrofit.create(MarsApiService::class.java)
//    }
//}
package com.example.app10_amphibians.data

import com.example.app10_amphibians.network.ApiService
import com.example.app10_amphibians.network.DataFormatClass

interface AppRepository {
    suspend fun getApiData(): List<DataFormatClass>
}

class NetworkRepository(
    private val apiService: ApiService
): AppRepository{
    override suspend fun getApiData(): List<DataFormatClass> = apiService.getData()
}
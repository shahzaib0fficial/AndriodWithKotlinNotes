package com.example.app12_flightsearch.ui.viewModels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.app12_flightsearch.data.AppDatabase
import com.example.app12_flightsearch.data.FlightData
import com.example.app12_flightsearch.data.OfflineItemsRepository
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class HomeScreenViewModel(application: Application): AndroidViewModel(application) {
    private val repository: OfflineItemsRepository

    init {
        val dao = AppDatabase.getDatabase(application).accessDao()
        repository = OfflineItemsRepository(dao)
    }

    fun getRelatedFlight(fromAirportName: String): StateFlow<List<FlightData>>{
        return repository.getRelatedItemStream(fromAirportName)
            .map { it }
            .stateIn(
                scope = viewModelScope,
                started = SharingStarted.WhileSubscribed(5000),
                initialValue = emptyList()
            )
    }

    fun getSearchFlight(fromAirportName: String): StateFlow<List<FlightData>>{
        return repository.getSearchItemStream(fromAirportName)
            .map { it }
            .stateIn(
                scope = viewModelScope,
                started = SharingStarted.WhileSubscribed(5000),
                initialValue = emptyList()
            )
    }

    fun addFlight(flightDetails: FlightData){
        viewModelScope.launch {
            repository.insertItem(flightDetails)
        }
    }
}
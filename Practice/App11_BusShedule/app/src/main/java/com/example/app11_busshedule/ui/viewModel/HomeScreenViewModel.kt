package com.example.app11_busshedule.ui.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.app11_busshedule.data.AppDatabase
import com.example.app11_busshedule.data.BusEntity
import com.example.app11_busshedule.data.OfflineItemsRepository
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class HomeScreenViewModel (application: Application) : AndroidViewModel(application)  {

    private val repository: OfflineItemsRepository

    init {
        val dao = AppDatabase.getDatabase(application).accessDao()
        repository = OfflineItemsRepository(dao)
    }

    private fun insertEntity(busEntity: BusEntity){
        viewModelScope.launch {
            repository.insertItem(busEntity)
        }
    }

    val allBusItems: StateFlow<List<BusEntity>> = repository.getAllItemsStream()
        .map { it }
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5000),
            initialValue = emptyList()
        )

    fun addBusData(busStop: String,busTime: String){
        val busEntity = BusEntity(stopName = busStop, busTime = busTime)
        insertEntity(busEntity)
    }
}
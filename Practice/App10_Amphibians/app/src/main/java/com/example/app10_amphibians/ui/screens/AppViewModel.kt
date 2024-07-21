package com.example.app10_amphibians.ui.screens

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.app10_amphibians.AmphibianApplication
import com.example.app10_amphibians.data.AppRepository
import com.example.app10_amphibians.network.AppUiState
import kotlinx.coroutines.launch


class AppViewModel(
    private val appRepository:AppRepository
): ViewModel() {
    var uiState: AppUiState by mutableStateOf(AppUiState.Loading)

    init {
        getData()
    }

    fun getData(){
        viewModelScope.launch{
            try {

                val apiData = appRepository.getApiData()

                Log.d("Here",apiData.toString())

                uiState = AppUiState.Success(apiData)

            }
            catch (e: Exception){
                Log.d("Got Error",e.toString())
                uiState = AppUiState.Error
            }
        }
    }

    companion object {
        val Factory: ViewModelProvider.Factory = viewModelFactory {
            initializer {
                val application = (this[ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY] as AmphibianApplication)
                val appRepository = application.container.appRepository
                AppViewModel(appRepository = appRepository)
            }
        }
    }
}
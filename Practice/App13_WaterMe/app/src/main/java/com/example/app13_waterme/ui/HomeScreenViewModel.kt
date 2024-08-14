package com.example.app13_waterme.ui

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.app13_waterme.WaterMeApplication
import com.example.app13_waterme.data.Repository

class HomeScreenViewModel(val repository: Repository): ViewModel() {

    fun setReminder(name: String){
        repository.setReminder(name)
    }

    companion object {
        val Factory: ViewModelProvider.Factory = viewModelFactory {
            initializer {
                val repository = (this[APPLICATION_KEY] as WaterMeApplication).container.repository
                HomeScreenViewModel(
                    repository = repository
                )
            }
        }
    }
}
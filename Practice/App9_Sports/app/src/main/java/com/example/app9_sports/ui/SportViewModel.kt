package com.example.app9_sports.ui

import androidx.lifecycle.ViewModel
import com.example.app9_sports.data.SportsData
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class SportViewModel: ViewModel() {
    val _uiState = MutableStateFlow(SportUiState())
    val uiState = _uiState.asStateFlow()

    fun setDetailScreen(state:Boolean){
        _uiState.update {
            currentState->
                currentState.copy(
                    DetailScreen = state
                )
        }
    }

    fun setDetailMediumScreen(state:Boolean){
        _uiState.update {
                currentState->
            currentState.copy(
                detailMediumScreen = state
            )
        }
    }

    fun setCurrentSport(id:Int){
        _uiState.update {
                currentState->
            currentState.copy(
                currentSelectedSport = SportsData().getSport(id)?: SportsData().default
            )
        }
    }

    fun reSet() {
        _uiState.value = SportUiState()
    }
}
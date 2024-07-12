package com.example.app8_lunchtrayapp.ui

import android.util.Log
import androidx.lifecycle.ViewModel
import com.example.app8_lunchtrayapp.data.LunchUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class LunchViewModel: ViewModel() {
    private val _uiState = MutableStateFlow(LunchUiState())
    val uiState = _uiState.asStateFlow()

    fun setEntree(entree: String){
        _uiState.update {
            currentState->
            currentState.copy(
                Entree = entree
            )
        }
    }
    fun setSideDish(sideDish: String){
        _uiState.update {
                currentState->
            currentState.copy(
                SideDish = sideDish
            )
        }
    }
    fun setAccompanient(accompanient: String){
        _uiState.update {
                currentState->
            currentState.copy(
                Accompanient = accompanient
            )
        }
    }
    fun setEntreePrice(entreePrice: String){
        _uiState.update {
                currentState->
            currentState.copy(
                EntreePrice = entreePrice
            )
        }
    }
    fun setSideDishPrice(sideDishPrice: String){
        _uiState.update {
                currentState->
            currentState.copy(
                SideDishPrice = sideDishPrice
            )
        }
    }
    fun setAccompanientPrice(accompanientPrice: String){
        _uiState.update {
                currentState->
            currentState.copy(
                AccompanientPrice = accompanientPrice
            )
        }
    }
    fun setTotalPrice(price: String){
        val addPrice = price.toFloat()
        var previousPrice = if (uiState.value.TotalPrice.isEmpty()) {
            0.0f
        } else {
            uiState.value.TotalPrice.toFloat()
        }
        previousPrice += addPrice

        _uiState.update {
                currentState->
            currentState.copy(
                TotalPrice = previousPrice.toString()
            )
        }
    }
    fun reSet(){
        _uiState.value = LunchUiState()
        Log.d("Vlaue", _uiState.value.toString())
        Log.d("Value", LunchUiState().toString())
//        _uiState = MutableStateFlow(LunchUiState())
//        _uiState.update {
//            currentState->
//            currentState.copy(
//                TotalPrice = ""
//            )
//        }
    }
}
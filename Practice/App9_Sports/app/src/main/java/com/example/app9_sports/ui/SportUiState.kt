package com.example.app9_sports.ui

import com.example.app9_sports.data.Sport
import com.example.app9_sports.data.SportsData

data class SportUiState (
    val DetailScreen: Boolean = false,
    val detailMediumScreen: Boolean = false,
    val currentSelectedSport:Sport = SportsData().default
)
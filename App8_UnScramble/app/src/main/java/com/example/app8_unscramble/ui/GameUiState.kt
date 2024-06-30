package com.example.app8_unscramble.ui

data class GameUiState(
    val currentScrambledWord: String = "",
    val isGuessWordWrong: Boolean = false,
    val wordCount: Int = 1,
    val score:Int = 0,
    val isGameOver: Boolean = false
)
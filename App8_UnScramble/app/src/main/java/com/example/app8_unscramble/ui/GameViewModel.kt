package com.example.app8_unscramble.ui

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.app8_unscramble.data.MAX_LEVEL
import com.example.app8_unscramble.data.SCORE_INCREASE
import com.example.app8_unscramble.data.allWords
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

// implementation("androidx.lifecycle:lifecycle-viewmodel-compose:2.6.1") //dependency added in build.gradle.kts

class GameViewModel : ViewModel() {
    private val _uiState = MutableStateFlow(GameUiState())
    val uiState: StateFlow<GameUiState> = _uiState.asStateFlow()
    private lateinit var currentWord: String
    private val usedWords: MutableSet<String> = mutableSetOf()
    var userGuess by mutableStateOf("")

    private fun pickRandomWordAndShuffle(): String
    {
        currentWord = allWords.random()
        if (usedWords.contains(currentWord)) {
            return pickRandomWordAndShuffle()
        }
        else
        {
            usedWords.add(currentWord)
            return shuffleWord(currentWord)
        }
    }

    private fun shuffleWord(word: String): String {
        val tempWord = word.toCharArray()
        tempWord.shuffle()
        while (String(tempWord).equals(word)){
            tempWord.shuffle()
        }
        return String(tempWord)
    }

    fun resetGame() {
        usedWords.clear()
        _uiState.value = GameUiState(currentScrambledWord = pickRandomWordAndShuffle())
    }

    init {
        resetGame()
    }

    fun updateUserGuess(guessedWord:String) {
        userGuess = guessedWord
    }

    fun checkUserGuess(){
        if (userGuess.equals(currentWord, ignoreCase = true)){
            val updatedScore = _uiState.value.score.plus(SCORE_INCREASE)
            updateGameState(updatedScore)
        }
        else{
            _uiState.update { currentState ->
                currentState.copy(isGuessWordWrong = true)
            }
        }
        updateUserGuess("") // reset outline text field value
    }

    fun skipWord(){
        updateGameState(_uiState.value.score)
        updateUserGuess("")
    }

    private fun updateGameState(updatedScore:Int){
        if (usedWords.size == MAX_LEVEL)
        {
            _uiState.update { currentState->
                currentState.copy(
                    isGuessWordWrong = false,
                    score = updatedScore,
                    isGameOver = true
                )
            }
        }
        else
        {
            _uiState.update {
                    currentState ->
                currentState.copy(
                    score = updatedScore,
                    isGuessWordWrong = false,
                    currentScrambledWord = pickRandomWordAndShuffle(),
                    wordCount = currentState.wordCount.inc()
                )
            }
        }
    }
}
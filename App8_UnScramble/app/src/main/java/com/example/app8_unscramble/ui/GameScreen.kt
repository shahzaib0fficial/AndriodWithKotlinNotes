package com.example.app8_unscramble.ui

import android.app.Activity
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.app8_unscramble.ui.theme.App8_UnScrambleTheme

@Composable
fun App(
    gameViewModel: GameViewModel = viewModel()
) {
    val gameUiState by gameViewModel.uiState.collectAsState()
    GameScreen(
        gameViewModel = gameViewModel,
        gameUiState = gameUiState,
        onUserGuessChange = { gameViewModel.updateUserGuess(it) },
        onKeyboardDone = { gameViewModel.checkUserGuess() },
        userGuess = gameViewModel.userGuess,
        currentScrambledWord = gameUiState.currentScrambledWord,
        isGuessWrong = gameUiState.isGuessWordWrong
    )
}

@Composable
fun AlertBox(gameViewModel: GameViewModel,score: Int)
{
    val activity = (LocalContext.current as Activity)
    val openDialog = remember { mutableStateOf(true) }

    if (openDialog.value) {
        AlertDialog(
            onDismissRequest = {
//                           Todos
//                openDialog.value = false
            },
            title = { Text(text = "Congratulations") },
            text = { Text(text = "Your Scores are ${score}/100") },
            dismissButton = {
                TextButton(
                    onClick = {
                        activity.finish()
                    }
                ) {
                    Text(
                        text = "Exit"
                    )
                }
            },
            confirmButton = {
                TextButton(
                    onClick = {
                        gameViewModel.resetGame()
//                        openDialog.value = false
                    }
                ) {
                    Text(
                        text = "Play Again"
                    )
                }
            }
        )
    }
}

@Composable
fun GameScreen(
    gameViewModel: GameViewModel,
    gameUiState: GameUiState,
    onUserGuessChange:(String)->Unit,
    onKeyboardDone:()->Unit,
    userGuess:String,
    currentScrambledWord : String,
    isGuessWrong:Boolean,
    modifier: Modifier = Modifier
){
    if (gameUiState.isGameOver)
    {
        AlertBox(gameViewModel,gameUiState.score)
    }
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.padding(
            horizontal = 20.dp
        )
    ) {
        Text(
            text = "UnScramble",
            style = MaterialTheme.typography.titleMedium
        )
        Spacer(modifier = Modifier.height(10.dp))
        Card(
            elevation = CardDefaults.cardElevation(defaultElevation = 5.dp),
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(15.dp),
                modifier = Modifier.padding(
                    vertical = 10.dp,
                    horizontal = 10.dp
                )
            ) {
                Text(
                    text = "${gameUiState.wordCount}/10",
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onPrimary,
                    modifier = Modifier
                        .clip(MaterialTheme.shapes.medium)
                        .background(color = MaterialTheme.colorScheme.surfaceTint)
                        .padding(3.dp)
                        .align(
                            alignment = Alignment.End,
                        )
                )
                Text(
                    text = currentScrambledWord,
                    style = MaterialTheme.typography.titleLarge
                )
                Text(
                    text = "UnScramble the word using all letters.",
                    style = MaterialTheme.typography.bodyMedium
                )
                OutlinedTextField(
                    value = userGuess,
                    singleLine = true,
                    onValueChange = onUserGuessChange,
                    label = {
                        if (isGuessWrong){
                            Text(text = "Wrong Guess")
                        }
                        else{
                            Text(text = "Enter your word")
                        }
                            },
                    isError = isGuessWrong,
                    keyboardOptions = KeyboardOptions.Default.copy(
                        imeAction = ImeAction.Done
                    ),
                    keyboardActions = KeyboardActions(
                        onDone = { onKeyboardDone() }
                    ),
                )
            }
        }
        Spacer(modifier = Modifier.height(15.dp))
        Button(
            modifier = Modifier.fillMaxWidth(),
            onClick = { gameViewModel.checkUserGuess() }
        ) {
            Text(
                text = "Submit"
            )
        }
        Spacer(modifier = Modifier.height(15.dp))
        OutlinedButton(
            modifier = Modifier.fillMaxWidth(),
            onClick = { gameViewModel.skipWord() }
        )  {
            Text(
                text = "Skip"
            )
        }
        Spacer(modifier = Modifier.height(15.dp))
        GameStatus(gameUiState.score)
    }
}

@Composable
fun GameStatus(score:Int){
    Card {
        Column(
            modifier = Modifier.padding(
                vertical = 7.dp,
                horizontal = 7.dp
            )
        ) {
            Text(
                text = "Score: $score",
                style = MaterialTheme.typography.bodyLarge
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    App8_UnScrambleTheme {
        App()
    }
}
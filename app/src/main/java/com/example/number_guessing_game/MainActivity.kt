package com.example.number_guessing_game

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.StringRes
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.view.ViewCompat.FocusDirection
import com.example.number_guessing_game.ui.theme.Number_Guessing_GameTheme
import kotlin.random.Random

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Number_Guessing_GameTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Number_Guessing_Game()
                }
            }
        }
    }
}

var hint: String = "Let's play"
var count: Int = 0

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Number_Guessing_Game() {
    var random by remember { mutableStateOf((1..1000).random()) }
    var number by remember { mutableStateOf("") }
    var hint by remember { mutableStateOf("Let's play") }
    var count by remember { mutableStateOf(0) }
    Column(
        Modifier
            .fillMaxSize()
            .padding(0.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(Modifier
            .fillMaxWidth()
            .background(color = Color(0xFF4A148C))
        ) {
            Text(
                text = "Number Guessing Game",
                fontSize = 20.sp,
                color = Color.White,
                modifier = Modifier.padding(12.dp)
            )
        }
        Spacer(modifier = Modifier.height(15.dp))
        Text(
            text = "Try to guess the number",
            fontSize = 20.sp,
        )
        Text(
            text = "I'm thinking of from 1 - 1000!",
            fontSize = 20.sp,
        )
        Spacer(modifier = Modifier.height(180.dp))

        EditNumberField(
            value = number,
            onValueChange = { number = it },

        )
        Spacer(modifier = Modifier.height(180.dp))
        Text(
            text = hint,
            color = Color.Gray,
            fontSize = 20.sp
        )
        Spacer(modifier = Modifier.height(30.dp))
        Row() {
            Button(
                onClick = {
                    val num = number.toIntOrNull()
                    if (num != null) {
                        if (num < random) {
                            hint = "Hint: It's higher!"
                            count += 1;
                        } else if (num > random) {
                            hint = "Hint: It's lower!"
                            count += 1;
                        } else {
                            hint = "Correct! You used $count tries to win"
                        }
                    } else {
                        hint = "Invalid input."
                    }
                }
            ) {
                Text(
                    text = "CHECK",
                    fontSize = 20.sp
                )
            }
            Spacer(modifier = Modifier.width(30.dp))
            Button(onClick = {
                random = (1..1000).random()
                number = ""
                hint = "Let's play"
                count = 0
            }) {
                Text(
                    text = "PLAY AGAIN",
                    fontSize = 20.sp
                )
            }
        }

    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EditNumberField(
    value: String,
    onValueChange: (String) -> Unit
) {

    TextField(
        value = value,
        onValueChange = onValueChange,
        label = {
            Text(
                stringResource(R.string.your_guess),
                fontSize = 20.sp,
            )
        },
        modifier = Modifier.fillMaxWidth().padding(60.dp),
        singleLine = true
    )

}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Number_Guessing_GameTheme {
    }
}
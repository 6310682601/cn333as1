package com.example.number_guessing_game

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.number_guessing_game.ui.theme.Number_Guessing_GameTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Number_Guessing_GameTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
                    Number_Guessing_Game()
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Number_Guessing_Game() {
    Column (
        Modifier
            .fillMaxSize()
            .padding(),
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Text(
            text = "Number Guessing Game",
            fontSize = 20.sp,
        )
        Text(
            text = "Try to guess the number I'm thinking of from 1 - 1000!",
            fontSize = 20.sp,
        )
        Spacer(modifier = Modifier.height(275.dp))
        var amountInput = "Your Guess"
        TextField(
            value = amountInput,
            onValueChange = {}
        )
        Spacer(modifier = Modifier.height(275.dp))
        Text(
            text = "Let,s Play",
            color = Color.Gray,
            fontSize = 20.sp
            )
        Spacer(modifier = Modifier.height(30.dp))
        Row() {
            Button(onClick = { /*TODO*/ }) {
                Text(
                    text = "CHECK",
                    fontSize = 20.sp
                    )
            }
            Spacer(modifier = Modifier.width(30.dp))
            Button(onClick = { /*TODO*/ }) {
                Text(
                    text = "PLAY AGAIN",
                    fontSize = 20.sp
                )
            }
        }

    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Number_Guessing_GameTheme {
    }
}
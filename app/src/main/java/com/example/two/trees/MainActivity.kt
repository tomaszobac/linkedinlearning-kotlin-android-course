package com.example.two.trees

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.two.trees.ui.theme.AppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            StateApp()
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun StateApp() {
    AppTheme {
        Scaffold(
            modifier = Modifier.fillMaxSize(),
            topBar = {
                TopAppBar(
                    title = {
                        Text("What state are you in?")
                    },
                    colors = TopAppBarDefaults.topAppBarColors(
                        containerColor = MaterialTheme.colorScheme.primary,
                        titleContentColor = MaterialTheme.colorScheme.onPrimary,
                        navigationIconContentColor = MaterialTheme.colorScheme.onPrimary
                    )
                )
            }
        ) { innerPadding ->
            val states: List<String> = remember {
                listOf(
                    "Maryland",
                    "Texas",
                    "California",
                    "Maine",
                    "Utah",
                    "Washington"
                )
            }
            var guess by remember { mutableStateOf("") }
            var guessedState: String? by remember { mutableStateOf(null) }

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp)
            ) {
                EnterGuess(
                    modifier = Modifier.padding(innerPadding),
                    guess = guess,
                    guessChanged = { newGuess ->
                        guess = newGuess
                    },
                    checkGuess = {
                        guessedState = states.find { it == guess }
                    }
                )

                Spacer(modifier = Modifier.height(24.dp))

                DisplayStates(states = states, guessedState = guessedState)
            }
        }
    }
}

@Composable
fun EnterGuess(
    modifier: Modifier = Modifier,
    guess: String,
    guessChanged: (String) -> Unit,
    checkGuess: () -> Unit
) {
    Column(
        modifier = modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        TextField(
            value = guess,
            onValueChange = guessChanged,
            placeholder = {
                Text("Enter a state")
            }
        )

        Spacer(modifier = Modifier.height(24.dp))

        Button(
            onClick = checkGuess
        ) {
            Text(
                text = "Make your guess",
                style = MaterialTheme.typography.titleLarge
            )
        }
    }
}

@Composable
fun DisplayStates(
    modifier: Modifier = Modifier,
    states: List<String>,
    guessedState: String?
) {
    LazyVerticalGrid(
        modifier = modifier,
        columns = GridCells.Adaptive(minSize = 120.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(states) { item ->
            val isSelected = guessedState == item
            val borderColor =
                if (isSelected) MaterialTheme.colorScheme.tertiary else Color.Transparent

            Box(
                modifier = Modifier
                    .height(120.dp)
                    .background(MaterialTheme.colorScheme.surfaceContainer)
                    .border(
                        width = 4.dp,
                        color = borderColor
                    ),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = if (isSelected) item else "",
                    style = MaterialTheme.typography.labelLarge
                )
            }
        }
    }
}

@Preview(
    showBackground = true,
    device = Devices.NEXUS_5,
    name = "Nexus 5"
)
@Composable
fun StateAppPreview() {
    AppTheme {
        StateApp()
    }
}

package com.example.myspecial.application.lessons

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.myspecial.application.ui.theme.AppTheme

@Composable
fun StringPlaceholderComposable(modifier: Modifier = Modifier) {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        TextField(
            value = email,
            onValueChange = { email = it },
            label = {
                Text(text = "Email")
            },
            placeholder = {
                Text(text = "Enter your email address")
            }
        )
        TextField(
            value = password,
            onValueChange = { password = it },
            label = {
                Text(text = "Password")
            },
            placeholder = {
                Text(text = "Enter your password")
            }
        )
        Button(
            onClick = {
                Log.i("StringPlaceholderComposable", "email: $email, password: $password")
            }
        ) {
            Text (
                text = "Submit"
            )
        }
    }
}

@Preview(
    showBackground = true,
    device = Devices.PIXEL_4_XL,
    name = "Pixel 4 XL"
)
@Composable
fun StringPlaceholderComposablePreview() {
    AppTheme {
        StringPlaceholderComposable()
    }
}

package com.example.myspecial.application.lessons

import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarDuration
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.SnackbarResult
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.myspecial.application.R
import com.example.myspecial.application.ui.theme.AppTheme
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@Composable
fun SnackbarComposable(
    modifier: Modifier = Modifier,
    scope: CoroutineScope,
    snackbarHostState: SnackbarHostState
) {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    val message = stringResource(R.string.message_text, email, password)

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
        val context = LocalContext.current
        val controller = LocalSoftwareKeyboardController.current
        Button(
            onClick = {
                controller?.hide()
                scope.launch {
                    val result: SnackbarResult = snackbarHostState.showSnackbar(
                        message = "I'm a Snackbar! 👋",
                        actionLabel = "Show Info",
                        duration = SnackbarDuration.Indefinite
                    )

                    if (result == SnackbarResult.ActionPerformed) {
                        Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
                    }
                }
                Log.i("SnackbarComposable", message)
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
fun SnackbarComposablePreview() {
    val scope = rememberCoroutineScope()
    val snackbarHostState = remember { SnackbarHostState() }

    AppTheme {
        Scaffold(
            modifier = Modifier.fillMaxSize(),
            snackbarHost = {
                SnackbarHost(hostState = snackbarHostState)
            }
        ) { padding ->
            SnackbarComposable(
                modifier = Modifier.padding(padding),
                scope = scope,
                snackbarHostState = snackbarHostState
            )
        }
    }
}

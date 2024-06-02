package com.example.myspecial.application.challenge

import android.widget.Toast
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.myspecial.application.R
import com.example.myspecial.application.ui.theme.AppTheme

@Composable
fun GetToKnowYouComposable(
    modifier: Modifier = Modifier,
) {
    var firstName by remember { mutableStateOf("") }
    var favoriteColor by remember { mutableStateOf("") }
    var favoriteSnack by remember { mutableStateOf("") }
    val message = stringResource(
        R.string.get_to_know_you_text,
        firstName,
        favoriteColor,
        favoriteSnack
    )

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        TextField(
            value = firstName,
            onValueChange = { firstName = it },
            label = {
                Text(text = "First Name")
            },
            placeholder = {
                Text(text = "Enter your first name")
            }
        )
        Spacer(modifier = Modifier.height(16.dp))
        TextField(
            value = favoriteColor,
            onValueChange = { favoriteColor = it },
            label = {
                Text(text = "Favorite Color")
            },
            placeholder = {
                Text(text = "Enter your favorite color")
            }
        )
        Spacer(modifier = Modifier.height(16.dp))
        TextField(
            value = favoriteSnack,
            onValueChange = { favoriteSnack = it },
            label = {
                Text(text = "Favorite Snack")
            },
            placeholder = {
                Text(text = "Enter your favorite snack")
            }
        )
        Spacer(modifier = Modifier.height(16.dp))

        val context = LocalContext.current
        val controller = LocalSoftwareKeyboardController.current
        Button(
            modifier = Modifier.fillMaxWidth(fraction = 0.5f),
            onClick = {
                controller?.hide()
                Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
            }
        ) {
            Text(text = "Submit")
        }
    }
}

@Preview(
    showBackground = true,
    device = Devices.PIXEL_4_XL,
    name = "Pixel 4 XL"
)
@Composable
fun GetToKnowYouComposablePreview() {
    AppTheme {
        GetToKnowYouComposable()
    }
}

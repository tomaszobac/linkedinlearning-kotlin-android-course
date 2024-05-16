package com.example.myspecial.application.challenge

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.myspecial.application.R
import com.example.myspecial.application.ui.theme.MySpecialApplicationTheme

@Composable
fun MyComposable() {
    Column(
        modifier = Modifier.fillMaxSize()
        // choose the correct alignments
    ) {
        Image(
            painter = painterResource(id = R.drawable.logo),
            modifier = Modifier
                .height(400.dp)
                .padding(16.dp),
            contentScale = ContentScale.Crop,
            contentDescription = "App logo"
        )
        Column(
            modifier = Modifier.fillMaxWidth(),
            // choose the correct alignments
        ) {
            Icon(
                imageVector = , // choose the correct icon
                contentDescription = "Shopping cart icon",
            )
            Text(
                text = "<Update me!>",
                modifier = Modifier.padding(16.dp),
            )
        }
        Button(
            modifier = , // should expand horizontally and have padding
            onClick = { /* Ignore */ }
        ) {
            Text(
                text = "<Update me!>",
                fontWeight = FontWeight.Bold,
                style = MaterialTheme.typography.headlineMedium
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MyComposablePreview() {
    MySpecialApplicationTheme {
        MyComposable()
    }
}

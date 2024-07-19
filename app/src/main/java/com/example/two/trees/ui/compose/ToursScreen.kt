package com.example.two.trees.ui.compose

import androidx.compose.foundation.Image
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.two.trees.R
import com.example.two.trees.ui.theme.AppTheme

@Composable
fun ToursScreen(
    isSubscribed: Boolean,
    onSubscribeClick: (String) -> Unit,
    modifier: Modifier = Modifier,
    scrollState: ScrollState = rememberScrollState()
) {
    Column(modifier = modifier
        .fillMaxSize()
        .verticalScroll(scrollState)
    ) {
        Image(
            painter = painterResource(R.drawable.olive_field),
            modifier = Modifier.aspectRatio(16f / 9f),
            contentScale = ContentScale.Crop,
            contentDescription = null
        )
        Text(
            stringResource(R.string.tours_label).uppercase(),
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            style = MaterialTheme.typography.headlineMedium,
            fontWeight = FontWeight.Bold
        )
        Text(
            stringResource(R.string.tours_content),
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            fontSize = 18f.sp,
            lineHeight = 28.sp
        )

        if (!isSubscribed) {
            SubscribeToNewsletter(
                onSubscribeClick = onSubscribeClick
            )
        }
    }
}

@Composable
private fun SubscribeToNewsletter(
    onSubscribeClick: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    var emailAddress by remember { mutableStateOf("") }

    Column(
        modifier = modifier
    ) {
        Text(
            stringResource(R.string.subscribe_to_newsletter),
            modifier = Modifier.fillMaxWidth()
                .padding(16.dp),
            style = MaterialTheme.typography.headlineSmall,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center
        )
        TextField(
            value = emailAddress,
            onValueChange = {
                emailAddress = it
            },
            placeholder = {
                Text(stringResource(R.string.enter_your_email_address))
            },
            modifier = Modifier.fillMaxWidth()
                .padding(16.dp),
        )
        TextButton(
            onClick = { onSubscribeClick(emailAddress) }
        ) {
            Text(
                stringResource(R.string.subscribe).uppercase(),
                modifier = Modifier.fillMaxWidth()
                    .padding(16.dp),
                style = MaterialTheme.typography.titleLarge,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ToursScreenNotSubscribedPreview() {
    AppTheme {
        ToursScreen(
            isSubscribed = false,
            onSubscribeClick = {}
        )
    }
}

@Preview(showBackground = true)
@Composable
fun ToursScreenSubscribedPreview() {
    AppTheme {
        ToursScreen(
            isSubscribed = true,
            onSubscribeClick = {}
        )
    }
}

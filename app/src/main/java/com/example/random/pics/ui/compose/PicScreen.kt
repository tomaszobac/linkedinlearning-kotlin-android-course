package com.example.random.pics.ui.compose

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.random.pics.data.Picture
import com.example.random.pics.ui.theme.RandomPicAppTheme

@Composable
fun PicScreen(
    pic: Picture,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier.fillMaxSize()
            .padding(16.dp),
    ) {
        AsyncImage(
            model = ImageRequest.Builder(LocalContext.current)
                .data(pic.largeUrl)
                .crossfade(true)
                .build(),
            contentDescription = null,
            modifier = Modifier.fillMaxWidth()
                .height(400.dp),
            alignment = Alignment.Center,
        )
        Spacer(Modifier.width(24.dp))
        Text(
            text = pic.name.uppercase(),
            modifier = modifier.fillMaxWidth(),
            style = MaterialTheme.typography.headlineMedium,
            fontWeight = FontWeight.Bold
        )
        Text(
            text = pic.job,
            modifier = modifier.fillMaxWidth(),
            style = MaterialTheme.typography.headlineSmall,
        )
    }
}

@Preview(showBackground = true)
@Composable
fun PicScreenPreview() {
    val pic = Picture(
        name = "Elvin",
        thumbnailUrl = "https://duckduckgo.com/?q=omittam",
        largeUrl = "http://www.bing.com/search?q=quis",
        job = "Cetero"
    )

    RandomPicAppTheme {
        PicScreen(pic = pic)
    }
}

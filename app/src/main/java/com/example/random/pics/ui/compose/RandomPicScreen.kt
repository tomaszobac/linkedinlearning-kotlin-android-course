package com.example.random.pics.ui.compose

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.random.pics.data.Picture
import com.example.random.pics.ui.theme.RandomPicAppTheme

@Composable
fun RandomPicScreen(
    pics: List<Picture>,
    displayImages: () -> Unit,
    onPictureClick: (picture: Picture) -> Unit,
    modifier: Modifier = Modifier,
) {
    LazyColumn(modifier = modifier.fillMaxSize()) {
        item {
            DisplayRandomImages(displayImages = displayImages)
        }

        items(pics) { pic ->
            PictureItem(
                pic = pic,
                onPictureClick = onPictureClick
            )
        }
    }
}

@Composable
fun DisplayRandomImages(
    displayImages: () -> Unit,
    modifier: Modifier = Modifier
) {
    Button(
        modifier = modifier.fillMaxWidth()
            .padding(24.dp),
        onClick = displayImages
    ) {
        Text(
            text = "Display Random Images",
            style = MaterialTheme.typography.titleLarge
        )
    }
}

@Composable
private fun PictureItem(
    pic: Picture,
    onPictureClick: (picture: Picture) -> Unit,
    modifier: Modifier = Modifier
) {
    ElevatedCard(
        modifier = modifier.padding(16.dp),
        onClick = { onPictureClick(pic) }
    ) {
        Row(
            modifier = Modifier.padding(vertical = 8.dp),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            AsyncImage(
                model = ImageRequest.Builder(LocalContext.current)
                    .data(pic.thumbnailUrl)
                    .crossfade(true)
                    .build(),
                contentDescription = null,
                modifier = Modifier.size(140.dp)
                    .clip(CircleShape)
            )
            Spacer(Modifier.width(24.dp))
            Column {
                Text(
                    text = pic.name.uppercase(),
                    modifier = modifier.fillMaxSize(),
                    style = MaterialTheme.typography.headlineMedium,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = pic.job,
                    modifier = modifier.fillMaxSize(),
                    style = MaterialTheme.typography.headlineSmall,
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun RandomPicScreenPreview() {
    val pics = listOf(
        Picture(
            name = "Elvin",
            thumbnailUrl = "https://duckduckgo.com/?q=omittam",
            largeUrl = "http://www.bing.com/search?q=quis",
            job = "Cetero"
        ),
        Picture(
            name = "Mindy",
            thumbnailUrl = "http://www.bing.com/search?q=reque",
            largeUrl = "https://duckduckgo.com/?q=quidam",
            job = "Curae"
        )
    )
    RandomPicAppTheme {
        RandomPicScreen(
            pics = pics,
            displayImages = {},
            onPictureClick = {}
        )
    }
}

package com.example.random.pics

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.random.pics.ui.compose.RandomPicsAppBar
import com.example.random.pics.ui.compose.RandomPicsNavHost
import com.example.random.pics.ui.theme.RandomPicAppTheme

class RandomPictureActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            RandomPictureApp()
        }
    }
}

@Composable
fun RandomPictureApp() {
    RandomPicAppTheme {
        Scaffold(
            modifier = Modifier.fillMaxSize(),
            topBar = { RandomPicsAppBar() }
        ) { innerPadding ->
            RandomPicsNavHost(
                modifier = Modifier.padding(innerPadding)
            )
        }
    }
}

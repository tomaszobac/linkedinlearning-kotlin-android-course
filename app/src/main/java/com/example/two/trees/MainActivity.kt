package com.example.two.trees

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import com.example.two.trees.ui.compose.HomeScreen
import com.example.two.trees.ui.compose.TwoTreesAppBar
import com.example.two.trees.ui.theme.AppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TwoTreesApp()
        }
    }
}

@Composable
fun TwoTreesApp() {
    AppTheme {
        Scaffold(
            modifier = Modifier.fillMaxSize(),
            topBar = {
                TwoTreesAppBar(
                    appName = R.string.app_name,
                )
            }
        ) { innerPadding ->
            HomeScreen(
                modifier = Modifier.padding(innerPadding)
                    .fillMaxSize()
            )
        }
    }
}

@Preview(
    showBackground = true,
    device = Devices.PIXEL_5,
)
@Composable
fun TwoTreesAppPreview() {
    AppTheme {
        TwoTreesApp()
    }
}

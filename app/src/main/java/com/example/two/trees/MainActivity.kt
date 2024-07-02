package com.example.two.trees

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.myspecial.application.R
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
                TwoTreesAppBar()
            }
        ) { innerPadding ->
            ImageSwapper(
                modifier = Modifier.padding(innerPadding),
            )
        }
    }
}

@Composable
fun ImageSwapper(
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        val imageId: MutableState<Int> = remember {
            mutableIntStateOf(R.drawable.olive_branch_vector)
        }

        Image(
            painter = painterResource(imageId.value),
            modifier = Modifier.fillMaxWidth(),
            contentScale = ContentScale.Fit,
            contentDescription = null
        )

        Spacer(modifier = Modifier.height(24.dp))

        Button(
            onClick = {
                imageId.value = if (imageId.value == R.drawable.olive_branch_vector)
                    R.drawable.logo
                else
                    R.drawable.olive_branch_vector
            }
        ) {
            Text(
                text = "Swap image",
                style = MaterialTheme.typography.titleLarge
            )
        }
    }
}

@Preview(
    showBackground = true,
    device = Devices.NEXUS_5,
    name = "Nexus 5"
)
@Composable
fun MyComposableNexusPreview() {
    AppTheme {
        TwoTreesApp()
    }
}

package com.example.random.pics.ui.compose

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.random.pics.RandomPictureViewModel
import com.example.random.pics.RandomPictureViewModelFactory
import com.example.random.pics.data.PictureRepository

private const val TAG = "RandomPicsNavHost"

@Composable
fun RandomPicsNavHost(
    modifier: Modifier = Modifier
) {
    val navController = rememberNavController()
    val viewModel: RandomPictureViewModel = viewModel(
        factory = RandomPictureViewModelFactory(
            pictureRepository = PictureRepository()
        )
    )
    val pics by viewModel.pictures.collectAsStateWithLifecycle()

    // TODO: observe changes to the selected picture
    val selectedPicture by viewModel.selectedPicture.collectAsStateWithLifecycle()

    NavHost(
        navController = navController,
        startDestination = "home",
        modifier = modifier
    ) {
        composable(route = "home") {
            RandomPicScreen(
                pics = pics,
                displayImages = { viewModel.showRandomImage() },
                onPictureClick = { pic ->
                    Log.i(TAG, "The selected picture: $pic")
                    // TODO: update the selected picture
                    viewModel.selectPicture(pic)
                    navController.navigate("picture")
                }
            )
        }
        composable(route = "picture") {
            // TODO: swap the first picture for the selected one
            selectedPicture?.let { pic -> PicScreen(pic = pic) }
        }
    }
}

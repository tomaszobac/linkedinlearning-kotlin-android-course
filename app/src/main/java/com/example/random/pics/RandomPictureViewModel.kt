package com.example.random.pics

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.random.pics.data.Picture
import com.example.random.pics.data.PictureRepository
import com.example.two.trees.data.Product
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.mapLatest
import kotlinx.coroutines.flow.stateIn
import kotlin.random.Random

@OptIn(ExperimentalCoroutinesApi::class)
class RandomPictureViewModel(
    private val pictureRepository: PictureRepository
) : ViewModel() {

    private val _randomPageNumber = MutableStateFlow(0)

    // TODO: create StateFlows for the selected picture
    private val _selectedPicture = MutableStateFlow<Picture?>(null)
    val selectedPicture = _selectedPicture

    fun selectPicture(picture: Picture) {
        _selectedPicture.value = picture
    }

    val pictures: StateFlow<List<Picture>> = _randomPageNumber
        .mapLatest { num ->
            pictureRepository.getPictures(page = num)
        }
        .stateIn(viewModelScope, SharingStarted.Eagerly, emptyList())

    fun showRandomImage() {
        _randomPageNumber.value = Random.nextInt(0, 3)
    }

    // TODO: create a function to update the selected picture

}

class RandomPictureViewModelFactory(
    private val pictureRepository: PictureRepository
) : ViewModelProvider.Factory {
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(RandomPictureViewModel::class.java)) {
            return RandomPictureViewModel(pictureRepository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}

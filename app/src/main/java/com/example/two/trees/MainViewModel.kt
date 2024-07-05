package com.example.two.trees

import android.util.Log
import androidx.lifecycle.ViewModel
import kotlin.random.Random

private const val TAG = "MainViewModel"

class MainViewModel : ViewModel() {

    init {
        Log.i(TAG, "initialized")
    }

    fun generateNewImageId(): Int {
        Log.i(TAG, "generateNewImageId")
        return when(Random.nextInt(4)) {
            0 -> R.drawable.delicate_olive_oil
            1 -> R.drawable.lemon_olive_oil
            2 -> R.drawable.chili_olive_oil
            3 -> R.drawable.basil_olive_oil
            else -> R.drawable.logo
        }
    }
}

package com.example.two.trees

import android.util.Log
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

private const val TAG = "MainViewModel"

class MainViewModel : ViewModel() {

    private val _quantity = MutableStateFlow(0)
    val quantity: StateFlow<Int> = _quantity

    init {
        Log.i(TAG, "initialized")
    }

}

package com.example.two.trees

import android.util.Log
import androidx.lifecycle.ViewModel
import com.example.two.trees.data.Product
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

private const val TAG = "MainViewModel"

class MainViewModel : ViewModel() {

    private val _quantity = MutableStateFlow(0)
    val quantity: StateFlow<Int> = _quantity

    init {
        val product = Product(
            name = "Sandy Sears",
            imageFile = "efficiantur",
            description = "molestiae",
            size = 2659,
            price = 2.3
        )
        Log.i(TAG, "initialized")
        Log.i(TAG, product.toString())
    }

}

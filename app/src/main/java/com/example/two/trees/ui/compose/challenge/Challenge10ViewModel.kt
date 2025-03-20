package com.example.two.trees.ui.compose.challenge

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow

private const val PRICE_PER_CAN_OF_OLIVES = 5

class Challenge10ViewModel : ViewModel() {

    private val _quantity = MutableStateFlow(0)
    val quantity = _quantity
    // TODO: create public variable

    private val _totalAmount = MutableStateFlow(0)
    val totalAmount = _totalAmount
    // TODO: create public variable

    fun increaseQuantity() {
        _quantity.value += 1
        // TODO: implement this method
    }

    fun decreaseQuantity() {
        _quantity.value -= 1
        // TODO: implement this method
    }

    fun checkout() {
        _totalAmount.value = _quantity.value * PRICE_PER_CAN_OF_OLIVES
    }

}

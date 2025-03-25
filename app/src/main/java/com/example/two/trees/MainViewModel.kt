package com.example.two.trees

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.two.trees.data.Product
import com.example.two.trees.data.ProductRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

private const val TAG = "MainViewModel"

class MainViewModel(
    private val productRepository: ProductRepository
) : ViewModel() {
    private val _products = MutableStateFlow(emptyList<Product>())
    val products: StateFlow<List<Product>> = _products

    private val _selectedProduct = MutableStateFlow<Product?>(null)
    val selectedProduct: StateFlow<Product?> = _selectedProduct

    val quantity: StateFlow<Int> = productRepository.quantity
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5_000),
            initialValue = 0
        )

    // TODO: create a StateFlow<Boolean> that gets data from productRepository
    val subscriptionStatus: StateFlow<Boolean> = productRepository.subscriptionStatus
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5_000),
            initialValue = false
        )

    init {
        viewModelScope.launch {
            _products.value = productRepository.getProducts()
            Log.i(TAG, _products.value.toString())
        }
    }

    fun selectProduct(product: Product) {
        _selectedProduct.value = product
    }

    fun incrementQuantity() {
        viewModelScope.launch {
            productRepository.incrementQuantity()
        }
    }

    fun decrementQuantity() {
        viewModelScope.launch {
            productRepository.decrementQuantity()
        }
    }

    fun onSubscribeClick() {
        viewModelScope.launch {
            productRepository.subscribeToNewsletter()
        }
    }

}

class MainViewModelFactory(
    private val productRepository: ProductRepository
) : ViewModelProvider.Factory {
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MainViewModel::class.java)) {
            return MainViewModel(productRepository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}

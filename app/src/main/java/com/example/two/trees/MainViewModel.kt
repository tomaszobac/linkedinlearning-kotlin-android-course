package com.example.two.trees

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.two.trees.data.Product
import com.example.two.trees.data.ProductRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

private const val TAG = "MainViewModel"

class MainViewModel(
    private val productRepository: ProductRepository
) : ViewModel() {
    private val _products = MutableStateFlow(emptyList<Product>())
    val products: StateFlow<List<Product>> = _products

    private val _quantity = MutableStateFlow(0)
    val quantity: StateFlow<Int> = _quantity

    init {
        val data = productRepository.getProducts(
            filename = "olive_oils_data.json"
        )
        data?.let {
            _products.value = it
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

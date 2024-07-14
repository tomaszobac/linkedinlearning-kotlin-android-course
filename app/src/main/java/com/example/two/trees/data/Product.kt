package com.example.two.trees.data

import com.squareup.moshi.Json

data class Product(
    @Json(name = "productName")
    val name: String,
    val imageFile: String,
    val description: String,
    val size: Int,
    val price: Double
)

package com.example.two.trees.data

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET

interface ProductApi {
    @GET("olive_oils_with_images_data.json")
    suspend fun getProducts(): Response<List<Product>>
}

const val BASE_ENDPOINT_URL = "https://2873199.youcanlearnit.net/"

class ProductRepository {

    private val moshi: Moshi by lazy {
        Moshi.Builder().add(KotlinJsonAdapterFactory()).build()
    }

    private val retrofit: Retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_ENDPOINT_URL)
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .build()
    }

    private val productApi: ProductApi by lazy {
        retrofit.create(ProductApi::class.java)
    }

    suspend fun getProducts(): List<Product> {
        val response = productApi.getProducts()
        return if (response.isSuccessful)
            response.body().orEmpty()
        else
            emptyList()
    }
}

package com.example.two.trees.data

import android.content.Context
import android.util.Log
import com.squareup.moshi.Moshi
import com.squareup.moshi.Types
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import java.io.File

interface ProductApi {
    @GET("olive_oils_with_images_data.json")
    suspend fun getProducts(): Response<List<Product>>
}

const val BASE_ENDPOINT_URL = "https://2873199.youcanlearnit.net/"

class ProductRepository(private val context: Context) {

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

    private fun storeDataInFile(products: List<Product>) {
        val listType = Types.newParameterizedType(List::class.java, Product::class.java)
        val fileContents = moshi.adapter<List<Product>>(listType).toJson(products)

        val file = File(context.cacheDir, "products.json")
        file.writeText(fileContents, Charsets.UTF_8)
    }

    private fun readDataFromFile(): List<Product> {
        val file = File(context.cacheDir, "products.json")
        val json = if (file.exists()) file.readText() else null

        return if (json == null)
            emptyList()
        else {
            val listType = Types.newParameterizedType(List::class.java, Product::class.java)
            moshi.adapter<List<Product>>(listType).fromJson(json).orEmpty()
        }
    }

    suspend fun getProducts(): List<Product> {
        val productsFromCache = readDataFromFile()
        if (productsFromCache.isNotEmpty()) {
            Log.i("ProductRepository", "loaded from cache")
            return productsFromCache
        }

        val response = productApi.getProducts()
        return if (response.isSuccessful) {
            Log.i("ProductRepository", "loaded from webservice")
            val products = response.body()
            products?.let{ storeDataInFile(it) }
            products.orEmpty()
        }
        else
            emptyList()
    }
}

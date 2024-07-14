package com.example.two.trees.data

import android.content.Context
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi
import com.squareup.moshi.Types
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

const val BASE_ENDPOINT_URL = "https://2873199.youcanlearnit.net/"

class ProductRepository(private val context: Context) {

    private val retrofit: Retrofit by lazy {
        val moshi = Moshi.Builder().add(KotlinJsonAdapterFactory()).build()

        Retrofit.Builder()
            .baseUrl(BASE_ENDPOINT_URL)
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .build()
    }

    fun getTextFromResources(resourceId: Int): String {
        return context.resources.openRawResource(resourceId)
            .bufferedReader()
            .use { it.readText() }
    }

    fun getTextFromAssets(filename: String): String {
        return context.resources.assets.open(filename)
            .bufferedReader()
            .use { it.readText() }
    }

    fun getProducts(filename: String): List<Product>? {
        val moshi = Moshi.Builder().add(KotlinJsonAdapterFactory()).build()
        val listType = Types.newParameterizedType(
            List::class.java, Product::class.java
        )
        val adapter: JsonAdapter<List<Product>> = moshi.adapter(listType)
        return adapter.fromJson(getTextFromAssets(filename = filename))
    }
}

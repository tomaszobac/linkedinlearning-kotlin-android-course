package com.example.two.trees.data

import android.content.Context

class ProductRepository(private val context: Context) {

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
}

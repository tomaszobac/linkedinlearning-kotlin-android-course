package com.example.random.pics.data

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path

interface PictureApi {

    @GET("/robots/{page}/robots.json")
    suspend fun getPictures(@Path("page") page: Int): Response<List<Picture>>
}

const val BASE_ENDPOINT_URL = "https://2873199.youcanlearnit.net/"

class PictureRepository {

    private val retrofit: Retrofit by lazy {
        val moshi = Moshi.Builder().add(KotlinJsonAdapterFactory()).build()

        Retrofit.Builder()
            .baseUrl(BASE_ENDPOINT_URL)
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .build()
    }

    private val pictureApi: PictureApi by lazy {
        retrofit.create(PictureApi::class.java)
    }

    suspend fun getPictures(page: Int): List<Picture> {
        val response = pictureApi.getPictures(page)
        return if (response.isSuccessful)
            response.body().orEmpty()
        else
            emptyList()
    }
}

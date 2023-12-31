package com.example.newsweatherexchangeapp.News

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

object NewsApiClient {

    private  const val BASE_URL = "https://newsapi.org/v2/"

    private val client = OkHttpClient()
        .newBuilder()
        .build()

    private val retrofit =
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .build()
            .create(NewsApi::class.java)

    fun buildService(): NewsApi {
        return retrofit
    }
}
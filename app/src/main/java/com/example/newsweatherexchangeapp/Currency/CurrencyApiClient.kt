package com.example.newsweatherexchangeapp.Currency

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

object CurrencyApiClient {

    private const val API_KEY = "thOXfJIpcG5Yucac9HE9cQ==oXPOQkzVUh5J4mLn"
    private  const val BASE_URL = "https://api.api-ninjas.com/v1/"

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
            .create(CurrencyApi::class.java)

    fun buildService():CurrencyApi{
        return retrofit
    }
}
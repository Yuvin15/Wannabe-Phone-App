package com.example.newsweatherexchangeapp.News

import com.example.newsweatherexchangeapp.Models.NewsModel.News
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsApi {
    @GET("top-headlines")
    fun getNews(@Query("country") country: String, @Query("apiKey") apiKey: String): Observable<News>
}
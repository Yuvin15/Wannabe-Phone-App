package com.example.newsweatherexchangeapp.Weather

import com.example.newsweatherexchangeapp.Models.WeatherModel.Weather
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherApi {
    @GET("1day")
    fun getWeather(@Query("country_code") city: String, @Query("apiKey") apiKey: String): Observable<Weather>
}
package com.example.newsweatherexchangeapp.Weather

import com.example.newsweatherexchangeapp.Models.WeatherModel.Weather
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherApi {
    @GET("1day/305605")
    fun getWeather( @Query("apikey") apiKey: String
    ): Observable<Weather>
}
package com.example.newsweatherexchangeapp.Currency

import com.example.newsweatherexchangeapp.Models.CurrencyModel.Currency
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query

interface CurrencyApi {

    @GET("convertcurrency")
    fun getCurrency(
        @Query("have") have: String,
        @Query("want") want: String,
        @Query("amount") amount: String
    ): Observable<Currency>
}

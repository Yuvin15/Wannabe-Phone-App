package com.example.newsweatherexchangeapp

import android.os.Bundle
import android.util.Log
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.newsweatherexchangeapp.Models.WeatherModel.DailyForecasts
import com.example.newsweatherexchangeapp.Models.WeatherModel.Weather
import com.example.newsweatherexchangeapp.Weather.WeatherApiClient
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        val compositeDisposable = CompositeDisposable()
        compositeDisposable.add(
            WeatherApiClient.buildService()
                .getWeather( "ouon2ZezMb4QAwjGH7czk71UWuGg2I3J")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ response ->
                    onResponse(response)
                }, { t ->
                    onFailure(t)
                })
        )

        val currentTemp = findViewById<TextView>(R.id.textView)
    }

    private fun onResponse(response: Weather) {
        Log.d("[news]", response.toString())
        val daily_Forecasts: ArrayList<DailyForecasts> = response.DailyForecasts
        val currentTemp = findViewById<TextView>(R.id.textView)
        val temperatureValue = daily_Forecasts[0].Temperature

        currentTemp.text = "Temperature: $temperatureValue"
    }

    private fun onFailure(t: Throwable) {
        Toast.makeText(this, t.message, Toast.LENGTH_LONG).show()
        t.printStackTrace()
    }
}

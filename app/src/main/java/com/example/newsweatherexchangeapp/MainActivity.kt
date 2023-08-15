package com.example.newsweatherexchangeapp

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.newsweatherexchangeapp.Currency.CurrencyApiClient
import com.example.newsweatherexchangeapp.Models.CurrencyModel.Currency
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val buttonClick = findViewById<Button>(R.id.button)

        buttonClick.setOnClickListener {
            val intent = Intent(this, MainActivity2::class.java)
            startActivity(intent)
        }


        val currencyValueText = findViewById<TextView>(R.id.currency_value)

        val compositeDisposable = CompositeDisposable()
        compositeDisposable.add(
                CurrencyApiClient.buildService().getCurrency("USD", "ZAR", "100")
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe({ response ->
                        onResponse(response)
                    }, { t ->
                        onFailure(t)
                    })
                )
    }

    private fun onResponse(response: Currency) {
        val newAmount = response.newAmount
        val currencyValueText = findViewById<TextView>(R.id.currency_value)
        currencyValueText.text = "Amount= " + newAmount.toString()

        Toast.makeText(this, "$newAmount", Toast.LENGTH_SHORT).show()
        Log.i("[Success]", "$response")
    }

    private fun onFailure(t: Throwable) {
        Toast.makeText(this, t.message, Toast.LENGTH_SHORT).show()
        t.message?.let { Log.e("[Failed]", it) }
    }
}

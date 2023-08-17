package com.example.newsweatherexchangeapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (savedInstanceState == null) {
            val fragmentManager: FragmentManager = supportFragmentManager
            val fragmentTransaction: FragmentTransaction = fragmentManager.beginTransaction()

            val weatherFragment = WeatherFragment()
            fragmentTransaction.add(R.id.weather_fragment, weatherFragment)

            val currencyFragment = CurrencyFragment()
            fragmentTransaction.add(R.id.currency_fragment, currencyFragment)

            val newsFragment = NewsFragment()
            fragmentTransaction.add(R.id.news_fragment, newsFragment)
            fragmentTransaction.commit()
        }
    }
}

/*
val buttonClick = findViewById<Button>(R.id.button)
val buttonClick2 = findViewById<Button>(R.id.button2)
val buttonClick3 = findViewById<Button>(R.id.button3)

buttonClick.setOnClickListener {
    val intent = Intent(this, MainActivity2::class.java)
    startActivity(intent)
}
buttonClick2.setOnClickListener {
    val intent = Intent(this, MainActivity3::class.java)
    startActivity(intent)
}
buttonClick3.setOnClickListener {
    val intent = Intent(this, SettingsPage::class.java)
    startActivity(intent)
}

val currencyValueText = findViewById<TextView>(R.id.currency_value)

val compositeDisposable = CompositeDisposable()
compositeDisposable.add(
        CurrencyApiClient.buildService().getCurrency("USD", "ZAR", "1")
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
}*/

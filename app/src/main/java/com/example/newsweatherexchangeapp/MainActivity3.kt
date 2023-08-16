package com.example.newsweatherexchangeapp

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.newsweatherexchangeapp.Models.NewsModel.Articles
import com.example.newsweatherexchangeapp.Models.NewsModel.News
import com.example.newsweatherexchangeapp.News.NewsApiClient
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class MainActivity3 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)

        val compositeDisposable = CompositeDisposable()
        compositeDisposable.add(
            NewsApiClient.buildService()
                .getNews("za", "e6870c60da5b44d4a083240aa9fc5820")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ response ->
                    onResponse(response)
                }, { t ->
                    onFailure(t)
                })
        )

        val newsRecyclerView = findViewById<RecyclerView>(R.id.newsView)
        val layoutManager = LinearLayoutManager(this)
        newsRecyclerView.layoutManager = layoutManager
    }

        private fun onResponse(response: News) {
            Log.d("[news]", response.toString())
            val articles: List<Articles> = response.articles
            val newsRecyclerView = findViewById<RecyclerView>(R.id.newsView)
            val newsAdapter = NewsAdapter(articles)
            newsRecyclerView.adapter = newsAdapter
        }

        private fun onFailure(t: Throwable) {
            Toast.makeText(this, t.message, Toast.LENGTH_SHORT).show()
            t.printStackTrace()
        }
}

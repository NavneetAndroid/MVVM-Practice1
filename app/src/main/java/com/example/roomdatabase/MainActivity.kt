package com.example.roomdatabase

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.observe
import com.example.roomdatabase.api.QuoteService
import com.example.roomdatabase.api.RetrofitHelper
import com.example.roomdatabase.repository.QuoteRepository
import com.example.roomdatabase.viewmodel.MainViewModel
import com.example.roomdatabase.viewmodel.MainViewModelFactory
import retrofit2.create

class MainActivity : AppCompatActivity() {
    lateinit var mainViewModel: MainViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val quoteService=RetrofitHelper.getInstance().create(QuoteService::class.java)
val  repository=QuoteRepository(quoteService)

        mainViewModel=ViewModelProvider(this,MainViewModelFactory(repository)).get(MainViewModel::class.java)
        mainViewModel.quotes.observe(this, Observer {
            Log.d("Navneet",it.results.toString())
        })
    }
}
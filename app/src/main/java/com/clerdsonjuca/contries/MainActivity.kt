package com.clerdsonjuca.contries

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.get
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    lateinit var viewModel: MainViewModel
    val countryAdapter = CountryAdapter(arrayListOf())
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val myRecyclerView = findViewById<RecyclerView>(R.id.myRecyclerView)
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        myRecyclerView.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = countryAdapter
        }
        viewModel.fethcCountries()
        viewModel.items.observe(this, Observer {
            it?.let {
                countryAdapter.update(it)
            }
        })
    }
}
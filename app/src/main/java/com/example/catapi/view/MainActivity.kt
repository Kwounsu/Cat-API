package com.example.catapi.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.catapi.R
import com.example.catapi.viewmodel.CatViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    lateinit var catViewModel: CatViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        catViewModel = ViewModelProvider(this).get(CatViewModel::class.java)

        val tabNames = arrayListOf("Breeds","Images")
        catViewModel.tabLayout(tabLayout,tabNames, this, supportFragmentManager, viewPager)
    }
}
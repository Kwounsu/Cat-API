package com.example.catapi

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_breed_detail.*
import kotlinx.android.synthetic.main.breed_item_layout.tv_breedName

class BreedDetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_breed_detail)

        val bundle: Bundle? = intent.extras
        val name = bundle?.get("name")
        val origin = bundle?.get("origin")
        val description = bundle?.get("description")
        val temperament = bundle?.get("temperament")
        val wikipedia_url = bundle?.get("wikipedia_url")

        tv_breedName.text = name.toString()
        tv_breedOrigin.text = origin.toString()
        tv_breedDescription.text = description.toString()
        tv_breedTemperament.text = temperament.toString()
        tv_wikipedia_url.setOnClickListener {
            val openURL = Intent(Intent.ACTION_VIEW)
            openURL.data = Uri.parse(wikipedia_url.toString())
            startActivity(openURL)
        }
    }
}
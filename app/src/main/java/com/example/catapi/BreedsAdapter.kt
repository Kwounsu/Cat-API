package com.example.catapi

import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.catapi.model.Breeds

class BreedsAdapter (var breeds: List<Breeds>) : RecyclerView.Adapter<BreedsAdapter.ViewHolder>() {
    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val breedName: TextView = itemView.findViewById(R.id.tv_breedName)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BreedsAdapter.ViewHolder {
        val context = parent.context
        val inflater = LayoutInflater.from(context)
        val view = inflater.inflate(R.layout.breed_item_layout, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return breeds.size
    }

    override fun onBindViewHolder(holder: BreedsAdapter.ViewHolder, position: Int) {
        val breed = breeds[position]
        holder.breedName.text = breed.name

        holder.itemView.setOnClickListener {
            Log.i("Retrofit", "breed clicked!")
            val intent = Intent(holder.itemView.context, BreedDetailActivity::class.java)
            intent.putExtra("name", breed.name)
            intent.putExtra("origin", breed.origin)
            intent.putExtra("description", breed.description)
            intent.putExtra("temperament", breed.temperament)
            intent.putExtra("wikipedia_url", breed.wikipedia_url)
            holder.itemView.context.startActivity(intent)
        }
    }
}
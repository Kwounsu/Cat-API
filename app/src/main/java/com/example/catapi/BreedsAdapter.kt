package com.example.catapi

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class BreedsAdapter (var breeds: List<Breeds>) : RecyclerView.Adapter<BreedsAdapter.ViewHolder>() {
    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val breedName: TextView = itemView.findViewById(R.id.tv_breedName)
        val breedOrigin: TextView = itemView.findViewById(R.id.tv_breedOrigin)
        val breedDescription: TextView = itemView.findViewById(R.id.tv_breedDescription)
        val breedTemperament: TextView = itemView.findViewById(R.id.tv_breedTemperament)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BreedsAdapter.ViewHolder {
        val context = parent.context
        val inflater = LayoutInflater.from(context)
        val view = inflater.inflate(R.layout.breed_item_layout, parent, false)
        return ViewHolder(view)    }

    override fun getItemCount(): Int {
        return breeds.size
    }

    override fun onBindViewHolder(holder: BreedsAdapter.ViewHolder, position: Int) {
        val breed = breeds[position]
        holder.breedName.text = breed.name
        holder.breedOrigin.text = breed.origin
        holder.breedDescription.text = breed.description
        holder.breedTemperament.text = breed.temperament
    }
}
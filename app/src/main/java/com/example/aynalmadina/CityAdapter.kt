package com.example.aynalmadina

import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CityAdapter(private var cities: List<City>) : RecyclerView.Adapter<CityAdapter.CityViewHolder>() {

    fun updateList(newCities: List<City>) {
        cities = newCities
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CityViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.city_item, parent, false)
        return CityViewHolder(view)
    }

    override fun onBindViewHolder(holder: CityViewHolder, position: Int) {
        val city = cities[position]
        holder.bind(city)
    }

    override fun getItemCount(): Int = cities.size

    class CityViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val cityName: TextView = itemView.findViewById(R.id.cityName)
        private val cityCoord: TextView = itemView.findViewById(R.id.cityCoord)

        fun bind(city: City) {
            cityName.text = "${city.name}, ${city.country}"
            cityCoord.text = "Lat: ${city.coord.lat}, Lon: ${city.coord.lon}"
            itemView.setOnClickListener {
                val gmmIntentUri = Uri.parse("geo:${city.coord.lat},${city.coord.lon}")
                val mapIntent = Intent(Intent.ACTION_VIEW, gmmIntentUri)
                mapIntent.setPackage("com.google.android.apps.maps")
                itemView.context.startActivity(mapIntent)
            }
        }
    }
}

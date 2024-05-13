package com.example.android2finalproject.domain.ui.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.NavHostFragment.Companion.findNavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.android2finalproject.R
import com.example.android2finalproject.databinding.HistoryCardBinding

class WeatherAdapter(private val fragment: Fragment, private val weatherList: List<Any>) : RecyclerView.Adapter<WeatherAdapter.WeatherViewHolder>() {

    inner class WeatherViewHolder(private val binding: HistoryCardBinding) : RecyclerView.ViewHolder(binding.root) {
        @SuppressLint("SetTextI18n")
        fun bind(weather: Any) {
            binding.apply {
//                cityName.text = weather.cityName
//                cityTemperature.text = "Temperature: ${weather.temperature}"
//                cityWind.text = "Wind Speed: ${weather.windSpeed}"
//                cityStatus.text = "Status: ${weather.status}"
            }
            binding.root.setOnClickListener {
                fragment.findNavController().navigate(R.id.action_homeFragment_to_detailedFragment)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WeatherViewHolder {
        val binding = HistoryCardBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return WeatherViewHolder(binding)
    }

    override fun onBindViewHolder(holder: WeatherViewHolder, position: Int) {
        holder.bind(weatherList[position])
    }

    override fun getItemCount(): Int {
        return weatherList.size
    }
}


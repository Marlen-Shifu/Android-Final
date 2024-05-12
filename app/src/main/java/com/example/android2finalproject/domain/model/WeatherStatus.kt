package com.example.android2finalproject.domain.model

enum class WeatherStatus {
    SUNNY,
    CLOUDY,
    RAIN,
    SNOW;

    override fun toString(): String {
        return when(this) {
            SUNNY -> "sunny"
            CLOUDY -> "cloudy"
            RAIN -> "rain"
            SNOW -> "snow"
        }
    }
}

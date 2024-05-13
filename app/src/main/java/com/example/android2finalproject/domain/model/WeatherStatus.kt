package com.example.android2finalproject.domain.model

enum class WeatherStatus {
    SUNNY,
    CLOUDY,
    RAIN,
    SNOW,
    UNDEFINED;

    override fun toString(): String {
        return when(this) {
            SUNNY -> "sunny"
            CLOUDY -> "cloudy"
            RAIN -> "rain"
            SNOW -> "snow"
            UNDEFINED -> "undefined"
        }
    }
}

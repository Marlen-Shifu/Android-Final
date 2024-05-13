package com.example.android2finalproject.service.api.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Coord(
    @SerialName("lon") val longitude: Double,
    @SerialName("lat") val latitude: Double,
)

@Serializable
data class Weather(
    @SerialName("id") val id: Int,
    @SerialName("main") val main: String,
    @SerialName("description") val description: Int,
    @SerialName("icon") val icon: String,
    )

@Serializable
data class Main(
    @SerialName("temp") val temp: Double,
    @SerialName("feels_like") val feelsLike: Double,
    @SerialName("temp_min") val temp_min: Double,
    @SerialName("temp_max") val temp_max: Double,
    @SerialName("pressure") val pressure: Double,
    @SerialName("humidity") val humidity: Int,
    @SerialName("sea_level") val seaLevel: Int,
    @SerialName("grnd_level") val grndLevel: Int,
)

@Serializable
data class Wind(
    @SerialName("speed") val speed: Double,
    @SerialName("deg") val deg: Int,
    @SerialName("gust") val gust: Double,
)

@Serializable
data class Rain(
    @SerialName("1h") val h1: Double,
)

@Serializable
data class Clouds(
    @SerialName("all") val all: Int,
)

@Serializable
data class Sys(
    @SerialName("type") val type: Int,
    @SerialName("id") val id: Long,
    @SerialName("country") val country: String,
    @SerialName("sunrise") val sunrise: Long,
    @SerialName("sunset") val sunset: Long,
)

@Serializable
data class WeatherInfoDto(
    @SerialName("coord") val coord: Coord,
    @SerialName("weather") val weather: List<Weather>,
    @SerialName("base") val base: String,
    @SerialName("main") val main: Main,
    @SerialName("visibility") val visibility: Int,
    @SerialName("wind") val wind: Wind,
    @SerialName("rain") val rain: Rain?,
    @SerialName("clouds") val clouds: Clouds,
    @SerialName("dt") val dt: Long,
    @SerialName("sys") val sys: Sys,
    @SerialName("timezone") val timezone: Int,
    @SerialName("id") val id: Long,
    @SerialName("name") val name: String,
    @SerialName("cod") val cod: Int,
)

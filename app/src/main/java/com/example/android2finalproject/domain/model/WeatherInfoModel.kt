package com.example.android2finalproject.domain.model

import java.util.UUID

data class WeatherInfoModel(
    val id: UUID,
    var cityName: String,
    var temperature: Double,
    var windSpeed: Double,
    var status: WeatherStatus,
    val creationTime: Long,
)

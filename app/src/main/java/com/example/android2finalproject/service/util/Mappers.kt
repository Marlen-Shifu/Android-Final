package com.example.android2finalproject.service.util

import com.example.android2finalproject.domain.model.WeatherInfoModel
import com.example.android2finalproject.domain.model.WeatherStatus
import com.example.android2finalproject.service.api.dto.WeatherInfoDto


fun WeatherInfoDto.toModel(): WeatherInfoModel = WeatherInfoModel(
    id = this.id,
    cityName = this.name,
    temperature = this.main.temp,
    windSpeed = this.wind.speed,
    status = when(this.weather[0].main) {
        "Clear" -> WeatherStatus.SUNNY
        "Clouds" -> WeatherStatus.CLOUDY
        "Snow" -> WeatherStatus.SNOW
        "Rain" -> WeatherStatus.RAIN
        else -> WeatherStatus.UNDEFINED
        },
    creationTime = this.dt,
)

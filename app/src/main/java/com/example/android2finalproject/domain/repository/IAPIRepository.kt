package com.example.android2finalproject.domain.repository

import android.net.http.NetworkException
import com.example.android2finalproject.domain.model.WeatherInfoModel

interface IAPIRepository {
    @Throws(NetworkException::class)
    suspend fun getWeatherInfo(weatherInfo: WeatherInfoModel)
}

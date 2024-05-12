package com.example.android2finalproject.domain.repository

import android.net.http.NetworkException
import com.example.android2finalproject.domain.model.WeatherInfoModel

interface IAPIRepository {
    @Throws(NetworkException::class)
    suspend fun getWeatherInfoByCityName(cityName: String)

    @Throws(NetworkException::class)
    suspend fun getWeatherInfoByGeo(latitude: Double, longitude: Double)
}

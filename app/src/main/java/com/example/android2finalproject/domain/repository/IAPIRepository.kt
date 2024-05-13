package com.example.android2finalproject.domain.repository

import android.net.http.NetworkException
import com.example.android2finalproject.domain.model.DataState
import com.example.android2finalproject.domain.model.WeatherInfoModel
import kotlinx.coroutines.flow.Flow

interface IAPIRepository {
    @Throws(NetworkException::class)
    suspend fun getWeatherInfoByCityName(cityName: String): Flow<DataState<WeatherInfoModel>>

    @Throws(NetworkException::class)
    suspend fun getWeatherInfoByGeo(latitude: Double, longitude: Double): Flow<DataState<WeatherInfoModel>>
}

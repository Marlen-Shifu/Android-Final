package com.example.android2finalproject.domain.repository

import com.example.android2finalproject.domain.model.DataState
import com.example.android2finalproject.domain.model.ValidationException
import com.example.android2finalproject.domain.model.WeatherInfoModel
import com.example.android2finalproject.domain.model.WeatherStatus
import kotlinx.coroutines.flow.Flow
import java.util.UUID

interface IWeatherInfoModelRepository {

    fun getWeatherInfos(): Flow<DataState<List<WeatherInfoModel>>>

    fun getWeatherInfo(id: UUID): Flow<DataState<WeatherInfoModel>>

    @Throws(ValidationException::class)
    suspend fun addWeatherInfo(cityName: String, temperatue: Double, windSpeed: Double, status: WeatherStatus)

    suspend fun deleteWeatherInfo(task: WeatherInfoModel)
}

package com.example.android2finalproject.service.api

import com.example.android2finalproject.domain.model.DataState
import com.example.android2finalproject.domain.model.WeatherInfoModel
import com.example.android2finalproject.domain.repository.IAPIRepository
import com.example.android2finalproject.service.util.toModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map

class OPAPIRepo constructor(
    private val api: OpenWeatherAPI
): IAPIRepository {
    override suspend fun getWeatherInfoByCityName(cityName: String): Flow<DataState<WeatherInfoModel>> = flow {
        emit(DataState.Initial)
        val response = api.getWeatherInfoByCityName(cityName = cityName)
        emit(DataState.Result(response.toModel()))
    }

    override suspend fun getWeatherInfoByGeo(
        latitude: Double,
        longitude: Double
    ): Flow<DataState<WeatherInfoModel>> = flow {
        emit(DataState.Initial)
        val response = api.getWeatherInfoByGeo(latitude = latitude, longitude = longitude)
        emit(DataState.Result(response.toModel()))
    }
}

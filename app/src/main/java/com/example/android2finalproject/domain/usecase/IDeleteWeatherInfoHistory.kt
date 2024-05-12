package com.example.android2finalproject.domain.usecase

import com.example.android2finalproject.domain.model.DataState
import com.example.android2finalproject.domain.model.WeatherInfoModel
import kotlinx.coroutines.flow.Flow

interface IDeleteWeatherInfoHistory{
    suspend operator fun invoke(weatherInfo: WeatherInfoModel): Flow<DataState<Boolean>>
}

package com.example.android2finalproject.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.android2finalproject.domain.usecase.IDeleteWeatherInfoHistoryUseCase
import com.example.android2finalproject.domain.usecase.IGetWeatherInfoByGPSUseCase
import com.example.android2finalproject.domain.usecase.IGetWeatherInfoHistoryItemUseCase
import com.example.android2finalproject.domain.usecase.IGetWeatherInfoHistoryUseCase
import com.example.android2finalproject.domain.usecase.IGetWeatherInfoUseCase
import com.example.android2finalproject.domain.usecase.ISettingsUseCase


class ViewModelFactory constructor(
    private val getWeatherInfoCase: IGetWeatherInfoUseCase,
    private val getWeatherInfoByGPSCase: IGetWeatherInfoByGPSUseCase,
    private val getWeatherInfoHistoryCase: IGetWeatherInfoHistoryUseCase,
    private val deleteWeatherinfoHistoryCase: IDeleteWeatherInfoHistoryUseCase,
    private val settingsUseCase: ISettingsUseCase,
    private val getWeatherInfoUseCase: IGetWeatherInfoHistoryItemUseCase,
    private val deleteWeatherInfoHistoryUseCase: IDeleteWeatherInfoHistoryUseCase,
) : ViewModelProvider.Factory {
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return when(modelClass) {
            MainActivityViewModel::class.java -> MainActivityViewModel(
                getWeatherInfoCase,
                getWeatherInfoByGPSCase,
                getWeatherInfoHistoryCase,
                deleteWeatherinfoHistoryCase,
                settingsUseCase,
            ) as T
            WeatherInfoViewModel::class.java -> WeatherInfoViewModel(
                getWeatherInfoUseCase = getWeatherInfoUseCase,
                deleteWeatherInfoHistoryUseCase = deleteWeatherinfoHistoryCase,
            ) as T
            else -> throw IllegalArgumentException("Big shit bro, wrong VM!")
        }
    }
}

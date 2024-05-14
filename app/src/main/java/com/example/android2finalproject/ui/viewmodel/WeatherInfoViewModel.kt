package com.example.android2finalproject.ui.viewmodel

import androidx.lifecycle.ViewModel
import com.example.android2finalproject.domain.model.DataState
import com.example.android2finalproject.domain.model.WeatherInfoModel
import com.example.android2finalproject.ui.util.UiState
import com.example.android2finalproject.domain.usecase.IDeleteWeatherInfoHistoryUseCase
import com.example.android2finalproject.domain.usecase.IGetWeatherInfoHistoryItemUseCase
import com.example.android2finalproject.domain.usecase.IGetWeatherInfoHistoryUseCase
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.flow
import org.jetbrains.annotations.NotNull
import java.util.UUID

class WeatherInfoViewModel(
    private val getWeatherInfoUseCase: IGetWeatherInfoHistoryItemUseCase,
    private val deleteWeatherInfoHistoryUseCase: IDeleteWeatherInfoHistoryUseCase,
): ViewModel() {
    private val _weatherInfoModel: MutableStateFlow<WeatherInfoModel?> = MutableStateFlow(null)
    val weatherInfoModel: StateFlow<WeatherInfoModel?> = _weatherInfoModel.asStateFlow()

    fun loadWeatherInfo(id: Long): Flow<UiState<Any>> = flow {
        getWeatherInfoUseCase(id).collect { state ->
            emit(when (state) {
                is DataState.Initial -> UiState.Start
                is DataState.Result -> UiState.OK.also { load(state.data) }
                is DataState.Exception -> UiState.Error(
                    state.cause.message ?: state.cause.stackTraceToString()
                )
            })
        }
    }

    fun delete(): Flow<UiState<Any>> = flow {
        weatherInfoModel.collect { weatherInfo ->
            deleteWeatherInfoHistoryUseCase(checkNotNull(weatherInfo)).collect { state ->
                emit(
                    when (state) {
                        is DataState.Initial -> UiState.Start
                        is DataState.Result -> UiState.OK
                        is DataState.Exception -> UiState.Error(
                            state.cause.message ?: state.cause.stackTraceToString()
                        )
                    }
                )
            }
        }
    }

    private suspend fun load(weatherInfo: WeatherInfoModel) {
        _weatherInfoModel.emit(weatherInfo)
    }
}

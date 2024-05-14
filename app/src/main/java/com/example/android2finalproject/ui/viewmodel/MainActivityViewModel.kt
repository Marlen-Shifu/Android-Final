package com.example.android2finalproject.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.android2finalproject.domain.model.DataState
import com.example.android2finalproject.domain.model.WeatherInfoModel
import com.example.android2finalproject.ui.util.UiState
import com.example.android2finalproject.domain.usecase.IDeleteWeatherInfoHistoryUseCase
import com.example.android2finalproject.domain.usecase.IGetWeatherInfoByGPSUseCase
import com.example.android2finalproject.domain.usecase.IGetWeatherInfoHistoryUseCase
import com.example.android2finalproject.domain.usecase.IGetWeatherInfoUseCase
import com.example.android2finalproject.domain.usecase.ISettingsUseCase
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch

/**
 * Main ViewModel in application
 * @param getAllCase Tasks get all use case
 * @param syncCase Task synchronizing use case
 * @see ViewModel
 * @see ViewModelFactory
 * */
class MainActivityViewModel(
    private val getWeatherInfoCase: IGetWeatherInfoUseCase,
    private val getWeatherInfoByGPSCase: IGetWeatherInfoByGPSUseCase,
    private val getWeatherInfoHistoryCase: IGetWeatherInfoHistoryUseCase,
    private val deleteWeatherinfoHistoryCase: IDeleteWeatherInfoHistoryUseCase,
    private val settingsUseCase: ISettingsUseCase,
) : ViewModel() {
    private val _historyWeatherInfos: MutableStateFlow<UiState<List<WeatherInfoModel>>> = MutableStateFlow(
        UiState.Start)
    val historyWeatherInfos: StateFlow<UiState<List<WeatherInfoModel>>> get() = _historyWeatherInfos

    init {
        viewModelScope.launch {
            getWeatherInfoHistoryCase().collect { state ->
                when (state) {
                    is DataState.Result -> {
                        _historyWeatherInfos.emit(UiState.Success(state.data))
                    }
                    is DataState.Exception -> {
                        _historyWeatherInfos.emit(UiState.Error(state.cause.message ?: state.cause.stackTraceToString()))
                    }
                    else -> {
                        _historyWeatherInfos.emit(UiState.Start)
                    }
                }
            }
        }
    }

    fun deleteTask(weatherInfo: WeatherInfoModel): Flow<UiState<Any>> = flow {
        deleteWeatherinfoHistoryCase(weatherInfo).collect { state ->
            when (state) {
                is DataState.Initial -> emit(UiState.Start)
                is DataState.Result -> emit(UiState.OK)
                is DataState.Exception -> emit(UiState.Error(state.cause.message ?: state.cause.stackTraceToString()))
            }
        }
    }

    fun searchWeatherInfo(cityName: String): Flow<UiState<Any>> = flow {
        getWeatherInfoCase(cityName).collect { state ->
            when (state) {
                is DataState.Initial -> emit(UiState.Start)
                is DataState.Result -> emit(UiState.OK)
                is DataState.Exception -> emit(UiState.Error(state.cause.message ?: state.cause.stackTraceToString()))
            }
        }
    }

    fun isServerEnabled(): Boolean = settingsUseCase.getServerEnabled()
}

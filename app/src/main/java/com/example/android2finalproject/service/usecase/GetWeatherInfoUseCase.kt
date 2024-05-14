package com.example.android2finalproject.service.usecase

import com.example.android2finalproject.domain.model.DataState
import com.example.android2finalproject.domain.model.WeatherInfoModel
import com.example.android2finalproject.domain.usecase.IGetWeatherInfoUseCase
import com.example.android2finalproject.service.api.OPAPIRepo
import com.example.android2finalproject.service.api.OpenWeatherAPI
import kotlinx.coroutines.flow.Flow
import okhttp3.OkHttpClient

class GetWeatherInfoUseCase: IGetWeatherInfoUseCase {
    override suspend fun invoke(cityName: String): Flow<DataState<WeatherInfoModel>> {
        return OPAPIRepo(OpenWeatherAPI(
            "https://api.openweathermap.org/",
            token = "8c6a741f32e78c27320bcb318da43504",
            okHttpClient = OkHttpClient(),
        )
        ).getWeatherInfoByCityName(cityName)
    }
}

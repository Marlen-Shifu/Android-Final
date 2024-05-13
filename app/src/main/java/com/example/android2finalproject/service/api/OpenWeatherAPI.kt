package com.example.android2finalproject.service.api

import com.example.android2finalproject.domain.model.DataState
import com.example.android2finalproject.service.api.dto.WeatherInfoDto
import kotlinx.coroutines.flow.Flow
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import retrofit2.http.GET
import retrofit2.http.Query


interface OpenWeatherAPI {

    @GET("data/2.5/weather")
    suspend fun getWeatherInfoByCityName(
        @Query("q") cityName: String,
    ): WeatherInfoDto

    @GET("data/2.5/weather")
    suspend fun getWeatherInfoByGeo(
        @Query("lat") latitude: Double,
        @Query("lon") longitude: Double
    ): WeatherInfoDto
}

fun OpenWeatherAPI(
    baseUrl: String,
    token: String,
    okHttpClient: OkHttpClient? = null,
): OpenWeatherAPI {
    val modifiedOkHttpClient: OkHttpClient = (okHttpClient?.newBuilder() ?: OkHttpClient.Builder())
        .addInterceptor(TimeApiKeyInterceptor(token))
        .build()

    val retrofit = Retrofit.Builder()
        .baseUrl(baseUrl)
        .addConverterFactory(GsonConverterFactory.create())
        .client(modifiedOkHttpClient)
        .build()

    return retrofit.create()
}

class TimeApiKeyInterceptor(private val apiKey: String) : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        return chain.proceed(
            chain.request().newBuilder()
                .url(chain.request().url().toString() + "?appid=" + apiKey)
                .build()
        )
    }

}

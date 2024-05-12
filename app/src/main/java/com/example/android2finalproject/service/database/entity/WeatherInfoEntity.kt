package com.example.android2finalproject.service.database.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.android2finalproject.domain.model.WeatherStatus

@Entity(tableName = "weather_infos")
data class WeatherInfoEntity(
    @PrimaryKey(autoGenerate = false) @ColumnInfo(name = "id") val id: String,
    @ColumnInfo(name = "city_name") val cityName: String,
    @ColumnInfo(name = "temperature") val temperature: Double,
    @ColumnInfo(name = "wind_speed") val windSpeed: Double,
    @ColumnInfo(name = "status") val status: WeatherStatus,
    @ColumnInfo(name = "creationTime") val creationTime: Long,
)

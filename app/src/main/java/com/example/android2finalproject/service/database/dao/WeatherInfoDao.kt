package com.example.android2finalproject.service.database.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.android2finalproject.service.database.entity.WeatherInfoEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface WeatherInfoDao {
    @Query("SELECT * FROM weather_infos WHERE id = :id")
    fun getWeatherInfo(id: String): Flow<WeatherInfoEntity?>

    @Insert(entity = WeatherInfoEntity::class, onConflict = OnConflictStrategy.REPLACE)
    suspend fun addWeatherInfo(WeatherInfo: WeatherInfoEntity)

    @Delete(entity = WeatherInfoEntity::class)
    suspend fun removeWeatherInfo(WeatherInfo: WeatherInfoEntity)

    @Query("SELECT * FROM weather_infos")
    fun getWeatherInfos(): Flow<List<WeatherInfoEntity>>

    @Insert(entity = WeatherInfoEntity::class, onConflict = OnConflictStrategy.REPLACE)
    fun addWeatherInfos(WeatherInfos: List<WeatherInfoEntity>)

    @Query("DELETE FROM weather_infos")
    fun removeWeatherInfos()

    @Query("SELECT * FROM weather_infos")
    fun getWeatherInfosAsEntity(): List<WeatherInfoEntity>

    @Query("SELECT * FROM weather_infos WHERE id = :id")
    fun getWeatherInfoAsEntity(id: String): WeatherInfoEntity?
}

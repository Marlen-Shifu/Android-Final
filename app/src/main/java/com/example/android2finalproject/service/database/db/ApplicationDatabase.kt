package com.example.android2finalproject.service.database.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.android2finalproject.service.database.dao.WeatherInfoDao
import com.example.android2finalproject.service.database.entity.WeatherInfoEntity

@Database(entities = [WeatherInfoEntity::class], version = 3, exportSchema = false)
abstract class ApplicationDatabase : RoomDatabase() {
    abstract fun taskDao(): WeatherInfoDao
}

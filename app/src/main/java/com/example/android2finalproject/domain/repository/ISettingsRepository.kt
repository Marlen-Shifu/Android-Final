package com.example.android2finalproject.domain.repository

interface ISettingsRepository{
    fun getServerEnabled(): Boolean

    fun setServerEnabled(mode: Boolean)

    fun getAPIToken(): String

    fun setAPIToken(token: String)
}

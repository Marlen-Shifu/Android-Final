package com.example.android2finalproject.domain.usecase

interface ISettingsUseCase {
    fun getServerEnabled(): Boolean

    fun setServerEnabled(mode: Boolean)

    fun getAPIToken(): String

    fun setAPIToken(token: String)
}

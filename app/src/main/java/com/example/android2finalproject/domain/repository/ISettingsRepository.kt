package com.example.android2finalproject.domain.repository

interface ISettingsRepository{
    fun getServerEnabled(): Boolean

    fun setServerEnabled(mode: Boolean)

    fun getRevision(): Int

    fun setRevision(revision: Int)

    fun getUsername(): String

    fun setUsername(username: String)

    fun getToken(): String

    fun setToken(token: String)

    fun getTheme(): ThemeState

    fun setTheme(theme: ThemeState)

    fun getNotificationEnabled(): Boolean

    fun setNotificationEnabled(mode: Boolean)
}

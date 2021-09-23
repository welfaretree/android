package com.stac.welfaretree

import android.content.Context
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.emptyPreferences
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map
import java.io.IOException


class SettingManager(context: Context) {
    companion object {
        val IS_DARK_MODE = booleanPreferencesKey("dark_mode")

    }

    private val Context.dataStore by preferencesDataStore(name = "settings")

//    fun isDarkMode(context: Context) : Flow<Boolean> {
//        context.dataStore.data
//            .catch { exception ->
//                if (exception is IOException) {
//                    emit(emptyPreferences())
//                } else {
//                    throw exception
//                }
//            }
//            .map {preferences ->
//                preferences[IS_DARK_MODE] ?: ""
//            }
//    }
}
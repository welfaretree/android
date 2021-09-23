package com.stac.welfaretree.fragment.profile

import android.content.Context
import android.util.Log
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.*
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.map
import java.io.IOException

data class User (
    val profileUrl: String?,
    val name: String,
    val age: Int,
    val gender: String,
    val job: String?,
    val welfareReceiving: Int,
    val welfareReceived: Int,
    val etcList: List<String>?,
    val reviewedWelfareList: List<ProfileReviewedItem>?
)

private val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "user")

class UserManager(context: Context) {
    private val dataStore: DataStore<Preferences> = context.dataStore

    val TAG = "UserManager"

    companion object {
        val keyName = "user_name"
        val keyAge = "user_age"
        val keyGender = "user_gender"
        val keyJob = "user_job"

        val name = stringPreferencesKey(keyName)
        val age = intPreferencesKey(keyAge)
        val gender = stringPreferencesKey(keyGender)
        val job = stringPreferencesKey(keyJob)

        val tutorial = booleanPreferencesKey("tutorial")
    }

    suspend fun saveUser(user: User) {
        Log.d(TAG, "saveUser: $user")

        dataStore.edit { preferences ->
            preferences[name] = user.name
            preferences[age] = user.age
            preferences[gender] = user.gender
            preferences[job] = user.job ?: "없음"
        }
    }

    suspend fun saveTutorialState(boolean: Boolean) {
        dataStore.edit { preferences ->
            preferences[tutorial] = boolean
        }
    }
    suspend fun getTutorialState(): Boolean {
        val boolean: Flow<Boolean> = dataStore.data
            .catch { exception ->
                if (exception is IOException) {
                    emit(emptyPreferences())
                } else {
                    throw exception
                }
            }
            .map { preferences ->
                preferences[tutorial] ?: false
            }
        return boolean.first()
    }

    suspend fun getUser(): User {
        val user: Flow<User> = dataStore.data
            .catch { exception ->
                if (exception is IOException) {
                    emit(emptyPreferences())
                } else {
                    throw exception
                }
            }
            .map { preferences ->
                User(
                    null,
                    preferences[name] ?: "없음",
                    preferences[age] ?: 0,
                    preferences[gender] ?: "중성",
                    preferences[job] ?: "없음",
                    0,
                    0,
                    null,
                    null
                )
            }

        return user.first()
    }
}
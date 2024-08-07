package com.example.dessertrelease.data.local

import android.util.Log
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.emptyPreferences
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map
import java.io.IOException

class UserPreferencesRepository(
    private val datastore: DataStore<Preferences>
) {
    private companion object {
        val IS_LINEAR_LAYOUT = booleanPreferencesKey("is_linear_layout")
        const val TAG = "UserPreferencesRepo"
    }
    suspend fun saveLayoutPreferences(isLinearLayout: Boolean){
        datastore.edit { preferences->
            preferences[IS_LINEAR_LAYOUT] = isLinearLayout
        }
    }
    val isLinearLayout: kotlinx.coroutines.flow.Flow<Boolean> = datastore.data
        .catch {
            if(it is IOException){
                Log.e(TAG, "Error reading preferences.", it)
                emit(emptyPreferences())
            }else{
                throw it
            }
        }
        .map { preferences->
        preferences[IS_LINEAR_LAYOUT]?: true
    }
}
package com.stac.welfaretree.fragment.profile

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class ProfileViewModel(application: Application) : AndroidViewModel(application) {
    private val context = getApplication<Application>().applicationContext

    suspend fun getUser(): User {
        var user: User = withContext(viewModelScope.coroutineContext) {
            UserManager(context).getUser()
        }

        return user
    }
    fun saveUser(user: User) {
        viewModelScope.launch {
            UserManager(context).saveUser(user)
        }
    }
}
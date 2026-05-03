package com.upn.catatlari.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.upn.catatlari.database.RunDatabase
import com.upn.catatlari.model.User
import com.upn.catatlari.repository.UserRepository
import kotlinx.coroutines.launch

class UserViewModel(application: Application) : AndroidViewModel(application) {

    private val repository: UserRepository

    init {
        val userDao = RunDatabase.getDatabase(application).userDao()
        repository = UserRepository(userDao)
    }

    fun insertUser(user: User) {
        viewModelScope.launch {
            repository.insertUser(user)
        }
    }

    fun login(
        email: String,
        password: String,
        onResult: (User?) -> Unit
    ) {
        viewModelScope.launch {
            val user = repository.login(email, password)
            onResult(user)
        }
    }

    fun updateUser(user: User) {
        viewModelScope.launch {
            repository.updateUser(user)
        }
    }
}
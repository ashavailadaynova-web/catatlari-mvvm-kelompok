package com.upn.catatlari.viewmodel

import androidx.lifecycle.*
import com.upn.catatlari.model.User
import com.upn.catatlari.repository.UserRepository
import kotlinx.coroutines.launch

class ProfileViewModel(private val repository: UserRepository) : ViewModel() {

    fun getUserData(email: String): LiveData<User> = repository.getUserByEmail(email)

    fun updateUser(email: String, name: String, city: String) {
        viewModelScope.launch {
            repository.updateUser(email, name, city)
        }
    }
}
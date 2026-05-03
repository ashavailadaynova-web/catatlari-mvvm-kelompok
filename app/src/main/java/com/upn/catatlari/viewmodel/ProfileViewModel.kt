package com.upn.catatlari.viewmodel

import androidx.lifecycle.ViewModel
import com.upn.catatlari.model.User

class ProfileViewModel : ViewModel() {

    fun getUserByEmail(email: String): User {
        return User(
            email = email,
            password = "",
            name = "",
            city = ""
        )
    }

    fun updateUser(email: String, name: String, city: String) {
        // sementara kosong dulu, karena database dimatikan
    }
}
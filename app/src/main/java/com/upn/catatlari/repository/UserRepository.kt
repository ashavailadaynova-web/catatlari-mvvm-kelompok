package com.upn.catatlari.repository

import androidx.lifecycle.LiveData
import com.upn.catatlari.database.UserDao
import com.upn.catatlari.model.User

class UserRepository(private val userDao: UserDao) {
    fun getUserByEmail(email: String): LiveData<User> = userDao.getUserByEmail(email)

    suspend fun updateUser(email: String, name: String, city: String) {
        userDao.updateUser(email, name, city)
    }
}
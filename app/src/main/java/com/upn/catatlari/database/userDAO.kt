//package com.upn.catatlari.database
//
//import androidx.lifecycle.LiveData
//import androidx.room.*
//import com.upn.catatlari.model.User
//
//@Dao
//interface UserDao {
//    @Query("SELECT * FROM user_table WHERE email = :email")
//    fun getUserByEmail(email: String): LiveData<User>
//
//    @Query("UPDATE user_table SET name = :name, city = :city WHERE email = :email")
//    suspend fun updateUser(email: String, name: String, city: String)
//
//    @Insert(onConflict = OnConflictStrategy.REPLACE)
//    suspend fun insertUser(user: User)
//}
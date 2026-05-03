package com.upn.catatlari.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity(tableName = "user_table")
data class User(
    @PrimaryKey
    val email: String,
    val password: String,
    val name: String = "",
    val city: String = ""
) : Parcelable
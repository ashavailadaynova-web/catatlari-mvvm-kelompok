package com.upn.catatlari.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "run_table")
data class Run(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val runDate: String,
    val runDuration: Int,
    val runDistance: Int
)
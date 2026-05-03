package com.upn.catatlari.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.upn.catatlari.model.Run
import com.upn.catatlari.model.User

@Database(
    entities = [Run::class, User::class],
    version = 1,
    exportSchema = false
)
abstract class RunDatabase : RoomDatabase() {

    abstract fun runDao(): RunDao
    abstract fun userDao(): UserDao

    companion object {
        @Volatile
        private var INSTANCE: RunDatabase? = null

        fun getDatabase(context: Context): RunDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    RunDatabase::class.java,
                    "catatlari_database"
                ).fallbackToDestructiveMigration()
                    .build()

                INSTANCE = instance
                instance
            }
        }
    }
}
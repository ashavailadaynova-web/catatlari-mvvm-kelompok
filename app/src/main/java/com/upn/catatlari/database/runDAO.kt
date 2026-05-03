package com.upn.catatlari.database

import androidx.lifecycle.LiveData
import androidx.room.*
import com.upn.catatlari.model.Run

@Dao
interface RunDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertRun(run: Run)

    @Query("SELECT * FROM run_table ORDER BY id DESC")
    fun getAllRuns(): LiveData<List<Run>>

    @Delete
    suspend fun deleteRun(run: Run)
}
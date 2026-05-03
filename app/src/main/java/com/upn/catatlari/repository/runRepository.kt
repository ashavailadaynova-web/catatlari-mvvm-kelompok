package com.upn.catatlari.repository

import androidx.lifecycle.LiveData
import com.upn.catatlari.database.RunDao
import com.upn.catatlari.model.Run

class RunRepository(private val runDao: RunDao) {

    val allRuns: LiveData<List<Run>> = runDao.getAllRuns()

    suspend fun insertRun(run: Run) {
        runDao.insertRun(run)
    }

    suspend fun updateRun(run: Run) {
        runDao.updateRun(run)
    }
    suspend fun deleteRun(run: Run) {
        runDao.deleteRun(run)
    }
}
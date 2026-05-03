package com.upn.catatlari.viewmodel

import android.app.Application
import androidx.lifecycle.*
import com.upn.catatlari.database.RunDatabase
import com.upn.catatlari.model.Run
import com.upn.catatlari.repository.RunRepository
import kotlinx.coroutines.launch

class RunViewModel(application: Application) : AndroidViewModel(application) {

    private val repository: RunRepository
    val runHistory: LiveData<List<Run>>

    init {
        val runDao = RunDatabase.getDatabase(application).runDao()
        repository = RunRepository(runDao)
        runHistory = repository.allRuns
    }

    fun addRun(run: Run) {
        viewModelScope.launch {
            repository.insertRun(run)
        }
    }

    fun deleteRun(run: Run) {
        viewModelScope.launch {
            repository.deleteRun(run)
        }
    }
}
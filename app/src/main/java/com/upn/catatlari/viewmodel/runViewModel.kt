//package com.upn.catatlari.viewmodel
//
//import android.app.Application
//import androidx.lifecycle.AndroidViewModel
//import androidx.lifecycle.LiveData
//import androidx.lifecycle.viewModelScope
//import com.upn.catatlari.database.RunDao
//import com.upn.catatlari.database.RunDatabase
//import com.upn.catatlari.model.Run
//import com.upn.catatlari.repository.RunRepository
//import kotlinx.coroutines.Dispatchers
//import kotlinx.coroutines.launch
//
//class RunViewModel(application: Application) : AndroidViewModel(application) {
//
//    private val repository: RunRepository
//    val runHistory: LiveData<List<Run>>
//
//    init {
//        val runDao = RunDatabase.getDatabase(application as RunDao).runDao()
//        repository = RunRepository(runDao) // Menghubungkan ke repo
//        runHistory = repository.allRuns
//    }
//
//    // CREATE
//    fun addRun(run: Run) {
//        viewModelScope.launch(Dispatchers.IO) {
//            repository.insertRun(run)
//        }
//    }
//
//    // READ
//    fun getRuns(): LiveData<List<Run>> {
//        return runHistory
//    }
//
//    // UPDATE
//    fun updateRun(run: Run) = viewModelScope.launch {
//        repository.updateRun(run)
//    }
//
//    // DELETE
//    fun deleteRun(run: Run) = viewModelScope.launch(Dispatchers.IO) {
//        repository.deleteRun(run)
//    }
//}

package com.upn.catatlari.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.upn.catatlari.model.Run

class RunViewModel : ViewModel() {

    private val runListLiveData = MutableLiveData<MutableList<Run>>(
        mutableListOf(
            Run(id = 1, runDate = "22 Mei 2026", runDistance = 1, runDuration = 3),
            Run(id = 2, runDate = "23 Mei 2026", runDistance = 2, runDuration = 5),
            Run(id = 3, runDate = "24 Mei 2026", runDistance = 3, runDuration = 8)
        )
    )

    val runHistory: LiveData<MutableList<Run>> = runListLiveData

    // CREATE
    fun addRun(run: Run) {
        val currentList = runListLiveData.value ?: mutableListOf()
        val newRun = run.copy(id = currentList.size + 1)
        currentList.add(newRun)
        runListLiveData.value = currentList
    }

    // READ
    fun getRuns(): LiveData<MutableList<Run>> {
        return runHistory
    }

    // UPDATE
    fun updateRun(updatedRun: Run) {
        val currentList = runListLiveData.value ?: mutableListOf()
        val index = currentList.indexOfFirst { it.id == updatedRun.id }

        if (index != -1) {
            currentList[index] = updatedRun
            runListLiveData.value = currentList
        }
    }

    // DELETE
    fun deleteRun(run: Run) {
        val currentList = runListLiveData.value ?: mutableListOf()
        currentList.removeAll { it.id == run.id }
        runListLiveData.value = currentList
    }
}
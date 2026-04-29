package com.upn.catatlari.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.upn.catatlari.model.Run

class RunViewModel : ViewModel() {

    private val runList = listOf(
        Run(runDate = "22 Mei 2026", runDistance = 1, runDuration = 3),
        Run(runDate = "23 Mei 2026", runDistance = 1, runDuration = 3),
        Run(runDate = "24 Mei 2026", runDistance = 1, runDuration = 3)
    )

    private val runListLiveData = MutableLiveData<List<Run>>(runList)

    val runHistory: LiveData<List<Run>> = runListLiveData

    // CREATE
    fun addRun(run: Run) {
        // ambil nilai data maka pakek value, trs orempty kalo kosong maka dikosong kao engga ya muncul mutabele  list nya
        val currentList = runListLiveData.value.orEmpty().toMutableList()
        currentList.add(run)
        // ini kayak nge update gitu.
        runListLiveData.value = currentList
    }
    // READ
    // UPDATE
    // DELETE
}
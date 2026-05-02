package com.upn.catatlari.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.upn.catatlari.databinding.FragmentAddRunBinding
import com.upn.catatlari.model.Run
import com.upn.catatlari.viewmodel.RunViewModel

class AddRunFragment : Fragment() {

    private lateinit var binding: FragmentAddRunBinding
    private val runViewModel: RunViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentAddRunBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Logika Tombol Kembali
        binding.btnBack.setOnClickListener {
            findNavController().popBackStack()
        }

        // Logika Tombol Simpan
        binding.btnSaveRun.setOnClickListener {
            val runDate = binding.etDate.text.toString()
            val runDurationStr = binding.etRunDuration.text.toString()
            val runDistanceStr = binding.etRunDistance.text.toString()

            // Validasi sederhana agar tidak error saat convert to Int
            if (runDate.isNotEmpty() && runDurationStr.isNotEmpty() && runDistanceStr.isNotEmpty()) {

                val runInput = Run(
                    runDate = runDate,
                    runDuration = runDurationStr.toInt(),
                    runDistance = runDistanceStr.toInt()
                )

                runViewModel.addRun(runInput)
                findNavController().popBackStack()
            } else {
                // Opsional: Tambahkan Toast atau error message jika input kosong
                if (runDate.isEmpty()) binding.tilDate.error = "Isi tanggal"
                if (runDistanceStr.isEmpty()) binding.tilDistance.error = "Isi jarak"
                if (runDurationStr.isEmpty()) binding.tilDuration.error = "Isi durasi"
            }
        }
    }
}
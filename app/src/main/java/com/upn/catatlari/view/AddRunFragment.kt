package com.upn.catatlari.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
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

        // Tombol back
        binding.btnBack.setOnClickListener {
            findNavController().popBackStack()
        }

        // Tombol save
        binding.btnSaveRun.setOnClickListener {
            val runDate = binding.etDate.text.toString()
            val runDurationStr = binding.etRunDuration.text.toString()
            val runDistanceStr = binding.etRunDistance.text.toString()

            // Reset error dulu
            binding.tilDate.error = null
            binding.tilDuration.error = null
            binding.tilDistance.error = null

            // Validasi input
            if (runDate.isEmpty()) {
                binding.tilDate.error = "Isi tanggal"
                return@setOnClickListener
            }

            if (runDurationStr.isEmpty()) {
                binding.tilDuration.error = "Isi durasi"
                return@setOnClickListener
            }

            if (runDistanceStr.isEmpty()) {
                binding.tilDistance.error = "Isi jarak"
                return@setOnClickListener
            }

            // Convert ke Int
            val runDuration = runDurationStr.toInt()
            val runDistance = runDistanceStr.toInt()

            // Buat object Run
            val runInput = Run(
                id = 0,
                runDate = runDate,
                runDuration = runDuration,
                runDistance = runDistance
            )

            // Tambah ke ViewModel
            runViewModel.addRun(runInput)

            Toast.makeText(requireContext(), "Run berhasil ditambahkan!", Toast.LENGTH_SHORT).show()

            // Balik ke halaman sebelumnya
            findNavController().popBackStack()
        }
    }
}
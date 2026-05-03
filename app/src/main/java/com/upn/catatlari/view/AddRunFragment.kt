package com.upn.catatlari.view

import android.app.DatePickerDialog
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
import java.util.Calendar

private var existingRun: Run? = null

class AddRunFragment : Fragment() {

    private lateinit var binding: FragmentAddRunBinding
    private val runViewModel: RunViewModel by activityViewModels()

    private fun showDatePicker() {
        val calendar = Calendar.getInstance()

        val datePicker = DatePickerDialog(
            requireContext(),
            { _, year, month, day ->
                val dateText = String.format("%02d/%02d/%04d", day, month + 1, year)
                binding.etDate.setText(dateText)
            },
            calendar.get(Calendar.YEAR),
            calendar.get(Calendar.MONTH),
            calendar.get(Calendar.DAY_OF_MONTH)
        )

        datePicker.show()
    }

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
        existingRun = arguments?.getParcelable("run")

        binding.etDate.setOnClickListener {
            showDatePicker()
        }

        binding.tilDate.setStartIconOnClickListener {
            showDatePicker()
        }

        binding.btnBack.setOnClickListener {
            findNavController().popBackStack()
        }

        binding.btnSaveRun.setOnClickListener {
            val runDate = binding.etDate.text.toString()
            val runDurationStr = binding.etRunDuration.text.toString()
            val runDistanceStr = binding.etRunDistance.text.toString()

            binding.tilDate.error = null
            binding.tilDuration.error = null
            binding.tilDistance.error = null

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

            val runDuration = runDurationStr.toIntOrNull()
            val runDistance = runDistanceStr.toIntOrNull()

            if (runDuration == null) {
                binding.tilDuration.error = "Durasi harus angka"
                return@setOnClickListener
            }

            if (runDistance == null) {
                binding.tilDistance.error = "Jarak harus angka"
                return@setOnClickListener
            }

            val runInput = Run(
                id = 0,
                runDate = runDate,
                runDuration = runDuration,
                runDistance = runDistance
            )

            runViewModel.addRun(runInput)

            Toast.makeText(requireContext(), "Run berhasil ditambahkan!", Toast.LENGTH_SHORT).show()
            findNavController().popBackStack()
        }
    }
}
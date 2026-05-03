package com.upn.catatlari.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.upn.catatlari.databinding.FragmentHomeBinding
import com.upn.catatlari.viewmodel.RunViewModel
import com.upn.catatlari.R

class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding
    private val runViewModel: RunViewModel by activityViewModels()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        binding = FragmentHomeBinding.inflate(inflater, container, false)

        val user = (activity as MainActivity).user
        binding.welcomingTxt.text = "Halo, ${user?.email}"

        binding.floatingBtnAddRun.setOnClickListener {
            // Pastikan ID action di nav_graph adalah action_homeFragment_to_addRunFragment
            findNavController().navigate(R.id.action_homeFragment_to_addRunFragment)
        }
        // Inisialisasi Adapter dengan dua aksi (Hapus otomatis dari ViewModel, Edit diarahkan dengan Navigation)
        val runAdapter = RunAdapter(runViewModel) { runToEdit ->
            // Aksi saat tombol Edit di-klik
            val action = R.id.action_homeFragment_to_addRunFragment
            findNavController().navigate(action)
        }

        binding.rvRunList.layoutManager = LinearLayoutManager(requireContext())
        runViewModel.runHistory.observe(viewLifecycleOwner) { runList ->
            runAdapter.setData(runList)
        }

        binding.rvRunList.adapter = runAdapter

        binding.rvRunList.layoutManager = LinearLayoutManager(requireContext())
        runViewModel.runHistory.observe(viewLifecycleOwner) { runList ->
            runAdapter.setData(runList)
        }

        binding.rvRunList.adapter = runAdapter

        return binding.root
    }

}
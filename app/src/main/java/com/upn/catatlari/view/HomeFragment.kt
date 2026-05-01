package com.upn.catatlari.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.upn.catatlari.databinding.FragmentHomeBinding
import com.upn.catatlari.model.Run
import com.upn.catatlari.viewmodel.RunViewModel

class HomeFragment : Fragment() {

    private lateinit var  binding: FragmentHomeBinding
    private val runViewModel: RunViewModel by activityViewModels()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        binding = FragmentHomeBinding.inflate(inflater, container, false)

        val user = (activity as MainActivity).user
        binding.welcomingTxt.text = "Halo, ${user?.email}"

        binding.floatingBtnAddRun.setOnClickListener {
            findNavController().navigate(HomeFragmentDirections.Companion.actionHomeFragmentToAddRunFragment())
        }

        val runAdapter = RunAdapter { runToEdit ->
            // 1. Ambil data yang di-klik (runToEdit)
            // 2. Kirim data tersebut ke ViewModel untuk diproses
            runViewModel.updateRun(runToEdit, 0) // 0 adalah posisi/index yang akan di-update
        }

        binding.rvRunList.layoutManager = LinearLayoutManager(requireContext())
        runViewModel.runHistory.observe(viewLifecycleOwner) { runList ->
            runAdapter.setData(runList)
        }

        binding.rvRunList.adapter = runAdapter

        return binding.root
    }

}
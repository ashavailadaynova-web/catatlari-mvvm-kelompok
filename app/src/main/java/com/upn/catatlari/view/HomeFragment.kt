package com.upn.catatlari.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.upn.catatlari.R
import com.upn.catatlari.databinding.FragmentHomeBinding
import com.upn.catatlari.viewmodel.RunViewModel

class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding
    private val runViewModel: RunViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val email = requireActivity().intent.getStringExtra("email") ?: "User"
        binding.welcomingTxt.text = "Halo, $email"

        val runAdapter = RunAdapter(runViewModel) { runToEdit ->
            val bundle = Bundle()
            bundle.putParcelable("run", runToEdit)
            findNavController().navigate(R.id.action_homeFragment_to_addRunFragment, bundle)
        }

        binding.rvRunList.layoutManager = LinearLayoutManager(requireContext())
        binding.rvRunList.adapter = runAdapter

        runViewModel.runHistory.observe(viewLifecycleOwner) { runList ->
            runAdapter.setData(runList)
        }

        binding.floatingBtnAddRun.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_addRunFragment)
        }
    }
}
package com.upn.catatlari.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.upn.catatlari.databinding.FragmentWelcomeBinding
import com.upn.catatlari.R

class WelcomeFragment : Fragment() {

    private var _binding: FragmentWelcomeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentWelcomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Aksi tombol Signup (Get Started)
        binding.btnSignup.setOnClickListener {
            val action = R.id.action_welcomeFragment_to_registerFragment
            findNavController().navigate(action)
        }

        // Aksi tombol Login
        binding.btnLogin.setOnClickListener {
            val action = R.id.action_welcomeFragment_to_loginFragment
            findNavController().navigate(action)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
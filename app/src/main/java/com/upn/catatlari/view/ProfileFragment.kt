package com.upn.catatlari.view

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.upn.catatlari.R
import com.upn.catatlari.databinding.FragmentProfileBinding

class ProfileFragment : Fragment() {

    private lateinit var binding: FragmentProfileBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentProfileBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Navigasi ke halaman Edit Profile
        binding.btnEditProfile.setOnClickListener {
            // Pastikan ID action_profileFragment_to_editProfileFragment sesuai dengan nav_graph kamu
            findNavController().navigate(R.id.action_profileFragment_to_editProfileFragment)
        }

        // Navigasi Logout ke AuthActivity (Halaman Welcome/Login)
        binding.btnLogout.setOnClickListener {
            val intent = Intent(requireContext(), AuthActivity::class.java)

            // Menghapus tumpukan activity sebelumnya agar user tidak bisa 'back' ke profil setelah logout
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK

            startActivity(intent)
            requireActivity().finish()
        }
    }
}
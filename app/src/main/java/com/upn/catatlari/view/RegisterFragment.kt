package com.upn.catatlari.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.upn.catatlari.R
import com.upn.catatlari.databinding.FragmentRegisterBinding

class RegisterFragment : Fragment() {

    private var _binding: FragmentRegisterBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentRegisterBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Tombol untuk proses pendaftaran
        binding.btnRegisterAction.setOnClickListener {
            val name = binding.etNameSignup.text.toString().trim()
            val email = binding.etEmailSignup.text.toString().trim()
            val password = binding.etPasswordSignup.text.toString()
            val retypePassword = binding.etRetypePasswordSignup.text.toString()

            // Validasi Input
            if (name.isEmpty() || email.isEmpty() || password.isEmpty()) {
                Toast.makeText(requireContext(), "Semua kolom harus diisi ya!", Toast.LENGTH_SHORT).show()
            } else if (password != retypePassword) {
                // Cek apakah password dan konfirmasi password sama
                Toast.makeText(requireContext(), "Password tidak cocok, coba cek lagi!", Toast.LENGTH_SHORT).show()
            } else {
                // Logika jika berhasil (sementara kita buat toast lalu balik ke login)
                Toast.makeText(requireContext(), "Akun berhasil dibuat, silahkan login!", Toast.LENGTH_LONG).show()
                findNavController().navigate(R.id.action_registerFragment_to_loginFragment)
            }
        }

        // Navigasi balik ke halaman Login melalui tombol di bawah
        binding.btnGoToLogin.setOnClickListener {
            findNavController().navigate(R.id.action_registerFragment_to_loginFragment)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
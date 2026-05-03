package com.upn.catatlari.view

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.upn.catatlari.R
import com.upn.catatlari.databinding.FragmentLoginBinding

class LoginFragment : Fragment() {

    private lateinit var loginBinding: FragmentLoginBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        loginBinding = FragmentLoginBinding.inflate(inflater, container, false)
        return loginBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        loginBinding.btnGoToHome.setOnClickListener {
            val emailUser = loginBinding.etEmail.text.toString()
            val passwordUser = loginBinding.etPassword.text.toString()

            if (emailUser.isEmpty() || passwordUser.isEmpty()) {
                Toast.makeText(requireContext(), "Silahkan masukkan email/password, bro!", Toast.LENGTH_SHORT).show()
            } else {
                if (passwordUser != "123456") {
                    Toast.makeText(requireContext(), "Password Anda salah!", Toast.LENGTH_SHORT).show()
                } else {
                    val intent = Intent(requireContext(), MainActivity::class.java)
                    intent.putExtra("email", emailUser)
                    startActivity(intent)
                    requireActivity().finish()
                }
            }
        }

        loginBinding.btnGoToRegister.setOnClickListener {
            findNavController().navigate(R.id.action_loginFragment_to_registerFragment)
        }
    }
}
package com.upn.catatlari.view // Pastikan package ini sesuai dengan struktur foldermu

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.upn.catatlari.R // Import R project kamu

class SplashFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate layout fragment_splash
        return inflater.inflate(R.layout.fragment_splash, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Timer untuk pindah halaman otomatis
        Handler(Looper.getMainLooper()).postDelayed({
            // Navigasi ke welcome fragment
            findNavController().navigate(R.id.action_splashFragment_to_fragment_welcome)
        }, 3000)
    }
}
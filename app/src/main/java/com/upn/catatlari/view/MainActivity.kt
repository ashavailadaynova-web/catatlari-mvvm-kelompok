package com.upn.catatlari.view

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.upn.catatlari.R
import com.upn.catatlari.databinding.ActivityMainBinding
import com.upn.catatlari.model.User

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    var user: User? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Ambil data email dari intent
        val email = intent.getStringExtra("email")

        user = if (email.isNullOrEmpty()) {
            null
        } else {
            User(
                email = email,
                password = "",
                name = "",
                city = ""
            )
        }

        // Inisialisasi Navigation Component dengan aman
        val navHostFragment = supportFragmentManager
            .findFragmentById(R.id.nav_host_fragment) as? NavHostFragment

        if (navHostFragment != null) {
            val navController = navHostFragment.navController

            // Hubungkan Bottom Navigation
            binding.bottomNavMenu.setupWithNavController(navController)

            // Atur kapan BottomNav muncul atau hilang
            navController.addOnDestinationChangedListener { _, destination, _ ->
                when (destination.id) {
                    R.id.addRunFragment,
                    R.id.editProfileFragment,
                    R.id.splashFragment, // Tambahkan ini jika ada splash
                    R.id.loginFragment -> { // Tambahkan ini jika login ada di nav yang sama
                        binding.bottomNavMenu.visibility = View.GONE
                    }
                    else -> {
                        binding.bottomNavMenu.visibility = View.VISIBLE
                    }
                }
            }
        }
    }
}
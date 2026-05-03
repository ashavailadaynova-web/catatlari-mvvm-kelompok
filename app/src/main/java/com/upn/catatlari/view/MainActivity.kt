package com.upn.catatlari.view

import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
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

        val email = intent.getStringExtra("email") ?: ""
        user = User(email = email, password = "")

        enableEdgeToEdge()
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(binding.main) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, 0)
            insets
        }

        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment

        val navController = navHostFragment.navController

        binding.bottomNavMenu.setupWithNavController(navController)

        navController.addOnDestinationChangedListener { _, destination, _ ->
            if (destination.id == R.id.editProfileFragment) {
                binding.bottomNavMenu.visibility = View.GONE
            } else {
                binding.bottomNavMenu.visibility = View.VISIBLE
            }
        }
    }
}
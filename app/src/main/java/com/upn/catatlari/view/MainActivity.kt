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

        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment

        val navController = navHostFragment.navController

        binding.bottomNavMenu.setupWithNavController(navController)

        navController.addOnDestinationChangedListener { _, destination, _ ->
            when (destination.id) {
                R.id.addRunFragment,
                R.id.editProfileFragment -> {
                    binding.bottomNavMenu.visibility = View.GONE
                }

                else -> {
                    binding.bottomNavMenu.visibility = View.VISIBLE
                }
            }
        }
    }
}
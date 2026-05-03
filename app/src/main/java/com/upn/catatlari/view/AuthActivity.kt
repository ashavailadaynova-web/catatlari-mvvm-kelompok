//package com.upn.catatlari.view
//
//import android.os.Bundle
//import androidx.appcompat.app.AppCompatActivity
//import com.upn.catatlari.R
//
//class AuthActivity : AppCompatActivity() {
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_auth)
//    private lateinit var binding: ActivityAuthBinding
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//
//        // Inisialisasi ViewBinding
//        binding = ActivityAuthBinding.inflate(layoutInflater)
//
//        enableEdgeToEdge()
//        setContentView(binding.root)
//
//        // Mengatur padding agar elemen UI tidak tertutup status bar
//        ViewCompat.setOnApplyWindowInsetsListener(binding.root) { v, insets ->
//            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
//            insets
//        }
//    }
//}
package com.upn.catatlari.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.upn.catatlari.R

class AuthActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_auth)
    }
}
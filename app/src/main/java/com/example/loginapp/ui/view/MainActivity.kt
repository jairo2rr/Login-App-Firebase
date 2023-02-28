package com.example.loginapp.ui.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.loginapp.R
import com.example.loginapp.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.tvGoToRegister.setOnClickListener {
            goToRegister()
        }
    }

    private fun goToRegister() {
        val intent = Intent(this,RegisterActivity::class.java)
        startActivity(intent)
    }
}
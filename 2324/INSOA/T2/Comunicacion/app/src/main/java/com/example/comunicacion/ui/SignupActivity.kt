package com.example.comunicacion.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.comunicacion.R
import com.example.comunicacion.databinding.ActivitySignupBinding

class SignupActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySignupBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignupBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}
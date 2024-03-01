package com.example.comunicacion.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.comunicacion.R
import com.example.comunicacion.databinding.ActivityLoginBinding
import com.example.comunicacion.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var nombre: String
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        this.nombre = intent.getStringExtra("correo")!!
        binding.textoSaludo.text = nombre
    }
}
package com.example.comunicacion.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.comunicacion.R
import com.example.comunicacion.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val correo = intent.getStringExtra("correo")!!
        val perfil = intent.getStringExtra("perfil")!!

        binding.textoSaludo.setText("Bienvenido $correo")
        binding.textoPefil.setText("$perfil")

    }
}
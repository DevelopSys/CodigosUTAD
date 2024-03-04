package com.example.comunicacion.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.comunicacion.R
import com.example.comunicacion.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var correo: String
    private var perfil: Char? =null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        correo = intent.getStringExtra("correo")!!
        perfil = intent.getStringExtra("perfil")!!.get(0)

        binding.textoSaludo.setText("Bienvenido $correo")
        binding.textoPerfil.setText("$perfil")


    }
}
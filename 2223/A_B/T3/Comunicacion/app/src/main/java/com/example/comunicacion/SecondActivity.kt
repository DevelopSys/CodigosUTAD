package com.example.comunicacion

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.comunicacion.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySecondBinding
    private lateinit var nombre: String;
    private lateinit var pass: String;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // recuperar datos
        nombre = intent.extras?.getString("nombre") ?: "dato vacio"
        pass = intent.extras?.getString("pass") ?: "dato vacio"

        binding.textoNombre.text = nombre
        binding.textoPass.text = pass;
    }
}
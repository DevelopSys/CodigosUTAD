package com.example.t3comunicacion

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.t3comunicacion.databinding.ActivityMainBinding
import com.example.t3comunicacion.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySecondBinding
    private lateinit var nombreRecuperado: String
    private lateinit var passRecuperado: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // recuperar datos
        nombreRecuperado = intent.extras?.getString("nombre") ?: "valor por defecto"
        passRecuperado = intent.extras?.getString("password") ?: "valor por defecto"
    }
}
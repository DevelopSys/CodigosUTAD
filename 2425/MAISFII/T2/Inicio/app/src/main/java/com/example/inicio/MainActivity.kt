package com.example.inicio

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.inicio.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.botonSaludar.setOnClickListener {

            if (binding.editNombre.text.isEmpty()) {
                Snackbar.make(
                    binding.root,
                    "Por favor introduce datos",
                    Snackbar.LENGTH_LONG
                ).show()
            } else {
                Snackbar.make(
                    binding.root,
                    "Enhorabuena ${binding.editNombre.text.toString()}, tu primera app android completa",
                    Snackbar.LENGTH_LONG
                ).show()
            }

        }

    }
}
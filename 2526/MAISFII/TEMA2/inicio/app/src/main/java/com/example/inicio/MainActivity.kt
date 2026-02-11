package com.example.inicio

import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.inicio.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {

    // referencia a cada uno de los elementos de la parte UI

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.botonSaludar.setOnClickListener {
            // configura que pasa cuando se pulsa el boton
            Snackbar.make(
                binding.root,
                "Enhorabuena ${binding.editNombre.text.toString()} primera app android completada",
                Snackbar.LENGTH_LONG
            ).show()
        }

    }
}
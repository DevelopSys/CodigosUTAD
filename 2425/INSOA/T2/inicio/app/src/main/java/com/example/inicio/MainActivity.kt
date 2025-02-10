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

        binding.btnSaludar.setOnClickListener {
            Snackbar.make(binding.root
                ,"Enorabuena ${binding.editNombre.text.toString()}"
                ,Snackbar.LENGTH_LONG).show()
        }

        binding.btnLimpiar.setOnClickListener {
            binding.editNombre.text.clear()
        }
    }
}
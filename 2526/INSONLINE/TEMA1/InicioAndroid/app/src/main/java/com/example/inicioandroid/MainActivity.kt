package com.example.inicioandroid

import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.inicioandroid.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {


    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnSaludar.setOnClickListener {
            val nombre = binding.editNombre.text.toString()
            if (binding.editNombre.text.isEmpty()){
                  Snackbar.make(binding.root, "No hay nadie a quien saludar", Snackbar.LENGTH_LONG).show()
            } else {
                Snackbar.make(binding.root, "Enhorabuena $nombre", Snackbar.LENGTH_LONG).show()
            }
        }
    }
}
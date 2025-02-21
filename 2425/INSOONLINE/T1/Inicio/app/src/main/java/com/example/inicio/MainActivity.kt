package com.example.inicio

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.inicio.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar

/*toda pantalla tiene una parte logica y una parte grafica*/

class MainActivity : AppCompatActivity() {
    /*crear tantas variables como elementos tenga en el XML*/
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnPulsar.setOnClickListener {

            if (binding.editNombre.text.isEmpty()){
                Snackbar.make(binding.root, "Por favor introduce un nombre", Snackbar.LENGTH_SHORT).show()
            } else {
                val nombre=binding.editNombre.text.toString()
                Snackbar.make(binding.root, "Perfecto $nombre, primera app completada", Snackbar.LENGTH_SHORT).show()
            }

        }
    }
}
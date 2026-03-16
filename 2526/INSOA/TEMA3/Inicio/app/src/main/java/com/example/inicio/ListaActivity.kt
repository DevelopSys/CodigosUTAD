package com.example.inicio

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.inicio.databinding.ActivityListaBinding

class ListaActivity : AppCompatActivity() {

    private lateinit var binding: ActivityListaBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityListaBinding.inflate(layoutInflater)
        setContentView(binding.root)
        // binding.recyclerProductos
    }
}
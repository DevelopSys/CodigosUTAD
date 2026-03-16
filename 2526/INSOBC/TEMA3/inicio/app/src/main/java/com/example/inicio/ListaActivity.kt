package com.example.inicio

import android.os.Bundle
import android.widget.LinearLayout
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.inicio.adapter.ProductoAdapter
import com.example.inicio.data.DataSet
import com.example.inicio.databinding.ActivityListaBinding

class ListaActivity : AppCompatActivity() {
    private lateinit var binding: ActivityListaBinding
    private lateinit var productoAdapter: ProductoAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityListaBinding.inflate(layoutInflater)
        setContentView(binding.root)
        instances()
        initGUI()
    }

    private fun initGUI() {
        binding.recyclerProductos.adapter = productoAdapter
        if (resources.configuration.orientation == 1) {
            binding.recyclerProductos.layoutManager =
                LinearLayoutManager(
                    this,
                    LinearLayoutManager.VERTICAL, false
                )
        } else {
            binding.recyclerProductos.layoutManager =
                GridLayoutManager(
                    this, 2, LinearLayoutManager.VERTICAL,
                    false
                )
        }

        // LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
    }

    private fun instances() {
        productoAdapter = ProductoAdapter(DataSet.getAllProducts(), this)
    }
}
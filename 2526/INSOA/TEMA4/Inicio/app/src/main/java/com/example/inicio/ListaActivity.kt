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
    private lateinit var adapterProducto: ProductoAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityListaBinding.inflate(layoutInflater)
        setContentView(binding.root)
        instances()
        initGUI()
        // binding.recyclerProductos
    }

    private fun initGUI() {
        binding.recyclerProductos.adapter = adapterProducto
        // como internamente vas a renderizar la lista

        if (resources.configuration.orientation == 1){
            binding.recyclerProductos.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL,false)
        } else {
            binding.recyclerProductos.layoutManager = GridLayoutManager(this, 2, LinearLayoutManager.VERTICAL, false)
        }

        //
        //
    }

    private fun instances() {
        adapterProducto = ProductoAdapter(
            DataSet.getAllProducts(),
            this
        )
        // si quieres usar interfaz de callback -> this en vez de applicationContext
    }
}
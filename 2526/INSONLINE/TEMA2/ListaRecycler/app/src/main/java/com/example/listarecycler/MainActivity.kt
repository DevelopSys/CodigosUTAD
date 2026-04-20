package com.example.listarecycler

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.listarecycler.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var adapterProductos: ProductoAdapter
    private lateinit var listaProductos: ArrayList<Producto>


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        instancias()
        initGUI()
        // setContentView(R.id.recyclerProductos)

    }

    private fun initGUI() {

    }

    private fun instancias() {
        listaProductos = arrayListOf(
            Producto("Producto 1", 10),
            Producto("Producto 2", 20),
            Producto("Producto 3", 30),
            Producto("Producto 4", 40),
            Producto("Producto 5", 50),
            Producto("Producto 6", 60),
            Producto("Producto 7", 70),
            Producto("Producto 8", 80),
        )
        adapterProductos = ProductoAdapter(listaProductos, this)
        binding.recyclerProductos.adapter = adapterProductos
        if (resources.configuration.orientation == 1) {
            binding.recyclerProductos.layoutManager =
                LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        } else {
            binding.recyclerProductos.layoutManager = GridLayoutManager(this, 2)

        }

    }
}
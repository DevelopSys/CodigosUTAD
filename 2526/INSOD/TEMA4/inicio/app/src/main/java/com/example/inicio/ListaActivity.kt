package com.example.inicio

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.inicio.adapter.ProductAdapter
import com.example.inicio.data.DataSet
import com.example.inicio.databinding.ActivityListaBinding

class ListaActivity : AppCompatActivity() {
    private lateinit var productAdapter: ProductAdapter
    private lateinit var binding: ActivityListaBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityListaBinding.inflate(this.layoutInflater)
        setContentView(binding.root)
        productAdapter = ProductAdapter(DataSet.getAllProducts(), this)
        binding.recyclerProductos.adapter = productAdapter

        if(resources.configuration.orientation == 1){
            binding.recyclerProductos.layoutManager =
                LinearLayoutManager(this,
                    LinearLayoutManager.VERTICAL,
                    false)
        } else{
            binding.recyclerProductos.layoutManager =
                GridLayoutManager(this,2)
        }

        /**/



    }
}
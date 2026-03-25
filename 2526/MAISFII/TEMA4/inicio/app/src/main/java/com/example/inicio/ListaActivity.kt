package com.example.inicio

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.android.volley.toolbox.JsonArrayRequest
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import com.example.inicio.adapter.ProductAdapter
import com.example.inicio.data.DataSet
import com.example.inicio.databinding.ActivityListaBinding
import com.example.inicio.model.ProductResponse
import com.google.gson.Gson
import org.json.JSONArray

class ListaActivity : AppCompatActivity() {

    private lateinit var binding: ActivityListaBinding
    private lateinit var adapterProduct: ProductAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityListaBinding.inflate(layoutInflater)
        setContentView(binding.root)
        instances()
        initGUI()
        getJSONData()
    }

    private fun getJSONData() {
        // 1. configura la peticion
        val request: JsonObjectRequest =
            JsonObjectRequest(
                "https://dummyjson.com/products",
                {
                    /*val products: JSONArray = it.getJSONArray("products")
                    for (i in 0..products.length()-1){
                        val productJSON = products.getJSONObject(i)
                        val title = productJSON.getString("title")
                    }*/
                    val gson = Gson()
                    val productResponse = gson.fromJson(it.toString(), ProductResponse::class.java)
                    productResponse.products?.forEach {
                        adapterProduct.addProduct(it)
                    }
                },
                {
                    // lanzar una notificacion del error
                })
        // 2. lanza la peticion a la pila
        Volley.newRequestQueue(this).add(request)
    }

    private fun initGUI() {

        binding.recyclerProductos.adapter = adapterProduct
        if (resources.configuration.orientation == 1) {
            binding.recyclerProductos.layoutManager =
                LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        } else {
            binding.recyclerProductos.layoutManager =
                GridLayoutManager(this, 2, LinearLayoutManager.VERTICAL, false)
        }

        // LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)

    }

    private fun instances() {
        adapterProduct = ProductAdapter(this)
    }
}
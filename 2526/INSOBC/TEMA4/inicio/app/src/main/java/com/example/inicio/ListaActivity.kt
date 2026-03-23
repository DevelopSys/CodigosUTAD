package com.example.inicio

import android.os.Bundle
import android.util.Log
import android.widget.LinearLayout
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import com.example.inicio.adapter.ProductoAdapter
import com.example.inicio.data.DataSet
import com.example.inicio.databinding.ActivityListaBinding
import com.example.inicio.model.ProductJSON
import com.google.gson.Gson
import org.json.JSONArray
import org.json.JSONObject

class ListaActivity : AppCompatActivity() {
    private lateinit var binding: ActivityListaBinding
    private lateinit var productoAdapter: ProductoAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityListaBinding.inflate(layoutInflater)
        setContentView(binding.root)
        instances()
        initGUI()
        getJSONProducts()
    }

    private fun getJSONProducts() {
        // 1-realiza la peticion
        val request: JsonObjectRequest =
            JsonObjectRequest(
                "https://dummyjson.com/products",
                {
                    val gson = Gson()
                    // aqui tengo lo que pasa cuando la contestacion sea OK
                    val products: JSONArray = it.getJSONArray("products")
                    for (i in 0..products.length() - 1) {
                        val productJSON: JSONObject = products.getJSONObject(i)
                        val product: ProductJSON = gson.fromJson(
                            productJSON.toString(),
                            ProductJSON::class.java
                        )
                        productoAdapter.addProduct(product)

                    }

                },
                {
                    // toast avisando del error -> it: VolleyError
                }

            )
        // 2-lanza la peticion
        Volley.newRequestQueue(this).add(request)
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
        productoAdapter = ProductoAdapter(this)
    }
}

// 1. Crear un spinner en la activity donde mostrar las categorias (cargadas por API)
// 2. Al pulsar el ver detalles -> aparce una activity nueva con los detalles del producto
// 3. Al pulsar el comprar -> se actualiza el precio (puesto en un TextView) con el total del carrito
//  (gestionarlo localmente)
// 4. Poner un boton en la activity donde al pulsarlo aparece un snack (ojo si esta vacio) indicando
//      el fina de la compra y  vaciando el carrito 
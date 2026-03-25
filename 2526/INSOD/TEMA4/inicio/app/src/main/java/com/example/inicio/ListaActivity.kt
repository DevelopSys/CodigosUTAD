package com.example.inicio

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import com.example.inicio.adapter.ProductAdapter
import com.example.inicio.data.DataSet
import com.example.inicio.databinding.ActivityListaBinding
import com.example.inicio.model.ProductResponse
import com.google.gson.Gson
import org.json.JSONArray

class ListaActivity : AppCompatActivity() {
    private lateinit var productAdapter: ProductAdapter
    private lateinit var binding: ActivityListaBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityListaBinding.inflate(this.layoutInflater)
        setContentView(binding.root)
        productAdapter = ProductAdapter(this)
        binding.recyclerProductos.adapter = productAdapter

        if (resources.configuration.orientation == 1) {
            binding.recyclerProductos.layoutManager =
                LinearLayoutManager(
                    this,
                    LinearLayoutManager.VERTICAL,
                    false
                )
        } else {
            binding.recyclerProductos.layoutManager =
                GridLayoutManager(this, 2)
        }

        /**/

        getJSONData()

    }

    private fun getJSONData() {
        // 1. configuro lo que quiero pedir
        val request: JsonObjectRequest = JsonObjectRequest(
            "https://dummyjson.com/products",
            {
                /*val products: JSONArray = it.getJSONArray("products")
                for (i in 0..products.length()-1){
                    val productJSON = products.getJSONObject(i)
                    val title = productJSON.getString("title")
                    // val producto = Product()

                }*/
                val gson = Gson()
                val reponse: ProductResponse =
                    gson.fromJson(it.toString(), ProductResponse::class.java)
                reponse.products?.forEach {
                    productAdapter.addProduct(it)
                }

            },
            {

            }
        )

        // 2. Añado la peticion a la cola de peticiones
        Volley.newRequestQueue(this).add(request)

    }
}

/*
1. En la pantalla de la lista:
- Un spinner donde aparecen todas las categorias (cargadas por API)
- Al cambiar el spinner, se muestra la lista de productos de dicha categoria (filtro)
- Poner un contador del precio acumulado del carrito
- Poner un boton para completar la compra: al pulsarlo -> snackbar con el total de la compra
y vacia el carrito (local)

2- En el item de la lista
- si pulso detella -> nueva activity con el detalle del producto (UI como quieras)
- si pulso el comprar -> dicho producto va al carrito (dataset) y actualiza el contador
*/
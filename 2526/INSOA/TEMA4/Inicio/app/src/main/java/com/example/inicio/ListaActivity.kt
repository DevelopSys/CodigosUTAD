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
    private lateinit var adapterProducto: ProductoAdapter
    private lateinit var listJSON: ArrayList<ProductJSON>


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityListaBinding.inflate(layoutInflater)
        setContentView(binding.root)
        instances()
        initGUI()
        getJSONProducts()


        // binding.recyclerProductos
    }
    private fun getJSONProducts() {
        // 1: creo la peticion
        val gson = Gson()
        val request: JsonObjectRequest = JsonObjectRequest(
            "https://dummyjson.com/product", {
                val products: JSONArray = it.getJSONArray("products")
                for (i in 0..products.length() - 1) {
                    val jsonProduct: JSONObject = products.getJSONObject(i)
                    val product = gson.fromJson(
                        jsonProduct.toString(),
                        ProductJSON::class.java
                    )
                    Log.v("datos",product.title.toString())
                    adapterProducto.addProduct(product)
                }

            },
            {
                Log.v("datos",it.toString())
            })
        // 2: lanzo la peticion
        Volley.newRequestQueue(applicationContext).add(request)
    }
    private fun initGUI() {
        binding.recyclerProductos.adapter = adapterProducto
        // como internamente vas a renderizar la lista

        if (resources.configuration.orientation == 1) {
            binding.recyclerProductos.layoutManager =
                LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        } else {
            binding.recyclerProductos.layoutManager =
                GridLayoutManager(this, 2, LinearLayoutManager.VERTICAL, false)
        }

        //
        //
    }
    private fun instances() {
        listJSON = ArrayList()
        adapterProducto = ProductoAdapter(
            this
        )

        // si quieres usar interfaz de callback -> this en vez de applicationContext
    }
}


/*
Al pulsar el boton de ver detalle
    se carga una nueva pantalla con los datos del producto seleccionado
Al pulsar el boton comprar, el producto se agrega a un carrito (meterlo dentro del dataset)
    incorporar un boton en la pantalla de ver total, que muestra una snackbar con el total del carrito
Poner un spinner con las categorias (sacadas del API). Al cambiar de categoria
    se filtrara la lista de productos, mostrando los que son de dicha categoria
 */
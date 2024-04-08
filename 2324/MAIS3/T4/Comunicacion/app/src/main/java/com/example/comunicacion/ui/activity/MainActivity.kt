package com.example.comunicacion.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract.Data
import android.util.Log
import android.view.View
import android.view.View.OnClickListener
import android.widget.AdapterView
import android.widget.AdapterView.OnItemSelectedListener
import android.widget.ArrayAdapter
import androidx.recyclerview.widget.LinearLayoutManager
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley

import com.example.comunicacion.R
import com.example.comunicacion.adapters.ModeloAdapter
import com.example.comunicacion.adapters.ProductosAdapter
import com.example.comunicacion.data.DataSet
import com.example.comunicacion.databinding.ActivityMainBinding
import com.example.comunicacion.model.Marca
import com.example.comunicacion.model.Modelo
import com.example.comunicacion.model.Producto
import com.google.android.material.snackbar.Snackbar
import com.google.gson.Gson
import org.json.JSONArray

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var adaptadoProducto: ProductosAdapter
    private lateinit var adaptadorMarcas: ArrayAdapter<Marca>
    private lateinit var correo: String

    private var perfil: Char? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        instancias()
        personalizarSpinner()
        personalizarRecycler()
        realizarPeticionJSON()

        correo = intent.getStringExtra("correo")!!
        perfil = intent.getStringExtra("perfil")!!.get(0)
        binding.textoSaludo.setText("Bienvenido $correo")
        binding.textoPerfil.setText("$perfil")


        binding.spinnerMarca.onItemSelectedListener = object : OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {

                val seleccion = parent!!.adapter.getItem(position) as Marca
                // al adaptador le tendré que dar la lista nueva
                // adaptadorModelos.getListaModelos(DataSet.getAllModelos(seleccion.nombre))


            }

            override fun onNothingSelected(parent: AdapterView<*>?) {

            }

        }

    }

    private fun realizarPeticionJSON() {

        // crear la peticion
        val url = "https://dummyjson.com/products"
        val peticion: JsonObjectRequest = JsonObjectRequest(url,{
            // clase PRODUCTO (nombre, id, precio, descripcion, imagen, categoria)
            val productos: JSONArray = it.getJSONArray("products")
            for (i in 0..productos.length()-1){
                val productoJSON = productos.getJSONObject(i)
                var producto = Gson().fromJson(productoJSON.toString(),Producto::class.java)
                adaptadoProducto.addProducto(producto)
            }

        },{

        })
        // lanzar la peticion
        Volley.newRequestQueue(applicationContext).add(peticion)
    }
    fun instancias(){
        adaptadoProducto = ProductosAdapter(this)
        adaptadorMarcas = ArrayAdapter(
            applicationContext,
            android.R.layout.simple_spinner_item,
            DataSet.getAllMarcas()
        )

    }
    fun personalizarRecycler(){
        binding.recyclerModelos.adapter = adaptadoProducto
        binding.recyclerModelos.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)

    }
    fun personalizarSpinner(){
        adaptadorMarcas.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        binding.spinnerMarca.adapter = adaptadorMarcas
    }


}

// crear un objeto llamado marca el cual tiene
// nombre, calidad e imagen
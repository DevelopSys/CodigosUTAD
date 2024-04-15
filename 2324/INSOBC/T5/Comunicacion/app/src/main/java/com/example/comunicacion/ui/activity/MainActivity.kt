package com.example.comunicacion.ui.activity

import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract.Data
import android.util.Log
import android.view.View
import android.view.View.OnClickListener
import android.widget.AdapterView
import android.widget.AdapterView.OnItemSelectedListener
import android.widget.ArrayAdapter
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.android.volley.toolbox.JsonArrayRequest
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import com.example.comunicacion.R
import com.example.comunicacion.adapters.AdaptadorModelo
import com.example.comunicacion.adapters.AdaptadorProducto
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

    //private lateinit var adaptadorMarcas: ArrayAdapter<Marca>
    private lateinit var adaptadorCategorias: ArrayAdapter<String>
    private lateinit var adaptadorProducto: AdaptadorProducto
    private lateinit var listaCategorias: ArrayList<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        instancias()
        realizarPeticionCategorias()
        persoSpinner()
        persoRecycler()
        realizarPeticionJSON()

        val correo = intent.getStringExtra("correo")!!
        val perfil = intent.getStringExtra("perfil")!!

        binding.textoSaludo.setText("Bienvenido $correo")
        binding.textoPefil.setText("$perfil")

        acciones()

    }

    private fun realizarPeticionJSON() {

        // crear la peticion y analizarla la respuesta -> then
        val url = "https://dummyjson.com/products"
        val peticion: JsonObjectRequest = JsonObjectRequest(url, {
            val productos: JSONArray = it.getJSONArray("products")
            for (i in 0..<productos.length()) {
                val productoJSON = productos.getJSONObject(i);
                val producto: Producto =
                    Gson().fromJson(productoJSON.toString(), Producto::class.java)
                adaptadorProducto.addProducto(producto)
                //Log.v("producto", producto.title)
            }
        }, {
        })

        // lanzar la peticio -> fetch
        Volley.newRequestQueue(applicationContext).add(peticion)
    }

    private fun realizarPeticionCategorias() {
        val url = "https://dummyjson.com/products/categories";

        val peticion: JsonArrayRequest = JsonArrayRequest(url, {
            for (i in 0..it.length() - 1) {
                listaCategorias.add(it.getString(i))
            }
        }, {})
        adaptadorCategorias.notifyDataSetChanged()
        Volley.newRequestQueue(applicationContext).add(peticion);


    }

    fun acciones() {
        binding.agregarMarca.setOnClickListener {
            // adaptadorMarcas.add(Marca("Nueva", "Desconocido", R.drawable.user))
            // adaptadorMarcas.notifyDataSetChanged()


        }
        binding.spinnerMarca.onItemSelectedListener = object : OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?, view: View?, position: Int, id: Long
            ) {
                val seleccion = parent!!.adapter.getItem(position) as Marca
                //seleccion.nombre

                // filtrar los datos
                // ir al dataset y filtrar por nombre
                // modificar la lista -> desde el adaptador
                // adaptadorModelo.cambiarLista(DataSet.getAllModelos(seleccion.nombre))

                /*Snackbar.make(
                    binding.root,
                    "${resources.getString(R.string.nombre)}: ${seleccion.nombre}, ${
                        resources.getString(
                            R.string.calidad
                        )
                    }: ${seleccion.calidad}",
                    Snackbar.LENGTH_SHORT
                ).show()*/
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {

            }

        }

    }

    fun persoSpinner() {
        adaptadorCategorias.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        binding.spinnerMarca.adapter = adaptadorCategorias
    }

    fun persoRecycler() {
        binding.recyclerModelos.adapter = adaptadorProducto
        if (resources.configuration.orientation == Configuration.ORIENTATION_LANDSCAPE) {

            binding.recyclerModelos.layoutManager = GridLayoutManager(this, 2)
        } else {
            binding.recyclerModelos.layoutManager =
                LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        }

        /*LinearLayoutManager(this,
            LinearLayoutManager.VERTICAL, false)*/
    }

    fun instancias() {
        listaCategorias = ArrayList()
        adaptadorProducto = AdaptadorProducto(this);
        adaptadorCategorias = ArrayAdapter(
            applicationContext, android.R.layout.simple_spinner_item, listaCategorias
        )
    }


}
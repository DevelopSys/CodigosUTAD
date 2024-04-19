package com.example.comunicacion.ui

import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.view.View.OnClickListener
import android.widget.AbsSpinner
import android.widget.Adapter
import android.widget.AdapterView
import android.widget.AdapterView.OnItemClickListener
import android.widget.AdapterView.OnItemSelectedListener
import android.widget.ArrayAdapter
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView.Orientation
import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import com.example.comunicacion.R
import com.example.comunicacion.adapters.AdaptadorModelo
import com.example.comunicacion.adapters.AdaptadorProducto
import com.example.comunicacion.data.DataSet
import com.example.comunicacion.databinding.ActivityLoginBinding
import com.example.comunicacion.databinding.ActivityMainBinding
import com.example.comunicacion.model.Marca
import com.example.comunicacion.model.Producto
import com.google.android.material.snackbar.Snackbar
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.gson.Gson
import org.json.JSONArray
import org.json.JSONObject

class MainActivity : AppCompatActivity() {

    // 1- al iniciar sesion un usuario se tiene que escribir en la base de datos
    // usuarios
    // uid 123123AXASDA
    // correo: borja@utad.com
    // 2- al crear un usuario se tiene que escribir en la base de datos
    // usuarios
    // uid 123123dsaasd
    // correo: borjaras
    // nombre:asdasdasd
    // genero: asdasdasd
    // perfil: asdasdasdasd

    private lateinit var binding: ActivityMainBinding

    //private lateinit var adaptadorModelo: AdaptadorModelo
    private lateinit var adaptadorProducto: AdaptadorProducto;
    private lateinit var firebaseDatabase: FirebaseDatabase
    private lateinit var uidCurrentUser: String
    private lateinit var nombre: String
    private lateinit var adapterSpinner: ArrayAdapter<Marca>
    private lateinit var databaseReference: DatabaseReference

    // referencia -> nodo sobre el cual me puedo colocar y trabajar de ahi en adelante
    // child -> todos los nodos. Si hago referencia a un nodo que no existe, se crea automaticamente
    // value -> dato asociado a un nodo. Si el nodo existe y se le da un valor nuevo -> update

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        instancias()
        persoAdaptadores()
        peticionJSON()

        this.nombre = intent.getStringExtra("correo")!!
        this.uidCurrentUser = intent.getStringExtra("uid")!!
        binding.textoSaludo.text = nombre
        acciones()

    }

    private fun peticionJSON() {
        // crear la peticion
        val url = "https://dummyjson.com/products"
        val peticion: JsonObjectRequest = JsonObjectRequest(url, {
            val productos: JSONArray = it.getJSONArray("products")
            for (i in 0..<productos.length()) {
                val producto: JSONObject = productos.getJSONObject(i)
                val productoOBJ: Producto =
                    Gson().fromJson(producto.toString(), Producto::class.java)
                // productoOBJ a la lista del adaptador
                adaptadorProducto.addProducto(productoOBJ)
                /*val id = producto.getInt("id")
                val title = producto.getString("title")
                val description = producto.getString("description")
                val category = producto.getString("category")
                val thumbnail = producto.getString("thumbnail")
                val price = producto.getDouble("price")
                val productoOBJ: Producto = Producto(id,title,description, thumbnail, category, price)*/
                Log.v("dats", "${productoOBJ.id} ${productoOBJ.title}")
            }
        }, {
            Log.v("dats", "Error de conexion")
        })

        // lanzar la peticion
        Volley.newRequestQueue(applicationContext).add(peticion)
    }

    fun acciones() {
        binding.spinnerSeleccion.onItemSelectedListener = object : OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {

                val selecccion: Marca = parent!!.adapter.getItem(position) as Marca

                // filtrar la lista -> DATASET OK
                // cambiar la lista -> ADAPTADOR
                // adaptadorModelo.cambiarLista(DataSet.getAllModelos(selecccion.nombre))


                Snackbar.make(
                    binding.root,
                    "${selecccion.nombre} ${selecccion.calidad}",
                    Snackbar.LENGTH_SHORT
                ).show()
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {

            }

        }
    }

    fun instancias() {
        // crea la parte de datos del spinner
        adapterSpinner = ArrayAdapter(
            applicationContext,
            android.R.layout.simple_spinner_item,
            DataSet.getAllMarcas()
        )
        //adaptadorModelo = AdaptadorModelo(DataSet.getAllModelos("Mercedes"), this)
        adaptadorProducto = AdaptadorProducto(this)
        firebaseDatabase =
            FirebaseDatabase.getInstance("https://bmh-utad2024-default-rtdb.europe-west1.firebasedatabase.app/")
    }


    fun persoAdaptadores() {
        // junta parte grafica con parte logica
        binding.spinnerSeleccion.adapter = adapterSpinner;
        // muestra el desplegable de forma visible
        adapterSpinner.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

        binding.recyclerModelos.adapter = adaptadorProducto
        binding.recyclerModelos.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)

        if (resources.configuration.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            binding.recyclerModelos.layoutManager =
                GridLayoutManager(this, 2)
        }

        //GridLayoutManager(this,2)

        //LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        when (item.itemId) {
            R.id.menu_add_nodo -> {
                databaseReference = firebaseDatabase.reference.child("usuarios").child("uid")
                databaseReference
                    .child("usuario2").setValue("usuario1")
            }

            R.id.menu_del_nodo -> {
                firebaseDatabase.reference.child("usuarios")
                    .child("usuario2").setValue(null)
            }

            R.id.menu_get_nodo -> {

            }
        }

        return true
    }

}

/*
* Clase Modelo: marca (s), modelo (s), cv (int), precio (d), imagen (int)
* */



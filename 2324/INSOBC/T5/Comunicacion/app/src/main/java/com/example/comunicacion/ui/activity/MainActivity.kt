package com.example.comunicacion.ui.activity

import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract.Data
import android.util.Log
import android.view.Menu
import android.view.MenuItem
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
import com.example.comunicacion.model.Usuario
import com.google.android.material.snackbar.Snackbar
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.google.gson.Gson
import org.json.JSONArray

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    //private lateinit var adaptadorMarcas: ArrayAdapter<Marca>
    private lateinit var adaptadorCategorias: ArrayAdapter<String>
    private lateinit var adaptadorProducto: AdaptadorProducto
    private lateinit var listaCategorias: ArrayList<String>
    private lateinit var firebaseDatabase: FirebaseDatabase
    private lateinit var uid: String;

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
        uid = intent.getStringExtra("uid")!!
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
        firebaseDatabase =
            FirebaseDatabase.getInstance("https://bmh-utad23242-default-rtdb.europe-west1.firebasedatabase.app/")
        listaCategorias = ArrayList()
        adaptadorProducto = AdaptadorProducto(this);
        adaptadorCategorias = ArrayAdapter(
            applicationContext, android.R.layout.simple_spinner_item, listaCategorias
        )
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        // menuRes (int) -> el elemento que quiero poner R.menu.asdasd
        // menu (Menu)-> donde lo quieres poner

        menuInflater.inflate(R.menu.main_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        // itemId
        when (item.itemId) {
            R.id.menu_add_nodo -> {
                firebaseDatabase.reference.child("usuario")
                    .child("nombre")
                    .setValue("Borja")
            }

            R.id.menu_del_nodo -> {
                firebaseDatabase.reference.child("usuario").setValue(null)
            }

            R.id.menu_update_nodo -> {
                firebaseDatabase.reference.child("usuario")
                    .child("nombre")
                    .setValue("BorjaModificado")
            }

            R.id.menu_get_nodo -> {
                firebaseDatabase.reference.child("usuarios")
                    //.child(uid)
                    //.addListenerForSingleValueEvent(object : ValueEventListener{
                    .addValueEventListener(object : ValueEventListener {
                        override fun onDataChange(snapshot: DataSnapshot) {
                            // val usuario: Usuario = Gson().fromJson(snapshot.value.toString(), Usuario::class.java)
                            val usuarios: Iterable<DataSnapshot> = snapshot.children
                            usuarios.forEach {

                                Log.v("datos", it.key.toString())
                                Log.v("datos", it.value.toString())
                                Log.v("datos", it.child(it.key.toString()).child("nombre").value.toString())

                            }

                        }

                        override fun onCancelled(error: DatabaseError) {
                            TODO("Not yet implemented")
                        }

                    })

            }
        }

        return true
    }
}

// cada vez que se registe un usuario se tiene que quedar
// asociada toda su informacion
// (sin la pass) en la base de datos
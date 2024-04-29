package com.example.comunicacion.ui.activity

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
import com.example.comunicacion.model.Usuario
import com.google.android.material.snackbar.Snackbar
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.google.gson.Gson
import org.json.JSONArray

class MainActivity : AppCompatActivity() {

    private lateinit var firebaseDatabase: FirebaseDatabase
    private lateinit var binding: ActivityMainBinding
    private lateinit var adaptadoProducto: ProductosAdapter
    private lateinit var adaptadorMarcas: ArrayAdapter<Marca>
    private lateinit var correo: String
    private lateinit var uid: String

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
        uid = intent.getStringExtra("uid")!!
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
        val peticion: JsonObjectRequest = JsonObjectRequest(url, {
            // clase PRODUCTO (nombre, id, precio, descripcion, imagen, categoria)
            val productos: JSONArray = it.getJSONArray("products")
            for (i in 0..productos.length() - 1) {
                val productoJSON = productos.getJSONObject(i)
                var producto = Gson().fromJson(productoJSON.toString(), Producto::class.java)
                adaptadoProducto.addProducto(producto)
            }

        }, {

        })
        // lanzar la peticion
        Volley.newRequestQueue(applicationContext).add(peticion)
    }

    fun instancias() {
        firebaseDatabase =
            FirebaseDatabase.getInstance("https://bah-utad23241-default-rtdb.europe-west1.firebasedatabase.app/")
        adaptadoProducto = ProductosAdapter(this)
        adaptadorMarcas = ArrayAdapter(
            applicationContext,
            android.R.layout.simple_spinner_item,
            DataSet.getAllMarcas()
        )

    }

    fun personalizarRecycler() {
        binding.recyclerModelos.adapter = adaptadoProducto
        binding.recyclerModelos.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)

    }

    fun personalizarSpinner() {
        adaptadorMarcas.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        binding.spinnerMarca.adapter = adaptadorMarcas
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        // menuRes(int) -> lo que quiero inflar
        // menu: Menu -> donde lo quiero inflar
        menuInflater.inflate(R.menu.main_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.menu_add_nodo -> {
                // capturar la bd y crear el camino
                // usuarios
                // usuario1
                //nombre: borja
                firebaseDatabase.reference.child("usuarios")
                    .child("usuario1")
                    .child("nombre")
                    .setValue("Borja")
            }

            R.id.menu_del_nodo -> {
                firebaseDatabase.reference.child("usuarios")
                    .child("usuario1")
                    .child("nombre")
                    .setValue(null)
            }

            R.id.menu_update_nodo -> {
                firebaseDatabase.reference.child("usuarios")
                    .child("usuario1")
                    .child("nombre")
                    .setValue("valor diferente")
            }

            R.id.menu_get -> {
                firebaseDatabase.reference.child("productos")
                    .child("products")
                    .addValueEventListener(object : ValueEventListener {
                        override fun onDataChange(snapshot: DataSnapshot) {
                            val productos: Iterable<DataSnapshot> = snapshot.children;
                            productos.forEach {
                                Log.v("datos", it.value.toString())
                                //val nombre: String = it.value.child("nombre").value.toString();
                            }

                        }

                        override fun onCancelled(error: DatabaseError) {

                        }

                    })
                /*firebaseDatabase.reference.child("usuarios")
                    //.child(uid)
                    .child(FirebaseAuth.getInstance().currentUser!!.uid)
                    .addValueEventListener( object : ValueEventListener{
                        override fun onDataChange(snapshot: DataSnapshot) {
                            // cuando un dato de la ruta cambie
                            //val usuario: Usuario = Gson().fromJson(snapshot.value.toString(), Usuario::class.java)
                            Log.v("datos",snapshot.value.toString())
                        }

                        override fun onCancelled(error: DatabaseError) {
                            // la peticion se cancele por el usuario
                        }

                    })*/
            }
        }

        return true
    }


}

// crear un objeto llamado marca el cual tiene
// nombre, calidad e imagen

// al registrar un usuario, en la base de datos tiene que quedar constancia de todos sus datos
// usuarios
// UID
// nombre:
// correo:
// genero:
// perfil:

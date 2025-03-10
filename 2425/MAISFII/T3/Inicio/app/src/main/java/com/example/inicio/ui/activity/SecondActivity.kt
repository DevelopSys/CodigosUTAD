package com.example.inicio.ui.activity

import android.os.Bundle
import android.provider.ContactsContract.Data
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import com.example.inicio.R
import com.example.inicio.adapter.ConctactAdapter
import com.example.inicio.data.DataSet
import com.example.inicio.databinding.ActivitySecondBinding
import com.example.inicio.model.User
import com.example.inicio.model.UserJSON
import com.example.inicio.ui.dialog.InfoDialog
import com.google.android.material.snackbar.Snackbar
import com.google.gson.Gson
import org.json.JSONArray
import org.json.JSONObject

class SecondActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySecondBinding
    private lateinit var userRecuperado: User
    private lateinit var adapterConctact: ConctactAdapter
    private lateinit var listaConctacts: ArrayList<UserJSON>


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.toolbar)
        instancias()
        crearPeticion()

        // recuperar el dato que me han pasado
        val bundleRecuperado = intent.extras?.getBundle("datos")
        // user - serializable - user
        userRecuperado = bundleRecuperado?.getSerializable("user") as User
        supportActionBar?.title = "Bienvenido ${userRecuperado.getCorreo()}"

    }

    private fun crearPeticion() {
        val gson: Gson = Gson()
        val url = "https://dummyjson.com/users/"
        val peticionJSON: JsonObjectRequest =
            JsonObjectRequest(url, {
                val users: JSONArray = it.getJSONArray("users")
                for (i in 0..<users.length()) {
                    val userJSON: JSONObject = users.getJSONObject(i)
                    val user: UserJSON = gson.fromJson(userJSON.toString(),UserJSON::class.java)
                    adapterConctact.addConctact(user)
                    Log.v("datos", "El nombre del usuario es ${user.firstName} ${user.lastName}")
                    // usuario -> Objeto
                }

            }, {
                Snackbar.make(binding.root, "Error en la peticion", Snackbar.LENGTH_SHORT).show()
            })
        Volley.newRequestQueue(applicationContext).add(peticionJSON)
    }

    private fun instancias() {
        listaConctacts = ArrayList()
        adapterConctact = ConctactAdapter(listaConctacts, this)
        binding.recycler.adapter = adapterConctact

        if (resources.configuration.orientation == 1) {
            binding.recycler.layoutManager = LinearLayoutManager(
                applicationContext,
                LinearLayoutManager.VERTICAL,
                false
            )
        } else {
            binding.recycler.layoutManager = GridLayoutManager(
                applicationContext,
                2, LinearLayoutManager.VERTICAL, false
            )

        }


    }

    override fun onStart() {
        super.onStart()
        // quiero acceder a los datos del usuarios
        Log.v("datos", userRecuperado.getCorreo() ?: "sin correo")
        Log.v("datos", userRecuperado.getPerfil() ?: "sin perfil")
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        when (item.itemId) {
            R.id.menuCerrarSesion -> {
                finish()
            }

            R.id.menuInfo -> {
                val dialogo = InfoDialog()
                dialogo.show(supportFragmentManager, null)
            }

            R.id.menuSub1 -> {}
            R.id.menuSub2 -> {}
        }

        return true
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
    }
}
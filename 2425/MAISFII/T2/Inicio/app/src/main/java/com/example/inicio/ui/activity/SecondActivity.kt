package com.example.inicio.ui.activity

import android.os.Bundle
import android.provider.ContactsContract.Data
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.inicio.R
import com.example.inicio.adapter.ConctactAdapter
import com.example.inicio.data.DataSet
import com.example.inicio.databinding.ActivitySecondBinding
import com.example.inicio.model.User
import com.example.inicio.ui.dialog.InfoDialog

class SecondActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySecondBinding
    private lateinit var userRecuperado: User
    private lateinit var adapterConctact: ConctactAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.toolbar)
        instancias()

        // recuperar el dato que me han pasado
        val bundleRecuperado = intent.extras?.getBundle("datos")
        // user - serializable - user
        userRecuperado = bundleRecuperado?.getSerializable("user") as User
        supportActionBar?.title = "Bienvenido ${userRecuperado.getCorreo()}"

    }

    private fun instancias() {
        adapterConctact = ConctactAdapter(DataSet.lista, this)
        binding.recycler.adapter = adapterConctact

        if (resources.configuration.orientation == 1){
            binding.recycler.layoutManager = LinearLayoutManager(applicationContext,
                    LinearLayoutManager.VERTICAL,
                    false)
        } else {
            binding.recycler.layoutManager = GridLayoutManager(applicationContext,
                2,LinearLayoutManager.VERTICAL,false)

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
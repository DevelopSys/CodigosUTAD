package com.example.inicio.ui.activity

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.helper.widget.Grid
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.inicio.R
import com.example.inicio.adapter.ContactAdapter
import com.example.inicio.data.DataSet
import com.example.inicio.databinding.ActivitySecondBinding
import com.example.inicio.model.User
import com.example.inicio.ui.dialog.InfoDialog

class SecondActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySecondBinding
    private lateinit var contactAdapter: ContactAdapter
    // lista y contexto
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.toolbar)
        instancias()
        obtenerDatos()

    }

    private fun instancias() {
        contactAdapter = ContactAdapter(DataSet.lista,this)
        binding.recycler.adapter = contactAdapter
        if (resources.configuration.orientation == 1){
            binding.recycler.layoutManager =
                LinearLayoutManager(applicationContext
                    ,LinearLayoutManager.VERTICAL
                    ,false)
        } else {
            binding.recycler.layoutManager =
                GridLayoutManager(applicationContext,2,
                    LinearLayoutManager.VERTICAL,false)
        }

            /*GridLayoutManager(applicationContext,2,
                LinearLayoutManager.VERTICAL,false)*/
        /*LinearLayoutManager(applicationContext
                ,LinearLayoutManager.VERTICAL
                ,false)*/

    }

    private fun obtenerDatos() {
        val bundle  = intent.extras!!.getBundle("datos")
        val usuario:User = bundle!!.getSerializable("usuario") as User
        supportActionBar?.title = usuario.nombre
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu,menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        when(item.itemId){
            R.id.itemCerrarSesion ->{finish()}
            R.id.itemInformacion ->{
                // escribir el codigo del cuadro de dialogo aqui
                // escribir el codigo del cuadro de dialogo en una clase
                val dialogo: InfoDialog = InfoDialog()
                dialogo.show(supportFragmentManager,null)
            }
            R.id.itemAccion1 ->{}
            R.id.itemAccion2 ->{}
        }

        return true
    }
}
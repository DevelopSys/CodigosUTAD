package com.example.inicio.ui.activity

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.inicio.R
import com.example.inicio.adapter.ProductAdapter
import com.example.inicio.data.DataSet
import com.example.inicio.databinding.ActivitySecondBinding
import com.example.inicio.model.User
import com.example.inicio.ui.dialog.InfoDialog

class SecondActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySecondBinding
    // lista
    private lateinit var adapterProductos: ProductAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)
        instancias();
        setSupportActionBar(binding.toolber)
        obtenerDatos()
        asociarDatosRecycler()

    }

    private fun asociarDatosRecycler() {
        binding.recycler.adapter = adapterProductos
        if (resources.configuration.orientation == 1){
            binding.recycler.layoutManager = LinearLayoutManager(applicationContext,
                LinearLayoutManager.VERTICAL,false)
        } else {
            binding.recycler.layoutManager = GridLayoutManager(applicationContext,
                2,LinearLayoutManager.VERTICAL,false)
        }


        /*LinearLayoutManager(applicationContext,
            LinearLayoutManager.VERTICAL,false)*/
    }

    private fun instancias() {
        adapterProductos = ProductAdapter(lista = DataSet.lista, context = this)
    }

    private fun obtenerDatos() {
        val bundle  = intent.extras!!.getBundle("datos")
        val usuario:User = bundle!!.getSerializable("usuario") as User
        // binding.textoUsuario.setText(usuario.nombre)
        supportActionBar?.title = "Bienvenido ${usuario.nombre}"
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu,menu)
        return true
    }

    /*
    * Pila de activitys

    * * MainActivity (resume)
    * */

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // saber cual es el item pulsado -> id
        when(item.itemId){
            R.id.menuInfo ->{
                val dialogo = InfoDialog()
                dialogo.show(supportFragmentManager,null)
            }
            R.id.menuCerrar ->{
                finish()
            }
            else->{}
        }
        return super.onOptionsItemSelected(item)
    }

    /*1- Crear una template: xml con el aspecto de todas las filas
    * 2- Crear un modelo con el objeto que quiero representar en la lista
    * 3- Crear un adaptador, se encargan de asociar los datos a un recycler
    *   con un holder, que actua como patron
    * 4- Asociar la parte adapter con la parte recycler
    *   le tengo que indicar cual es la disposicion de los datos
    *       linear
    *       grid
    *       staggered
    * */
}
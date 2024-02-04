package com.example.t7dialogos

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.view.View.OnClickListener
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.t7dialogos.adapters.AdaptadorProyecto
import com.example.t7dialogos.databinding.ActivityMainBinding
import com.example.t7dialogos.dialogs.DialogoAyuda
import com.example.t7dialogos.dialogs.DialogoProyecto
import kotlin.concurrent.fixedRateTimer

class MainActivity : AppCompatActivity(), OnClickListener, DialogoProyecto.OnDialogoProyectoListener {

    override fun onProyectoAdd(nombre: String, responsable: String, presupuesto: Int) {
        // llevar los datos a la lista (recycler)
        adaptadorProyecto.addProyecto(nombre,responsable, presupuesto)

    }


    private lateinit var binding: ActivityMainBinding
    private lateinit var adaptadorProyecto: AdaptadorProyecto

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        adaptadorProyecto = AdaptadorProyecto(applicationContext)
        setContentView(binding.root)

        binding.proyectos.adapter = adaptadorProyecto
        binding.proyectos.layoutManager =
            LinearLayoutManager(applicationContext, LinearLayoutManager.VERTICAL,false)

        binding.botonAyuda.setOnClickListener(this)
        binding.botonAdd.setOnClickListener(this)


    }

    override fun onClick(p0: View?) {
       when(p0!!.id){
           binding.botonAdd.id ->{
               // lanzar un dialogo personalizado
               DialogoProyecto().show(supportFragmentManager,null)
           }
           binding.botonAyuda.id ->{
               // lanzar un dialogo preconstruido

               //DialogoAyuda().show(supportFragmentManager,null)

               DialogoAyuda.newInstance("Ejemplo",10).show(supportFragmentManager,null)

           }


       }
    }


    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu,menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        when(item.itemId){
            R.id.opcion1->{
                DialogoProyecto().show(supportFragmentManager,"")
            }
            R.id.opcion2->{
                DialogoAyuda.newInstance("Menus").show(supportFragmentManager,"")
            }
        }
        return true
    }


}
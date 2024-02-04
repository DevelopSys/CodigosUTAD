package com.example.t7dialogos

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.view.View.OnClickListener
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.t6recycler.adapter.AdaptadorProyectos
import com.example.t7dialogos.databinding.ActivityMainBinding
import com.example.t7dialogos.dialog.DialogoAyuda
import com.example.t7dialogos.dialog.DialogoPerso

// TODO 3. Implmenento la interfaz
class MainActivity : AppCompatActivity(), OnClickListener, DialogoPerso.OnDialogoProyectoListener {

    private lateinit var binding: ActivityMainBinding
    private lateinit var adaptadorProyectos: AdaptadorProyectos
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        adaptadorProyectos = AdaptadorProyectos(applicationContext)

        setContentView(binding.root)

        binding.botonAnadir.setOnClickListener(this)
        binding.botonAyuda.setOnClickListener(this)


        binding.listaProyectos.adapter = adaptadorProyectos
        binding.listaProyectos.layoutManager = LinearLayoutManager(applicationContext, LinearLayoutManager.VERTICAL,false)

    }

    override fun onClick(p0: View?) {
        when(p0!!.id){
            binding.botonAnadir.id ->{
                // lanzar un dialogo
                val dialogoPerso = DialogoPerso()
                dialogoPerso.show(supportFragmentManager,null)
            }
            binding.botonAyuda.id ->{
                // lanzar un dialogo
                //val dialogoAyuda = DialogoAyuda()
                val dialogoAyuda = DialogoAyuda.newInstance("Borja")
                dialogoAyuda.show(supportFragmentManager,null)
            }
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu,menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        when(item.itemId){
            R.id.opcion1 ->{

            }
            R.id.opcion2 ->{

            }
            R.id.opcion3 ->{

            }
        }

        return true
    }

    override fun onDatoAdd(nombre: String, responsable: String, presupuesto: Int) {
        // llevar los datos al recycler -- adaptador
        adaptadorProyectos.addProyecto(nombre,responsable,presupuesto)
    }
}
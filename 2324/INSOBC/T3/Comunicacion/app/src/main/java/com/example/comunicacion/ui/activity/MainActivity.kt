package com.example.comunicacion.ui.activity

import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract.Data
import android.view.View
import android.view.View.OnClickListener
import android.widget.AdapterView
import android.widget.AdapterView.OnItemSelectedListener
import android.widget.ArrayAdapter
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.comunicacion.R
import com.example.comunicacion.adapters.AdaptadorModelo
import com.example.comunicacion.data.DataSet
import com.example.comunicacion.databinding.ActivityMainBinding
import com.example.comunicacion.model.Marca
import com.example.comunicacion.model.Modelo
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var adaptadorMarcas: ArrayAdapter<Marca>
    private lateinit var adaptadorModelo: AdaptadorModelo

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        instancias()
        persoSpinner()
        persoRecycler()

        val correo = intent.getStringExtra("correo")!!
        val perfil = intent.getStringExtra("perfil")!!

        binding.textoSaludo.setText("Bienvenido $correo")
        binding.textoPefil.setText("$perfil")

        acciones()

    }

    fun acciones() {
        binding.agregarMarca.setOnClickListener {
            // adaptadorMarcas.add(Marca("Nueva", "Desconocido", R.drawable.user))
            // adaptadorMarcas.notifyDataSetChanged()
            adaptadorModelo.addModelo(Modelo("Mercedes", "GLE", 70000.0, 300,
                R.drawable.mercedes))

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
                adaptadorModelo.cambiarLista(DataSet.getAllModelos(seleccion.nombre))

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
        adaptadorMarcas.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        binding.spinnerMarca.adapter = adaptadorMarcas
    }

    fun persoRecycler() {
        binding.recyclerModelos.adapter = adaptadorModelo
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

        adaptadorModelo = AdaptadorModelo(DataSet.getAllModelos("Mercedes"), this)
        adaptadorMarcas = ArrayAdapter(
            applicationContext, android.R.layout.simple_spinner_item, DataSet.getAllMarcas()
        )
    }


}
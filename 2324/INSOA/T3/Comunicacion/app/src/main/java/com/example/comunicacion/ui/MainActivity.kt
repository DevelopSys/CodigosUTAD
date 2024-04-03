package com.example.comunicacion.ui

import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
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
import com.example.comunicacion.R
import com.example.comunicacion.adapters.AdaptadorModelo
import com.example.comunicacion.data.DataSet
import com.example.comunicacion.databinding.ActivityLoginBinding
import com.example.comunicacion.databinding.ActivityMainBinding
import com.example.comunicacion.model.Marca
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var adaptadorModelo: AdaptadorModelo
    private lateinit var nombre: String
    private lateinit var adapterSpinner: ArrayAdapter<Marca>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        instacias()
        persoAdaptadores()

        this.nombre = intent.getStringExtra("correo")!!
        binding.textoSaludo.text = nombre
        acciones()

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
                adaptadorModelo.cambiarLista(DataSet.getAllModelos(selecccion.nombre))


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

    fun instacias() {
        // crea la parte de datos del spinner
        adapterSpinner = ArrayAdapter(
            applicationContext,
            android.R.layout.simple_spinner_item,
            DataSet.getAllMarcas()
        )
        adaptadorModelo = AdaptadorModelo(DataSet.getAllModelos("Mercedes"), this)
    }


    fun persoAdaptadores() {
        // junta parte grafica con parte logica
        binding.spinnerSeleccion.adapter = adapterSpinner;
        // muestra el desplegable de forma visible
        adapterSpinner.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

        binding.recyclerModelos.adapter = adaptadorModelo
        binding.recyclerModelos.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)

        if (resources.configuration.orientation == Configuration.ORIENTATION_LANDSCAPE){
            binding.recyclerModelos.layoutManager =
                GridLayoutManager(this, 2)
        }

        //GridLayoutManager(this,2)

        //LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
    }

}

/*
* Clase Modelo: marca (s), modelo (s), cv (int), precio (d), imagen (int)
* */



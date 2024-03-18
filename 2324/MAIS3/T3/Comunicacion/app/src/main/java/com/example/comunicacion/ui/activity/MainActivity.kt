package com.example.comunicacion.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract.Data
import android.util.Log
import android.view.View
import android.view.View.OnClickListener
import android.widget.AdapterView
import android.widget.AdapterView.OnItemSelectedListener
import android.widget.ArrayAdapter
import androidx.recyclerview.widget.LinearLayoutManager

import com.example.comunicacion.R
import com.example.comunicacion.adapters.ModeloAdapter
import com.example.comunicacion.data.DataSet
import com.example.comunicacion.databinding.ActivityMainBinding
import com.example.comunicacion.model.Marca
import com.example.comunicacion.model.Modelo
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var adaptadorMarcas: ArrayAdapter<Marca>
    private lateinit var correo: String
    private lateinit var adaptadorModelos: ModeloAdapter
    private var perfil: Char? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        instancias()
        personalizarSpinner()
        personalizarRecycler()

        correo = intent.getStringExtra("correo")!!
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
                adaptadorModelos.getListaModelos(DataSet.getAllModelos(seleccion.nombre))


            }

            override fun onNothingSelected(parent: AdapterView<*>?) {

            }

        }

    }

    fun instancias(){
        adaptadorModelos = ModeloAdapter(DataSet.getAllModelos("Mercedes"), this)
        adaptadorMarcas = ArrayAdapter(
            applicationContext,
            android.R.layout.simple_spinner_item,
            DataSet.getAllMarcas()
        )

    }
    fun personalizarRecycler(){
        binding.recyclerModelos.adapter = adaptadorModelos
        binding.recyclerModelos.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)

    }
    fun personalizarSpinner(){
        adaptadorMarcas.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        binding.spinnerMarca.adapter = adaptadorMarcas
    }


}

// crear un objeto llamado marca el cual tiene
// nombre, calidad e imagen
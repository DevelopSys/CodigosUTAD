package com.example.comunicacion.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.View.OnClickListener
import android.widget.AdapterView
import android.widget.AdapterView.OnItemSelectedListener
import android.widget.ArrayAdapter

import com.example.comunicacion.R
import com.example.comunicacion.data.DataSet
import com.example.comunicacion.databinding.ActivityMainBinding
import com.example.comunicacion.model.Marca
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var adaptadorMarcas: ArrayAdapter<Marca>
    private lateinit var correo: String
    private var perfil: Char? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        adaptadorMarcas = ArrayAdapter(
            applicationContext,
            android.R.layout.simple_spinner_item,
            DataSet.getAllMarcas()
        )

        adaptadorMarcas.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        binding.spinnerMarca.adapter = adaptadorMarcas

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
                // Log.v("datos", parent!!.adapter.getItem(position).toString())
                val marca: Marca = parent!!.adapter.getItem(position) as Marca
                Snackbar.make(binding.root, "${marca.nombre}, calidad: ${marca.calidad}", Snackbar.LENGTH_SHORT).show()
                binding.imagenMarca.setImageResource(marca.imagen)
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {

            }

        }


    }


}

// crear un objeto llamado marca el cual tiene
// nombre, calidad e imagen
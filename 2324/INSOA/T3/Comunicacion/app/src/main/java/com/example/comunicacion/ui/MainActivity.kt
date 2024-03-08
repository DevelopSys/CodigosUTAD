package com.example.comunicacion.ui

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
import com.example.comunicacion.R
import com.example.comunicacion.data.DataSet
import com.example.comunicacion.databinding.ActivityLoginBinding
import com.example.comunicacion.databinding.ActivityMainBinding
import com.example.comunicacion.model.Marca
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var nombre: String
    private lateinit var adapterSpinner: ArrayAdapter<Marca>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        // crea la parte de datos del spinner
        adapterSpinner = ArrayAdapter(
            applicationContext,
            android.R.layout.simple_spinner_item,
            DataSet.getAllMarcas()
        )
        // junta parte grafica con parte logica
        binding.spinnerSeleccion.adapter = adapterSpinner;
        // muestra el desplegable de forma visible
        adapterSpinner.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

        // cada vez que cambia la seleccion del spinner, que salga un Snackbar con el nombre de la
        // marca

        this.nombre = intent.getStringExtra("correo")!!
        binding.textoSaludo.text = nombre

        // arraylist con todas las marcas


        binding.spinnerSeleccion.onItemSelectedListener = object : OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {

                val selecccion : Marca = parent!!.adapter.getItem(position) as Marca
                binding.imagenMarca.setImageResource(selecccion.imagen)


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
}



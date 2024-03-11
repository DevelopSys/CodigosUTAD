package com.example.comunicacion.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
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

        val correo = intent.getStringExtra("correo")!!
        val perfil = intent.getStringExtra("perfil")!!

        binding.textoSaludo.setText("Bienvenido $correo")
        binding.textoPefil.setText("$perfil")

        binding.agregarMarca.setOnClickListener {
            adaptadorMarcas.add(Marca("Nueva","Desconocido",R.drawable.user))
            adaptadorMarcas.notifyDataSetChanged()
        }


        binding.spinnerMarca.onItemSelectedListener = object : OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                val seleccion = parent!!.adapter.getItem(position) as Marca
                binding.imagenMarca.setImageResource(seleccion.imagen)
                //binding.imagenMarca.setImageDrawable(resources.getDrawable(R.drawable.mercedes,null))
                Snackbar.make(
                    binding.root,
                    "${resources.getString(R.string.nombre)}: ${seleccion.nombre}, ${
                        resources.getString(
                            R.string.calidad
                        )
                    }: ${seleccion.calidad}",
                    Snackbar.LENGTH_SHORT
                ).show()
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {

            }

        }

    }


}
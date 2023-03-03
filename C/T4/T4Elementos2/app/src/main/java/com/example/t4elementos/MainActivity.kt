package com.example.t4elementos

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import android.widget.RadioButton
import com.example.t4elementos.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var adaptadorSpinner: ArrayAdapter<CharSequence>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        persoSpinner()
        actions()
    }

    fun persoSpinner(){


        // parte logica --> datos --> @array : ArrayAdater
        // parte logica --> datos --> DB --> ArrayList  : ArrayAdater
        adaptadorSpinner = ArrayAdapter
            .createFromResource(applicationContext,R.array.opciones_spinner, android.R.layout.simple_spinner_item)
        adaptadorSpinner.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

        // parte grafica
        binding.spinner.adapter = adaptadorSpinner
    }

    fun actions(){
        binding.botonComprobar.setOnClickListener {

            binding.spinner.selectedItem.toString()
            binding.spinner.adapter.getItem(binding.spinner.selectedItemPosition)

        //Log.v("comprobacion","Estado del toggle ${binding.toggle.isChecked}")
        // Log con el estado del toggle
            // pulsar cambio el estado true a false o de false a true
            val radioSeleccionado:RadioButton? =
                findViewById(binding.grupoRadios.checkedRadioButtonId)

            Log.v("comprobar",radioSeleccionado?.text.toString()?: "Sin seleccion")


            when(binding.grupoRadios.checkedRadioButtonId){
                binding.radioUno.id->{}
                binding.radioDos.id->{}
                binding.radioTres.id->{}
            }
        }
        binding.botonComprobar.setOnLongClickListener {
            binding.toggle.isChecked = !binding.toggle.isChecked
            binding.check.isChecked = !binding.check.isChecked
            binding.switchSeleccion.isChecked = !binding.switchSeleccion.isChecked
            return@setOnLongClickListener true
        }
        binding.toggle.setOnCheckedChangeListener { _,state ->
            Log.v("comprobacion","Cambio del estado del toggle ${state}")
        }
        binding.switchSeleccion.setOnCheckedChangeListener { _,state ->
            Log.v("comprobacion","Cambio del estado del switch ${state}")
        }
        binding.check.setOnCheckedChangeListener { _,state ->
            Log.v("comprobacion","Cambio del estado del check ${state}")
        }
        binding.grupoRadios.setOnCheckedChangeListener { _, i ->
            val radioSeleccionado:RadioButton? = findViewById(i)
            when(i){
                binding.radioUno.id ->{}
                binding.radioDos.id ->{}
                binding.radioTres.id ->{}
            }
        }
    }
}
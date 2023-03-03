package com.example.t4elementos

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import android.widget.CompoundButton
import android.widget.CompoundButton.OnCheckedChangeListener
import android.widget.RadioButton
import com.example.t4elementos.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), OnCheckedChangeListener {

    private lateinit var binding: ActivityMainBinding
    private var elementoSeleccionado: Boolean = false;
    private lateinit var adaptadorSpinner: ArrayAdapter<CharSequence>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        persoSpinner()
        action()

    }


    fun persoSpinner() {
        // parte grafica
        binding.spinner
        // parte logica - datos -> ArrayAdapter
        adaptadorSpinner = ArrayAdapter.createFromResource(
            applicationContext, R.array.opciones_spinner, android.R.layout.simple_spinner_item)
        binding.spinner.adapter = adaptadorSpinner
        adaptadorSpinner.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

    }

    fun action() {
        binding.botonComprobar.setOnClickListener {
            // cuando el boton se pulse
            val estadoToggle = binding.toggle.isChecked
            binding.toggle.isChecked = !binding.toggle.isChecked
            Log.v("comprobaciones", elementoSeleccionado.toString())
            // tratarlo como el cambio del grupo
            binding.grupoRadios.checkedRadioButtonId
            //binding.spinner.selectedItem
            binding.spinner.adapter.getItem(binding.spinner.selectedItemPosition)

        }
        binding.toggle.setOnCheckedChangeListener(this)
        binding.checkbox.setOnCheckedChangeListener(this)
        binding.switchSelect.setOnCheckedChangeListener(this)

        binding.grupoRadios.setOnCheckedChangeListener { _, i ->
            val radioSeleccionado: RadioButton = findViewById(i)
            Log.v("comprobaciones", radioSeleccionado.text.toString())
            when (i) {
                binding.radioUno.id -> {}
                binding.radioDos.id -> {}
                binding.radioTres.id -> {}
            }
        }
    }

    override fun onCheckedChanged(p0: CompoundButton?, p1: Boolean) {
        when (p0!!.id) {
            binding.toggle.id -> {
                elementoSeleccionado = p1
                Log.v("comprobaciones", "Toggle ${p1}")
            }
            binding.switchSelect.id -> {
                Log.v("comprobaciones", "Switch ${p1}")
            }
            binding.checkbox.id -> {
                Log.v("comprobaciones", "Check ${p1}")

            }
        }
    }
}
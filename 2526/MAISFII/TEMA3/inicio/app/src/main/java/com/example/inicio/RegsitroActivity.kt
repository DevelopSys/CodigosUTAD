package com.example.inicio

import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import com.example.inicio.data.DataSet
import com.example.inicio.databinding.ActivityRegistroBinding
import com.example.inicio.model.UserData
import com.google.android.material.snackbar.Snackbar

class RegsitroActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRegistroBinding
    private lateinit var listaEdades: ArrayList<CharSequence>
    private lateinit var adapterEdad: ArrayAdapter<CharSequence>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegistroBinding.inflate(layoutInflater)
        setContentView(binding.root)
        intancias()
        initGUI()
        acciones()
    }

    private fun acciones() {
        binding.btnRegistrar.setOnClickListener {
            // verificar si hay campos vacios
            val nombre = binding.editNombre.text.toString()
            val apellido = binding.editApellido.text.toString()
            val correo = binding.editCorreo.text.toString()
            val pass = binding.editPass.text.toString()
            val edad: Int = binding.spinnerEdad.selectedItem.toString().toInt()

            val user = UserData(nombre, apellido, correo, pass, edad)
            if (DataSet.addUser(user)) {
                getSnack("Usuario agregado correctamente")
                    .setAction("Pulsar"){  }
                    .show()
            } else {
                getSnack("Fallo en el proceso de registro").show()
            }
        }
    }

    private fun getSnack(mensaje: String): Snackbar {
        return Snackbar.make(binding.root, mensaje, Snackbar.LENGTH_LONG)
    }

    private fun initGUI() {
        binding.spinnerEdad.adapter = adapterEdad;
        adapterEdad.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
    }

    private fun intancias() {
        listaEdades = ArrayList()
        for (i in 18..90) {
            listaEdades.add(i.toString())
        }
        adapterEdad = ArrayAdapter<CharSequence>(
            applicationContext,
            android.R.layout.simple_spinner_item,
            listaEdades
        )
    }
}
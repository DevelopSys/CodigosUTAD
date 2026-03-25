package com.example.inicioandroid

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.inicioandroid.databinding.ActivitySecondBinding
import com.google.android.material.snackbar.Snackbar

class SecondActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySecondBinding
    private lateinit var adapterOpciones: ArrayAdapter<String>
    private lateinit var lista: ArrayList<String>


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)

        lista = arrayListOf("Opcion 1", "Opcion 2", "Opcion 3")
        adapterOpciones =
            ArrayAdapter(applicationContext, android.R.layout.simple_spinner_item, lista)
        binding.spinnerCategoria.adapter = adapterOpciones;
        adapterOpciones.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        // binding.btnAnadir.isEnabled = binding.checkHabilitar.isChecked

        binding.btnAnadir.setOnClickListener {
            lista.add("Opcion nueva")
        }

        binding.checkHabilitar.setOnCheckedChangeListener { _, isChecked ->
            binding.btnAnadir.isEnabled = isChecked
        }
        binding.btnSeleccion.setOnClickListener {
            val seleccion = binding.spinnerCategoria.selectedItem.toString()
            Snackbar.make(
                binding.root,
                "El elemento seleccionado es " + seleccion,
                Snackbar.LENGTH_LONG
            ).show()
        }
        binding.spinnerCategoria.onItemSelectedListener =
            object : AdapterView.OnItemSelectedListener {
                override fun onItemSelected(
                    parent: AdapterView<*>?,
                    view: View?,
                    position: Int,
                    id: Long
                ) {
                    binding.textoPosicion.text = position.toString()
                    Snackbar.make(
                        binding.root,
                        "El elemento seleccionado es ${
                            binding.spinnerCategoria.adapter.getItem(position)
                        }",
                        Snackbar.LENGTH_LONG
                    ).show()
                }

                override fun onNothingSelected(parent: AdapterView<*>?) {

                }

            }


    }
}
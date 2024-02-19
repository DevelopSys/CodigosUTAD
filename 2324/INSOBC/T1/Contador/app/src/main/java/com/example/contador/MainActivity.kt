package com.example.contador

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.View.OnClickListener
import android.widget.Button
import android.widget.TextView
import com.example.contador.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity(), OnClickListener {

    private lateinit var binding: ActivityMainBinding
    private var contador: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        contador = savedInstanceState?.getInt("contador", 0) ?: 0
        setContentView(binding.root)
        binding.textoContador.text = contador.toString()
        binding.botonIncremento.setOnClickListener(this)
        binding.botonDecremento.setOnClickListener(this)
        binding.botonReset?.setOnClickListener(this)
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt("contador", contador)
    }

    override fun onClick(v: View?) {
        when (v!!.id) {
            binding.botonIncremento.id -> {
                contador++
            }

            binding.botonDecremento.id -> {
                contador--
            }

            binding.botonReset!!.id -> {

                // no tenga nada -> aviso
                if (binding.editReset!!.text.toString().isEmpty()) {
                    Snackbar.make(
                        binding.root,
                        "No se pueden setear, faltan datos",
                        Snackbar.LENGTH_SHORT
                    ).show()
                } else if (binding.editReset!!.text.toString().toInt() > -1) {
                    contador = binding.editReset!!.text.toString().toInt()
                } else {
                    contador = 0
                }
                // > pondras el numero
                // pondras 0

            }
        }

        binding.textoContador.text = contador.toString()
    }
}
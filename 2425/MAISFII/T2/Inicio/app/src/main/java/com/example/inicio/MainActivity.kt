package com.example.inicio

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.inicio.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        acciones()
        /*binding.botonSaludar.setOnClickListener {

            if (binding.editNombre.text.isEmpty()) {
                Snackbar.make(
                    binding.root,
                    "Por favor introduce datos",
                    Snackbar.LENGTH_LONG
                ).show()
            } else {
                Snackbar.make(
                    binding.root,
                    "Enhorabuena ${binding.editNombre.text.toString()}, tu primera app android completa",
                    Snackbar.LENGTH_LONG
                ).show()
            }

        }*/

    }

    private fun acciones() {
        binding.checkInicio.setOnCheckedChangeListener { _, b ->
            binding.btnLogin.isEnabled = b
        }

        binding.btnLogin.setOnClickListener {
            if (!binding.editCorreo.text.isEmpty()
                && !binding.editPass.text.isEmpty()){

                Log.v("datos",binding.editCorreo.text.toString())
                Log.v("datos",binding.editPass.text.toString())
                Log.v("datos",binding.checkInicio.isChecked.toString())
                Log.v("datos",binding.spinnerPerfil.selectedItem.toString())

                // cambio pantalla
                val intent = Intent(applicationContext, SecondActivity::class.java)
                startActivity(intent)

            } else {

            }
        }
    }


}
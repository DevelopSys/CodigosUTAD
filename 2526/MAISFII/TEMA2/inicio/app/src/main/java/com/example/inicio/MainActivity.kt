package com.example.inicio

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.inicio.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity(), View.OnClickListener {

    // referencia a cada uno de los elementos de la parte UI

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        actions()
        Log.v("ciclo_vida","ejecutando metodo onCreate")

        /*
        binding.botonSaludar.setOnClickListener {
            // configura que pasa cuando se pulsa el boton
            Snackbar.make(
                binding.root,
                "Enhorabuena ${binding.editNombre.text.toString()} primera app android completada",
                Snackbar.LENGTH_LONG
            ).show()
        }

        binding.botonVaciar.setOnClickListener {
            binding.editNombre.text.clear()
        }

         */

    }

    private fun actions() {
        binding.botonSaludar.setOnClickListener(this)
        binding.botonVaciar.setOnClickListener(this)
        binding.botonSalir?.setOnClickListener(this)
    }

    override fun onClick(v: View?) {

        when (v!!.id) {
            binding.botonVaciar.id -> {
                binding.editNombre.text.clear()
            }
            binding.botonSaludar.id -> {

                if (binding.editNombre.text.toString().isEmpty()) {
                    Snackbar.make(
                        binding.root,
                        "${resources.getString(R.string.text_empty_edit)}",
                        Snackbar.LENGTH_LONG
                    ).show()
                } else {
                    Snackbar.make(
                        binding.root,
                        "Enhorabuena ${binding.editNombre.text.toString()} primera app android completada",
                        Snackbar.LENGTH_LONG
                    ).show()
                }


            }
            binding.botonSalir!!.id ->{
                finish()
            }
        }
    }

    override fun onStart() {
        super.onStart()
        Log.v("ciclo_vida","ejecutando metodo onStart")

    }

    override fun onResume() {
        super.onResume()
        Log.v("ciclo_vida","ejecutando metodo onResume")

    }

    override fun onPause() {
        super.onPause()
        Log.v("ciclo_vida","ejecutando metodo onPause")

    }

    override fun onStop() {
        super.onStop()
        Log.v("ciclo_vida","ejecutando metodo onStop")

    }

    override fun onRestart() {
        super.onRestart()
        Log.v("ciclo_vida","ejecutando metodo onRestart")

    }

    override fun onDestroy() {
        super.onDestroy()
        Log.v("ciclo_vida","ejecutando metodo onDestroy")

    }

}
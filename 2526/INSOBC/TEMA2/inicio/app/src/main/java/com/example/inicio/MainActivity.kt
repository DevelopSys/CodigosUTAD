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


class MainActivity : AppCompatActivity(), View.OnClickListener{

    // tantas variables coo elementos graficos tenga
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        actions()
        Log.v("ciclo_vida", "metodo onCreate ejecutado")
    }

    private fun actions() {
        /*
        binding.botonSaludar.setOnClickListener {

            val nombre = binding.editNombre.text.toString()

            if (nombre.isEmpty()) {
                Snackbar.make(
                    binding.root, R.string.text_snack_empty, Snackbar.LENGTH_LONG
                ).show()
            } else {
                // quien ha generado el evento -> it
                Snackbar.make(
                    binding.root,
                    "${resources.getString(R.string.text_congrats)} $nombre has completado la primera app",
                    Snackbar.LENGTH_LONG
                ).show()
            }


        }
        binding.botonVaciar.setOnClickListener {
            binding.editNombre.text.clear()
        }*/

        binding.botonVaciar.setOnClickListener(this)
        binding.botonSaludar.setOnClickListener(this)
        binding.botonCerrar?.setOnClickListener(this)
    }

    override fun onStart() {
        super.onStart()
        Log.v("ciclo_vida", "metodo onStart ejecutado")
    }

    override fun onResume() {
        super.onResume()
        Log.v("ciclo_vida", "metodo onResume ejecutado")
    }

    override fun onPause() {
        super.onPause()
        Log.v("ciclo_vida", "metodo onPause ejecutado")
    }

    override fun onStop() {
        super.onStop()
        Log.v("ciclo_vida", "metodo onStop ejecutado")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.v("ciclo_vida", "metodo onDestroy ejecutado")
    }

    override fun onRestart() {
        super.onRestart()
        Log.v("ciclo_vida", "metodo onRestart ejecutado")
    }

    override fun onClick(v: View?) {
        // que pasa cuando se pulsa el boton
            // cual de los dos es el pulsado
        when(v!!.id){
           binding.botonSaludar.id->{

           }
           binding.botonVaciar.id->{

           }

            binding.botonCerrar!!.id ->{
                finish()
            }
        }
    }
}
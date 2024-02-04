package com.example.contador

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.View.OnClickListener
import android.widget.Button
import android.widget.Spinner
import android.widget.TextView
import com.example.contador.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar


class MainActivity : AppCompatActivity(), OnClickListener {


    private lateinit var binding: ActivityMainBinding
    private var contador: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        contador = savedInstanceState?.getInt("contador") ?: 0
        Log.v("ciclo_vida", "Ejecutado el metodo onCreate")
        binding.textoContador.text = contador.toString()

    }


    override fun onStart() {
        super.onStart()
        Log.v("ciclo_vida", "Ejecutado el metodo onStart")
        /*binding.botonIncremento.setOnClickListener { // it
                Snackbar.make(it, "Pulsado boton"
                    , Snackbar.LENGTH_SHORT).show()
        }
        binding.botonDecremento.setOnClickListener { // it
            Snackbar.make(it, "Pulsado boton"
                , Snackbar.LENGTH_SHORT).show()
        }
        binding.botonReset.setOnClickListener { // it
            Snackbar.make(it, "Pulsado boton"
                , Snackbar.LENGTH_SHORT).show()
        }*/
        binding.botonIncremento.setOnClickListener(this)
        binding.botonDecremento.setOnClickListener(this)
        binding.botonReset.setOnClickListener(this)
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt("contador",contador)
    }

    override fun onResume() {
        super.onResume()
        Log.v("ciclo_vida", "Ejecutado el metodo onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.v("ciclo_vida", "Ejecutado el metodo onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.v("ciclo_vida", "Ejecutado el metodo onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.v("ciclo_vida", "Ejecutado el metodo onDestroy")
    }

    override fun onRestart() {
        super.onRestart()
        Log.v("ciclo_vida", "Ejecutado el metodo onREstart")
    }

    override fun onClick(p0: View?) {
        when(p0!!.id){
            binding.botonIncremento.id -> {
                contador++
            }
            binding.botonDecremento.id -> {
                contador--
            }
            binding.botonReset.id ->{
                contador = 0
            }
        }
        binding.textoContador.text = contador.toString();
    }


}
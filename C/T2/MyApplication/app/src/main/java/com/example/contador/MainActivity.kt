package com.example.contador

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.View.OnClickListener
import android.widget.Button
import androidx.core.view.children
import com.example.contador.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar


class MainActivity : AppCompatActivity(), OnClickListener {

    private lateinit var binding: ActivityMainBinding
    private var contador: Int = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        acciones()
        contador = savedInstanceState?.getInt("contador") ?: 0
        updateContador()
        Log.v("ciclo_vida","ejecutando el método    p onCreate")
    }

    fun updateContador(){
        binding.textoContador.text = contador.toString()
    }

    fun acciones(){



        /*binding.botonIncremento.setOnClickListener {
            Snackbar.make(it,"Boton pulsado",Snackbar.LENGTH_SHORT).show()
        }

        binding.botonDecremento.setOnClickListener {
            Snackbar.make(it,"Boton pulsado",Snackbar.LENGTH_SHORT).show()
        }

        binding.botonReset.setOnClickListener {
            Snackbar.make(it,"Boton pulsado",Snackbar.LENGTH_SHORT).show()
        }*/
        binding.botonIncremento.setOnClickListener(this)
        binding.botonDecremento.setOnClickListener(this)
        binding.botonReset.setOnClickListener(this)
    }

    override fun onStart() {
        super.onStart()
        Log.v("ciclo_vida","ejecutando el métodop onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.v("ciclo_vida","ejecutando el métodop onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.v("ciclo_vida","ejecutando el métodop onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.v("ciclo_vida","ejecutando el métodop onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.v("ciclo_vida","ejecutando el métodop onDestroy")
    }
    override fun onRestart() {
        super.onRestart()
        Log.v("ciclo_vida","ejecutando el métodop onRestart")
    }

    override fun onClick(p0: View?) {
        when(p0!!.id){
            binding.botonIncremento.id -> {
                contador++;
            }
            binding.botonDecremento.id -> {
                contador--
            }
            binding.botonReset.id -> {
                contador = 0;
            }
        }
        updateContador()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt("contador",contador)
    }
}
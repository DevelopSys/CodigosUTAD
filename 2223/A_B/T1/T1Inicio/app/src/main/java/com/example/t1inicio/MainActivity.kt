package com.example.t1inicio

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.View.OnClickListener
import android.widget.Button
import android.widget.TextView
import com.example.t1inicio.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar


class MainActivity : AppCompatActivity(), OnClickListener {

    /*private lateinit var botonIncrementar: Button
    private lateinit var botonDecrementar: Button
    private lateinit var botonResetear: Button
    private lateinit var textoContador: TextView*/
    private lateinit var binding: ActivityMainBinding

    companion object{
        val elemento: String = "ASDASD"
        val elemento2: Int = 2

        fun ejemploDeFucion(){
            elemento
            elemento2
        }
    }
    // mutables
    var nombre: String? = null
    var contador: Int =0;
    var experiencia: Boolean = false
    var asignaturas: ArrayList<String>? = null
    // no mutables
    val DNI: String = "123123123A";

    // asigna parte grafica y parte logica
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        this.setContentView(binding.root)
        contador = savedInstanceState?.getInt("valor_contador",0) ?: 0
        //binding.textoContador.setText(contador.toString())
        binding.textoContador.text = contador.toString()
        acciones()
    }

    override fun onStart() {
        super.onStart()

    }

    override fun onResume() {
        super.onResume()
    }

    override fun onPause() {
        super.onPause()
    }

    override fun onStop() {
        super.onStop()
    }

    override fun onDestroy() {
        super.onDestroy()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt("valor_contador",contador)
    }

    private fun acciones() {

        // OnClickListener
        /*binding.botonIncrementar.setOnClickListener {
            Snackbar.make(binding.root, "Pulsado boton incrementar",Snackbar.LENGTH_SHORT).show()
        }
        binding.botonDecrementar.setOnClickListener {
            Snackbar.make(binding.root, "Pulsado boton descrementar",Snackbar.LENGTH_SHORT).show()
        }
        binding.botonResetear.setOnClickListener {
            Snackbar.make(binding.root, "Pulsado boton resetear",Snackbar.LENGTH_SHORT).show()
        }*/

        binding.botonIncrementar.setOnClickListener(this)
        binding.botonResetear.setOnClickListener(this)
        binding.botonDecrementar.setOnClickListener(this)
    }

    override fun onClick(p0: View?) {
        when(p0?.id){
            binding.botonIncrementar.id ->{
                contador++
            }
            binding.botonDecrementar.id ->{
                contador--
            }
            binding.botonResetear.id ->{
                contador = 0
            }
        }

        binding.textoContador.text = contador.toString()
    }
}
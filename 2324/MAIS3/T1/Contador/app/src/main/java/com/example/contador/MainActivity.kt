package com.example.contador

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.View.OnClickListener
import android.widget.Button
import com.example.contador.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity(), OnClickListener {

    private lateinit var binding: ActivityMainBinding
    private var contador: Int = 0;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        contador = savedInstanceState?.getInt("contador",0) ?: 0

        setContentView(binding.root)
        // las cosas graficas
        binding.textoContador.text = contador.toString()
        binding.botonIncremento.setOnClickListener(this)
        binding.botonDecremento.setOnClickListener(this)
        binding.botonReset?.setOnClickListener(this)

    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt("contador",contador)
    }

    override fun onClick(v: View?) {
        when(v!!.id){
            binding.botonIncremento.id->{
                contador++
            }
            binding.botonDecremento.id->{
                contador--
            }
            binding.botonReset?.id ->{

                //val numeroReset = binding.editReset!!.text.toString().toInt()
                if (binding.editReset!!.text.toString().isEmpty()){
                    contador = 0
                }
                else if (binding.editReset!!.text.toString().toInt()>=0){
                    contador = binding.editReset!!.text.toString().toInt()
                } else if (binding.editReset!!.text.toString().toInt()<0){
                    Snackbar.make(binding.root,"No se setean nºs negativos"
                        , Snackbar.LENGTH_SHORT).show()
                }
            }
        }

        binding.textoContador.text = contador.toString()
    }
}

/*
* En la parte de la derecha crear un EDIT que sirva para indicar
* el numero al que se quiere resetear. Las opciones son:
*   - Si no hay nada metido en el EDIT - resetea a 0
*   - Si hay un positivo - reseteo al numero indicado
*  - Si hay un negativo - aparece Snackbar con un aviso
*   Snackbar.make(binding.root, "AVISO", Snackbar.LENGTH_SHORT).show
* */
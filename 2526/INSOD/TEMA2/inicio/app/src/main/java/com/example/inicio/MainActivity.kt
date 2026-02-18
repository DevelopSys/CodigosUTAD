package com.example.inicio

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.inicio.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity(), View.OnClickListener {
    // primer metodo del ciclo de vida

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        actions()


    }

    private fun actions() {

        /*
        binding.botonVaciar.setOnClickListener {
            binding.editNombre.text.clear()
        }
        binding.botonSaludar.setOnClickListener {

            if (binding.editNombre.text.isEmpty()) {
                showSnack(resources.getString(R.string.text_snack_empty))
            } else {
                showSnack("Enhorabuena ${binding.editNombre.text.toString()}, reto comletado")
            }
        }
        */

        binding.botonSaludar.setOnClickListener(this)
        binding.botonVaciar.setOnClickListener(this)
    }

    private fun showSnack(text: String) {
        val snack = Snackbar.make(
            binding.root,
            text,
            Snackbar.LENGTH_LONG
        )
        snack.show()
    }

    override fun onClick(v: View?) {
       // funcionamiento comun
        when(v?.id){
           binding.botonVaciar.id->{

           }
           binding.botonSaludar.id->{

           }
       }
    }
}
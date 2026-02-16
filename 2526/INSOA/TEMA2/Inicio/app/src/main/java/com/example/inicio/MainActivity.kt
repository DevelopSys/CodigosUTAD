package com.example.inicio

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.inicio.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        Log.v("ciclo_vida", "ejcutando el onCreate")
    }

    override fun onResume() {
        super.onResume()

        /*
        binding.botonSaludar.setOnClickListener {

            val nombre: String = binding.editNombre.text.toString()

            if (nombre.isEmpty()){
                Snackbar.make(
                    binding.root,
                    R.string.text_empty_name,
                    Snackbar.LENGTH_LONG).show()
            } else {
                Snackbar.make(
                    binding.root,
                    "${resources.getString(R.string.text_congratulation)} " +
                            "$nombre, has completado el primer proyecto",
                    Snackbar.LENGTH_LONG).show()
            }

        }
        binding.botonVaciar.setOnClickListener {  }
         */
        binding.botonSaludar.setOnClickListener(this)
        binding.botonVaciar.setOnClickListener(this)

    }

    override fun onStart() {
        super.onStart()
        Log.v("ciclo_vida", "ejcutando el onStart")
    }

    override fun onRestart() {
        super.onRestart()
        Log.v("ciclo_vida", "ejcutando el onRestart")
    }

    override fun onPause() {
        super.onPause()
        Log.v("ciclo_vida", "ejcutando el onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.v("ciclo_vida", "ejcutando el onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.v("ciclo_vida", "ejcutando el onDestroy")
    }

    override fun onClick(v: View?) {
        when (v!!.id) {
            binding.botonVaciar.id -> {
                binding.editNombre.text.clear()
            }
            binding.botonSaludar.id -> {
                val nombre: String = binding.editNombre.text.toString()

                if (nombre.isEmpty()) {
                    Snackbar.make(
                        binding.root,
                        R.string.text_empty_name,
                        Snackbar.LENGTH_LONG
                    ).show()
                } else {
                    Snackbar.make(
                        binding.root,
                        "${resources.getString(R.string.text_congratulation)} " +
                                "$nombre, has completado el primer proyecto",
                        Snackbar.LENGTH_LONG
                    ).show()
                }
            }
        }
    }
}
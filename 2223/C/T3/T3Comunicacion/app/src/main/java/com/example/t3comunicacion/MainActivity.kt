package com.example.t3comunicacion

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.t3comunicacion.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }

    override fun onStart() {
        super.onStart()
        // acciones
        binding.botonLogin.setOnClickListener {


            binding.editNombre.text.isEmpty()
            binding.editPass.text.toString().length > 0

            if (binding.editNombre.text.isEmpty() || binding.editPass.text.isEmpty()) {
                // algun campo sin rellenar
                // aviso de faltan datos
                Snackbar.make(binding.root, "Faltan datos", Snackbar.LENGTH_SHORT).show()
            } else {

                if (binding.editNombre.text.toString().equals("admin", true)
                    && binding.editPass.text.toString().equals("admin", true)
                ) {
                    // todos los datos correcto --> admin admin
                    // arrancar la otra activity
                    val intent= Intent(this, SecondActivity::class.java)

                    if (binding.checkDatos.isChecked){
                        val bundle = Bundle()
                        bundle.putString("nombre",binding.editNombre.text.toString())
                        bundle.putString("password",binding.editPass.text.toString())
                        startActivity(intent,bundle)
                    } else {
                        startActivity(intent)
                    }



                } else {
                    // alguno de los datos está mal
                    // aviso de datos incorrectos
                    Snackbar.make(binding.root, "Datos incorrectos", Snackbar.LENGTH_SHORT).show()

                }
            }
        }
    }
}
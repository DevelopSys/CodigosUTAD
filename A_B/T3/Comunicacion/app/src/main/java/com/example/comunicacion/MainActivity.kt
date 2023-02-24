package com.example.comunicacion

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.comunicacion.databinding.ActivityMainBinding
import com.example.comunicacion.model.Usuario
import com.google.android.material.snackbar.Snackbar


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var listaUsuarios: ArrayList<Usuario>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        listaUsuarios = ArrayList()
        listaUsuarios.add(Usuario("admin","admin"))
        listaUsuarios.add(Usuario("guest","guest"))
        listaUsuarios.add(Usuario("user","user"))

        binding.botonLogin.setOnClickListener {

            /*binding.editNombre.text.toString()
            binding.editPass.text.toString()
            binding.checkContrasenia.isChecked*/

            // algo no está relleno
            if (binding.editNombre.text.isEmpty() || binding.editPass.text.isEmpty()) {
                Snackbar.make(it, "Alguno de los datos está vacio", Snackbar.LENGTH_SHORT).show()
            } else {
                // buscar en la bd

                val usuarioEncontrado = listaUsuarios.find {
                    it.nombre.equals(binding.editNombre.text.toString(),true)
                            && it.pass.equals( binding.editPass.text.toString(),true)
                }

                if (usuarioEncontrado!=null){
                    // login
                } else {
                    // no login
                }

                if (binding.editNombre.text.toString().equals("admin", true)
                    && binding.editPass.text.toString().equals("admin", true)
                ) {
                    //Snackbar.make(it, "Credenciales correctas",Snackbar.LENGTH_SHORT).show()

                    val intent: Intent = Intent(this, SecondActivity::class.java);

                    Log.v("comprobacion",binding.checkContrasenia.isChecked.toString())

                    if (binding.checkContrasenia.isChecked) {
                        val bundle: Bundle = Bundle()
                        bundle.putString("nombre", binding.editNombre.text.toString())
                        bundle.putString("pass", binding.editPass.text.toString())
                        startActivity(intent,bundle)
                    } else {
                        startActivity(intent)
                    }


                } else {
                    Snackbar.make(it, "Credenciales incorrectas", Snackbar.LENGTH_SHORT).show()
                }
            }

        }


    }
}
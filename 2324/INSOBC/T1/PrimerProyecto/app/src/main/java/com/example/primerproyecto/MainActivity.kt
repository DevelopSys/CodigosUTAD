package com.example.primerproyecto

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import com.example.primerproyecto.model.Usuario
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {

    private lateinit var boton: Button
    private lateinit var edit: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        boton = findViewById(R.id.botonPulsar)
        edit = findViewById(R.id.editNombre)

        boton.setOnClickListener {
            val nombreUsuario = edit.text.toString()
            val usuario = Usuario(nombre = nombreUsuario)
            if (nombreUsuario.length>0){
                Snackbar.make(it, "El nombre seleccionado es ${usuario.nombre}", Snackbar.LENGTH_SHORT)
                    .show()
            } else {

            }


        }
    }
}
package com.example.primerproyecto

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {

    private lateinit var boton : Button
    private lateinit var editNombre: EditText
    private lateinit var editPass: EditText
    override fun onCreate(savedInstanceState :Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        boton = findViewById(R.id.botonLoging)
        editNombre = findViewById(R.id.editNombre)
        editPass = findViewById(R.id.editPass)

        boton.setOnClickListener {
            // sacar el nombre que esta puesto en el edit ->
            // sacar el pass que esta puesto en el edit -> Editable no -> String
            // sacar los dos datos en una notificacion -> Snackbar
        }
    }
}
package com.example.primerproyecto

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import com.google.android.material.snackbar.Snackbar


class MainActivity : AppCompatActivity() {

    private lateinit var boton: Button;
    private lateinit var edit: EditText;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        boton = findViewById(R.id.botonPulsar)
        edit = findViewById(R.id.editNombre)

        boton.setOnClickListener {
            val nombre = edit.text.toString()
            Snackbar.make(it, "El nombre introducido es $nombre"
                , Snackbar.LENGTH_SHORT).show()
        }

    }
}
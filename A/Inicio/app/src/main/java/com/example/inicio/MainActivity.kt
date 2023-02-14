package com.example.inicio

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {

    private lateinit var boton: Button;
    lateinit var nombre: String
    var edad: Int = 0;

    init {
        nombre = "e"
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //println(nombre?.length)
        boton = findViewById(R.id.boton_inicial);
        boton.setOnClickListener {
            Snackbar.make(boton, "Pulsacion correcta"
                , Snackbar.LENGTH_SHORT).show()
        }
    }
}
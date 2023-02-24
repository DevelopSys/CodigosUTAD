package com.example.t3comunicacion

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class SecondActivity : AppCompatActivity() {

    private lateinit var nombreRecuperado: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        // recepciono datos
        nombreRecuperado = intent.extras?.getString("user","INSO") ?: "defecto"
        Log.v("prueba_comunicacion",nombreRecuperado)
    }
}
package com.example.inicio

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {

    private lateinit var boton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main)
        boton = this.findViewById(R.id.boton_inicio)
        boton.setOnClickListener {
            // son ejecuciones cuando se pulse el boton
        }


    }
}
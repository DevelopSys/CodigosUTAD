package com.example.inicio

import android.content.Intent
import android.os.Bundle
import android.util.Log


import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.inicio.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnLogin.setOnClickListener {
            val correo = binding.editCorreo.text.toString()
            val pass = binding.editPass.text.toString()
            val perfil = binding.spinnerPerfil.selectedItem.toString()

            if (correo.equals("admin") && pass.equals("admin")){
                val intent: Intent = Intent(applicationContext,SecondActivity::class.java)
                startActivity(intent)
            } else {
                Snackbar.make(binding.root,
                    "Fallo en login",Snackbar.LENGTH_SHORT).show()
            }
            /*Log.v("datos",correo)
            Log.v("datos",pass)
            Log.v("datos",perfil)*/

        }
        binding.btnRegistro.setOnClickListener {  }
        binding.checkBox.setOnCheckedChangeListener { _, b ->
            binding.btnLogin.isEnabled = b
        }


    }
}
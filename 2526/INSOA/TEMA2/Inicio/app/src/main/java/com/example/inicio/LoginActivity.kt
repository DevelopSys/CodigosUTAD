package com.example.inicio

import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.inicio.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding
    private lateinit var adapterPerfiles: ArrayAdapter<CharSequence>
    private lateinit var listaPerfiles: List<CharSequence>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        instances()
        initGUI()

    }

    private fun instances() {
        listaPerfiles = listOf("Admin", "Usuario", "Invitado")
        adapterPerfiles =
            ArrayAdapter(applicationContext, android.R.layout.simple_spinner_item, listaPerfiles)


    }


    private fun initGUI() {
        // List -> relleno y asocio
        binding.spinnerPerfiles.adapter = adapterPerfiles;
        adapterPerfiles.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
    }
}
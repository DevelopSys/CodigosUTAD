package com.example.inicio

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.BaseAdapter
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.inicio.databinding.ActivityLoginBinding
import com.example.inicio.model.User

class LoginActivity() : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding
    private lateinit var profileAdapter: ArrayAdapter<CharSequence>
    private lateinit var profileList: List<CharSequence>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        instances()
        initGUI()
    }

    override fun onStart() {
        super.onStart()
        actions()
    }

    private fun actions() {
        binding.botonLogin.setOnClickListener {
            val mail = binding.editCorreoLogin.text.toString();
            val pass = binding.editPassLogin.text.toString();
            val profile = binding.spinnerPerfil.selectedItem.toString()
            val remeber = binding.checkBox.isChecked
            // comprobar datos

            val intent = Intent(
                applicationContext,
                MainActivity::class.java
            )
            intent.putExtra(
                "user",
                User(mail = mail, pass = pass, remeber = remeber, profile = profile)
            )
            startActivity(intent)
        }
    }

    override fun onRestart() {
        super.onRestart()
        clearData()
    }

    private fun clearData(){
        binding.editCorreoLogin.text.clear()
        binding.editPassLogin.text.clear()
        binding.spinnerPerfil.setSelection(0)
        binding.checkBox.isChecked = false
    }

    private fun instances() {
        profileList = listOf("Administrador", "Usuario", "Invitado")
        profileAdapter = ArrayAdapter<CharSequence>(
            this,
            android.R.layout.simple_spinner_item,
            profileList
        )
    }

    private fun initGUI() {
        binding.spinnerPerfil.adapter = profileAdapter
        profileAdapter
            .setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
    }
}
package com.example.inicio

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.inicio.databinding.ActivityLoginBinding
import com.example.inicio.model.Usuario

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

    override fun onStart() {
        super.onStart()
        actions()
    }

    private fun actions() {
        binding.botonLogin.setOnClickListener {
            // comprobar que todos los campos estan rellenos

            val correo = binding.editCorreoLogin.text.toString();
            val pass = binding.editPassLogin.text.toString();
            val perfil = binding.spinnerPerfiles.selectedItem.toString();
            val recordar = binding.checkPass.isChecked;
            val usuario = Usuario(pass = pass, perfil = perfil, correo = correo)
            // origen, destino
            val intent: Intent = Intent(this, MainActivity::class.java)
            intent.putExtra("usuario",usuario)
            startActivity(intent)
        }


        /*
           1- Comprobar que todos los datos estan rellenos
            En caso de no estarlos, sacar una notificacion con el aviso
            Ademas de limpiar todos los datos
            En caso de estar todos rellenos, solo hacer login si
                correo: admin@gmail.com
                pass: admin

                Si los datos no son esos, avisar del fallo en el login

           2- Realizar una pantalla de registro:
            Nombre
            Apellido
            Pass
            Edad
            Ciudad
            Comprobar los campos rellenos -> aviso si no hay nada relleno
            En caso de estar todo relleno y pulsar regstrar, navega a pantalla login
                              pasando el usuario

         */


    }

    override fun onRestart() {
        super.onRestart()
        binding.editCorreoLogin.text.clear()
        binding.editPassLogin.text.clear()
        binding.checkPass.isChecked = false
        binding.spinnerPerfiles.setSelection(0)
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
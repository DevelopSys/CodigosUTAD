package com.example.inicio

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.inicio.data.DataSet
import com.example.inicio.databinding.ActivityLoginBinding
import com.example.inicio.databinding.ActivityRegistroBinding
import com.example.inicio.model.User
import com.google.android.material.snackbar.Snackbar

class RegistroActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRegistroBinding
    private lateinit var adaprerEdades: ArrayAdapter<CharSequence>
    private lateinit var listaEdades: ArrayList<CharSequence>


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegistroBinding.inflate(layoutInflater)
        setContentView(binding.root)
        intances()
        initGUI()
        actions()
    }

    private fun actions() {
        binding.btnRegistrar.setOnClickListener {
            // comprobar si todos los campos estan rellenos -> si no lo estan aviso
            val nombre = binding.editNombre.text.toString()
            val apellido = binding.editApellido.text.toString()
            val correo = binding.editCorreo.text.toString()
            val pass = binding.editPass.text.toString()
            val edad = binding.spinnerEdad.selectedItem.toString().toInt()
            val user = User(nombre, apellido, correo, pass, edad)
            // DataSet.listaUsuarios.add(user)
            // origen, destino
            //startActivity(intent)
            if (DataSet.addUser(user)) {
                Snackbar.make(binding.root
                    , "Usuario agregado correctamente"
                    , Snackbar.LENGTH_LONG)
                    .show()
                val intent  = Intent(this, LoginActivity::class.java)
                startActivity(intent)
            } else {
                Snackbar.make(binding.root
                    , "No se ha podido completar el proceso"
                    , Snackbar.LENGTH_LONG)
                    .show()
            }
        }
    }

    private fun initGUI() {
        binding.spinnerEdad.adapter = adaprerEdades
        adaprerEdades.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
    }

    private fun intances() {
        listaEdades = arrayListOf()
        for (i in 18..90) {
            listaEdades.add(i.toString())
        }
        adaprerEdades = ArrayAdapter<CharSequence>(
            applicationContext,
            android.R.layout.simple_spinner_item,
            listaEdades
        )
    }
}
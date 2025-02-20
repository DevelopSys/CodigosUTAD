package com.example.inicio

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.inicio.databinding.ActivitySecondBinding
import com.example.inicio.model.User

class SecondActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySecondBinding
    private lateinit var userRecuperado: User

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // recuperar el dato que me han pasado
        val bundleRecuperado = intent.extras?.getBundle("datos")
        // user - serializable - user
        userRecuperado = bundleRecuperado?.getSerializable("user") as User
        binding.textoUsuario.text = "Bienvenido ${userRecuperado.getCorreo()}"

    }

    override fun onStart() {
        super.onStart()
        // quiero acceder a los datos del usuarios
        Log.v("datos",userRecuperado.getCorreo()?:"sin correo")
        Log.v("datos",userRecuperado.getPerfil()?:"sin perfil")
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)

    }
}
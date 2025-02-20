package com.example.inicio

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.inicio.model.User

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        val bundleRecuperado = intent.extras!!.getBundle("datos")
        val usuarioRecuperado: User = bundleRecuperado!!.getSerializable("user") as User
        Log.v("datos", usuarioRecuperado.correo ?: "sin correo")
    }
}
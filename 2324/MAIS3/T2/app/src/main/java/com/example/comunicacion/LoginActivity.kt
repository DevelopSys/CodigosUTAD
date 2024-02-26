package com.example.comunicacion

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

import com.example.comunicacion.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonSignUp.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when(v!!.id){
            binding.buttonSignUp.id -> {
                // pasar a una segunda pantalla -> Registro
                // origen, destino
                val intent: Intent = Intent(applicationContext, SignupActivity::class.java)
                startActivity(intent)
                finish()
            }
        }
    }
}
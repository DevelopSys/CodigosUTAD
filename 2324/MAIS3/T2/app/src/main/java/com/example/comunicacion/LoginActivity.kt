package com.example.comunicacion

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

import com.example.comunicacion.databinding.ActivityLoginBinding
import com.example.comunicacion.model.Usuario
import com.example.comunicacion.ui.activity.MainActivity
import com.google.android.material.snackbar.Snackbar

class LoginActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityLoginBinding
    private var usuario: Usuario? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        usuario = intent.getSerializableExtra("usuario") as Usuario?

        if (usuario != null) {
            binding.editUser.setText(usuario!!.correo)
            binding.editPass.setText(usuario!!.pass)
        }

        binding.buttonSignUp.setOnClickListener(this)
        binding.buttonLogin.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v!!.id) {
            binding.buttonSignUp.id -> {
                // pasar a una segunda pantalla -> Registro
                // origen, destino
                val intent: Intent = Intent(applicationContext, SignupActivity::class.java)
                startActivity(intent)
                finish()
            }

            binding.buttonLogin.id -> {

                if (binding.editUser.text.toString()
                        .isNotEmpty() && binding.editPass.text.toString().isNotEmpty()
                ) {
                    val intent: Intent = Intent(applicationContext, MainActivity::class.java)
                    intent.putExtra("correo", binding.editUser.text.toString())
                    if (usuario!=null){
                        //intent.putExtra("correo", usuario!!.correo)
                        intent.putExtra("perfil", usuario!!.perfil)
                    } else {
                        intent.putExtra("perfil", "?")
                    }
                    startActivity(intent)
                } else {
                    Snackbar.make(binding.root, "Fallo en la auth", Snackbar.LENGTH_SHORT).show()
                }


            }
        }
    }
}
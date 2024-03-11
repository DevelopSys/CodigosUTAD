package com.example.comunicacion.ui.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.View.OnClickListener
import com.example.comunicacion.databinding.ActivityLoginBinding
import com.example.comunicacion.model.Usuario
import com.google.android.material.snackbar.Snackbar

class LoginActivity : AppCompatActivity(), OnClickListener {

    private lateinit var binding: ActivityLoginBinding
    private var usuario: Usuario? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        usuario = intent.getSerializableExtra("usuario") as Usuario?

        // cuando pongo el correo y pass del usuario recuperado

        if (usuario != null) {
            binding.editUser.setText(usuario!!.correo)
            binding.editPass.setText(usuario!!.pass)
        }

        binding.buttonSignup.setOnClickListener(this)
        binding.buttonLogin.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v!!.id) {
            binding.buttonSignup.id -> {

                val intent: Intent = Intent(applicationContext, SignupActivity::class.java)
                startActivity(intent)
                //finish()
            }

            binding.buttonLogin.id -> {

                if (binding.editPass.text.toString()
                        .isNotEmpty() && binding.editUser.text.isNotEmpty()
                ) {
                    val intent: Intent = Intent(applicationContext, MainActivity::class.java)
                    intent.putExtra("correo", binding.editUser.text.toString())
                    intent.putExtra("perfil", usuario?.perfil?.get(0).toString() ?: "?")
                    /*if (usuario!=null){
                        intent.putExtra("perfil", usuario!!.perfil.get(0).toString())
                    } else {
                        intent.putExtra("perfil", "?")
                    }*/
                    startActivity(intent)
                    //finish()
                } else {
                    Snackbar.make(binding.root, "Fallo de auth",Snackbar.LENGTH_SHORT).show()
                }

            }
        }
    }


}
package com.example.comunicacion.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.View
import android.view.View.OnClickListener
import com.example.comunicacion.R
import com.example.comunicacion.databinding.ActivityLoginBinding
import com.example.comunicacion.model.Usuario
import com.google.android.material.snackbar.Snackbar
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser

class LoginActivity : AppCompatActivity(), OnClickListener {


    private lateinit var binding: ActivityLoginBinding
    private lateinit var authFirebase: FirebaseAuth
    private var userAuth: FirebaseUser? = null;
    private var usuario: Usuario? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        instancias()

        if (intent.getSerializableExtra("usuario") != null) {
            usuario = intent.getSerializableExtra("usuario") as Usuario
            binding.editCorreo.setText(usuario!!.correo)
            binding.editPass.setText(usuario!!.pass)
        }

        binding.botonLogin.setOnClickListener(this)
        binding.botonSignUp.setOnClickListener(this)
    }

    fun instancias() {
        authFirebase = FirebaseAuth.getInstance()
    }

    override fun onClick(v: View?) {
        when (v!!.id) {
            binding.botonLogin.id -> {
                if (!binding.editCorreo.text.toString().isEmpty() &&
                    !binding.editPass.text.toString().isEmpty()
                ) {

                    authFirebase.signInWithEmailAndPassword(
                        binding.editCorreo.text.toString(),
                        binding.editPass.text.toString()
                    ).addOnCompleteListener {
                        if (it.isSuccessful) {
                            val intent = Intent(applicationContext, MainActivity::class.java)
                            intent.putExtra("correo", binding.editCorreo.text.toString())
                            intent.putExtra("uid", authFirebase.currentUser?.uid)
                            startActivity(intent)
                        } else {
                            Snackbar.make(binding.root, "Fallo en los datos", Snackbar.LENGTH_SHORT)
                                .show()
                        }
                    }

                    /*val intent = Intent(applicationContext, MainActivity::class.java)
                    intent.putExtra("correo", binding.editCorreo.text.toString())
                    startActivity(intent)*/

                }


            }

            binding.botonSignUp.id -> {

                // crear una cuenta de usuario
                /*authFirebase.createUserWithEmailAndPassword("borja1@utad.com", "Utad2024@")
                    .addOnCompleteListener {
                        if (it.isSuccessful) {

                            userAuth = authFirebase.currentUser

                            Snackbar.make(
                                binding.root,
                                "usuario registrado con exito con UID ${userAuth?.uid}",
                                Snackbar.LENGTH_SHORT
                            ).show()
                        } else {
                            Snackbar.make(
                                binding.root,
                                "Fallo en el proceso. ¿Quieres crear cuenta?",
                                Snackbar.LENGTH_SHORT
                            ).setAction("ok"){
                                val intent = Intent(applicationContext,SignupActivity::class.java)
                                startActivity(intent)
                                finish()
                            }.show()
                        }
                    }*/

                val intent = Intent(applicationContext, SignupActivity::class.java)
                startActivity(intent)
                finish()
            }

        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {

        menuInflater.inflate(R.menu.help_menu,menu)

        return true
    }
}
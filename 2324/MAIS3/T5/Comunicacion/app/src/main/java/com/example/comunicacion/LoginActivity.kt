package com.example.comunicacion

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

import com.example.comunicacion.databinding.ActivityLoginBinding
import com.example.comunicacion.model.Usuario
import com.example.comunicacion.ui.activity.MainActivity
import com.google.android.material.snackbar.Snackbar
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser

class LoginActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityLoginBinding
    private var usuario: Usuario? = null
    private lateinit var authFirebase: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        instancias()

        usuario = intent.getSerializableExtra("usuario") as Usuario?

        if (usuario != null) {
            binding.editUser.setText(usuario!!.correo)
            binding.editPass.setText(usuario!!.pass)
        }

        binding.buttonSignUp.setOnClickListener(this)
        binding.buttonLogin.setOnClickListener(this)
    }

    private fun instancias() {
        authFirebase = FirebaseAuth.getInstance()
    }

    override fun onClick(v: View?) {
        when (v!!.id) {
            binding.buttonSignUp.id -> {
                // pasar a una segunda pantalla -> Registro
                // origen, destino
                val intent: Intent = Intent(applicationContext, SignupActivity::class.java)
                startActivity(intent)
                finish()

                // registrar usuario
                /*authFirebase.createUserWithEmailAndPassword("borja1@utad.com", "2324")
                    .addOnCompleteListener {
                        if (it.isSuccessful) {
                            Snackbar.make(binding.root, "Registro completo", Snackbar.LENGTH_SHORT)
                                .show()
                        } else {
                            Snackbar.make(binding.root, "Fallo en el registro", Snackbar.LENGTH_SHORT)
                                .show()
                        }
                    }
*/
            }

            binding.buttonLogin.id -> {

                if (binding.editUser.text.toString()
                        .isNotEmpty() && binding.editPass.text.toString().isNotEmpty()
                ) {

                    authFirebase.signInWithEmailAndPassword(
                        binding.editUser.text.toString(),
                        binding.editPass.text.toString()
                    ).addOnCompleteListener {
                        if (it.isSuccessful) {
                            // cambiar de pantalla pasandole
                            val currentUser: FirebaseUser = authFirebase.currentUser!!;
                            val uid: String = currentUser.uid
                            val intent: Intent =
                                Intent(applicationContext, MainActivity::class.java)
                            intent.putExtra("correo", binding.editUser.text.toString())
                            intent.putExtra("uid", uid)
                            if (usuario != null) {
                                intent.putExtra("perfil", usuario!!.perfil)
                            } else {
                                intent.putExtra("perfil", "?")
                            }
                            startActivity(intent)

                        } else {
                            Snackbar.make(
                                binding.root,
                                "Fallo en el inicio de sesion, ¿Quieres crear la cuenta?",
                                Snackbar.LENGTH_SHORT
                            ).setAction("Crear") {
                                val intent: Intent =
                                    Intent(applicationContext, SignupActivity::class.java)
                                startActivity(intent)
                                finish()
                            }

                                .show()
                        }
                    }


                    /*val intent: Intent = Intent(applicationContext, MainActivity::class.java)
                    intent.putExtra("correo", binding.editUser.text.toString())
                    if (usuario != null) {
                        //intent.putExtra("correo", usuario!!.correo)
                        intent.putExtra("perfil", usuario!!.perfil)
                    } else {
                        intent.putExtra("perfil", "?")
                    }*/
                } else {
                    Snackbar.make(binding.root, "Fallo en la auth", Snackbar.LENGTH_SHORT).show()
                }


            }
        }
    }
}
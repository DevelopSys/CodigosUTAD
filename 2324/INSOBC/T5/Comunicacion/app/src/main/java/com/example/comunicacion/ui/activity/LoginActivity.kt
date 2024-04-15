package com.example.comunicacion.ui.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.View.OnClickListener
import com.example.comunicacion.databinding.ActivityLoginBinding
import com.example.comunicacion.model.Usuario
import com.google.android.material.snackbar.Snackbar
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser

class LoginActivity : AppCompatActivity(), OnClickListener {

    private lateinit var binding: ActivityLoginBinding
    private var usuario: Usuario? = null
    private lateinit var authFirebase: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        instancias()


        usuario = intent.getSerializableExtra("usuario") as Usuario?

        // cuando pongo el correo y pass del usuario recuperado

        if (usuario != null) {
            binding.editUser.setText(usuario!!.correo)
            binding.editPass.setText(usuario!!.pass)
        }

        binding.buttonSignup.setOnClickListener(this)
        binding.buttonLogin.setOnClickListener(this)
    }

    private fun instancias() {

        authFirebase = FirebaseAuth.getInstance();

    }

    override fun onClick(v: View?) {
        when (v!!.id) {
            binding.buttonSignup.id -> {

                val intent: Intent = Intent(applicationContext, SignupActivity::class.java)
                startActivity(intent)
                finish()

                /*authFirebase.createUserWithEmailAndPassword("borja1@utad.com", "Utad2324")
                    .addOnCompleteListener {
                        if (it.isSuccessful) {
                            val currentUser: FirebaseUser = authFirebase.currentUser!!;
                            Snackbar.make(
                                binding.root,
                                "Usuario registrado con exito con UID ${currentUser.uid}",
                                Snackbar.LENGTH_SHORT
                            ).show()
                        } else {

                            Snackbar.make(
                                binding.root,
                                "Fallo en el registro",
                                Snackbar.LENGTH_SHORT
                            ).show()
                        }
                    }
*/
                // registra - ok - no existe y es un correo y es una pass segura
                // registra - no ok - existe o no es un correo o no es una pass segura

            }

            binding.buttonLogin.id -> {

                if (binding.editPass.text.toString()
                        .isNotEmpty() && binding.editUser.text.isNotEmpty()
                ) {
                    authFirebase.signInWithEmailAndPassword(
                        binding.editUser.text.toString(),
                        binding.editPass.text.toString()
                    ).addOnCompleteListener {
                        if (it.isSuccessful) {
                            val intent: Intent =
                                Intent(applicationContext, MainActivity::class.java)
                            intent.putExtra("correo", binding.editUser.text.toString())
                            intent.putExtra("perfil", usuario?.perfil?.get(0).toString() ?: "?")
                            intent.putExtra("uid", authFirebase.currentUser!!.uid)
                            startActivity(intent)
                            finish()
                        } else {
                            Snackbar.make(
                                binding.root,
                                "El usuario no existe, ¿Quieres crear la cuenta?",
                                Snackbar.LENGTH_LONG
                            ).setAction("OK"){
                                val intent = Intent(applicationContext, SignupActivity::class.java)
                                startActivity(intent)
                            }.show()
                        }
                    }
                    /*val intent: Intent = Intent(applicationContext, MainActivity::class.java)
                    intent.putExtra("correo", binding.editUser.text.toString())
                    intent.putExtra("perfil", usuario?.perfil?.get(0).toString() ?: "?")*/
                    /*if (usuario!=null){
                        intent.putExtra("perfil", usuario!!.perfil.get(0).toString())
                    } else {
                        intent.putExtra("perfil", "?")
                    }*/
                    // startActivity(intent)
                    //finish()
                } else {
                    Snackbar.make(binding.root, "Fallo de auth", Snackbar.LENGTH_SHORT).show()
                }

            }
        }
    }


}
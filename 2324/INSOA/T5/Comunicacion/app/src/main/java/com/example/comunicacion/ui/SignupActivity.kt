package com.example.comunicacion.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.RadioButton
import com.example.comunicacion.R
import com.example.comunicacion.databinding.ActivitySignupBinding
import com.example.comunicacion.model.Usuario
import com.google.android.material.snackbar.Snackbar
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase

class SignupActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySignupBinding
    private lateinit var authFirebase: FirebaseAuth
    private lateinit var firebaseDatabase: FirebaseDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignupBinding.inflate(layoutInflater)
        setContentView(binding.root)

        instancias()

        binding.botonRegistro.setOnClickListener {

            if (!binding.editCorreo.text.toString().isEmpty()
                && !binding.editNombre.text.toString().isEmpty()
                && !binding.editPass.text.toString().isEmpty()
                && !binding.editPass2.text.toString().isEmpty()
                && (binding.editPass.text.toString()
                    .equals(binding.editPass2.text.toString()))
            ) {
                // si todos los datos estan completos -> paso de pantalla

                // sacar el dato que esta seleccionado en el spinner
                val perfil: String = binding.spinnerPerfil.selectedItem.toString()
                /*val perfil: String =
                    binding.spinnerPerfil.adapter.getItem(binding.spinnerPerfil.selectedItemPosition)
                        .toString()*/
                val radioSeleccionado: RadioButton =
                    findViewById(binding.radioGroup.checkedRadioButtonId)
                val genero = radioSeleccionado.text.toString();

                val usuario =
                    Usuario(
                        nombre = binding.editNombre.text.toString(),
                        correo = binding.editCorreo.text.toString(),
                        genero = genero,
                        perfil = perfil
                    )

                authFirebase.createUserWithEmailAndPassword(
                    usuario.correo!!,
                    binding.editPass.text.toString()
                )
                    .addOnCompleteListener {
                        if (it.isSuccessful) {

                            /*
                                    * usuarios
                                    *   UID
                                    *       nombre
                                    *       correo
                                    *       genero
                                    *       perfil
                                    *   UID
                                    *       nombre
                                    *       correo
                                    *       genero
                                    *       perfil
                                    * */
                            firebaseDatabase.reference.child("usuarios")
                                .child(authFirebase.currentUser!!.uid).setValue(usuario)
                            Snackbar.make(
                                binding.root,
                                "Usuario registrado con exito",
                                Snackbar.LENGTH_SHORT
                            )
                                .setAction("ir a login") {

                                    /*val intent = Intent(this, LoginActivity::class.java)
                                    intent.putExtra("usuario",usuario)
                                    startActivity(intent)*/
                                }
                                .show()
                        } else {
                            Snackbar.make(
                                binding.root,
                                "Fallo en el proceso",
                                Snackbar.LENGTH_SHORT
                            )
                                .show()
                        }
                    }


            } else {
                // si todos los datos estan completos pero las pass no coincida -> aviso
                // los datos no estan completos pero las pass no coincida -> aviso
                Snackbar.make(binding.root, "Fallo en el proceso", Snackbar.LENGTH_SHORT).show()
            }

        }
    }

    private fun instancias() {
        authFirebase = FirebaseAuth.getInstance()
        firebaseDatabase =
            FirebaseDatabase.getInstance("https://bmh-utad2024-default-rtdb.europe-west1.firebasedatabase.app/")
    }
}
package com.example.comunicacion.ui.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.RadioButton
import com.example.comunicacion.databinding.ActivitySignupBinding
import com.example.comunicacion.model.Usuario
import com.google.android.material.snackbar.Snackbar
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase

class SignupActivity : AppCompatActivity() {

    private lateinit var authFirebase: FirebaseAuth
    private lateinit var binding: ActivitySignupBinding
    private lateinit var firebaseDatabase: FirebaseDatabase
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignupBinding.inflate(layoutInflater)
        setContentView(binding.root)

        instancias()

        binding.buttonRegister.setOnClickListener {
            // si todos los datos estan completos (n, c, p y las pass coinciden
            // cambio de pantalla
            if (binding.editNombre.text.toString()
                    .isNotEmpty() && binding.editCorreo.text.toString().isNotEmpty()
                && binding.editPass.text.toString()
                    .isNotEmpty() && binding.editPass2.text.toString().isNotEmpty()
                && (binding.editPass.text.toString().equals(binding.editPass2.text.toString()))
            ) {

                // val perfil: String = binding.spinnerPerfil.selectedItem.toString()
                val perfil: String =
                    binding.spinnerPerfil.adapter.getItem(binding.spinnerPerfil.selectedItemPosition)
                        .toString()

                val radioSeleccionado: RadioButton =
                    findViewById(binding.radioGroupGenero.checkedRadioButtonId)

                // pasar de pantalla
                val intent: Intent = Intent(applicationContext, LoginActivity::class.java)
                val usuario: Usuario =
                    Usuario(
                        nombre = binding.editNombre.text.toString(),
                        correo = binding.editCorreo.text.toString(),
                        perfil = perfil,
                        genero = radioSeleccionado.text.toString()
                    )

                authFirebase.createUserWithEmailAndPassword(
                    usuario.correo!!,
                    binding.editPass.text.toString()
                )
                    .addOnCompleteListener {
                        if (it.isSuccessful) {


                            // usuarios
                            // UID
                            //nombre:asdasd
                            // genero: asdasd

                            firebaseDatabase.reference.child("usuarios")
                                .child(authFirebase.currentUser!!.uid)
                                .setValue(usuario)
                            /*referencia.child("nombre").setValue(usuario.nombre)
                            referencia.child("correo").setValue(usuario.correo)
                            referencia.child("genero").setValue(usuario.genero)
                            referencia.child("perfil").setValue(usuario.perfil)*/

                            intent.putExtra("usuario", usuario)
                            // intent.putExtra("uid", authFirebase.currentUser!!.uid)
                            startActivity(intent)
                            finish()
                        } else {
                            Snackbar.make(
                                binding.root,
                                "Error en el registro",
                                Snackbar.LENGTH_SHORT
                            ).show()
                        }
                    }


            } else {
                Snackbar.make(binding.root, "Fallo en el registro", Snackbar.LENGTH_SHORT).show()
            }

        }


    }

    private fun instancias() {
        firebaseDatabase =
            FirebaseDatabase.getInstance("https://bmh-utad23242-default-rtdb.europe-west1.firebasedatabase.app/");
        authFirebase = FirebaseAuth.getInstance()
    }
}
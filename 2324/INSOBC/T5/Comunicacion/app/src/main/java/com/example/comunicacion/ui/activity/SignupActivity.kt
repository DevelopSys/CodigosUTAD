package com.example.comunicacion.ui.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.RadioButton
import com.example.comunicacion.databinding.ActivitySignupBinding
import com.example.comunicacion.model.Usuario
import com.google.android.material.snackbar.Snackbar
import com.google.firebase.auth.FirebaseAuth

class SignupActivity : AppCompatActivity() {

    private lateinit var authFirebase: FirebaseAuth
    private lateinit var binding: ActivitySignupBinding
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
                        binding.editNombre.text.toString(),
                        binding.editCorreo.text.toString(),
                        binding.editPass.text.toString(),
                        perfil,
                        radioSeleccionado.text.toString()
                    )

                authFirebase.createUserWithEmailAndPassword(usuario.correo, usuario.pass)
                    .addOnCompleteListener {
                        if (it.isSuccessful) {
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
        authFirebase = FirebaseAuth.getInstance()
    }
}
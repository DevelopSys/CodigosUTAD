package com.example.comunicacion

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

    private lateinit var binding: ActivitySignupBinding
    private lateinit var authFirebase: FirebaseAuth
    private lateinit var firebaseDatabase: FirebaseDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignupBinding.inflate(layoutInflater)
        setContentView(binding.root)

        instancias();

        binding.botonRegistrar.setOnClickListener {

            if (binding.editNombre.text.isNotEmpty() && binding.editCorreo.text.isNotEmpty()
                && binding.editPass.text.isNotEmpty() && binding.editPass2.text.isNotEmpty()
                && (binding.editPass.text.toString().equals(binding.editPass2.text.toString()))
            ) {
                // realizar cambio pasando un objeto de tipo usuario
                // val perfil = binding.spinnerPerfil.selectedItem.toString()
                val perfil =
                    binding.spinnerPerfil.adapter.getItem(binding.spinnerPerfil.selectedItemPosition)


                val radioSeleccionado: RadioButton =
                    findViewById(binding.radioGroup.checkedRadioButtonId);

                val usuario: Usuario =
                    Usuario(
                        binding.editNombre.text.toString(),
                        binding.editCorreo.text.toString(),
                        binding.editPass.text.toString(),
                        perfil.toString(),
                        radioSeleccionado.text.toString()
                    )

                authFirebase.createUserWithEmailAndPassword(usuario.correo, usuario.pass)
                    .addOnCompleteListener {
                        if (it.isSuccessful) {


                            firebaseDatabase.reference.child("usuarios")
                                .child(authFirebase.currentUser!!.uid)
                                .setValue(usuario)
                            /*val referencia = firebaseDatabase.reference.child("usuarios")
                                .child(authFirebase.currentUser!!.uid)

                           referencia
                                .child("nombre").setValue(usuario.nombre)

                            firebaseDatabase.reference.child("usuarios")
                                .child(authFirebase.currentUser!!.uid)
                                .child("correo").setValue(usuario.correo)

                            firebaseDatabase.reference.child("usuarios")
                                .child(authFirebase.currentUser!!.uid)
                                .child("perfil").setValue(usuario.perfil)

                            firebaseDatabase.reference.child("usuarios")
                                .child(authFirebase.currentUser!!.uid)
                                .child("genero").setValue(usuario.genero)
*/

                            val intent: Intent = Intent(this, LoginActivity::class.java)
                            intent.putExtra("usuario", usuario)
                            startActivity(intent)
                            finish()
                        } else {
                            Snackbar.make(
                                binding.root,
                                "Fallo en el registro",
                                Snackbar.LENGTH_SHORT
                            ).show()
                        }
                    }


            } else {
                Snackbar.make(binding.root, "Fallo en el proceso", Snackbar.LENGTH_SHORT).show()
            }

        }

    }

    private fun instancias() {
        firebaseDatabase =
            FirebaseDatabase.getInstance("https://bah-utad23241-default-rtdb.europe-west1.firebasedatabase.app/")
        authFirebase = FirebaseAuth.getInstance()
    }
}

/*
* Crear una tercera pantalla a la cual puedo navegar si
* en el login hay usuario y contraseña
* En la 3a pantalla aparecerá un mensaje con el correo y
* una inicial (A, U , I). En el caso de no poder detectar el
* perfil, pondrá una ?
* */
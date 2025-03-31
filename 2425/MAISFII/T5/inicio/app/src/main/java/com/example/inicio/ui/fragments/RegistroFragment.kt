package com.example.inicio.ui.fragments

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.inicio.R
import com.example.inicio.databinding.FragmentLoginBinding
import com.example.inicio.databinding.FragmentRegistroBinding
import com.example.inicio.model.User
import com.google.android.material.snackbar.Snackbar
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase


class RegistroFragment : Fragment() {

    private lateinit var binding: FragmentRegistroBinding
    private lateinit var datoRecuperado: String
    private lateinit var auth: FirebaseAuth
    private lateinit var database: FirebaseDatabase

    override fun onAttach(context: Context) {
        super.onAttach(context)
        datoRecuperado = arguments?.getString("dato")!!
        auth = FirebaseAuth.getInstance()
        database =
            FirebaseDatabase.getInstance("https://utad2425bmh-default-rtdb.europe-west1.firebasedatabase.app/")
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentRegistroBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onStart() {
        super.onStart()
        binding.botonVolver.setOnClickListener {
            findNavController().navigate(R.id.action_registroFragment_to_loginFragment)
        }
        binding.botonRegistro.setOnClickListener {
            auth.createUserWithEmailAndPassword(
                binding.editCorreo.text.toString(), binding.editPass.text.toString()
            ).addOnCompleteListener {
                if (it.isSuccessful) {
                    guardarUsuarioDB(
                        User(
                            nombre = binding.editNombre.text.toString(),
                            correo = binding.editCorreo.text.toString(),
                            telefono = binding.editTelefono.text.toString().toInt(),
                            pass = binding.editPass.text.toString()
                        ), auth.currentUser!!.uid
                    )
                    Snackbar.make(binding.root, "Usuario creado con exito", Snackbar.LENGTH_SHORT)
                        .show()
                    val user: FirebaseUser = auth.currentUser!!
                    Log.v("usuario", user.uid)
                    auth.signOut()
                } else {
                    Snackbar.make(binding.root, "Fallo de registro", Snackbar.LENGTH_SHORT).show()
                }
            }
        }
    }

    private fun guardarUsuarioDB(usuario: User, uid: String) {
        /*val referencia: DatabaseReference = database.reference.child("usuarios").child(uid);
        referencia.child("telefono")
            .setValue(usuario.telefono)
        referencia.child("nombre")
            .setValue(usuario.nombre)
        }*/
        database.reference.child("usuarios").child(uid).setValue(usuario)
    }
}
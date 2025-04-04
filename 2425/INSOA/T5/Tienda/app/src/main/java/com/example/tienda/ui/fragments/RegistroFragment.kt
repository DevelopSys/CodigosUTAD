package com.example.tienda.ui.fragments

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.tienda.R
import com.example.tienda.databinding.FragmentLoginBinding
import com.example.tienda.databinding.FragmentRegistroBinding
import com.example.tienda.model.User
import com.google.android.material.snackbar.Snackbar
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase

class RegistroFragment : Fragment() {

    private lateinit var binding: FragmentRegistroBinding
    private lateinit var database: FirebaseDatabase
    private lateinit var auth: FirebaseAuth

    override fun onAttach(context: Context) {
        super.onAttach(context)
        auth = FirebaseAuth.getInstance()
        database =
            FirebaseDatabase.getInstance("https://bmh-utadinsoa-default-rtdb.europe-west1.firebasedatabase.app/")
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
        binding.btnCrear.setOnClickListener {
            auth.createUserWithEmailAndPassword(
                binding.editCorreo.text.toString(),
                binding.editPass.text.toString()
            ).addOnCompleteListener {
                // Log.v("datos",it.result.toString())
                if (it.isSuccessful) {
                    Snackbar.make(binding.root, "Usuario creado con existo", Snackbar.LENGTH_SHORT)
                        .show()
                    //Log.v("datos",auth.currentUser!!.uid)

                    database.reference.child("usuarios")
                        .child(auth.currentUser!!.uid).setValue(
                            User(
                                nombre = binding.editNombre.text.toString(),
                                correo = binding.editCorreo.text.toString(),
                                telefono = binding.editTelefono.text.toString().toInt()
                            )
                        )


                    val bundle = Bundle();
                    bundle.putString("correo", binding.editCorreo.text.toString())
                    bundle.putString("pass", binding.editPass.text.toString())
                    findNavController().navigate(
                        R.id.action_registroFragment_to_loginFragment,
                        bundle
                    )
                } else {
                    Snackbar.make(binding.root, "Error en el proceso", Snackbar.LENGTH_SHORT).show()
                }
            }
        }
    }
}
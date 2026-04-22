package com.example.tiendafragments.ui.fregment

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.tiendafragments.R
import com.example.tiendafragments.databinding.FragmentLoginBinding
import com.example.tiendafragments.databinding.FragmentRegisterBinding
import com.google.android.material.snackbar.Snackbar
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase


class RegisterFragment : Fragment() {

    private lateinit var binding: FragmentRegisterBinding
    private lateinit var auth: FirebaseAuth
    private lateinit var database: FirebaseDatabase

    override fun onAttach(context: Context) {
        super.onAttach(context)
        // inicializaciones logicas
        auth = FirebaseAuth.getInstance()
        database = FirebaseDatabase.getInstance("https://bmh-insod2526-default-rtdb.europe-west1.firebasedatabase.app/")
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // indica que vista se pone al fragment
        binding = FragmentRegisterBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onStart() {
        super.onStart()
        binding.btnRegistro.setOnClickListener {
            // verificar campos
            auth.createUserWithEmailAndPassword(
                binding.editCorreo.text.toString(),
                binding.editPass.text.toString()
            ).addOnCompleteListener {
                if (it.isSuccessful) {
                    Snackbar.make(
                        binding.root,
                        "Registro correcto. Quieres iniciar sesion?",
                        Snackbar.LENGTH_LONG
                    )
                        .setAction("OK") { findNavController().navigate(R.id.action_registerFragment_to_mainFragment) }
                        .show()
                } else {
                    Snackbar.make(
                        binding.root,
                        "Error en el registro",
                        Snackbar.LENGTH_LONG
                    ).show()
                }
            }
        }
    }

    override fun onDetach() {
        super.onDetach()
        // liberar memoria -> iguala a null
    }


}
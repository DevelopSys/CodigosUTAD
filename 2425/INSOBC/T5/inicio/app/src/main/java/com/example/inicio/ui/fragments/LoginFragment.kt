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
import com.example.inicio.databinding.FragmentLogBinding
import com.example.inicio.databinding.FragmentLoginBinding
import com.google.android.material.snackbar.Snackbar
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser


class LoginFragment : Fragment() {

    private lateinit var binding: FragmentLogBinding
    private lateinit var auth: FirebaseAuth
    private var user: FirebaseUser? = null

    override fun onAttach(context: Context) {
        super.onAttach(context)
        auth = FirebaseAuth.getInstance()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentLogBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onStart() {
        super.onStart()
        user = auth.currentUser

        Log.v("usuario", "El uid del usuario es: ${user?.uid ?: "sin usuario"}")

        binding.btnRegistro.setOnClickListener {
            val bundle = Bundle()
            // bundle.putString("dato","dato que voy a pasar entre fragments")
            findNavController().navigate(R.id.action_loginFragment_to_registroFragment, bundle)
        }

        binding.btnLogin.setOnClickListener {
            // exise el usuario?
            // navego al main
            auth.signInWithEmailAndPassword(
                binding.editCorreo.text.toString(),
                binding.editPass.text.toString()
            ).addOnCompleteListener {
                if (it.isSuccessful){
                    findNavController().navigate(R.id.action_loginFragment_to_mainFragment)
                } else {
                    Snackbar.make(binding.root, "Inicio incorrecto", Snackbar.LENGTH_SHORT).show()
                }
            }
        }
    }
}
package com.example.tiendafragments.ui.fragment

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.tiendafragments.R
import com.example.tiendafragments.databinding.FragmentLoginBinding
import com.example.tiendafragments.databinding.FragmentLregisterBinding
import com.google.android.material.snackbar.Snackbar
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase

class RegisterFragment : Fragment() {

    private lateinit var binding: FragmentLregisterBinding
    private lateinit var nombre: String
    private lateinit var pass: String
    private lateinit var auth: FirebaseAuth
    private lateinit var database: FirebaseDatabase


    override fun onAttach(context: Context) {
        super.onAttach(context)
        auth = FirebaseAuth.getInstance();
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        nombre = requireArguments().getString("name").toString()
        pass = requireArguments().getString("pass").toString()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        binding = FragmentLregisterBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onStart() {
        super.onStart()
        binding.editCorreo.setText(nombre)
        binding.editPass.setText(pass)
        binding.btnRegistro.setOnClickListener {
            val nombre = binding.editNombre.text.toString()
            val apellido = binding.editApellido.text.toString()
            val correo = binding.editCorreo.text.toString()
            val pass = binding.editPass.text.toString()
            // valido datos
            auth.createUserWithEmailAndPassword(correo, pass).addOnCompleteListener {
                if (it.isSuccessful) {
                    Snackbar.make(
                        binding.root,
                        "Registro correcto, ¿quieres iniciar sesion?",
                        Snackbar.LENGTH_LONG
                    ).setAction("OK") {
                        findNavController().navigate(R.id.action_registerFragment_to_mainFragment)
                    }.show()
                } else {
                    Snackbar.make(
                        binding.root,
                        "Fallo en el registro",
                        Snackbar.LENGTH_LONG
                    ).show()
                }
            }
        }
    }

    override fun onDetach() {
        super.onDetach()
    }


}
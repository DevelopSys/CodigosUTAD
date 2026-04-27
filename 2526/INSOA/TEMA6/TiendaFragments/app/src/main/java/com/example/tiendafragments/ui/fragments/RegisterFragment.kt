package com.example.tiendafragments.ui.fragments

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.tiendafragments.R
import com.example.tiendafragments.databinding.FragmentRegisterBinding
import com.example.tiendafragments.model.User
import com.google.android.material.snackbar.Snackbar
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase

class RegisterFragment : Fragment() {

    private lateinit var auth: FirebaseAuth
    private lateinit var binding: FragmentRegisterBinding
    private lateinit var name: String
    private lateinit var pass: String
    private lateinit var database: FirebaseDatabase

    override fun onAttach(context: Context) {
        super.onAttach(context)
        name = requireArguments().getString("name").toString()
        pass = requireArguments().getString("pass").toString()
        auth = FirebaseAuth.getInstance()
        database =
            FirebaseDatabase.getInstance("https://bmh-insoa2526-default-rtdb.europe-west1.firebasedatabase.app/")
        // CREAR - MODIFICAR - ELIMIAR ELEMENTO EN BASE DE DATOS
        // database.reference.child("nombreApp").setValue(null)
        /*database.reference.child("users").child("1")
            .setValue(User("Borja@gmail.com", "123123", "Borja", "Martin"))*/


    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentRegisterBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onStart() {
        super.onStart()

        binding.editCorreo.setText(name)
        binding.editPass.setText(pass)
        binding.btnRegistro.setOnClickListener {
            val email = binding.editCorreo.text.toString()
            val pass = binding.editPass.text.toString()
            val name = binding.editNombre.text.toString()
            val surname = binding.editApellido.text.toString()

            auth.createUserWithEmailAndPassword(email, pass)
                .addOnCompleteListener {
                    if (it.isSuccessful) {

                        database.reference.child("users")
                            .child(auth.currentUser!!.uid)
                            .setValue(User(email, pass, name, surname))


                        Snackbar.make(
                            binding.root,
                            "Registro correcto. Quieres iniciar sesion",
                            Snackbar.LENGTH_LONG
                        )
                            .setAction("OK") {
                                findNavController().navigate(R.id.action_registerFragment_to_mainFragment)
                            }
                            .show()
                    } else {
                        Snackbar.make(
                            binding.root,
                            "Fallo en el registro",
                            Snackbar.LENGTH_LONG
                        )
                            .show()
                    }
                }

        }

    }


    override fun onDetach() {
        super.onDetach()
    }

}

/*
Al registrar un usuario, meterlo dentro del DATASET
Al realizar login, pasar a un fragment main donde se muestra el nombre y apellido
del usuario logeado, si esta en el DS, en caso contrario mostrar un snack
 */
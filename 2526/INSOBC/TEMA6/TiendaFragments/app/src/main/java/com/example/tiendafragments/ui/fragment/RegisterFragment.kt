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
import com.example.tiendafragments.databinding.FragmentRegisterBinding
import com.example.tiendafragments.model.User
import com.google.android.material.snackbar.Snackbar
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase

class RegisterFragment : Fragment() {

    private lateinit var auth: FirebaseAuth
    private lateinit var binding: FragmentRegisterBinding
    private lateinit var database: FirebaseDatabase
    private lateinit var name: String
    private lateinit var pass: String

    override fun onAttach(context: Context) {
        super.onAttach(context)
        auth = FirebaseAuth.getInstance()
        database = FirebaseDatabase
            .getInstance("https://bmh-insobc2526-default-rtdb.europe-west1.firebasedatabase.app/")
        name = requireArguments().getString("name").toString()
        pass = requireArguments().getString("psas").toString()


    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentRegisterBinding.inflate(
            inflater,
            container,
            false
        )
        return binding.root
    }

    override fun onStart() {
        super.onStart()
        // todas las acciones
        binding.btnRegistro.setOnClickListener {
            val email = binding.editCorreo.text.toString()
            val pass = binding.editPass.text.toString()
            val name = binding.editNombre.text.toString()
            val surname = binding.editApellido.text.toString()
            auth.createUserWithEmailAndPassword(email, pass)
                .addOnCompleteListener {
                    if (it.isSuccessful) {

                        /*
                        val referenciaUser = database.reference
                            .child("users")
                            .child(auth.currentUser!!.uid)

                        referenciaUser
                            .child("apellido").setValue(surname)

                        referenciaUser
                            .child("nombre").setValue(name)

                        referenciaUser.child("correo").setValue(email)

                        referenciaUser
                            .child("pass").setValue(pass)*/
                        database.reference.child("users")
                            .child(auth.currentUser!!.uid)
                            .setValue(User(name,surname, email, pass,))


                        Snackbar.make(
                            binding.root,
                            "Registro correcto, ¿quieres iniciar sesión?",
                            Snackbar.LENGTH_LONG
                        ).setAction("OK") {
                            findNavController().navigate(R.id.action_registerFragment_to_mainFragment)
                        }
                            .show()
                    } else {
                        Snackbar.make(
                            binding.root,
                            "Registro erroneo",
                            Snackbar.LENGTH_LONG
                        ).show()
                    }
                }
        }
        binding.editCorreo.setText(name)
        binding.editPass.setText(pass)
    }

    override fun onDetach() {
        super.onDetach()
    }
}
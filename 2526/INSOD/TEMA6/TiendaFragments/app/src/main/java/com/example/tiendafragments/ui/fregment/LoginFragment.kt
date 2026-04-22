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
import com.google.android.material.snackbar.Snackbar
import com.google.firebase.auth.FirebaseAuth


class LoginFragment : Fragment() {

    private lateinit var binding: FragmentLoginBinding
    private lateinit var auth: FirebaseAuth

    override fun onAttach(context: Context) {
        super.onAttach(context)
        // inicializaciones logicas
        auth = FirebaseAuth.getInstance()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // indica que vista se pone al fragment
        binding = FragmentLoginBinding.inflate(inflater, container, false)
        return binding.root
    }

    private fun clearData(){
        binding.editCorreo.text.clear()
        binding.editPass.text.clear()
    }

    override fun onResume() {
        super.onResume()
        if (auth.currentUser != null){
            auth.signOut()
        }
    }

    override fun onStart() {
        super.onStart()

        binding.btnLogin.setOnClickListener {
            auth.signInWithEmailAndPassword(
                binding.editCorreo.text.toString(),
                binding.editPass.text.toString()
            ).addOnCompleteListener {
                if (it.isSuccessful) {
                    findNavController().navigate(R.id.action_loginFragment2_to_mainFragment)
                } else {

                    Snackbar.make(
                        binding.root, "Error en el login",
                        Snackbar.LENGTH_LONG
                    ).show()
                    clearData()
                }
            }
        }
        binding.btnRegistro.setOnClickListener {
            findNavController().navigate(R.id.action_loginFragment2_to_registerFragment2)
        }
    }

    override fun onDetach() {
        super.onDetach()
        // liberar memoria -> iguala a null
    }


}
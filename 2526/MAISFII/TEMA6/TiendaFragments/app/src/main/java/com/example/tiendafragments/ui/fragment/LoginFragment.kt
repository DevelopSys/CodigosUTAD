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
import com.google.android.material.snackbar.Snackbar
import com.google.firebase.auth.FirebaseAuth

class LoginFragment : Fragment() {

    private lateinit var binding: FragmentLoginBinding
    private lateinit var auth: FirebaseAuth


    override fun onAttach(context: Context) {
        super.onAttach(context)
        auth = FirebaseAuth.getInstance();
    }

    override fun onResume() {
        super.onResume()
        if (auth.currentUser != null){
            auth.signOut()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentLoginBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onStart() {
        super.onStart()
        binding.btnRegistro.setOnClickListener {
            val bundle = Bundle()
            bundle.putString("name", binding.editCorreo.text.toString())
            bundle.putString("pass", binding.editPass.text.toString())
            findNavController().navigate(R.id.action_loginFragment_to_registerFragment, bundle)
        }

        binding.btnLogin.setOnClickListener {
            val email = binding.editCorreo.text.toString()
            val pass = binding.editPass.text.toString()
            auth.signInWithEmailAndPassword(email, pass)
                .addOnCompleteListener {
                    if (it.isSuccessful) {
                        findNavController().navigate(R.id.action_loginFragment_to_mainFragment)
                    } else {
                        Snackbar.make(
                            binding.root,
                            "Error en el proceso de login",
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
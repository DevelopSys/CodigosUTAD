package com.example.agenda.ui.fragments

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.agenda.R
import com.example.agenda.databinding.FragmentLoginBinding
import com.google.android.material.snackbar.Snackbar

class LoginFragment : Fragment() {

    private lateinit var binding: FragmentLoginBinding

    override fun onAttach(context: Context) {
        super.onAttach(context)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentLoginBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onStart() {
        super.onStart()
        binding.btnLogin.setOnClickListener {
            Log.v("datos", binding.editMail.text.toString())
            Log.v("datos", binding.editPass.text.toString())
            if (binding.editMail.text.toString().equals("borja@gmail.com") && binding.editPass.text.toString().equals("1234")){
                findNavController().navigate(R.id.action_loginFragment_to_mainFragment)
            } else {
                Snackbar.make(binding.root, "Error en el login", Snackbar.LENGTH_SHORT).show()
            }

        }
        binding.btnLoginRegistrar.setOnClickListener {
            findNavController().navigate(R.id.action_loginFragment_to_regsiterFragment)
        }
    }


}
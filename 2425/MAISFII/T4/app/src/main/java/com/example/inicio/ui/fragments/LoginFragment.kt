package com.example.inicio.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.inicio.R
import com.example.inicio.databinding.FragmentLoginBinding


class LoginFragment: Fragment() {

    private lateinit var binding: FragmentLoginBinding

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
        binding.botonRegistro.setOnClickListener {
            val bundle = Bundle()
            bundle.putString("dato","dato que voy a pasar entre fragments")
            findNavController().navigate(R.id.action_loginFragment_to_registroFragment,bundle)
        }
    }
}
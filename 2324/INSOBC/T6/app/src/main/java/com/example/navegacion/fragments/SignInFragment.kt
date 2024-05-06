package com.example.navegacion.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.navegacion.R
import com.example.navegacion.databinding.FragmentSiginBinding

class SignInFragment: Fragment() {


    private lateinit var binding: FragmentSiginBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSiginBinding.inflate(inflater, container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.botonCrearCuenta.setOnClickListener {
            val bundle: Bundle = Bundle()
            bundle.putString("nombre",binding.editNombre.text.toString())
            bundle.putString("pass",binding.editPass.text.toString())
            findNavController().navigate(R.id.action_signInFragment_to_loginFragment,bundle)
        }
    }

}
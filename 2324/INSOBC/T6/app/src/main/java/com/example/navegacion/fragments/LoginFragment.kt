package com.example.navegacion.fragments

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.navegacion.R
import com.example.navegacion.databinding.FragmentLoginBinding

class LoginFragment : Fragment() {

    private lateinit var binding: FragmentLoginBinding
    private var nombre: String? = null;
    private var pass: String? = null;

    override fun onAttach(context: Context) {
        super.onAttach(context)
        nombre = arguments?.getString("nombre")
        pass = arguments?.getString("pass")
    }

    /*Asocia grafico y logico*/
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentLoginBinding.inflate(inflater,container
            ,false)
        return binding.root
    }

    /*Acciones logicas de los elementos*/
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if (nombre!=null && pass != null){
            binding.editNombre.setText(nombre)
            binding.editPass.setText(pass)
        }


        binding.botonCuenta.setOnClickListener {
            findNavController().navigate(R.id.action_loginFragment_to_signInFragment)
        }
    }
}
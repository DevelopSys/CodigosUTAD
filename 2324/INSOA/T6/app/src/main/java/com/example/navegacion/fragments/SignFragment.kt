package com.example.navegacion.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.navegacion.R
import com.example.navegacion.databinding.FragmentLoginBinding
import com.example.navegacion.databinding.FragmentSignBinding
import com.google.android.material.snackbar.Snackbar

class SignFragment : Fragment() {

    private lateinit var binding: FragmentSignBinding

    /*Asocia parte grafica y parte logica*/
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSignBinding.inflate(
            inflater, container,
            false
        )
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        /*logica de la aplicacion*/
        binding.botonRegistrar.setOnClickListener {

            val bundle: Bundle = Bundle()
            bundle.putString("pass", binding.editPass.text.toString())
            bundle.putString("correo", binding.editCorreo.text.toString())
            findNavController()
                .navigate(R.id.action_signFragment_to_loginFragment
                    , bundle)

        }
    }

}
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
import com.google.android.material.snackbar.Snackbar

class LoginFragment : Fragment() {

    private lateinit var binding: FragmentLoginBinding
    private var pass: String? = null;
    private var correo: String? = null;

    override fun onAttach(context: Context) {
        super.onAttach(context)
        pass = arguments?.getString("pass")
        correo = arguments?.getString("correo")
    }

    /*Asocia parte grafica y parte logica*/
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentLoginBinding.inflate(
            inflater, container,
            false
        )
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        /*logica de la aplicacion*/

        // poner en los edit los datos -> cuando no sean null
        if (correo!=null && pass !=null){
            binding.editCorreo.setText(correo)
            binding.editPass.setText(pass)
        }

        binding.botonRegistrar.setOnClickListener {
            Snackbar.make(binding.root, "Estas seguro que quieres crear cuenta",
                Snackbar.LENGTH_SHORT)
                .setAction("Iniciar"){
                    findNavController().navigate(R.id.action_loginFragment_to_signFragment)
                }
                .show()

        }
    }

}
package com.example.tienda.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.tienda.R
import com.example.tienda.databinding.FragmentLoginBinding
import com.google.android.material.snackbar.Snackbar

class LoginFragment : Fragment() {

    private lateinit var binding: FragmentLoginBinding

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
        binding.btnInicio.setOnClickListener {
            if (binding.editCorreo.text.toString().equals("borja@gmail.com")
                && binding.editPass.text.toString().equals("1234")) {
                val bundle = Bundle()
                bundle.putString("correo",binding.editCorreo.text.toString())
                
                findNavController().navigate(R.id.action_loginFragment_to_mainFragment,bundle)
            } else {
                Snackbar.make(binding.root, "Error en el inicio",
                    Snackbar.LENGTH_SHORT).show()
            }

        }
    }
}
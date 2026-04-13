package com.example.tiendafragments.ui.fragment

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.tiendafragments.databinding.FragmentLoginBinding
import com.example.tiendafragments.databinding.FragmentRegisterBinding

class RegisterFragment : Fragment(){

    private lateinit var binding: FragmentRegisterBinding
    private lateinit var name: String
    private lateinit var pass: String
    override fun onAttach(context: Context) {
        super.onAttach(context)
        name = requireArguments().getString("name").toString()
        pass = requireArguments().getString("psas").toString()

    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentRegisterBinding.inflate(inflater,
            container,
            false)
        return binding.root
    }

    override fun onStart() {
        super.onStart()
        // todas las acciones
        binding.btnRegistro.setOnClickListener {  }
        binding.editCorreo.setText(name)
        binding.editPass.setText(pass)
    }

    override fun onDetach() {
        super.onDetach()
    }
}
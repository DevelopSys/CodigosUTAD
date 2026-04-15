package com.example.tiendafragments.ui.fragment

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.tiendafragments.databinding.FragmentLoginBinding
import com.example.tiendafragments.databinding.FragmentLregisterBinding

class RegisterFragment : Fragment() {

    private lateinit var binding: FragmentLregisterBinding
    private lateinit var nombre: String
    private lateinit var pass: String

    override fun onAttach(context: Context) {
        super.onAttach(context)
        nombre = requireArguments().getString("name").toString()
        pass = requireArguments().getString("pass").toString()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentLregisterBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onStart() {
        super.onStart()
        binding.editCorreo.setText(nombre)
        binding.editPass.setText(pass)
    }

    override fun onDetach() {
        super.onDetach()
    }


}
package com.example.agenda.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.agenda.R
import com.example.agenda.databinding.FragmentLoginBinding
import com.example.agenda.databinding.FragmentRegisterBinding

class RegsiterFragment : Fragment() {

    private lateinit var binding: FragmentRegisterBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentRegisterBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onStart() {
        super.onStart()
        binding.btnRegistrar.setOnClickListener {
            findNavController().navigate(R.id.action_regsiterFragment_to_loginFragment)
        }
    }
}
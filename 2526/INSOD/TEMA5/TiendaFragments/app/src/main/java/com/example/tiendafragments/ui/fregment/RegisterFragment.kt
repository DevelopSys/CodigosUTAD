package com.example.tiendafragments.ui.fregment

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.tiendafragments.databinding.FragmentLoginBinding
import com.example.tiendafragments.databinding.FragmentRegisterBinding


class RegisterFragment : Fragment() {

    private lateinit var binding: FragmentRegisterBinding

    override fun onAttach(context: Context) {
        super.onAttach(context)
        // inicializaciones logicas
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // indica que vista se pone al fragment
        binding = FragmentRegisterBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onDetach() {
        super.onDetach()
        // liberar memoria -> iguala a null
    }



}
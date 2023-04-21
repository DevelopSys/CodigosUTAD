package com.example.t8navegacion.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.t8navegacion.R
import com.example.t8navegacion.databinding.FragmentUnoBinding

class FragmentUno: Fragment() {

    private lateinit var binding: FragmentUnoBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentUnoBinding.inflate(layoutInflater,container,false)
        return binding.root
    }

    override fun onStart() {
        super.onStart()
        binding.botonF1.setOnClickListener {
            // cambia de fragment
            findNavController().navigate(R.id.action_fragmentUno_to_fragmentDos)
        }

        binding.botonF3.setOnClickListener{
            findNavController().navigate(R.id.action_fragmentUno_to_fragmentTres)
        }
    }

}
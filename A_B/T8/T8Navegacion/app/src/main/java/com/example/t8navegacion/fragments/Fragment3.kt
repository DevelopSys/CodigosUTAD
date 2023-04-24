package com.example.t8navegacion.fragments

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.t8navegacion.R
import com.example.t8navegacion.databinding.FragmentDosBinding
import com.example.t8navegacion.databinding.FragmentTresBinding
import com.example.t8navegacion.databinding.FragmentUnoBinding

class Fragment3: Fragment() {

    private lateinit var binding: FragmentTresBinding
    private lateinit var texto: String

    override fun onAttach(context: Context) {
        super.onAttach(context)
        texto = arguments?.getString("texto") ?:"valor defecto"

    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentTresBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onStart() {
        super.onStart()
        binding.textF3.text = texto
        binding.botonF3.setOnClickListener {
            findNavController().navigate(R.id.action_fragment3_to_fragment1)
        }
    }


}
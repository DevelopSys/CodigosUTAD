package com.example.t8navegacion.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.t8navegacion.R
import com.example.t8navegacion.databinding.FragmentDosBinding
import com.example.t8navegacion.databinding.FragmentUnoBinding

class Fragment2: Fragment() {

    private lateinit var binding: FragmentDosBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDosBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onStart() {
        super.onStart()
        binding.botonF2.setOnClickListener {
            // cambiar de fragment del 2 al 3
            val bundle = Bundle()
            bundle.putString("texto","ejemplo de paso de datos")
            findNavController().navigate(R.id.action_fragment2_to_fragment3, bundle)
        }
    }


}
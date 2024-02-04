package com.example.t8fragments.fragments

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.t8fragments.databinding.FragmentDetailBinding

class FragmentDetail: Fragment() {

    private lateinit var binding: FragmentDetailBinding
    private lateinit var nombre: String

    companion object{
        fun newInstance(nombre: String): FragmentDetail{
            val args = Bundle()
            args.putString("nombre",nombre)
            val fragment = FragmentDetail()
            fragment.arguments = args
            return fragment
        }
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        nombre= this.arguments?.getString("nombre") ?:"defecto"
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDetailBinding.inflate(inflater, container,false)
        return binding.root
    }

    override fun onResume() {
        super.onResume()
        binding.textoDetalle.text = nombre
    }
}
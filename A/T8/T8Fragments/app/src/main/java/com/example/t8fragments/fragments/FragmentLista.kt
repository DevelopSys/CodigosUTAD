package com.example.t8fragments.fragments

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.t8fragments.adapters.AdaptadorLenguaje
import com.example.t8fragments.databinding.FragmentListBinding

class FragmentLista : Fragment() {

    private lateinit var binding: FragmentListBinding
    private lateinit var adaptadorLenguaje: AdaptadorLenguaje;

    override fun onAttach(context: Context) {
        super.onAttach(context)
        val listaLenguajes: ArrayList<String> = ArrayList()
        listaLenguajes.add("Python")
        listaLenguajes.add("Java")
        listaLenguajes.add("Kotlin")
        listaLenguajes.add("JavaScript")
        listaLenguajes.add("TypeScript")
        listaLenguajes.add("PHP")
        listaLenguajes.add("Powershell")
        listaLenguajes.add("Bash")
        listaLenguajes.add("Dart")
        adaptadorLenguaje = AdaptadorLenguaje(listaLenguajes, context)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentListBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onResume() {
        super.onResume()
        binding.recyclerLenguajes.adapter = adaptadorLenguaje
        binding.recyclerLenguajes.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.VERTICAL,false)
    }
}
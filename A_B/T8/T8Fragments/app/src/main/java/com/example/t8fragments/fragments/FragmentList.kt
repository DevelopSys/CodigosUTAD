package com.example.t8fragments.fragments

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.t8fragments.adapters.AdapterLenguajes
import com.example.t8fragments.databinding.FragmentListBinding

class FragmentList: Fragment() {

    private lateinit var binding: FragmentListBinding
    private lateinit var listaLenguajes: ArrayList<String>
    private lateinit var adaptadorLenguajes: AdapterLenguajes

    override fun onAttach(context: Context) {
        super.onAttach(context)
        listaLenguajes = ArrayList();
        listaLenguajes.add("Java")
        listaLenguajes.add("Kotlin")
        listaLenguajes.add("Python")
        listaLenguajes.add("JS")
        listaLenguajes.add("TS")
        listaLenguajes.add("Dart")
        listaLenguajes.add("Powershell")
        listaLenguajes.add("Bash")
        listaLenguajes.add("R")
        listaLenguajes.add("SQL")
        adaptadorLenguajes = AdapterLenguajes(listaLenguajes,context);

    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentListBinding.inflate(inflater,container,false)
        return binding.root;
    }

    override fun onStart() {
        super.onStart()
        // binding.recyclerLenguajes
        binding.recyclerLenguajes.adapter = adaptadorLenguajes;
        binding.recyclerLenguajes.layoutManager = LinearLayoutManager(context,LinearLayoutManager.VERTICAL,false)

    }

}
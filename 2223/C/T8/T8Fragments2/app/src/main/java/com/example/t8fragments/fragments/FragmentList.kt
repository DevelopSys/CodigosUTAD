package com.example.t8fragments.fragments

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.t8fragments.adapters.AdaptadorLenguajes
import com.example.t8fragments.databinding.FragmentListBinding

class FragmentList: Fragment() {

    private lateinit var binding: FragmentListBinding
    private lateinit var adaptadorLenguajes: AdaptadorLenguajes
    private lateinit var listaLenguajes: ArrayList<String>


    override fun onAttach(context: Context) {
        super.onAttach(context)
        listaLenguajes = ArrayList();
        listaLenguajes.add("Kotlin")
        listaLenguajes.add("Python")
        listaLenguajes.add("Java")
        listaLenguajes.add("JS")
        listaLenguajes.add("TS")
        listaLenguajes.add("Ppwershell")
        listaLenguajes.add("Dart")
        listaLenguajes.add("Python")
        listaLenguajes.add("Bash")
        adaptadorLenguajes = AdaptadorLenguajes(listaLenguajes,context)
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
        binding.recyclerLenguajes.adapter = adaptadorLenguajes
        binding.recyclerLenguajes.layoutManager =
            LinearLayoutManager(context,LinearLayoutManager.VERTICAL,false)

    }

}
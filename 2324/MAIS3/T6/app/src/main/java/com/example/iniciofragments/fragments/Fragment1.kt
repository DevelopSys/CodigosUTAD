package com.example.iniciofragments.fragments

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.iniciofragments.databinding.FragmentUnoBinding
import com.google.android.material.snackbar.Snackbar

class Fragment1 : Fragment() {

    private lateinit var binding: FragmentUnoBinding

    /*Primer metodo ejecutado*/
    /*Inicializaciones que tienen que ver con el oontext*/
    override fun onAttach(context: Context) {
        super.onAttach(context)
        //binding = FragmentUnoBinding.inflate(layoutInflater)
    }

    /*Asociar parte grafica y logica*/
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentUnoBinding.inflate(inflater, container, false)
        return binding.root
    }

    /*vista asociada, trabajo con acciones logicas*/
    /*Inicializar todas aquellas cosas que tengan que ver con lo grafico*/
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.botonPulsarF1.setOnClickListener {
            Snackbar.make(binding.root, "Puslado desde F1", Snackbar.LENGTH_SHORT).show()
        }

    }

    /*Ultimo metodo en ejecucion*/
    /*Igualar variables a null*/
    override fun onDetach() {
        super.onDetach()
    }

}
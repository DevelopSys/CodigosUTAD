package com.example.tiendafragments.ui.fragments

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.tiendafragments.databinding.FragmentMainBinding
import com.example.tiendafragments.databinding.FragmentRegisterBinding
import com.google.android.material.snackbar.Snackbar
import com.google.firebase.auth.FirebaseAuth

class MainFragment : Fragment() {

    private lateinit var auth: FirebaseAuth
    private lateinit var binding: FragmentMainBinding
    private lateinit var name: String
    private lateinit var pass: String

    override fun onAttach(context: Context) {
        super.onAttach(context)


    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMainBinding.inflate(inflater, container, false)
        return binding.root
    }


    override fun onDetach() {
        super.onDetach()
    }

}

/*
Al registrar un usuario, meterlo dentro del DATASET
Al realizar login, pasar a un fragment main donde se muestra el nombre y apellido
del usuario logeado, si esta en el DS, en caso contrario mostrar un snack
 */
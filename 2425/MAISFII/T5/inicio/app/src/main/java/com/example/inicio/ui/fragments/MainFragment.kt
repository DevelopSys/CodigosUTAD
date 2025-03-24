package com.example.inicio.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.inicio.databinding.FragmentMBinding
import com.example.inicio.databinding.FragmentRegistroBinding

class MainFragment : Fragment() {

    private lateinit var binding: FragmentMBinding;

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMBinding.inflate(inflater,container, false)
        return binding.root
    }
}
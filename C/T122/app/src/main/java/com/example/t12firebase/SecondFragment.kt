package com.example.t12firebase

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.t12firebase.databinding.FragmentSecondBinding
import com.google.firebase.database.FirebaseDatabase

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class SecondFragment : Fragment() {

    private var _binding: FragmentSecondBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!
    private lateinit var userUid: String
    private lateinit var database: FirebaseDatabase


    override fun onAttach(context: Context) {
        super.onAttach(context)
        database = FirebaseDatabase.getInstance("https://utadbmh-default-rtdb.firebaseio.com/")
        userUid = arguments?.getString("uid")?:"sin uid"
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentSecondBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.textoUid.text = userUid
        binding.botonBd.setOnClickListener {
            database.reference.child("usuarios").child(userUid).child("nombre").setValue("Borja")
            database.reference.child("usuarios").child(userUid).child("logeos").setValue(5)
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
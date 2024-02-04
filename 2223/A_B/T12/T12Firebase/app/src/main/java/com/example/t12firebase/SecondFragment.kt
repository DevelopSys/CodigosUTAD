package com.example.t12firebase

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.t12firebase.databinding.FragmentSecondBinding
import com.example.t12firebase.model.Producto
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class SecondFragment : Fragment() {

    private var _binding: FragmentSecondBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!
    private lateinit var userUID: String;
    private lateinit var database: FirebaseDatabase

    override fun onAttach(context: Context) {
        super.onAttach(context)
        userUID = this.arguments?.getString("uid") ?: "no uid"
        database = FirebaseDatabase.getInstance("https://utadbmh-default-rtdb.firebaseio.com/")
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
        binding.botonAdd.setOnClickListener {
            // agregar a bd
            // datos -> edit -> binding
            // database

            val databaseRef = database.reference.child("usuarios")
                .child(userUID)
                .child("productos")
                .child(binding.editNombre.text.toString())

            databaseRef.setValue(Producto(binding.editNombre.text.toString()
                ,binding.editDescripcion.text.toString()
                ,binding.editPrecio.text.toString().toInt()
                ,binding.spinnerStock.selectedItem.toString().toInt()))


        }
        binding.botonConsultar.setOnClickListener {
            val databaseRef = database.reference.child("usuarios")
                .child(userUID)
                .child("productos")

            databaseRef.addListenerForSingleValueEvent(object : ValueEventListener{
                override fun onDataChange(snapshot: DataSnapshot) {
                    for ( data in snapshot.children ){
                        // data
                        val producto = data.getValue(Producto::class.java)
                        Log.v("nodos_fb","El precio del producto ${producto!!.nombre} es de ${producto.precio}")
                    }
                }

                override fun onCancelled(error: DatabaseError) {

                }

            })
        }


    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
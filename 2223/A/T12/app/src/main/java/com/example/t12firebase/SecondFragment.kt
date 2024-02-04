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
import com.google.android.material.snackbar.Snackbar
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
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

    private lateinit var userUid: String
    private lateinit var database: FirebaseDatabase
    private var contadorProductos = 0;

    override fun onAttach(context: Context) {
        super.onAttach(context)
        database = FirebaseDatabase.getInstance("https://utadbmh-default-rtdb.firebaseio.com/")
        userUid = arguments?.getString("uid") ?: "no id"
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

            var referenciaProducto = database.reference.child("usuarios").child(userUid)
                .child("productos").child(binding.editNombre.text.toString())

            // Database
            referenciaProducto.setValue(
                Producto(
                    binding.editNombre.text.toString(), binding.editDescripcion.text.toString(),
                    binding.editPrecio.text.toString().toInt(),
                    binding.spinnerStock.selectedItem.toString().toInt()
                )
            )
            /*referenciaProducto
                .child("nombre").setValue(binding.editNombre.text.toString())

            referenciaProducto
                .child("descripcion").setValue(binding.editDescripcion.text.toString())

            referenciaProducto
                .child("precio").setValue(binding.editPrecio.text.toString())

            referenciaProducto
                .child("stock").setValue(binding.spinnerStock.selectedItem)*/

            contadorProductos++;
        }
        binding.botonVender.setOnClickListener {
            var referencia: DatabaseReference = database.reference.child("usuarios")
                .child(userUid).child("productos")
                .child(binding.editNombre.text.toString())
                .child("stock")
            referencia.setValue(0)
        }
        binding.botonConsultar.setOnClickListener {ç


            database.reference.child("usuarios").child(userUid)
                .child("productos").valu

            findNavController().navigate(R.id.action_SecondFragment_to_listFragment)

            /*var referenciaProducto = database.reference.child("usuarios").child(userUid)
                .child("productos")
            referenciaProducto.addValueEventListener(object : ValueEventListener {
                override fun onDataChange(snapshot: DataSnapshot) {
                    for (data in snapshot.children) {

                        var producto = data.getValue(Producto::class.java)
                        Log.v("firebase_nodos", producto?.nombre.toString())
                    }
                }

                override fun onCancelled(error: DatabaseError) {
                    TODO("Not yet implemented")
                }

            })*/
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


}
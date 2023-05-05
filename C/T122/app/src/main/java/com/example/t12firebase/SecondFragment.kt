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


    override fun onAttach(context: Context) {
        super.onAttach(context)
        database = FirebaseDatabase.getInstance("https://utadbmh-default-rtdb.firebaseio.com/")
        userUid = arguments?.getString("uid") ?: "sin uid"
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentSecondBinding.inflate(inflater, container, false)
        return binding.root

    }

    /**
     *  Edit nombre del produco
     *  Edit descripcion del producto
     *  Edit precio del producto (numeros)
     *  Spinner stock productor (1-10)
     *  Button agregar
     */


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.botonAdd.setOnClickListener {
            // llevar los datos a bd
            // capturar los datos -> binding.edit.
            // bd navegar en ella -> database

            var referencia: DatabaseReference = database.reference.child("usuarios")
                .child(userUid)
                .child("productos")
                .child(binding.editNombre.text.toString());

            /*referencia
                .child("nombre").setValue(binding.editNombre.text.toString())

            referencia
                .child("descripcion").setValue(binding.editDescripcion.text.toString())

            referencia
                .child("precio").setValue(binding.editPrecio.text.toString().toInt())

            referencia
                .child("stock").setValue(binding.spinnerStock.selectedItem.toString().toInt())*/

            referencia.setValue(
                Producto(
                    binding.editNombre.text.toString(),
                    binding.editDescripcion.text.toString(),
                    binding.editPrecio.text.toString().toInt(),
                    binding.spinnerStock.selectedItem.toString().toInt()
                )
            )

            var producto = Producto(
                binding.editNombre.text.toString(),
                binding.editDescripcion.text.toString(),
                binding.editPrecio.text.toString().toInt(),
                binding.spinnerStock.selectedItem.toString().toInt()
            )


        }
        binding.botonVender.setOnClickListener {
            var referencia: DatabaseReference = database.reference.child("usuarios")
                .child(userUid)
                .child("productos")
                .child(binding.editNombre.text.toString());

            referencia.child("stock").addListenerForSingleValueEvent(object : ValueEventListener{
                override fun onDataChange(snapshot: DataSnapshot) {
                    //Log.v("nodos_fb","cambios detectados single")
                    //Log.v("nodos_fb",snapshot.value.toString())
                    referencia.child("stock").setValue(snapshot.value.toString().toInt()-1)
                }

                override fun onCancelled(error: DatabaseError) {
                    TODO("Not yet implemented")
                }

            })
        }
        binding.botonConsultar.setOnClickListener {
            var referencia: DatabaseReference = database.reference.child("usuarios")
                .child(userUid)
                .child("productos")

            /*referencia.addValueEventListener(object : ValueEventListener {
                override fun onDataChange(snapshot: DataSnapshot) {
                    for (data in snapshot.children) {
                        var producto = data.getValue(Producto::class.java)
                        Log.v("nodos_fb", "El stock de las ${producto!!.nombre} es de ${producto!!.stock}")
                    }
                }

                override fun onCancelled(error: DatabaseError) {

                }

            })*/

        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
package com.example.tienda.ui.fragments

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.tienda.R
import com.example.tienda.databinding.FragmentLoginBinding
import com.example.tienda.databinding.FragmentMainBinding
import com.example.tienda.model.User
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.ChildEventListener
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class MainFragment : Fragment() {

    private lateinit var auth: FirebaseAuth
    private lateinit var database: FirebaseDatabase
    private lateinit var binding: FragmentMainBinding
    private var correo: String? = null


    override fun onAttach(context: Context) {
        super.onAttach(context)
        auth = FirebaseAuth.getInstance()
        database =
            FirebaseDatabase.getInstance("https://bmh-utadinsoa-default-rtdb.europe-west1.firebasedatabase.app/")
        correo = arguments?.getString("correo")
        Log.v("datos", auth.currentUser!!.uid)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMainBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onStart() {
        super.onStart()
        binding.textoMain.text = correo
        binding.btnEscribir.setOnClickListener {
            database.reference.child("aplicacion")
                .child("fecha").setValue(null)
        }
        binding.btnConsulta.setOnClickListener {
            /*database.reference.child("aplicacion")
                .child("caracteristicas")
                .child("nombre")
                .get().addOnSuccessListener {
                    // it.key // nombre
                    binding.textoMain.text = it.value.toString() // ProductosApp
                }*/

            /*database.reference.child("aplicacion")
                .addChildEventListener(object : ChildEventListener{
                    override fun onChildAdded(snapshot: DataSnapshot, previousChildName: String?) {
                        Log.v("dato", "Añadido"+snapshot.toString())
                    }
                    override fun onChildChanged(
                        snapshot: DataSnapshot,
                        previousChildName: String?
                    ) {
                        Log.v("dato", "Modificado"+snapshot.toString())
                    }

                    override fun onChildRemoved(snapshot: DataSnapshot) {
                        Log.v("dato", "Borrado"+snapshot.toString())
                    }

                    override fun onChildMoved(snapshot: DataSnapshot, previousChildName: String?) {
                        Log.v("dato", "movido"+snapshot.toString())
                    }

                    override fun onCancelled(error: DatabaseError) {
                        TODO("Not yet implemented")
                    }

                })*/
            //.child("caracteristicas")
            //.child("nombre")
            /*.addValueEventListener(object : ValueEventListener{
                override fun onDataChange(snapshot: DataSnapshot) {
                    Log.v("dato", snapshot.value.toString())
                    binding.textoMain.text = snapshot.value.toString()
                }

                override fun onCancelled(error: DatabaseError) {
                    TODO("Not yet implemented")
                }

            })*/

            database.reference.child("usuarios")
                .addChildEventListener(object : ChildEventListener {
                override fun onChildAdded(snapshot: DataSnapshot, previousChildName: String?) {
                    val usuario = snapshot.getValue(User::class.java)
                    Log.v("usuarios",usuario?.nombre.toString())
                }

                override fun onChildChanged(snapshot: DataSnapshot, previousChildName: String?) {
                    val usuario = snapshot.getValue(User::class.java)
                    Log.v("usuarios",usuario?.nombre.toString())
                }

                override fun onChildRemoved(snapshot: DataSnapshot) {
                    val usuario = snapshot.getValue(User::class.java)
                    Log.v("usuarios",usuario?.nombre.toString())
                }

                override fun onChildMoved(snapshot: DataSnapshot, previousChildName: String?) {
                    val usuario = snapshot.getValue(User::class.java)
                    Log.v("usuarios",usuario?.nombre.toString())
                }

                override fun onCancelled(error: DatabaseError) {
                    TODO("Not yet implemented")
                }

            })

        }
        binding.btnVolver.setOnClickListener {
            findNavController().navigate(R.id.action_mainFragment_to_loginFragment)
        }
    }
}
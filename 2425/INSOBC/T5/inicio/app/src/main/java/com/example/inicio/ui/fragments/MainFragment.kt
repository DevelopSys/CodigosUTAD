package com.example.inicio.ui.fragments

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.inicio.databinding.FragmentMainBinding
import com.example.inicio.model.User
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.ChildEventListener
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class MainFragment : Fragment() {

    private lateinit var binding: FragmentMainBinding
    private lateinit var database: FirebaseDatabase
    private lateinit var auth: FirebaseAuth

    override fun onAttach(context: Context) {
        super.onAttach(context)
        auth = FirebaseAuth.getInstance()
        database =
            FirebaseDatabase.getInstance("https://utad2425insobc-default-rtdb.europe-west1.firebasedatabase.app/")
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMainBinding.inflate(
            inflater, container,
            false
        )
        return binding.root
    }

    override fun onStart() {
        super.onStart()
        // puntual -> preguntas a un path solo cuando se ejecuta este codigo
        /* database.reference.child("aplicacion")
             .child("nombre").get().addOnSuccessListener {
                 // it -> datasnapshot
                 binding.textoApp.text = it.value.toString()
             }*/

        // En el textoUsuario quiero que aparezca el nombre
        // o correo del usuario
        // que ha iniciado sesion

        database.reference.child("usuarios")
            .child(auth.currentUser!!.uid).child("nombre")
            .addValueEventListener(object : ValueEventListener {
                override fun onDataChange(snapshot: DataSnapshot) {
                    binding.textoUsuario.text = snapshot.value.toString()
                }

                override fun onCancelled(error: DatabaseError) {
                    TODO("Not yet implemented")
                }

            })

        database.reference.child("aplicacion")
            .child("nombre")
            .addValueEventListener(object : ValueEventListener {
                override fun onDataChange(snapshot: DataSnapshot) {
                    binding.textoApp.text = snapshot.value.toString()
                }

                override fun onCancelled(error: DatabaseError) {
                    TODO("Not yet implemented")
                }

            })

        database.reference.child("usuarios")
            .addChildEventListener(object : ChildEventListener{
                override fun onChildAdded(snapshot: DataSnapshot, previousChildName: String?) {
                    Log.v("datos", "Añadido" +snapshot.toString())
                }

                override fun onChildChanged(snapshot: DataSnapshot, previousChildName: String?) {
                    Log.v("datos","Cambio" +snapshot.toString())
                }

                override fun onChildRemoved(snapshot: DataSnapshot) {
                    Log.v("datos","Borrado" +snapshot.toString())
                }

                override fun onChildMoved(snapshot: DataSnapshot, previousChildName: String?) {
                    TODO("Not yet implemented")
                }

                override fun onCancelled(error: DatabaseError) {
                    TODO("Not yet implemented")
                }

            })
            /*.addValueEventListener(object : ValueEventListener {
                override fun onDataChange(snapshot: DataSnapshot) {
                    for (i in snapshot.children){
                        val usuario: User? = i.getValue(User::class.java)
                        Log.v("datos", usuario!!.correo.toString())
                    }
                }

                override fun onCancelled(error: DatabaseError) {
                    TODO("Not yet implemented")
                }

            })*/

    }
}
package com.example.inicio.ui.fragments

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.inicio.databinding.FragmentMBinding
import com.example.inicio.databinding.FragmentRegistroBinding
import com.example.inicio.model.User
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.ChildEventListener
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class MainFragment : Fragment() {

    private lateinit var binding: FragmentMBinding;
    private lateinit var database: FirebaseDatabase
    private lateinit var auth: FirebaseAuth

    override fun onAttach(context: Context) {
        super.onAttach(context)
        auth = FirebaseAuth.getInstance()
        database =
            FirebaseDatabase.getInstance("https://utad2425bmh-default-rtdb.europe-west1.firebasedatabase.app/")
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onStart() {
        super.onStart()
        // forma directa -> consulta solo una vez y a un nodo concreo
        // obtengo un task con el datasnapshot de los datos
        /*database.reference.child("aplicacion")
            .child("nombre").get().addOnSuccessListener {
                Log.v("dato", it.value.toString())
            }*/
        // forma recurrente -> consulta solo una vez a un nodo concreo,
        // pero en cada cambio obtengo notificacion
        // asociado al cambio de un valor
        // asociado al cambio de un hijo (añade, borra, mueve, modifica)
        /*database.reference.child("aplicacion")
            .child("nombre").addValueEventListener(object : ValueEventListener {
                override fun onDataChange(snapshot: DataSnapshot) {
                    Log.v("dato", snapshot.value.toString())
                }

                override fun onCancelled(error: DatabaseError) {
                    TODO("Not yet implemented")
                }
            })*/
        /*database.reference.child("aplicacion").addChildEventListener(object :ChildEventListener{
            override fun onChildAdded(snapshot: DataSnapshot, previousChildName: String?) {
                Log.v("dato", snapshot.toString())
            }

            override fun onChildChanged(snapshot: DataSnapshot, previousChildName: String?) {
                Log.v("dato", snapshot.toString())
            }

            override fun onChildRemoved(snapshot: DataSnapshot) {
                Log.v("dato", snapshot.toString())
            }

            override fun onChildMoved(snapshot: DataSnapshot, previousChildName: String?) {
                TODO("Not yet implemented")
            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }
        })*/
        // database.reference.child("usuario").child(auth.currentUser!!.uid)
        database.reference.child("usuarios").addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                for (i in snapshot.children) {
                    val usuario: User? = i.getValue(User::class.java)
                    Log.v("dato", usuario!!.correo.toString())
                }
            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }
        })
    }
}
package com.example.tiendafragments.ui.fregment

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.tiendafragments.R

import com.example.tiendafragments.databinding.FragmentLoginBinding
import com.example.tiendafragments.databinding.FragmentMainBinding
import com.example.tiendafragments.model.User
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.database.ChildEventListener
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener


class MainFragment : Fragment() {

    private lateinit var binding: FragmentMainBinding
    private lateinit var auth: FirebaseAuth
    private lateinit var currentUser: FirebaseUser
    private lateinit var database: FirebaseDatabase


    override fun onAttach(context: Context) {
        super.onAttach(context)
        // inicializaciones logicas
        auth = FirebaseAuth.getInstance()
        currentUser = auth.currentUser!!
        database =
            FirebaseDatabase.getInstance("https://bmh-insod2526-default-rtdb.europe-west1.firebasedatabase.app/")
        // currentUser = FirebaseAuth.getInstance().currentUser
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // indica que vista se pone al fragment
        binding = FragmentMainBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onStart() {
        super.onStart()
        // binding.textMain.text = "Bienvenido ${currentUser.email}"
        database.reference
            .child("users")
            .addChildEventListener(object : ChildEventListener {
                override fun onChildAdded(
                    snapshot: DataSnapshot,
                    previousChildName: String?
                ) {
                    Log.v("datos","Añadido "+snapshot.toString())
                }

                override fun onChildChanged(
                    snapshot: DataSnapshot,
                    previousChildName: String?
                ) {
                    Log.v("datos","Cambio "+snapshot.toString())
                }

                override fun onChildRemoved(snapshot: DataSnapshot) {

                }

                override fun onChildMoved(
                    snapshot: DataSnapshot,
                    previousChildName: String?
                ) {

                }

                override fun onCancelled(error: DatabaseError) {

                }

            })
        /*
        .child(auth.currentUser!!.uid)
        .addValueEventListener(object : ValueEventListener
        {
            override fun onDataChange(snapshot: DataSnapshot) {
                Log.v("datos", snapshot.toString())
                val userLogin = snapshot.getValue(User::class.java)
                binding.textMain.text = "Bienvenido ${userLogin!!.name.toString()}"
            }

            override fun onCancelled(error: DatabaseError) {
            }

        })*/
        /*.addListenerForSingleValueEvent(object : ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                Log.v("datos", snapshot.toString())
                val userLogin = snapshot.getValue(User::class.java)
                binding.textMain.text = "Bienvenido ${userLogin!!.name.toString()}"

            }

            override fun onCancelled(error: DatabaseError) {

            }
        })*/

    }

    override fun onDetach() {
        super.onDetach()
        // liberar memoria -> iguala a null
    }


}
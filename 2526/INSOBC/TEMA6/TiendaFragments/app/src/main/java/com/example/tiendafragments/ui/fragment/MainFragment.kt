package com.example.tiendafragments.ui.fragment

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
        auth = FirebaseAuth.getInstance()
        currentUser = auth.currentUser!!
        database =
            FirebaseDatabase.getInstance("https://bmh-insobc2526-default-rtdb.europe-west1.firebasedatabase.app/")
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMainBinding.inflate(
            inflater,
            container,
            false
        )
        return binding.root
    }

    override fun onStart() {
        super.onStart()
        database.reference
            .child("users")
            .child(auth.currentUser!!.uid)
            .addChildEventListener(object : ChildEventListener{
                override fun onChildAdded(
                    snapshot: DataSnapshot,
                    previousChildName: String?
                ) {
                    Log.v("datos", snapshot.toString())
                }

                override fun onChildChanged(
                    snapshot: DataSnapshot,
                    previousChildName: String?
                ) {

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
        .addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                Log.v("datos", snapshot.toString())
                val user: User = snapshot.getValue(User::class.java)!!
                binding.textMain.text = user.nombre
            }

            override fun onCancelled(error: DatabaseError) {
            }

        })*/
        /*
        .addListenerForSingleValueEvent(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                Log.v("datos", snapshot.toString())
                val user: User = snapshot.getValue(User::class.java)!!
                binding.textMain.text = user.nombre


            }

            override fun onCancelled(error: DatabaseError) {

            }

        })*/


    }


    override fun onDetach() {
        super.onDetach()
    }
}
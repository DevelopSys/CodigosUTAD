package com.example.tiendafragments.ui.fragments

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.tiendafragments.databinding.FragmentMainBinding
import com.example.tiendafragments.databinding.FragmentRegisterBinding
import com.example.tiendafragments.model.User
import com.google.android.material.snackbar.Snackbar
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.ChildEvent
import com.google.firebase.database.ChildEventListener
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class MainFragment : Fragment() {


    private lateinit var binding: FragmentMainBinding
    private lateinit var auth: FirebaseAuth
    private lateinit var uid: String
    private lateinit var database: FirebaseDatabase
    private lateinit var userDatabase: User




    override fun onAttach(context: Context) {
        super.onAttach(context)
        auth = FirebaseAuth.getInstance()
        uid = auth.currentUser!!.uid
        database = FirebaseDatabase
            .getInstance("https://bmh-insoa2526-default-rtdb.europe-west1.firebasedatabase.app/")
        database.reference.child("users")
            // .child(uid)
            .addChildEventListener(object : ChildEventListener{
                override fun onChildAdded(
                    snapshot: DataSnapshot,
                    previousChildName: String?
                ) {
                    val user = snapshot.getValue(User::class.java)
                    Log.v("prueba",user?.nombre.toString())

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
            .addValueEventListener(object : ValueEventListener{
                override fun onDataChange(snapshot: DataSnapshot) {
                    userDatabase = snapshot.getValue(User::class.java)!!
                    Log.v("prueba",userDatabase.nombre.toString())                }

                override fun onCancelled(error: DatabaseError) {
                    TODO("Not yet implemented")
                }

            })*/

            /*.addListenerForSingleValueEvent(object : ValueEventListener
            {
                override fun onDataChange(snapshot: DataSnapshot) {
                    userDatabase = snapshot.getValue(User::class.java)!!
                    Log.v("prueba",userDatabase.nombre.toString())

                }

                override fun onCancelled(error: DatabaseError) {

                }

            })*/

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
        // binding.textMain.text = userDatabase?.nombre ?: ""

    }


    override fun onDetach() {
        super.onDetach()

    }

}

/*
Al registrar un usuario, meterlo dentro del DATASET
Al realizar login, pasar a un fragment main donde se muestra el nombre y apellido
del usuario logeado, si esta en el DS, en caso contrario mostrar un snack
 */
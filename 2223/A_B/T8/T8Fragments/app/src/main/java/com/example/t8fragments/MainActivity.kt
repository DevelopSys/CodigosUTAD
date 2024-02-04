package com.example.t8fragments

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.View.OnClickListener
import com.example.t8fragments.adapters.AdapterLenguajes
import com.example.t8fragments.databinding.ActivityMainBinding
import com.example.t8fragments.fragments.FragmentDetail
import com.example.t8fragments.fragments.FragmentList

class MainActivity : AppCompatActivity(), OnClickListener, AdapterLenguajes.OnLenguajeListener{

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.botonF1.setOnClickListener(this)
        binding.botonF2.setOnClickListener(this)
    }

    override fun onStart() {
        super.onStart()
        val ft = supportFragmentManager.beginTransaction()
        ft.setCustomAnimations(android.R.anim.fade_in,android.R.anim.fade_out)
        ft.replace(binding.sitioFragments.id,FragmentList())
        //ft.addToBackStack(null)
        ft.commit()
    }

    override fun onClick(p0: View?) {

        // FragmentManager: gestor de los fragments (decidir cual es el estado de los fragments)
        // FragmentTransaction: mueve los fragments (add,remove,replace)
        val ft = supportFragmentManager.beginTransaction()
        ft.setCustomAnimations(android.R.anim.fade_in,android.R.anim.fade_out)
        when(p0!!.id){
            binding.botonF1.id ->{
                ft.replace(binding.sitioFragments.id,FragmentList())
                // cargar fragment1 (quitar lo que hay)
            }
            binding.botonF2.id ->{
                ft.replace(binding.sitioFragments.id,FragmentDetail())
                // cargar fragment1 (quitar lo que hay)
            }
        }

        ft.commit()

    }

    override fun onLenguajeSelected(nombre: String) {
        val ft = supportFragmentManager.beginTransaction()
        ft.setCustomAnimations(android.R.anim.fade_in,android.R.anim.fade_out)
        ft.replace(binding.sitioFragments.id,FragmentDetail.newInstance(nombre))
        ft.addToBackStack(null)
        ft.commit()
    }
}
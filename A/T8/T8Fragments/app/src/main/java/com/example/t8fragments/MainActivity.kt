package com.example.t8fragments

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.View.OnClickListener
import androidx.fragment.app.FragmentManager
import com.example.t8fragments.adapters.AdaptadorLenguaje
import com.example.t8fragments.databinding.ActivityMainBinding
import com.example.t8fragments.fragments.FragmentDetail
import com.example.t8fragments.fragments.FragmentLista

class MainActivity : AppCompatActivity(), OnClickListener, AdaptadorLenguaje.OnLenguajeListener {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.botonIrF1.setOnClickListener(this)
        binding.botonIrF2.setOnClickListener(this)
    }

    override fun onResume() {
        super.onResume()
        val ft = supportFragmentManager.beginTransaction();
        ft.replace(binding.sitioFragments.id, FragmentLista())
        ft.addToBackStack("f1")
        ft.commit()
    }

    override fun onBackPressed() {
        super.onBackPressed()
        if (supportFragmentManager.backStackEntryCount==0){
            finish()
        }
    }

    // FragmentManager --> gestor de fragments
    // FragmentTransacion --> add, remove, replace
    override fun onClick(p0: View?) {

        // supportFragmentManager  // FragmentManager
        val ft = supportFragmentManager.beginTransaction();
        ft.setCustomAnimations(android.R.anim.fade_in
            , android.R.anim.fade_out)

        when(p0!!.id){
            binding.botonIrF1.id ->{
                // aparecer el F1
                ft.replace(binding.sitioFragments.id, FragmentLista())
                ft.addToBackStack("f1")
            }
            binding.botonIrF2.id ->{
                // aparecer el F2
                ft.replace(binding.sitioFragments.id, FragmentDetail())
                ft.addToBackStack("f2")
            }
        }

        ft.commit()
    }

    override fun onLenguajeSelected(nombre: String) {
        val ft = supportFragmentManager.beginTransaction();
        ft.setCustomAnimations(android.R.anim.fade_in
            , android.R.anim.fade_out)
        ft.replace(binding.sitioFragments.id, FragmentDetail.newInstance(nombre))
        ft.addToBackStack("f2")
        ft.commit()
    }
}
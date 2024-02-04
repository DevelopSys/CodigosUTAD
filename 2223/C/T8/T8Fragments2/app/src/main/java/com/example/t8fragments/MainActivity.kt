package com.example.t8fragments

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.View.OnClickListener
import com.example.t8fragments.adapters.AdaptadorLenguajes
import com.example.t8fragments.databinding.ActivityMainBinding
import com.example.t8fragments.fragments.FragmentDetail
import com.example.t8fragments.fragments.FragmentList

class MainActivity : AppCompatActivity(), OnClickListener, AdaptadorLenguajes.OnLenguajeListener {

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
        val ft = supportFragmentManager.beginTransaction()
        ft.setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out)
        ft.replace(binding.sitioFragments.id,FragmentList())
        ft.addToBackStack(null)
        ft.commit()
    }

    override fun onClick(p0: View?) {
        // FrgamentManager : gestor de fragments -> supportFragmentManager
        // FragmentTransaction: acciones de movimientos de fragments-> supportFragmentManager.beginTransaction()
        val ft = supportFragmentManager.beginTransaction()
        ft.setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out)

        // replace add remove

        when(p0!!.id){
            binding.botonIrF1.id->{
                // cambiar lo que hay en el sitioFragment por el F1
                ft.replace(binding.sitioFragments.id,FragmentList())
                ft.addToBackStack(null)
            }
            binding.botonIrF2.id->{
                // cambiar lo que hay en el sitioFragment por el F2
                ft.replace(binding.sitioFragments.id,FragmentDetail())
                ft.addToBackStack(null)
            }
        }
        ft.commit()
    }

    override fun onBackPressed() {
        super.onBackPressed()
        if (supportFragmentManager.backStackEntryCount==0){
            finish()
        }
    }

    override fun onLenguajeSelected(nombre: String) {
        val ft = supportFragmentManager.beginTransaction()
        ft.setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out)
        ft.replace(binding.sitioFragments.id,FragmentDetail.newInstance(nombre))
        ft.addToBackStack(null)
        ft.commit()
    }
}
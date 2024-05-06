package com.example.iniciofragments

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.View.OnClickListener
import androidx.fragment.app.FragmentTransaction
import com.example.iniciofragments.databinding.ActivityMainBinding
import com.example.iniciofragments.fragments.Fragment1
import com.example.iniciofragments.fragments.Fragment2

class MainActivity : AppCompatActivity(), OnClickListener{

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.botonF1.setOnClickListener(this)
        binding.botonF2.setOnClickListener(this)
    }

    override fun onClick(v: View?) {

        val transaction: FragmentTransaction = supportFragmentManager
            .beginTransaction()
        transaction.setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out)

        when(v!!.id){
            binding.botonF1.id->{
                transaction.replace(binding.sitioFragments.id,
                    Fragment1())
            }
            binding.botonF2.id->{
                transaction.replace(binding.sitioFragments.id,
                    Fragment2())
            }
        }

        transaction.commit()
    }
}
package com.example.comunicacion.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.View.OnClickListener
import com.example.comunicacion.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity(), OnClickListener {


    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.botonLogin.setOnClickListener(this)
        binding.botonSignUp.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
      when(v!!.id){
          binding.botonLogin.id->{}
          binding.botonSignUp.id->{
              val intent = Intent(applicationContext,SignupActivity::class.java)
              startActivity(intent)
              finish()
          }
      }
    }
}
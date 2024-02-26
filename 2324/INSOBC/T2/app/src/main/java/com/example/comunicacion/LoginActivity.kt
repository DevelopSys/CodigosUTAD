package com.example.comunicacion

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

        binding.buttonSignup.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v!!.id) {
            binding.buttonSignup.id -> {
                val intent: Intent = Intent(applicationContext, SignupActivity::class.java)
                startActivity(intent)
                //finish()
            }
        }
    }


}
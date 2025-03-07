package com.example.login

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.login.databinding.ActivityMainBinding
import com.example.login.model.User
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnInicio.setOnClickListener {
            if (binding.editPass.text.isNotEmpty() && binding.editCorreo.text.isNotEmpty()) {
                // origen, destino
                // logica del login
                val intent: Intent = Intent(applicationContext, SecondActivity::class.java)
                val usuario = User(
                    correo = binding.editCorreo.text.toString(),
                    pass = binding.editPass.text.toString()
                )
                val bundle: Bundle = Bundle()
                bundle.putSerializable("user", usuario)
                intent.putExtra("data",bundle)
                startActivity(intent)
            } else {
                Snackbar.make(
                    binding.root,
                    "Alguno de los campos está vacío",
                    Snackbar.LENGTH_SHORT
                ).show()
            }

        }
    }

    override fun onStop() {
        super.onStop()
        binding.editCorreo.text.clear()
        binding.editPass.text.clear()
    }
}
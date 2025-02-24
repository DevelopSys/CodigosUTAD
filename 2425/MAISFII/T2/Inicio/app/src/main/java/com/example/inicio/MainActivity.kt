package com.example.inicio

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.inicio.databinding.ActivityMainBinding
import com.example.inicio.model.User
import com.example.inicio.ui.activity.SecondActivity

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        acciones()
        /*binding.botonSaludar.setOnClickListener {

            if (binding.editNombre.text.isEmpty()) {
                Snackbar.make(
                    binding.root,
                    "Por favor introduce datos",
                    Snackbar.LENGTH_LONG
                ).show()
            } else {
                Snackbar.make(
                    binding.root,
                    "Enhorabuena ${binding.editNombre.text.toString()}, tu primera app android completa",
                    Snackbar.LENGTH_LONG
                ).show()
            }

        }*/

    }

    private fun acciones() {
        binding.checkInicio.setOnCheckedChangeListener { _, b ->
            binding.btnLogin.isEnabled = b
        }

        binding.btnLogin.setOnClickListener {
            if (!binding.editCorreo.text.isEmpty()
                && !binding.editPass.text.isEmpty()
            ) {

                /*Log.v("datos",binding.editCorreo.text.toString())
                Log.v("datos",binding.editPass.text.toString())
                Log.v("datos",binding.checkInicio.isChecked.toString())
                Log.v("datos",binding.spinnerPerfil.selectedItem.toString())*/
                val user =
                    User(
                        binding.editCorreo.text.toString(),
                        binding.editPass.text.toString(),
                        binding.spinnerPerfil.selectedItem.toString()
                    )

                val bundle: Bundle = Bundle()
                bundle.putSerializable("user",user)
                // cambio pantalla
                val intent = Intent(applicationContext, SecondActivity::class.java)
                intent.putExtra("datos",bundle)
                startActivity(intent)
                //finish()

            } else {

            }
        }
    }

    override fun onRestart() {
        super.onRestart()
        binding.editPass.text.clear()
        binding.editCorreo.text.clear()
        binding.checkInicio.isChecked = false
    }


}
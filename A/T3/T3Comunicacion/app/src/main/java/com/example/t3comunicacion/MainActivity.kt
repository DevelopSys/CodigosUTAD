package com.example.t3comunicacion


import android.app.Notification.Action
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.t3comunicacion.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar


class MainActivity : AppCompatActivity() {

    // componentes

    private lateinit var binding: ActivityMainBinding;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.botonLogin.setOnClickListener {

            if (binding.editNombre.text.isEmpty() || binding.editPass.text.isEmpty()){
                Snackbar.make(binding.root, "Falta algún dato",Snackbar.LENGTH_SHORT).show()
            } else {
                // admin - admin
                if (binding.editNombre.text.toString().equals("admin",true)
                    && binding.editPass.text.toString().equals("admin",false)){
                    // login
                    val intent = Intent(this,SecondActivity::class.java)

                    // hay que pasar datos?
                    if (binding.chekDatos.isChecked){

                        val bundle = Bundle()
                        bundle.putString("user",binding.editNombre.text.toString())
                        bundle.putString("pass",binding.editPass.text.toString())
                        startActivity(intent, bundle)
                    } else {

                        startActivity(intent)
                    }

                } else {
                    Snackbar.make(binding.root, "Datos incorrectos",Snackbar.LENGTH_SHORT).show()
                }
            }

            binding.editNombre.text.toString()
            binding.editPass.text.toString()

            // capturar datos de los edit, comprobando disponibilidad
                // si hay disponibles
                    // pasar de pantalla
                // no hay disponibles
                    // sacar un avisor

        }

    }
}
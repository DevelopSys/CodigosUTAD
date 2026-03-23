package com.example.inicio

import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.inicio.data.DataSet
import com.example.inicio.databinding.ActivityRegistroBinding
import com.example.inicio.model.UserData
import com.google.android.material.snackbar.Snackbar

class RegistroActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRegistroBinding
    private lateinit var ageAdapter: ArrayAdapter<CharSequence>
    private lateinit var ageList: ArrayList<CharSequence>


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegistroBinding.inflate(layoutInflater)
        setContentView(binding.root)
        instances()
        initGUI()
        actions()
    }

    private fun actions() {
        binding.btnRegistro.setOnClickListener {
            // comprobar si todos los datos estan rellenos
            // guardarlos en una base de datos
            val nombre = binding.editNombre.text.toString()
            val apellido = binding.editApellido.text.toString()
            val correo = binding.editCorreo.text.toString()
            val pass = binding.editPass.text.toString()
            val ciudad = binding.editCiudad.text.toString()
            val edad = binding.spinnerEdad.selectedItem.toString().toInt()
            val user = UserData(
                nombre,
                apellido,
                correo, pass, ciudad, edad
            )
            if (DataSet.addUser(user)) {
                Snackbar.make(
                    binding.root,
                    "Usuario agregado con existo",
                    Snackbar.LENGTH_SHORT
                )
                    .show()
            } else {
                Snackbar.make(
                    binding.root,
                    "Fallo en el proceso",
                    Snackbar.LENGTH_SHORT
                )
                    .show()
            }


        }
    }

    private fun initGUI() {
        binding.spinnerEdad.adapter = ageAdapter
        ageAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

    }

    private fun instances() {
        ageList = arrayListOf()
        for (i in 18..90) {
            ageList.add(i.toString())
        }
        ageAdapter = ArrayAdapter<CharSequence>(
            applicationContext,
            android.R.layout.simple_spinner_item,
            ageList
        )

    }
}

/*

        /*
            1 -> En la pantalla de login: Si algun campos no esta rellenos -> aviso
            2 -> En la pantalla de login: Si introduzco datos
                -> si el mail/pass estan en dataSet -> navega al main pasando
                el usuario logeado
                y en la pantalla de main ponga un texto de bienvendio NOMBRE USUARIO
                -> si el mail/pass no estan en dataSet -> aviso
            3 -> En la pantalla de registro:
                -> Si se registra el usuario -> navego al login y ademas
                    -> paso el correo / mail  registrado y lo pongo en
                    los edit correspondientes
         */
 */
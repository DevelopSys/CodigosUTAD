package com.example.inicio

import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.inicio.data.DataSet
import com.example.inicio.databinding.ActivityRegistroBinding
import com.example.inicio.model.User
import com.example.inicio.model.UserData
import com.google.android.material.snackbar.Snackbar

class RegistroActivity : AppCompatActivity() {
    private lateinit var ageAdapter: ArrayAdapter<CharSequence>
    private lateinit var ageList: ArrayList<CharSequence>
    private lateinit var binding: ActivityRegistroBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegistroBinding.inflate(layoutInflater)
        setContentView(binding.root)
        instances()
        initGUI()
        actions()
    }

    private fun actions() {
        binding.btnRegistrar.setOnClickListener {
            // comprobar que todos estar rellenos ok -> si no lo estan -> salto un aviso
            val nombre = binding.editNombre.text.toString()
            val apellido = binding.editApellido.text.toString()
            val correo = binding.editCorreo.text.toString()
            val pass = binding.editPass.text.toString()
            val edad: Int = binding.spinnerEdad.selectedItem.toString().toInt()
            // creo el usuario y lo persisto
            val user: UserData = UserData(nombre, apellido, correo, pass, edad)
            // DataSet.listaUsuarios.add(user)
            if (DataSet.addUser(user)){
                getSnackbar("Usuario registrado correctamente, ¿querieres iniciar sesion?")
                    .setAction("SI"){
                        finish()
                    }
                    .show()
            } else {
                getSnackbar("Fallo en el proceso de registro").show()
            }
        }
    }

    private fun getSnackbar(message: String): Snackbar{
        return Snackbar.make(binding.root, message, Snackbar.LENGTH_LONG)
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
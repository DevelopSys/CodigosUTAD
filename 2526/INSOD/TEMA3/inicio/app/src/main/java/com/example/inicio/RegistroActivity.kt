package com.example.inicio

import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.inicio.databinding.ActivityRegistroBinding

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
            //
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
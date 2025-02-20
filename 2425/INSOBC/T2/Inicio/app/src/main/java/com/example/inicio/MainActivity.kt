package com.example.inicio

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.Spinner
import androidx.appcompat.app.AppCompatActivity
import com.example.inicio.databinding.ActivityMainBinding
import com.example.inicio.model.User


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var check: CheckBox;
    private lateinit var editPass: EditText
    private lateinit var editCorreo: EditText
    private lateinit var spinnerPerfil: Spinner
    private lateinit var butonLogin: Button;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        // setContentView(binding.root)
        setContentView(R.layout.activity_main)

        spinnerPerfil = findViewById(R.id.spinnerPerfil)
        editCorreo = findViewById(R.id.editCorreo)
        editPass = findViewById(R.id.editPass)
        check = findViewById(R.id.checkInicio)
        butonLogin = findViewById(R.id.btnLogin)

        acciones()
    }

    override fun onRestart() {
        super.onRestart()
        editCorreo.text.clear()
        editPass.text.clear()
        check.isChecked = false
    }

    private fun acciones() {

        check.setOnCheckedChangeListener { _, b ->
            butonLogin.isEnabled = b
        }

        butonLogin.setOnClickListener {
            // cambio de pantalla

            val user = User(
                editCorreo.text.toString(),
                editPass.text.toString(),
                spinnerPerfil.selectedItem.toString()
            )

            val bundle: Bundle = Bundle()
            bundle.putSerializable("user", user)
            bundle.putString("name", "Borja")

            val intent = Intent(applicationContext, SecondActivity::class.java)
            intent.putExtra("datos", bundle)

            startActivity(intent)
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)

    }
}
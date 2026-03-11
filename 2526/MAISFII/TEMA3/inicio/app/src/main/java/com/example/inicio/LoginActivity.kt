package com.example.inicio

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.inicio.databinding.ActivityLoginBinding
import com.example.inicio.model.Usuario

class LoginActivity : AppCompatActivity(){

    private lateinit var binding: ActivityLoginBinding
    private lateinit var adapterPerfiles: ArrayAdapter<CharSequence>
    private lateinit var listaPerfiles: List<CharSequence>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        instancias()
        initGUI()
        acciones()
    }

    private fun acciones() {
        binding.botonLogin.setOnClickListener {

            val mail = binding.editMail.text.toString()
            val pass = binding.editPass.text.toString()
            val perfil: String = binding.spinnerPerfil.selectedItem.toString()
            val recordar = binding.checkRecordar.isChecked

            val usuario = Usuario(mail,pass,perfil,recordar)

            val intent = Intent(applicationContext, MainActivity::class.java)
            intent.putExtra("usuario_dato",usuario)
            startActivity(intent)

        }
        binding.btnRegistrar.setOnClickListener {
            val intent = Intent(applicationContext, RegsitroActivity::class.java)
            startActivity(intent)
        }
    }

    private fun initGUI() {
        // todas las inicializaciones graficas
        binding.spinnerPerfil.adapter = adapterPerfiles
        adapterPerfiles.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
    }

    private fun instancias() {
        // todas las inicializaciones de variables
        listaPerfiles = listOf("Administrador","Usuario","Invitado")
        adapterPerfiles = ArrayAdapter<CharSequence>(applicationContext,
            android.R.layout.simple_spinner_item,listaPerfiles)
    }

    private fun vaciarDatos(){
        binding.editPass.text.clear()
        binding.editMail.text.clear()
        binding.checkRecordar.isChecked = false;
        binding.spinnerPerfil.setSelection(0)
    }

    override fun onRestart() {
        super.onRestart()
        vaciarDatos()
    }


}

/*
    1 -> En la pantalla de login: Si algun campos no esta rellenos -> aviso
    2 -> En la pantalla de login: Si introduzco datos
        -> si el mail/pass estan en dataSet -> navega al main pasando
        el usuario logeado
        y en la pantalla de main ponga un texto de bienvendio NOMBRE USUARIO
        -> si el mail/pass no estan en dataSet -> aviso
    3 -> En la pantalla de registro:
        -> Si se registra el usuario ->
            se lanza una notifiacion con accion y si le digo ok
                navego al login y ademas
                -> paso el correo / mail  registrado y lo pongo en
                los edit correspondientes
 */
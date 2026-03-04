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
En la pantalla de login:
    - En caso de tener algun edit no relleno,
        Saltar un aviso de faltan datos
    - En caso de tener todos los edit rellenos
        Si el mail y pass no son admin@admin.com admin
            Saltar un aviso de error
        En caso contrario hacer login
 */
/*
Al pulsar el boton registro
    Aparece una pantalla nueva con un formaulario para
    dar de alta un usuario:
        Nombre
        Apellido
        Correo
        Pass
        Pass verificada
        Edad (spinner 18-90)
        Boton
       Cuando le de al boton
            Si falta algun dato -> aviso
            Si las dos pass no coinciden -> aviso
            En caso contrario
                Paso a la pantalla de Login con el usuario
                    Se pone en el mail el pasado
                            en el pass el pasado
 */
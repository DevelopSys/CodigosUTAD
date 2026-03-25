package com.example.inicio
import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.inicio.databinding.ActivityLoginBinding
import com.example.inicio.model.User

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding
    private lateinit var adapterProfile: ArrayAdapter<CharSequence>
    private lateinit var listProfiles: List<CharSequence>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        instances()
        initGUI()
        actions()
    }

    private fun actions() {

        binding.botonLogin.setOnClickListener {
            val intent: Intent = Intent(applicationContext, ListaActivity::class.java)
            val mail= binding.editCorreo.text.toString()
            val pass=binding.editPass.text.toString();
            val profile = binding.spinnerPerfil.selectedItem.toString()
            val remeber = binding.checkPass.isChecked
            val user = User(mail,pass,profile,remeber)
            // intent.putExtra("user_data",user)
            startActivity(intent)
            clearData()

        }
        binding.botonRegistro.setOnClickListener {
            val intent = Intent(applicationContext, RegistroActivity::class.java)
            startActivity(intent)
        }
    }

    private fun clearData() {

        binding.editCorreo.text.clear()
        binding.editPass.text.clear()
        binding.checkPass.isChecked = false
        binding.spinnerPerfil.setSelection(0)
    }

    override fun onRestart() {
        super.onRestart()
        clearData()
    }

    private fun initGUI() {
        binding.spinnerPerfil.adapter = adapterProfile
        adapterProfile.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
    }

    private fun instances() {
        listProfiles = listOf("Administrador", "Usuario", "Invitado")
        adapterProfile = ArrayAdapter<CharSequence>(
            applicationContext,
            android.R.layout.simple_spinner_item, listProfiles
        )
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
}
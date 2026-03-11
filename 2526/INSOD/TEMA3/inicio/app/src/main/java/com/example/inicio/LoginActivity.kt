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
            val intent: Intent = Intent(applicationContext, MainActivity::class.java)
            val mail= binding.editCorreo.text.toString()
            val pass=binding.editPass.text.toString();
            val profile = binding.spinnerPerfil.selectedItem.toString()
            val remeber = binding.checkPass.isChecked
            val user = User(mail,pass,profile,remeber)
            intent.putExtra("user_data",user)
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
    En la pantalla de login
        Si pulso login
            si falta algun dato por rellenar -> aviso del error
            si todos los datos estan rellenos
                si el user/pass admin@admin.com admin-> navega
                si el user/pass no es admin@admin.com admin -> avisto del error
     */

    /*
    Si doy al boton de registro
        Nueva pantalla donde tengo un form
            Nombre
            Apellido
            Correo
            Pass
            Pass verificada
            Edad (17-99)
            Boton

            Al darle al boton puede pasar lo siguiente
                Si falta algun campo -> aviso del error
                Si las pass no coinciden -> aviso del error
                En caso contrario
                    Navego al login, pansando el usuario
                        en el campo mail -> mail
                        en el campo pass -> pass
     */
}
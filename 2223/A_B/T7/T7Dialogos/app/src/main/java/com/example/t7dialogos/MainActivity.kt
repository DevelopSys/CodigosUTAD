package com.example.t7dialogos

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.View.OnClickListener
import com.example.t7dialogos.adapter.AdaptadorProyecto
import com.example.t7dialogos.databinding.ActivityMainBinding
import com.example.t7dialogos.dialog.DialogoAdd
import com.example.t7dialogos.dialog.DialogoAyuda


// TODO 3. En el destino de los datos, implementa la interfaz
class MainActivity : AppCompatActivity(), OnClickListener, DialogoAdd.OnDialogoAddListener {

    private lateinit var binding: ActivityMainBinding
    private lateinit var adaptadorProyecto: AdaptadorProyecto;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        adaptadorProyecto = AdaptadorProyecto(applicationContext)
        setContentView(binding.root)

        // pulsacion de dos botones
        binding.botonAdd.setOnClickListener(this)
        binding.botonAyuda.setOnClickListener(this)

    }

    override fun onClick(p0: View?) {
        when(p0!!.id){
            binding.botonAdd.id ->{
                // lanzad dialogo -> por personalizado
                DialogoAdd().show(supportFragmentManager,null)
            }
            binding.botonAyuda.id ->{
                // lanzad dialogo -> por defecto
                // objeto de cuadro de diálogo
                DialogoAyuda().show(supportFragmentManager,null)
            }
        }
    }

    override fun addProyecto(nombre: String, presupuesto: Int, responsable: String) {
        // hago funcionalidad
        // Log.v("dialogo","$nombre ${presupuesto.toString()} $responsable en destino")
        // meterlos en el recycler (necesito un adaptador - vista)
        adaptadorProyecto.addProyecto(nombre)
    }
}
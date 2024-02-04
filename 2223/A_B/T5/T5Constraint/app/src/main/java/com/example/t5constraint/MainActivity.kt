package com.example.t5constraint

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import com.example.t5constraint.adapter.AdaptadorTecnologia
import com.example.t5constraint.databinding.ActivityMainBinding
import com.example.t5constraint.model.Tecnologia

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var listaTecnologia: ArrayList<Tecnologia>
    private lateinit var adaptador: ArrayAdapter<Tecnologia>
    private lateinit var adaptadorPerso: AdaptadorTecnologia

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        instancias()
        cargarTecnologias()
    }

    private fun cargarTecnologias() {
        listaTecnologia.add(Tecnologia("Kotlin","https://cms-assets.tutsplus.com/uploads/users/1499/posts/29328/preview_image/kotlin.jpg"))
        listaTecnologia.add(Tecnologia("Pyhon","https://upload.wikimedia.org/wikipedia/commons/thumb/0/0a/Python.svg/1200px-Python.svg.png"))
        listaTecnologia.add(Tecnologia("JS","https://static.javatpoint.com/images/javascript/javascript_logo.png"))
        listaTecnologia.add(Tecnologia("Angular","https://upload.wikimedia.org/wikipedia/commons/thumb/c/cf/Angular_full_color_logo.svg/1200px-Angular_full_color_logo.svg.png"))
        listaTecnologia.add(Tecnologia("React","https://www.datocms-assets.com/45470/1631110818-logo-react-js.png"))
        //adaptador.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        binding.spinnerTecnologia.adapter = adaptadorPerso;

    }

    fun instancias(){
        listaTecnologia = ArrayList()
        adaptadorPerso = AdaptadorTecnologia(listaTecnologia, applicationContext)
        //adaptador = ArrayAdapter(applicationContext,android.R.layout.simple_spinner_item, listaTecnologia)
    }
}
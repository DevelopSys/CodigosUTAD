package com.example.t5constraint

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.AdapterView.OnItemSelectedListener
import com.example.t5constraint.adapter.AdaptadorTecnologia
import com.example.t5constraint.databinding.ActivityMainBinding
import com.example.t5constraint.model.Tecnologia

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var listaTecnologias: ArrayList<Tecnologia>
    private lateinit var adaptadorTecnologia: AdaptadorTecnologia

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Crear un objeto <Tecnologia>
        // ArrayList<Tecnologia> --> los datos
        listaTecnologias = ArrayList()
        listaTecnologias.add(Tecnologia("Kotlin","https://developer.android.com/static/images/cluster-illustrations/kotlin-hero.svg.png"))
        listaTecnologias.add(Tecnologia("Python","https://upload.wikimedia.org/wikipedia/commons/thumb/0/0a/Python.svg/1200px-Python.svg.png"))
        listaTecnologias.add(Tecnologia("JS","https://static.javatpoint.com/images/javascript/javascript_logo.png"))
        listaTecnologias.add(Tecnologia("Angular","https://upload.wikimedia.org/wikipedia/commons/thumb/c/cf/Angular_full_color_logo.svg/1200px-Angular_full_color_logo.svg.png"))
        listaTecnologias.add(Tecnologia("React","https://upload.wikimedia.org/wikipedia/commons/thumb/a/a7/React-icon.svg/1200px-React-icon.svg.png"))
        // Adatpter.createFromRerource -> (string-array) --> no me vale
        // crear un xml con el aspecto de las filas
        // ArrayAdapter --> BaseAdapter
        adaptadorTecnologia = AdaptadorTecnologia(listaTecnologias,
            applicationContext)
        binding.spinnerTecnologia.adapter = adaptadorTecnologia

        //binding.spinnerTecnologia.adapter.getItem(binding.spinnerTecnologia.selectedItem)

        binding.spinnerTecnologia.onItemSelectedListener = object : OnItemSelectedListener{
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                (p0!!.adapter.getItem(p2) as Tecnologia)
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
            }

        }


    }
}
package com.example.t5constraint

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.t5constraint.adapter.AdaptadorTecnologia
import com.example.t5constraint.databinding.ActivityMainBinding
import com.example.t5constraint.model.Tecnologia

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var listaTecnologia: ArrayList<Tecnologia>
    private lateinit var adaptadorTecnologia: AdaptadorTecnologia

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // 0. tener el objeto y una lista de datos --> ArrayList (List)
        listaTecnologia = ArrayList()
        listaTecnologia.add(Tecnologia("Kotlin","https://cms-assets.tutsplus.com/uploads/users/1499/posts/29328/preview_image/kotlin.jpg"))
        listaTecnologia.add(Tecnologia("Python","https://upload.wikimedia.org/wikipedia/commons/thumb/0/0a/Python.svg/1200px-Python.svg.png"))
        listaTecnologia.add(Tecnologia("JS","https://trellat.es/wp-content/uploads/2015/02/javascript_logo.png"))
        listaTecnologia.add(Tecnologia("Angular","https://upload.wikimedia.org/wikipedia/commons/thumb/c/cf/Angular_full_color_logo.svg/1200px-Angular_full_color_logo.svg.png"))

        // 1. Adapter -> ArrayAdapter -> BaseAdapter
        adaptadorTecnologia= AdaptadorTecnologia(listaTecnologia, applicationContext)

        // 2. Spinner -> Binding
        binding.spinnerTecnologia.adapter = adaptadorTecnologia
    }
}
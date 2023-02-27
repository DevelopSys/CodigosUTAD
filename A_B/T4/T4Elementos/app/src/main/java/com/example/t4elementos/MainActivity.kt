package com.example.t4elementos

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.AdapterView.OnItemSelectedListener
import android.widget.ArrayAdapter
import android.widget.CompoundButton
import android.widget.CompoundButton.OnCheckedChangeListener
import android.widget.RadioButton
import com.example.t4elementos.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity(), OnCheckedChangeListener {

    private lateinit var binding: ActivityMainBinding
    private lateinit var adaptadorSimple: ArrayAdapter<CharSequence>
    private lateinit var listaDatos: ArrayList<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        instancias()
        personalizarSpinner()
        acciones()
    }

    fun instancias(){
        listaDatos = ArrayList()
        listaDatos.add("Opcion 1")
        listaDatos.add("Opcion 2")
        listaDatos.add("Opcion 3")
        listaDatos.add("Opcion 4")
        //adaptadorSimple = ArrayAdapter(applicationContext,android.R.layout.simple_spinner_item,listaDatos)
        adaptadorSimple = ArrayAdapter.createFromResource(applicationContext
            ,R.array.opciones,android.R.layout.simple_spinner_item)

    }

    fun personalizarSpinner(){
        // UI --> Spinner --> XML
        // Datos --> ArrayAdapter --> adaptador simple --> datos (desde recurso o desde objeto) y un layout
        binding.spinner.adapter = adaptadorSimple
        adaptadorSimple.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
    }

    fun acciones(){
        binding.botonCmoprobar.setOnClickListener {
            //Snackbar.make(binding.root, "El estado del Toggle es ${binding.toggle.isChecked}", Snackbar.LENGTH_SHORT).show()
            //binding.toggle.isChecked = !binding.toggle.isChecked
            // sacar el radio seleccionado???
            val seleccionado: RadioButton = findViewById(binding.grupoRadios.checkedRadioButtonId)
            Snackbar.make(binding.root, "El seleccionado es ${seleccionado.text}", Snackbar.LENGTH_SHORT).show()

        }

        /*binding.toggle.setOnCheckedChangeListener { compoundButton, b ->
            Snackbar.make(binding.root, "El estado del Toggle es ${b}", Snackbar.LENGTH_SHORT)
                .show()
            binding.textoToggle.text = b.toString();

        }*/
        /*binding.check.setOnCheckedChangeListener { compoundButton, b ->
            Snackbar.make(binding.root, "El estado del Checkbox es ${b}", Snackbar.LENGTH_SHORT)
                .show()
            binding.textoCheck.text = b.toString();

        }*/
        binding.check.setOnCheckedChangeListener(this)
        binding.toggle.setOnCheckedChangeListener(this)

        binding.grupoRadios.setOnCheckedChangeListener { _, i ->
            // la i es el id del elemento seleccionado
            // sacar un snackbar con el texto del radio seleccionado
            // i es el el id del RadioButton

            val radioSeleccionado: RadioButton = findViewById(i)
            binding.textoRadio.text = radioSeleccionado.text
            when(i){
                binding.radioUno.id ->{}
                binding.radioDos.id ->{}
                binding.radioTres.id ->{}
            }
        }

        binding.spinner.onItemSelectedListener = object : OnItemSelectedListener{
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {

                //listaDatos[p2]

                binding.spinner.adapter.getItem(p2).toString()
                binding.spinner.selectedItem.toString()

                Snackbar.make(binding.root,
                    "El elemento seleccionado es el ${p2}"
                    ,Snackbar.LENGTH_SHORT)
                    .show()
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
            }
        }

    }

    override fun onCheckedChanged(p0: CompoundButton?, p1: Boolean) {
        when(p0!!.id){
            binding.check.id -> {
                Snackbar.make(binding.root, "El estado del Checkbox es ${p1}", Snackbar.LENGTH_SHORT)
                    .show()
                binding.textoCheck.text = p1.toString();
            }
            binding.toggle.id -> {
                Snackbar.make(binding.root, "El estado del Toggle es ${p1}", Snackbar.LENGTH_SHORT)
                    .show()
                binding.textoToggle.text = p1.toString();
            }
        }
    }
}
package com.example.comunicacion.data

import com.example.comunicacion.R
import com.example.comunicacion.model.Marca

class DataSet {

    // aqui quiero tener la lista de todos los datos que maneja la app
    // quiero que estos datos ean capturados de forma automatica
    // no necesito tener la instancia del objeto para ejecutar un método

    companion object{
        fun getAllMarcas(): ArrayList<Marca> {
            val listaMarcas = ArrayList<Marca>()

            listaMarcas.add(Marca("Audi", R.drawable.audi, "alta"))
            listaMarcas.add(Marca("Mercedes",R.drawable.mercedes, "premium"))
            listaMarcas.add(Marca("Ford",R.drawable.ford,"normal"))
            listaMarcas.add(Marca("VW",R.drawable.vw, "alta"))

            return listaMarcas;
        }
    }

}
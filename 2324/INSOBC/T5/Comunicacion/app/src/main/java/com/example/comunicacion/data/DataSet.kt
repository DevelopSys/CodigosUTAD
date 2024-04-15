package com.example.comunicacion.data

import android.view.Display.Mode
import com.example.comunicacion.R
import com.example.comunicacion.model.Marca
import com.example.comunicacion.model.Modelo

class DataSet {

    // el conjunto de metodos que PERTENECEN a la clase (no al objeto)
    // y al llamarlos me dan el conjundo de datos
    // DataSet.metodo()
    companion object {
        fun getAllMarcas(): ArrayList<Marca> {
            val lista: ArrayList<Marca> = ArrayList()
            lista.add(Marca("Mercedes", "Premium", R.drawable.mercedes))
            lista.add(Marca("Audi", "Premium", R.drawable.audi))
            lista.add(Marca("VW", "Alta", R.drawable.vw))
            lista.add(Marca("Ford", "Normal", R.drawable.ford))
            return lista
        }

        fun getAllModelos(marca: String): List<Modelo> {

            val lista = ArrayList<Modelo>()
            lista.add(Modelo("Mercedes", "C220", 60000.0, 300, R.drawable.vw))
            lista.add(Modelo("Mercedes", "GLC", 80000.0, 450, R.drawable.vw))
            lista.add(Modelo("Audi", "A8", 100000.0, 500, R.drawable.vw))
            lista.add(Modelo("Audi", "E-Tron", 120000.0, 400, R.drawable.vw))
            lista.add(Modelo("Ford", "Mustang", 60000.0, 300, R.drawable.vw))
            lista.add(Modelo("Ford", "Focus", 30000.0, 200, R.drawable.vw))
            lista.add(Modelo("VW", "Arteon", 60000.0, 300, R.drawable.vw))
            lista.add(Modelo("VW", "TROC", 50000.0, 200, R.drawable.vw))

            return lista.filter {
                return@filter it.marca.equals(marca)
            }
        }
    }

}
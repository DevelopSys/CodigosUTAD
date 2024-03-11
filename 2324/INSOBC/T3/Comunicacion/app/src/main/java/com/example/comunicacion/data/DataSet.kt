package com.example.comunicacion.data

import com.example.comunicacion.R
import com.example.comunicacion.model.Marca

class DataSet {

    // el conjunto de metodos que PERTENECEN a la clase (no al objeto)
    // y al llamarlos me dan el conjundo de datos
    // DataSet.metodo()
    companion object{
        fun getAllMarcas(): ArrayList<Marca> {

            val lista: ArrayList<Marca> = ArrayList()
            lista.add(Marca("Mercedes","Premium", R.drawable.mercedes))
            lista.add(Marca("Audi","Premium", R.drawable.audi))
            lista.add(Marca("VW","Alta", R.drawable.vw))
            lista.add(Marca("Ford","Normal", R.drawable.ford))
            return lista
        }
    }

}
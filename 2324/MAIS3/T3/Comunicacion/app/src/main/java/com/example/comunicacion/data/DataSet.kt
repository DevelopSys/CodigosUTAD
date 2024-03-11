package com.example.comunicacion.data

import com.example.comunicacion.R
import com.example.comunicacion.model.Marca

class DataSet {

    // conjunto de datos, accedido de forma directa
    // los metodos que aqui voy a crear no pertenecen al objeto
    // pertenecen a la clase
    // DataSet.metodo() -> static

    companion object{
        fun getAllMarcas(): ArrayList<Marca> {

            val listaMarcar = ArrayList<Marca>()

            listaMarcar.add(Marca("Mercedes","premium", R.drawable.mercedes))
            listaMarcar.add(Marca("Audi","premium", R.drawable.audi))
            listaMarcar.add(Marca("VW","alta", R.drawable.vw))
            listaMarcar.add(Marca("Ford","normal", R.drawable.ford))

            return listaMarcar

        }
    }

}
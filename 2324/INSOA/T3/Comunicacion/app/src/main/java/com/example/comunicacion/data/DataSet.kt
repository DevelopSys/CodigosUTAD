package com.example.comunicacion.data

import com.example.comunicacion.R
import com.example.comunicacion.model.Marca
import com.example.comunicacion.model.Modelo

class DataSet {

    // aqui quiero tener la lista de todos los datos que maneja la app
    // quiero que estos datos ean capturados de forma automatica
    // no necesito tener la instancia del objeto para ejecutar un método

    companion object {
        fun getAllMarcas(): ArrayList<Marca> {
            val listaMarcas = ArrayList<Marca>()

            listaMarcas.add(Marca("Audi", R.drawable.audi, "alta"))
            listaMarcas.add(Marca("Mercedes", R.drawable.mercedes, "premium"))
            listaMarcas.add(Marca("Ford", R.drawable.ford, "normal"))
            listaMarcas.add(Marca("VW", R.drawable.vw, "alta"))

            return listaMarcas;
        }

        fun getAllModelos(marca: String): ArrayList<Modelo> {

            val listaModelos = ArrayList<Modelo>();

            listaModelos.add(
                Modelo(
                    "Mercedes", "C220", 300, 70000.0,
                    R.drawable.mercedes
                )
            )
            listaModelos.add(
                Modelo(
                    "Mercedes", "C220", 400, 80000.0,
                    R.drawable.mercedes
                )
            )
            listaModelos.add(
                Modelo(
                    "Audi", "A8", 300, 75000.0,
                    R.drawable.mercedes
                )
            )
            listaModelos.add(
                Modelo(
                    "Audi", "ETron", 400, 90000.0,
                    R.drawable.mercedes
                )
            )
            listaModelos.add(
                Modelo(
                    "Ford", "Mustang", 500, 60000.0,
                    R.drawable.mercedes
                )
            )
            listaModelos.add(
                Modelo(
                    "Ford", "Focus", 200, 30000.0,
                    R.drawable.mercedes
                )
            )
            listaModelos.add(
                Modelo(
                    "VW", "Arteon", 300, 40000.0,
                    R.drawable.mercedes
                )
            )
            listaModelos.add(
                Modelo(
                    "VW", "TROC", 200, 50000.0,
                    R.drawable.mercedes
                )
            )


            return listaModelos.filter {
                return@filter it.marca.equals(marca)
            } as ArrayList<Modelo>

        }
    }

}
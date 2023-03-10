package com.example.t5constraint.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.example.t5constraint.R
import com.example.t5constraint.model.Tecnologia

class AdaptadorTecnologia(
    var listaTecnologia: ArrayList<Tecnologia>, var context: Context
) : BaseAdapter() {
    override fun getCount(): Int {
        // cantidad de la lista
        return listaTecnologia.size
    }

    override fun getItem(p0: Int): Any {
        // el objeto de una posicion de la lista
        return listaTecnologia[p0]
    }

    override fun getItemId(p0: Int): Long {
        // el long asociado a un elemento
        return p0.toLong()
    }

    override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
        // pinta cada una de las filas con el elemento concreto
        // metodo ejecutado tantas veecs como elemento en la lista tenga

        val teclogiaTemp = listaTecnologia[p0]
        val vista: View = LayoutInflater.from(context)
            .inflate(R.layout.item_tecnologia,p2, false)
        val imagen: ImageView = vista.findViewById(R.id.imagen_tecnologia)
        val nombre: TextView = vista.findViewById(R.id.nombre_tecnologia)

        //Glide.with(context).load(teclogiaTemp.imagen).into(imagen)
        nombre.text = teclogiaTemp.nombre;


        return vista

    }
}
package com.example.t5constraint.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.example.t5constraint.R
import com.example.t5constraint.model.Tecnologia

class AdaptadorTecnologia(var listaTecnologias: ArrayList<Tecnologia>, var context: Context) :
    BaseAdapter() {
    override fun getCount(): Int {
        // retornar el tamaño de la lista de elementos a representar
        return listaTecnologias.size
    }

    override fun getItem(p0: Int): Tecnologia {
        // retornar el elemento (any) de la lista en la posicion p0
        return listaTecnologias[p0]
    }

    override fun getItemId(p0: Int): Long {
        // retornar el id del elemento de la lista en la posicion p0
        return p0.toLong()

    }

    override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
        // retornar la vista (el xml) con los datos del elemento de la lista
        // de la posicion p0

        val vista: View = LayoutInflater.from(context).inflate(
            R.layout.item_tecnologia, p2, false
        )

        val tecnologiaTemp = listaTecnologias[p0]
        val nombreTextView: TextView = vista.findViewById(R.id.nombre_tecnologia)
        val imagenImageView: ImageView = vista.findViewById(R.id.imagen_tecnologia)

        Glide.with(context).load(tecnologiaTemp.imagen).into(imagenImageView)
        nombreTextView.text = tecnologiaTemp.nombre

        return vista
    }


}
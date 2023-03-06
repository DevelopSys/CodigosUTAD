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

class AdaptadorTecnologia(var listaElementos: ArrayList<Tecnologia>,
                          var context: Context): BaseAdapter() {
    override fun getCount(): Int {
        return listaElementos.size
    }

    override fun getItem(p0: Int): Tecnologia {
        return listaElementos[p0]
    }

    override fun getItemId(p0: Int): Long {
        return p0.toLong()
    }

    override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
        // renderiza el elemento en una posición con su xml correspondiente

        val vista: View = LayoutInflater.from(context).inflate(R.layout.item_tecnologia,p2,false)
        val imagen: ImageView = vista.findViewById(R.id.imagen_tecnologia)
        val nombre: TextView = vista.findViewById(R.id.nombre_tecnologia)
        val tecnologia = listaElementos[p0]
        Glide.with(context).load(tecnologia.imagen).into(imagen)
        nombre.text = tecnologia.nombre

        return vista
    }
}
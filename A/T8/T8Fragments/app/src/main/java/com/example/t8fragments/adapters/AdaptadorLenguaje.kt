package com.example.t8fragments.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.t8fragments.R

class AdaptadorLenguaje(var listaLenguejs: ArrayList<String>, var context: Context): RecyclerView.Adapter<AdaptadorLenguaje.MyHolder>()  {

    var listener: OnLenguajeListener;

    inner class MyHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var textViewNombre: TextView
        init {
            textViewNombre = itemView.findViewById(R.id.nombre_lenguaje)
        }
    }

    init {
        listener = context as OnLenguajeListener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_recycler,parent,false)
        return  MyHolder(view)
    }

    override fun getItemCount(): Int {
        return listaLenguejs.size
    }

    override fun onBindViewHolder(holder: MyHolder, position: Int) {
        val lenguaje = listaLenguejs[position]
        holder.textViewNombre.text = lenguaje
        holder.textViewNombre.setOnClickListener {
            listener.onLenguajeSelected(lenguaje)
        }
    }

    interface OnLenguajeListener{
        fun onLenguajeSelected(nombre: String )
    }

}
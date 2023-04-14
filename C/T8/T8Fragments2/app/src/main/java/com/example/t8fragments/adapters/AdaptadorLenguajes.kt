package com.example.t8fragments.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.t8fragments.R

class AdaptadorLenguajes(var listaLenguajes: ArrayList<String>, var context: Context): RecyclerView.Adapter<AdaptadorLenguajes.MyHolder>() {

    private lateinit var listener: OnLenguajeListener

    init {
        listener = context as OnLenguajeListener
    }

    inner class MyHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var textViewNombre: TextView

        init {
            textViewNombre = itemView.findViewById(R.id.nombre_lenguaje);
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_recycler,parent,false)
        return MyHolder(view)
    }

    override fun getItemCount(): Int {
        return listaLenguajes.size
    }

    override fun onBindViewHolder(holder: MyHolder, position: Int) {
        val lenguaje = listaLenguajes[position]
        holder.textViewNombre.text = lenguaje
        holder.textViewNombre.setOnClickListener {
            // ejecuto cambio de fragment
            listener.onLenguajeSelected(lenguaje)
        }
    }

    interface OnLenguajeListener{
        fun onLenguajeSelected(nombre: String)
    }
}
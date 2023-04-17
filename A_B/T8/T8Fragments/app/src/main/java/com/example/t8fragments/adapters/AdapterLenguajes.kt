package com.example.t8fragments.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.t8fragments.R

class AdapterLenguajes (var lista: ArrayList<String>, var context: Context): RecyclerView.Adapter<AdapterLenguajes.MyHolder>() {

    private lateinit var listener: OnLenguajeListener

    init {
        listener = context as OnLenguajeListener;
    }

    inner class MyHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        // declarar cada uno de los elementos de la UI
        var textoNombre: TextView

        init {
            textoNombre = itemView.findViewById(R.id.nombre_lenguaje)
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder {
        val view: View = LayoutInflater.from(context)
            .inflate(R.layout.item_recyckler,parent,false)
        return MyHolder(view);
    }

    override fun getItemCount(): Int {
        return lista.size
    }

    override fun onBindViewHolder(holder: MyHolder, position: Int) {
        val lenguaje: String = lista[position]
        holder.textoNombre.text = lenguaje;
        holder.textoNombre.setOnClickListener {
            // cambiar el fragment por el de detalle
            listener.onLenguajeSelected(lenguaje)
        }
    }

    interface OnLenguajeListener{
        fun onLenguajeSelected(nombre: String)
    }

}
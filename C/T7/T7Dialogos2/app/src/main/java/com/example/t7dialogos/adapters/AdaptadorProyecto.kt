package com.example.t7dialogos.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.t7dialogos.R

class AdaptadorProyecto(var context: Context) :
    RecyclerView.Adapter<AdaptadorProyecto.MyHolder>() {
    var listaProyecto: ArrayList<String>;

    init {
        listaProyecto = ArrayList()
    }

    class MyHolder(itemView: View) : ViewHolder(itemView) {
        var nombreProyecto: TextView

        init {
            nombreProyecto = itemView.findViewById(R.id.texto_proyecto)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder {
        val vista: View = LayoutInflater.from(context)
            .inflate(R.layout.item_recycler, parent, false)
        return MyHolder(vista)
    }

    override fun getItemCount(): Int {
        return listaProyecto.size
    }

    override fun onBindViewHolder(holder: MyHolder, position: Int) {
        holder.nombreProyecto.text = listaProyecto[position]
    }

    fun addProyecto(nombre: String, responsable: String, presupuesto: Int) {
        this.listaProyecto.add(nombre)
        notifyItemInserted(listaProyecto.size - 1)
        // this.notifyDataSetChanged()
    }

    fun removeProyecto(posicion: Int) {
        this.listaProyecto.removeAt(posicion)
        notifyItemRemoved(posicion)
        //notifyItemInserted(listaProyecto.size-1)
        // this.notifyDataSetChanged()
    }

}
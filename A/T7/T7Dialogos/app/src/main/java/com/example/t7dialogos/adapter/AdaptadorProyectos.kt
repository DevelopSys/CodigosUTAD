package com.example.t6recycler.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.TextureView
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.t7dialogos.R

import com.google.android.material.snackbar.Snackbar

class AdaptadorProyectos(var context: Context) : RecyclerView.Adapter<AdaptadorProyectos.MyHolder>() {

    var listaProyectos: ArrayList<String>

    init {
        listaProyectos = ArrayList();
    }

    // Holder --> template
    class MyHolder(itemView: View) : ViewHolder(itemView) {
       var nombreTextView: TextView

        init {
            nombreTextView = itemView.findViewById(R.id.text_responable)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder {
        // retorna la plantilla (Holder creado)
        val vista: View = LayoutInflater.from(context).inflate(R.layout.item_recycler,parent,false)
        return MyHolder(vista)
    }

    override fun getItemCount(): Int {
        // retorna el tamaño del arraylist --> el n de filas que se renderizaran
        return listaProyectos.size
    }

    fun addProyecto(nombre: String, responsable: String, presupuesto: Int){
        listaProyectos.add(nombre)
        //notifyDataSetChanged()
        notifyItemInserted(listaProyectos.size-1)
    }

    override fun onBindViewHolder(holder: MyHolder, position: Int) {
        // junta la plantilla con el dato de la lista (en un posicion)
        // sacar el dato de la posicion
        holder.nombreTextView.text = listaProyectos[position]
    }

}
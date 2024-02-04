package com.example.t7dialogos.adapter

import android.content.Context
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class AdaptadorProyecto(var contexto: Context): RecyclerView.Adapter<AdaptadorProyecto.MyHolder>() {

    private var listaProyectos: ArrayList<Any>

    init {
        listaProyectos = ArrayList()
    }

    class MyHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int {
        return listaProyectos.size
    }

    override fun onBindViewHolder(holder: MyHolder, position: Int) {
        TODO("Not yet implemented")
    }

    fun addProyecto(nombre: String){
        listaProyectos.add(nombre)
        //notifyDataSetChanged()
        notifyItemInserted(listaProyectos.size-1)
    }
}
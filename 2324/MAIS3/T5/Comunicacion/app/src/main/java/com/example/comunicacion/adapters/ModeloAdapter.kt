package com.example.comunicacion.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.comunicacion.R
import com.example.comunicacion.model.Modelo

class ModeloAdapter(var listaDatos: ArrayList<Modelo>, var context: Context) :
    RecyclerView.Adapter<ModeloAdapter.MyHolder>() {

    class MyHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var imagen: ImageView = itemView.findViewById(R.id.imagenFila)
        var titulo: TextView = itemView.findViewById(R.id.tituloFila)
        var subTitulo: TextView = itemView.findViewById(R.id.subtituloFila)

    }

    // crear la plantilla de cada fila
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder {
        val view: View = LayoutInflater.from(context)
            .inflate(R.layout.item_recycler, parent, false)
        return MyHolder(view)
    }

    // numero de elementos - filas que se tienen que pintar
    // TODO necesitare una lista de elementos!!
    override fun getItemCount(): Int {
        return listaDatos.size
    }

    // asociar datos con plantilla
    override fun onBindViewHolder(holder: MyHolder, position: Int) {

        val item: Modelo = listaDatos[position]
        holder.titulo.setText(item.modelo)
        holder.subTitulo.setText(item.marca)
        holder.imagen.setImageResource(item.imagen)

    }

    fun getListaModelos(lista: ArrayList<Modelo>){
        this.listaDatos = lista;
        notifyDataSetChanged()
    }
}
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

class AdaptadorModelo(var lista: List<Modelo>, var context: Context) :
    RecyclerView.Adapter<AdaptadorModelo.MyHolder>() {

    class MyHolder(view: View) : RecyclerView.ViewHolder(view) {
        var imagen: ImageView = view.findViewById(R.id.imagenFila)
        var titulo: TextView = view.findViewById(R.id.tituloFila)
        var subTitulo: TextView = view.findViewById(R.id.subtituloFila)
    }

    // crear la plantilla
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder {

        val vista: View =
            LayoutInflater.from(context).inflate(R.layout.item_recycler, parent, false)
        return MyHolder(vista)
    }

    // cuantas filas tienes que renderizar
    override fun getItemCount(): Int {
        return lista.size
    }

    // asociar plantillas con datos
    override fun onBindViewHolder(holder: MyHolder, position: Int) {
        val modelo = lista[position]
        holder.titulo.text =  modelo.modelo
        holder.subTitulo.setText(modelo.marca)
        holder.imagen.setImageResource(modelo.imagen)
    }

    fun cambiarLista(lista: List<Modelo>){
        this.lista = lista;
        notifyDataSetChanged()
    }

    fun addModelo(modelo: Modelo){
        (this.lista as ArrayList).add(modelo)
        notifyItemInserted(lista.size-1)
    }
}
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
import com.bumptech.glide.Glide
import com.example.t6recycler.R
import com.example.t6recycler.model.Juego
import com.google.android.material.snackbar.Snackbar

class AdaptadorJuego(var listaJuegos: ArrayList<Juego>, var context: Context) : RecyclerView.Adapter<AdaptadorJuego.MyHolder>() {

    // Holder --> template
    class MyHolder(itemView: View) : ViewHolder(itemView) {
        var nombreTextView: TextView
        var detalleTextView: TextView
        var imagenImageView: ImageView

        init {
            nombreTextView = itemView.findViewById(R.id.nombre_recycler)
            detalleTextView = itemView.findViewById(R.id.detalle_recycler)
            imagenImageView = itemView.findViewById(R.id.imagen_recycler)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder {
        // retorna la plantilla (Holder creado)
        val vista: View = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_recycler,parent,false)
        return MyHolder(vista)
    }

    override fun getItemCount(): Int {
        // retorna el tamaño del arraylist --> el n de filas que se renderizaran
        return listaJuegos.size
    }

    override fun onBindViewHolder(holder: MyHolder, position: Int) {
        // junta la plantilla con el dato de la lista (en un posicion)
        // sacar el dato de la posicion
        val dato = listaJuegos[position]
        holder.nombreTextView.text = dato.nombre
        holder.detalleTextView.text = dato.anioDesarrollo.toString()
        Glide.with(context).load(dato.imagen).into(holder.imagenImageView)
        holder.imagenImageView.setOnClickListener{
            Snackbar.make(holder.imagenImageView,dato.genero,Snackbar.LENGTH_SHORT).show()
        }
    }

}
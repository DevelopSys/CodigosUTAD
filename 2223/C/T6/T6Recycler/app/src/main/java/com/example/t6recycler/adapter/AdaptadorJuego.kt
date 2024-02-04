package com.example.t6recycler.adapter

import android.content.Context
import android.view.LayoutInflater
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

    class MyHolder(itemView: View) : ViewHolder(itemView) {
        // template --> aspecto del XML
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
        // creará la plantilla y la retorna, necesitando el XML
        val view: View = LayoutInflater.from(context).inflate(R.layout.item_recycler,parent,
            false)
        return MyHolder(view)
    }

    override fun getItemCount(): Int {
        // tamaño de la lista de elementos a mostrar <Juegos>
        return listaJuegos.size
    }

    override fun onBindViewHolder(holder: MyHolder, position: Int) {
        // enlaza la plantilla con el elemento de la posicion
        val dato = listaJuegos[position]
        holder.nombreTextView.text =  dato.nombre
        holder.detalleTextView.text = dato.anioDesarrollo.toString()
        Glide.with(context).load(dato.imagen)
            .into(holder.imagenImageView)

        holder.imagenImageView.setOnClickListener {
            Snackbar.make(holder.imagenImageView,
                dato.genero, Snackbar.LENGTH_SHORT).show()
        }

    //dato.imagen
    }


}
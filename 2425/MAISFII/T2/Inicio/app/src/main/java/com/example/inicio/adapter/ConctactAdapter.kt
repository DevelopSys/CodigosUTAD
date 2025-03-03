package com.example.inicio.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toolbar
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.Glide
import com.example.inicio.R
import com.example.inicio.model.Contact

class ConctactAdapter(var lista: List<Contact>, var context: Context) :
    RecyclerView.Adapter<ConctactAdapter.MyHolder>() {
    inner class MyHolder(itemView: View) : ViewHolder(itemView) {
        // representa el patron con la extraccion de cada uno de
        // los elementos del XML
        val imagen = itemView.findViewById<ImageView>(R.id.imagenCard)
        val texto: TextView = itemView.findViewById(R.id.phoneCard)
        val toolbar: androidx.appcompat.widget.Toolbar = itemView.findViewById(R.id.toolbarCard)
        val card: CardView = itemView.findViewById(R.id.cardContact)

        // TODO asociar un menu a cada carta
        // en este menu tenemos un item de ver detalle
        // al pulsarlo se cambia a una pantalla de detalle
        // mostrando todos los datelles del contacto
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder {
        // retonar una clase anidada con la estructura del patron
        val vista: View = LayoutInflater.from(context).inflate(
            R.layout.item_recycler, parent, false
        )
        return MyHolder(vista)
    }

    override fun getItemCount(): Int {
        // retorna cuantos elementos se pintaran
        return this.lista.size
    }

    override fun onBindViewHolder(holder: MyHolder, position: Int) {
        // con el patron y la posicion dada
        // asociar el patron con los datos
        // ejecutado tantas veces como getItemCount
        val contact = lista[position]
        holder.toolbar.title = contact.nombre
        holder.texto.text = contact.telefono.toString()
        Glide.with(context).load(contact.imagen)
            .placeholder(R.drawable.base)
            .into(holder.imagen)
        holder.card.setOnClickListener {
            val intent: Intent()
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            context.startActivity(intent)
        }


    }
}
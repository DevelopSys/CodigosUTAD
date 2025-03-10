package com.example.inicio.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.Glide
import com.example.inicio.R
import com.example.inicio.model.Contact
import com.example.inicio.model.ContactJSON

class ContactAdapter(var lista: List<ContactJSON>, var context: Context) :
    RecyclerView.Adapter<ContactAdapter.MyHolder>() {
    inner class MyHolder(itemView: View) : ViewHolder(itemView) {
        // representa el patron de cada una de las filas -> XML
        // la extraccion de cada uno de los elementos del patron
        // TODO poner la imagen via CDN
        val imagen = itemView.findViewById<ImageView>(R.id.imageCard)
        val toolbar: Toolbar = itemView.findViewById(R.id.toolbarCard)
        val textPhone: TextView = itemView.findViewById(R.id.textCard)

        // TODO poner un menu en cada toolbar
        init {
            toolbar.inflateMenu(R.menu.contact_menu)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder {
        // obtener el item_recycler de alguna forma para poder retornar el holder
        val vista: View = LayoutInflater.from(context)
            .inflate(R.layout.item_recycler, parent, false)
        return MyHolder(vista)
    }

    override fun getItemCount(): Int {
        // cuantos elementos tengo -> cuantas filas se renderizan
        return lista.size
    }

    override fun onBindViewHolder(holder: MyHolder, position: Int) {
        // asociar parte grafica (holder) con los datos (el que le toca)
        val contact = lista[position]

        holder.toolbar.title = contact.firstName + " " + contact.lastName
        holder.textPhone.text = contact.phone.toString()
        Glide.with(context).load(contact.image)
            .placeholder(R.drawable.base).into(holder.imagen)
    }

    fun addConctact(contact: ContactJSON) {
        // quiero add, sin cambiar la lista en el constructor
        (lista as ArrayList).add(contact)
        notifyItemInserted(lista.size - 1)
    }
}
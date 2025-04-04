package com.example.agenda.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Recycler
import com.bumptech.glide.Glide
import com.example.agenda.R
import com.example.agenda.model.Contact
import com.google.android.material.snackbar.Snackbar

class AgendaAdapter(var context: Context, var lista: ArrayList<Contact>) :
    RecyclerView.Adapter<AgendaAdapter.MyHolder>() {

    inner class MyHolder(item: View) : RecyclerView.ViewHolder(item) {
        val textoNombre: TextView = item.findViewById(R.id.nombreRecycler)
        val textoTelefono: TextView = item.findViewById(R.id.telefonoRecycler)
        val imagenContacto: ImageView = item.findViewById(R.id.imagenRecycler)
        val layout: ConstraintLayout = item.findViewById(R.id.layoutGeneral)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder {
        val view = LayoutInflater.from(context).inflate(
            R.layout.item_recycler, parent, false
        )
        return MyHolder(view)
    }

    override fun getItemCount(): Int {
        return this.lista.size
    }

    override fun onBindViewHolder(holder: MyHolder, position: Int) {
        val contacto: Contact = lista[position]
        holder.textoNombre.text = contacto.nombre
        holder.textoTelefono.text = contacto.telefono.toString()
        Glide.with(context).load(contacto.imagen).placeholder(R.drawable.user)
            .into(holder.imagenContacto)

        /*holder.textoNombre.setOnClickListener {
            Snackbar.make(holder.textoNombre, "Has pulsado el nombre el cual es: ${contacto.nombre}", Snackbar.LENGTH_SHORT).show()
        }
        holder.textoTelefono.setOnClickListener {
            Snackbar.make(holder.textoNombre, "Has pulsado el telefono el cual es: ${contacto.telefono}", Snackbar.LENGTH_SHORT).show()
        }*/

        holder.layout.setOnClickListener {
            Snackbar. make(holder.textoNombre, "Has pulsado la fila completa del contacto: ${contacto.nombre}", Snackbar.LENGTH_SHORT).show()
        }
    }
}
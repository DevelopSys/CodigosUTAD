package com.example.comunicacion.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.comunicacion.R
import com.example.comunicacion.model.Modelo
import com.example.comunicacion.model.Producto

class AdaptadorProducto(var context: Context) :
    RecyclerView.Adapter<AdaptadorProducto.MyHolder>() {

    val lista: ArrayList<Producto> = ArrayList()

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

        val producto: Producto = lista[position]
        holder.titulo.text = producto.title
        holder.subTitulo.setText(producto.price.toString());
        //holder.imagen.setImageResource(producto.thumbnail);
        Glide.with(context).load(producto.thumbnail)
            .placeholder(R.drawable.vw)
            .into(holder.imagen)
    }

    fun addProducto(x: Producto) {
        lista.add(x)
        //notifyDataSetChanged()
        notifyItemInserted(lista.size - 1)
    }
}
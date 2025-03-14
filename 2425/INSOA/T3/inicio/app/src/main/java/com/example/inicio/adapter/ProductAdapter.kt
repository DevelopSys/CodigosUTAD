package com.example.inicio.adapter

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
import com.example.inicio.model.Product
import com.example.inicio.model.ProductV2

class ProductAdapter(var context: Context) : RecyclerView.Adapter<ProductAdapter.MyHolder>() {

    private lateinit var lista: List<ProductV2>

    init {
        lista = arrayListOf()
    }

    inner class MyHolder(itemView: View) : ViewHolder(itemView) {
        // itemView -> el xml que representa el elemento grafico de la fila
        // extraer cada uno de los elementos del XML
        val imagen = itemView.findViewById<ImageView>(R.id.imagenFila);
        val titulo: TextView = itemView.findViewById(R.id.textTitulo);
        val precio: TextView = itemView.findViewById(R.id.textPrecio);
        val toolbar: Toolbar = itemView.findViewById(R.id.toolbar);

        init {

            toolbar.inflateMenu(R.menu.menu_product)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):
            MyHolder {
        // crea el patron de las filas
        val vista: View = LayoutInflater.from(context)
            .inflate(R.layout.item_recycler, parent, false)
        return MyHolder(vista)
    }

    override fun getItemCount(): Int {
        // indica cuantos elementos hay en la lista
        return lista.size
    }

    override fun onBindViewHolder(holder: MyHolder, position: Int) {
        // asocia el dato en una posicion al holde
        // tantas como size
        val product: ProductV2 = lista[position]

        holder.titulo.text = product.title
        holder.precio.text = product.price.toString()
        // holder.imagen.setImageResource()
        Glide.with(context)
            .load(product.thumbnail)
            .placeholder(R.drawable.base)
            .into(holder.imagen)

    }

    fun addProduct(x: ProductV2) {
        (this.lista as ArrayList).add(x)
        notifyItemInserted(lista.size - 1)
    }

}
package com.example.inicio.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.inicio.R
import com.example.inicio.databinding.ItemProductoBinding
import com.example.inicio.model.Product
import com.example.inicio.model.ProductJSON
import kotlin.random.Random

// 1- extiendo de Recycler.Adater
// 3- Tipo el adapter con la clase anidada
// 4- implmento dos los metodos de la clase
// 5- por constructor pasa todos los parametros que son necesarios
class ProductoAdapter(var context: Context) :
    RecyclerView.Adapter<ProductoAdapter.MyHolder>() {
    // 2 - creo clase anidada inner : RecycerView.ViewHolder
    val lista: ArrayList<ProductJSON> = ArrayList()

    inner class MyHolder(var binding: ItemProductoBinding) : RecyclerView.ViewHolder(binding.root)

    // crea la plantilla de las filas
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MyHolder {
        val binding = ItemProductoBinding.inflate(
            LayoutInflater.from(context), parent, false
        )
        val holder = MyHolder(binding)

        return holder
    }

    // enlaza la plantilla con el dato en una posicion
    override fun onBindViewHolder(
        holder: MyHolder,
        position: Int
    ) {
        val product = lista[position]
        holder.binding.nombreProducto.text = product.title
        // holder.binding.imagenProducto.setImageResource(R.drawable.imgdefault)
        // TODO pendiente pintar la imagen con Glide
        Glide.with(context)
            .load(product.thumbnail)
            .placeholder(R.drawable.imgdefault)
            .into(holder.binding.imagenProducto)
        // TODO pendiente de decir como funcionan los botones
        // TODO pendiente de indicar la logica de cada fila

    }

    // cuantos elementos tiene la lista de "cosas" a renderiza
    override fun getItemCount(): Int {
        return lista.size
    }

    fun addProduct(productJSON: ProductJSON) {
        this.lista.add(productJSON)
        notifyItemInserted(lista.size - 1)
    }


}
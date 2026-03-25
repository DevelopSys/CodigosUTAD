package com.example.inicio.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.inicio.R
import com.example.inicio.databinding.ItemProductoBinding
import com.example.inicio.model.Product
import com.example.inicio.model.ProductDATA

class ProductAdapter(var context: Context) :
    RecyclerView.Adapter<ProductAdapter.ProductHolder>() {

    private val list = ArrayList<Product>()

    inner class ProductHolder(var binding: ItemProductoBinding) :
        RecyclerView.ViewHolder(binding.root)

    // crea la plantilla
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ProductHolder {

        val binding: ItemProductoBinding = ItemProductoBinding.inflate(
            LayoutInflater.from(context),
            parent,
            false
        )
        return ProductHolder(binding)
    }

    // asocia la plantilla con un elemento ubicado en una posicion
    override fun onBindViewHolder(
        holder: ProductHolder,
        position: Int
    ) {
        val product: Product = list[position]
        holder.binding.textoProducto.text = product.title
        // TODO gestionar logica de elementos
        // TODO gestionar eventos de elementos
        // TODO poner imagen
        Glide.with(context)
            .load(product.thumbnail)
            .placeholder(R.drawable.image_def)
            .into(holder.binding.imagenProducto)
        // holder.binding.imagenProducto.setImageResource()
        // Al pulsar el boton de ver detalle, se pasa de pantalla y se muestran los detalles del producto seleccionado
    }

    // cuantos items tiene la lista que quires renderizar
    override fun getItemCount(): Int {
        return list.size
    }

    fun addProduct(product: Product) {
        list.add(product)
        // notifyDataSetChanged()
        notifyItemInserted(list.size - 1)

    }


}
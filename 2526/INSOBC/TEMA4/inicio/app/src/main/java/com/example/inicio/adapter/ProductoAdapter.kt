package com.example.inicio.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.inicio.R
import com.example.inicio.databinding.ItemProductoBinding
import com.example.inicio.model.Product
import com.example.inicio.model.ProductJSON

// 2. Tipa el Adapter con la clase anidada
// 3. Defino todos los elementos que son necesarios en el construtor
class ProductoAdapter(
    var context: Context
) :
    RecyclerView.Adapter<ProductoAdapter.MyHolder>() {

        val list: ArrayList<ProductJSON> = ArrayList()

    //1. define la plantilla que utilizan todas las filas
    // mediante una clase anidada
    inner class MyHolder(var binding: ItemProductoBinding) : RecyclerView.ViewHolder(binding.root)

    // crea la plantilla que utilizara cada fila
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MyHolder {
        val binding = ItemProductoBinding.inflate(
            LayoutInflater.from(context), parent, false
        )
        return MyHolder(binding)
    }

    // asociará cada posicion con una plantilla
    override fun onBindViewHolder(
        holder: MyHolder,
        position: Int
    ) {
        // val product = list.get(position)
        val product = list[position]
        holder.binding.nombreProducto.text = product.title
        // holder.binding.imagenProducto.setImageResource(R.drawable.imgdefault)
        Glide
            .with(context)
            .load(product.thumbnail)
            .placeholder(R.drawable.imgdefault)
            .into(holder.binding.imagenProducto)

        // TODO asociar los eventos de los botones
        // TODO asociar la logica del producto
    }

    // cuantos elementos totales se tienen
    override fun getItemCount(): Int {
        return list.size
    }

    fun addProduct(productJSON: ProductJSON){
        list.add(productJSON)
        // notifyDataSetChanged()
        notifyItemInserted(list.size-1)
    }


}
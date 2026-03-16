package com.example.inicio.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.inicio.databinding.ItemProductoBinding
import com.example.inicio.model.Product

// 2. Tipa el Adapter con la clase anidada
// 3. Defino todos los elementos que son necesarios en el construtor
class ProductoAdapter(
    var list: ArrayList<Product>,
    var context: Context
) :
    RecyclerView.Adapter<ProductoAdapter.MyHolder>() {

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
        // TODO poner la imagen -> GLIDE
        // TODO asociar los eventos de los botones
        // TODO asociar la logica del producto
    }

    // cuantos elementos totales se tienen
    override fun getItemCount(): Int {
        return list.size
    }


}
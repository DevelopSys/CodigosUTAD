package com.example.listarecycler

import android.R
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.listarecycler.databinding.ItemProductoBinding

class ProductoAdapter(var lista: ArrayList<Producto>, var context: Context) :
    RecyclerView.Adapter<ProductoAdapter.MyHolder>() {

    inner class MyHolder(var binding: ItemProductoBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MyHolder {
        var binding = ItemProductoBinding.inflate(
            LayoutInflater.from(context),parent,false
        )

        return MyHolder(binding)
    }

    override fun onBindViewHolder(
        holder: MyHolder,
        position: Int
    ) {
        var producto = lista[position]
        holder.binding.textoNombre.text = producto.titulo
        holder.binding.textoPrecio.text = producto.precio.toString()
        holder.binding.btnComprar.setOnClickListener {
            // lleva a la base de datos
            // cambia de pantalla
        }
    }

    override fun getItemCount(): Int {
        return lista.size
    }


}
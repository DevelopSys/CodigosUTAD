package com.example.comunicacion.adapters

import android.content.Context
import android.content.Intent
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


class AdaptadorProducto(var context: Context) : RecyclerView.Adapter<AdaptadorProducto.MyHolder>() {

    var lista: ArrayList<Producto> = ArrayList()

    class MyHolder(item: View) : RecyclerView.ViewHolder(item) {

        // definir cada uno de los elementos de la fila
        var imagen: ImageView = item.findViewById(R.id.imagenFila)
        var titulo: TextView = item.findViewById(R.id.tituloFila)
        var subTitulo: TextView = item.findViewById(R.id.subtituloFila)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder {
        // creara la plantilla asociada
        val vista: View = LayoutInflater.from(context).inflate(
            R.layout.item_modelo,
            parent, false
        )
        return MyHolder(vista)
    }

    override fun getItemCount(): Int {
        // cuantos elementos tengo pintar -> LOS QUE HAY EN LA LISTA A REPRESENTAR
        return lista.size;
    }

    override fun onBindViewHolder(holder: MyHolder, position: Int) {
        // asociar el holder (XML) con datos de la LISTA

        val elemento = lista[position]
        holder.titulo.text = elemento.title
        holder.subTitulo.text = elemento.price.toString()
        Glide.with(context).load(elemento.thumbnail)
            .placeholder(R.drawable.vw).into(holder.imagen)
        //holder.imagen.setImageResource(elemento.imagen)
        //holder.imagen.setOnClickListener {
        /*val intent: Intent = Intent(context,)
        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
        context.startActivity(intent)*/
    }

    fun addProducto(x: Producto) {
        lista.add(x)
        notifyItemInserted(lista.size - 1)
    }
}

/*fun cambiarLista(lista: ArrayList<Modelo>) {
    this.lista = lista;
    notifyDataSetChanged()
}*/


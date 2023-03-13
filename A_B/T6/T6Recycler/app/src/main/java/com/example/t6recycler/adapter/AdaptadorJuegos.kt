package com.example.t6recycler.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.Glide
import com.example.t6recycler.R
import com.example.t6recycler.model.Juego
import com.google.android.material.snackbar.Snackbar

class AdaptadorJuegos(var lista: ArrayList<Juego>, var context: Context) : RecyclerView.Adapter<AdaptadorJuegos.MyHolder>() {

    class MyHolder(itemView: View) : ViewHolder(itemView) {

        // vista de cada una de las filas
        val imagenImageView: ImageView = itemView.findViewById(R.id.imagen_recycler);
        val tituloTextView: TextView = itemView.findViewById(R.id.titulo_recycler)
        val subTituloTextView: TextView = itemView.findViewById(R.id.texto_subtitulo)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder {
        // Crea un ViewHolder de la clase anidada
        // Para poder crear un MyHolder necesito una vista (el xml)

        val vista: View = LayoutInflater.from(context)
            .inflate(R.layout.item_recycler,parent,false)
        return MyHolder(vista)
    }

    override fun getItemCount(): Int {
        // Cantidad de elemento que tendra el recycler
        return lista.size
    }

    override fun onBindViewHolder(holder: MyHolder, position: Int) {
        // Coloca cada uno de los elementos en una lista (en la posicion indicada)
        // poniendolos en el MyHolder

        val elementoTemp = lista[position]
        holder.imagenImageView.setOnClickListener{
            // como se comporta la pulsacion
            Snackbar.make(holder.imagenImageView
                , elementoTemp.tipo,Snackbar.LENGTH_SHORT).show()
        }
        holder.tituloTextView.text = elementoTemp.titulo
        holder.subTituloTextView.text = elementoTemp.anio.toString()
        // holder.imagenImageView
        Glide.with(context).load(elementoTemp.imagen).placeholder(R.drawable.ic_launcher_background).into(holder.imagenImageView)

    }
}
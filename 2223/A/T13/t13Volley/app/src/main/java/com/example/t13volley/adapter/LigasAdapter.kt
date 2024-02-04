package com.example.t13volley.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.t13volley.R

class LigasAdapter : RecyclerView.Adapter<LigasAdapter.MyHolder>() {

    private var listaLigas: ArrayList<String>

    init {
        listaLigas = ArrayList();
    }

    class MyHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var textoNombre: TextView;

        init {
            textoNombre = itemView.findViewById(R.id.texto_nombre_liga);
        }
    }

    fun addLiga(liga: String){
        this.listaLigas.add(liga)
        notifyDataSetChanged();
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_recycler, parent, false)
        return MyHolder(view)
    }

    override fun getItemCount(): Int {
        return listaLigas.size
    }

    override fun onBindViewHolder(holder: MyHolder, position: Int) {
        holder.textoNombre.text = listaLigas[position]
    }
}
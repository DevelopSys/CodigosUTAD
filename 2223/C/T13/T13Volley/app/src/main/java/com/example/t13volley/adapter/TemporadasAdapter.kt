package com.example.t13volley.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.t13volley.R
import com.example.t13volley.model.Liga
import com.google.android.material.snackbar.Snackbar

class TemporadasAdapter : RecyclerView.Adapter<TemporadasAdapter.MyHolder>() {

    private lateinit var listaTemporadas: ArrayList<String>;

    init {
        listaTemporadas = ArrayList()
    }

    inner class MyHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var textoTemporada: TextView;

        init {
            textoTemporada = itemView.findViewById(R.id.texto_temporada_liga)

        }


    }

    fun addTemporada(temporada: String) {
        listaTemporadas.add(temporada)
        notifyItemInserted(listaTemporadas.size - 1)
    }

    override fun getItemCount(): Int {
        return listaTemporadas.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_recycler_temparada, parent, false)
        return MyHolder(view)
    }

    override fun onBindViewHolder(holder: MyHolder, position: Int) {

        holder.textoTemporada.text = listaTemporadas[position]
        holder.textoTemporada.setOnClickListener {

        }
    }
}
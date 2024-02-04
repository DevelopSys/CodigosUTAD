package com.example.t13volley.adapter

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.t13volley.FirstFragment
import com.example.t13volley.R
import com.example.t13volley.model.Liga
import com.google.android.material.snackbar.Snackbar

class LigasAdapter(var fragment: FirstFragment) : RecyclerView.Adapter<LigasAdapter.MyHolder>() {

    private lateinit var listaLigas: ArrayList<Liga>;

    init {
        listaLigas = ArrayList()
    }

    inner class MyHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var textoNombre: TextView;

        init {
            textoNombre = itemView.findViewById(R.id.texto_nombre_liga)

        }
    }

    fun addLiga(liga: Liga) {
        listaLigas.add(liga)
        notifyItemInserted(listaLigas.size - 1)
    }

    override fun getItemCount(): Int {
        return listaLigas.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_recycler, parent, false)
        return MyHolder(view)
    }

    override fun onBindViewHolder(holder: MyHolder, position: Int) {

        holder.textoNombre.text = listaLigas[position].strLeague
        holder.textoNombre.setOnClickListener {

            val bundle = Bundle();
            bundle.putString("id", listaLigas[position].id);
            fragment.findNavController()
                .navigate(R.id.action_FirstFragment_to_SecondFragment, bundle)
            /*Snackbar.make(holder.textoNombre,
                listaLigas[position].id,Snackbar.LENGTH_SHORT).show()*/
            //listaLigas[position].id
        }
    }
}
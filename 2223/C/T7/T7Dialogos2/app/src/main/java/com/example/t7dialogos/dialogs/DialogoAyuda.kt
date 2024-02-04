package com.example.t7dialogos.dialogs

import android.app.Dialog
import android.content.Context
import android.content.DialogInterface
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment

class DialogoAyuda : DialogFragment() {


    private lateinit var nombre: String ;

    override fun onAttach(context: Context) {
        super.onAttach(context)
        this.nombre = arguments?.getString("nombre") ?: "defecto"
    }

    companion object {
        // todo lo declarado aqui es éstatico
        fun newInstance(nombre: String): DialogoAyuda {
            val dialogo = DialogoAyuda()
            val bundle = Bundle();
            bundle.putString("nombre",nombre)
            dialogo.arguments = bundle
            return dialogo;
        }
    }




    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {

        val builder = AlertDialog.Builder(requireContext())
        // titulo
        builder.setTitle("Diálogo ayuda $nombre")
        // mensaje ó items
        builder.setMessage("Este es un diálogo de ayuda de la aplicación de dispositivos móviles")

        // botones
        builder.setPositiveButton("YES", DialogInterface.OnClickListener { _, _ ->
            Log.v("dialogo", "Pulsado positivo")
        })
        builder.setNegativeButton("NO", DialogInterface.OnClickListener { _, _ ->
            Log.v("dialogo", "Pulsado negativo")
        })
        builder.setNeutralButton("CANCEL", DialogInterface.OnClickListener { _, _ ->
            Log.v("dialogo", "Pulsado neutral")
        })

        return builder.create()
    }

}
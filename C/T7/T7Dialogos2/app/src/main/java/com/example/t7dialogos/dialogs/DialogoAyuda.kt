package com.example.t7dialogos.dialogs

import android.app.Dialog
import android.content.DialogInterface
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment

class DialogoAyuda : DialogFragment() {

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {

        val builder = AlertDialog.Builder(requireContext())

        // titulo
        builder.setTitle("Diálogo ayuda")

        // mensaje ó items
        builder.setMessage("Este es un diálogo de ayuda de la aplicación de dispositivos móviles")

        // botones
        builder.setPositiveButton("YES", DialogInterface.OnClickListener { _, _ ->
            Log.v("dialogo","Pulsado positivo")
        })
        builder.setNegativeButton("NO", DialogInterface.OnClickListener { _, _ ->
            Log.v("dialogo","Pulsado negativo")
        })
        builder.setNeutralButton("CANCEL", DialogInterface.OnClickListener { _, _ ->
            Log.v("dialogo","Pulsado neutral")
        })

        return builder.create()
    }

}
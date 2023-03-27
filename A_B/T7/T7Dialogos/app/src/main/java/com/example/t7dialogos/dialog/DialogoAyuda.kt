package com.example.t7dialogos.dialog

import android.app.Dialog
import android.content.Context
import android.content.DialogInterface
import android.content.DialogInterface.OnClickListener
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment

class DialogoAyuda : DialogFragment(), OnClickListener {


    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {

        val builder = AlertDialog.Builder(requireContext())

        // TITULO
        builder.setTitle("Diálogo ayuda")

        // MENSAJE - LISTA
        builder.setMessage("Esjemplo de cuadro de diálogo de ayuda")

        // BOTONES (Neutral        Negativo Positivo))
        builder.setPositiveButton("YES") { _, _ ->
            Log.v("dialogo", "Pulsado ok")
        }
        builder.setNegativeButton("NO") { _, _ ->
            Log.v("dialogo", "Pulsado no")
        }
        builder.setNeutralButton("CANCEL") { _, _ ->
            Log.v("dialogo", "Pulsado calce")
        }

        return builder.create()
    }

    override fun onClick(p0: DialogInterface?, p1: Int) {
        TODO("Not yet implemented")
    }

}
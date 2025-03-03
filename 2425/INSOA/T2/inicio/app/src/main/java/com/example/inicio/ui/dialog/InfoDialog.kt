package com.example.inicio.ui.dialog

import android.app.Dialog
import android.content.DialogInterface
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment
import com.example.inicio.R

class InfoDialog: DialogFragment() {

    override fun onCreateDialog(savedInstanceState: Bundle?):
            Dialog {

        val builder: AlertDialog.Builder = AlertDialog.Builder(requireActivity())

        // TITULO
        builder.setTitle("Informacion")
        // MENSAJE o ELEMENTOS
        builder.setMessage("Esta app nos vale como ejemplo de app android con login")
        // BOTONES - POSITIVO, NEGATIVO, NEUTRAL
        builder.setPositiveButton("OK") { _, _ ->  }
        builder.setNegativeButton("NO") { _, _ ->  }
        builder.setNeutralButton("CANCEL") { _, _ ->  }

        return builder.create()
    }


}
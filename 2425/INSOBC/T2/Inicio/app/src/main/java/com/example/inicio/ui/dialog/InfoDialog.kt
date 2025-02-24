package com.example.inicio.ui.dialog

import android.app.Dialog
import android.content.DialogInterface
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment

class InfoDialog: DialogFragment() {

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        // construir el dialogo

        val builder: AlertDialog.Builder = AlertDialog.Builder(requireActivity())
        builder.setTitle("Información")
        builder.setMessage("App realizada para la asignatura de desarrollo movil")
        builder.setPositiveButton("OK", DialogInterface.OnClickListener { _, _ ->
            // la accion que quiero que se ejecute
        })

        return builder.create()
    }
}
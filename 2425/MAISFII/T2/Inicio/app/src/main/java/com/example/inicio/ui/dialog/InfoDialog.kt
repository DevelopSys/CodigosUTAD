package com.example.inicio.ui.dialog

import android.app.Dialog
import android.content.DialogInterface
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment

class InfoDialog: DialogFragment() {

    // primer metodo del ciclo de vida de una pantalla oNCreate
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {

        val builder: AlertDialog.Builder = AlertDialog.Builder(requireActivity())
        builder.setTitle("Información")
        builder.setMessage("App realizara para la asignatura de Desarrollo Movil")
        builder.setPositiveButton("OK"){ _, _ ->
            // accion al pulsar el boton positivo
        }

        return builder.create()
    }
}
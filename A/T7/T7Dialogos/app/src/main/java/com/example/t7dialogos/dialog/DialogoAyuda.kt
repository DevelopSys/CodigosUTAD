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

        // titulo
        builder.setTitle("Aplicación proyectos - diálogo")

        // mensaje o elementos
        builder.setMessage("Aplicación realizada por Borja Martin para la asignatura de Dispositivos Móviles")

        // botones
        builder.setPositiveButton("Ok",this)
        builder.setNegativeButton("Cancel",this)
        builder.setNeutralButton("Quit",this)

        return builder.create()
    }

    override fun onClick(p0: DialogInterface?, p1: Int) {
        Log.v("dialogo","Boton del cuadro pulsado")
    }


}
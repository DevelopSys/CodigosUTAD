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

    private var nombre: String? = null;

    // TODO 1 companion: crear un metodo companion que cree el objeto y retornarlo

    companion object{
        fun newInstance(nombre: String): DialogoAyuda{
            val dialogoAyuda = DialogoAyuda()
            // TODO 2 companion;poner los datos comunicados como argumentos
            val bundle = Bundle();
            bundle.putString("nombre",nombre)
            dialogoAyuda.arguments = bundle
            return dialogoAyuda
        }
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        // TODO 3 companion;recupero los datos comunicados como argumentos
        nombre = this.requireArguments().getString("nombre")
    }


    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {

        val builder = AlertDialog.Builder(requireContext())
        // titulo
        builder.setTitle("Aplicación proyectos - diálogo")
        // mensaje o elementos
        builder.setMessage("Aplicación realizada por $nombre Martin para la asignatura de Dispositivos Móviles")

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
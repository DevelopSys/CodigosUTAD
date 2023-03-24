package com.example.t7dialogos.dialog

import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment
import com.example.t7dialogos.R

class DialogoPerso: DialogFragment() {

    private lateinit var vista: View
    private lateinit var editNombre: EditText
    private lateinit var editResponsable: EditText
    private lateinit var editPresupeuesto: EditText
    private lateinit var botonAdd: Button
    // TODO 2. crear un objeto de la interfaz
    private lateinit var listener: OnDialogoProyectoListener

    // TODO 4. inicializar la interfaz

    override fun onAttach(context: Context) {
        super.onAttach(context)
        listener = context as OnDialogoProyectoListener
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val builder = AlertDialog.Builder(requireContext())
        vista = LayoutInflater.from(requireContext()).inflate(R.layout.dialogo_add,null)
        builder.setView(vista)
        return builder.create()
    }

    override fun onStart() {
        super.onStart()
        editNombre = vista.findViewById(R.id.edit_nombre)
        editPresupeuesto = vista.findViewById(R.id.edit_presupuesto)
        editResponsable = vista.findViewById(R.id.edit_responsable)
        botonAdd = vista.findViewById(R.id.boton_add)

        botonAdd.setOnClickListener {

            // enviar los datos a la pantalla
            var responsable = editResponsable.text.toString()
            var nombre= editNombre.text.toString()
            var presupuesto = editPresupeuesto.text.toString().toInt()
            listener.onDatoAdd(nombre, responsable, presupuesto)
            dismiss()
        }

    }

    // TODO 1. creo interfaz
    interface OnDialogoProyectoListener{
        fun onDatoAdd(nombre: String, responsable: String, presupuesto: Int)
    }
}
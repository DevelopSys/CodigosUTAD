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

class DialogoAdd: DialogFragment() {

    private lateinit var vista: View
    private lateinit var botonAdd: Button
    private lateinit var editNombre: EditText
    private lateinit var editResponsable: EditText
    private lateinit var editPresupuesto: EditText
    // TODO 2. Creo una instance de la interfaz
    private lateinit var listener: OnDialogoAddListener


    override fun onAttach(context: Context) {
        super.onAttach(context)
        vista = LayoutInflater.from(context).inflate(R.layout.dialogo_add,null)
        listener = context as OnDialogoAddListener
        // OnDialogoAddListener = Context


    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {

        val builder = AlertDialog.Builder(requireContext())
        // vista
        builder.setView(vista)
        return builder.create()
    }

    override fun onStart() {
        super.onStart()

        botonAdd = vista.findViewById(R.id.boton_add)
        editNombre = vista.findViewById(R.id.edit_nombre)
        editPresupuesto = vista.findViewById(R.id.edit_presupuesto)
        editResponsable = vista.findViewById(R.id.edit_responsable)

        botonAdd.setOnClickListener {

            val nombre = editNombre.text.toString()
            val responsable = editResponsable.text.toString()
            val presupuesto = editPresupuesto.text.toString().toInt()

            // damos por supuesto que todos los elementos están ok
            listener.addProyecto(nombre, presupuesto, responsable)
            dismiss()

        }
    }

    // TODO 1. En el origen de los datos creo una interfaz

    interface OnDialogoAddListener {
        fun addProyecto(nombre: String, presupuesto: Int, responsable: String)
    }
}
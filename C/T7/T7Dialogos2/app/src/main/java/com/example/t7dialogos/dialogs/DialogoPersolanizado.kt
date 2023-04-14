package com.example.t7dialogos.dialogs

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
import com.example.t7dialogos.databinding.DialogoProyectoBinding

class DialogoPersolanizado : DialogFragment() {

    private lateinit var vista: View
    private lateinit var boton: Button
    private lateinit var editNombre: EditText
    private lateinit var editResponsable: EditText
    private lateinit var editPresupuesto: EditText
    // TODO 2. creo un objeto de la interfaz
    private lateinit var listener: OnDialogoProyectoListener

    override fun onAttach(context: Context) {
        super.onAttach(context)
        listener = context as OnDialogoProyectoListener
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val builder =  AlertDialog.Builder(requireContext())
        vista = LayoutInflater.from(requireContext()).inflate(R.layout.dialogo_proyecto,null)
        builder.setView(vista)
        return builder.create()
    }

    override fun onStart() {
        super.onStart()
        boton = vista.findViewById(R.id.boton_add)
        editNombre = vista.findViewById(R.id.edit_nombre)
        editResponsable = vista.findViewById(R.id.edit_responsable)
        editPresupuesto = vista.findViewById(R.id.edit_presupuesto)

        boton.setOnClickListener {
            // sacar datos y llevarlos al recycler
            val responsble = editResponsable.text.toString()
            val nombre = editNombre.text.toString()
            val presupuesto = editPresupuesto.text.toString().toInt()
            listener.onProyectoAdd(nombre,responsble,presupuesto)
            dismiss()
        }
    }

    // TODO 1. creo una interfaz

    interface OnDialogoProyectoListener{
        fun onProyectoAdd(nombre: String, responsable: String, presupuesto: Int)
    }

}
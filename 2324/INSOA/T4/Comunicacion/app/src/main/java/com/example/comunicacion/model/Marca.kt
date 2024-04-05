package com.example.comunicacion.model

import android.graphics.drawable.Drawable

class Marca (var nombre: String, var imagen: Int, var calidad: String) {

    override fun toString(): String {
        return nombre
    }
}
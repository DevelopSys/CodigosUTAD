package com.example.comunicacion.model


class Marca(var nombre: String, var calidad: String, var imagen: Int){
    override fun toString(): String {
        return nombre
    }
}
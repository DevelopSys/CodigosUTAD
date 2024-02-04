package com.example.t5constraint.model

// nombre y una imagen
data class Tecnologia (var nombre: String,var imagen: String){
    override fun toString(): String {
        return nombre
    }
}
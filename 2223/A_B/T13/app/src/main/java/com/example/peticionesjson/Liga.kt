package com.example.peticionesjson

class Liga(var nombre: String, var deporte: String, var nombreAlt: String) {

    override fun toString(): String {
        return "Liga(nombre='$nombre', deporte='$deporte', nombreAlt='$nombreAlt')"
    }
}
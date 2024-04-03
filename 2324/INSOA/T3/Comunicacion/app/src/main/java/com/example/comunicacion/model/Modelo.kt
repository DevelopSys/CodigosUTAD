package com.example.comunicacion.model

import java.io.Serializable

class Modelo(
    var marca: String,
    var modelo: String,
    var cv: Int,
    var precio: Double,
    var imagen: Int
) : Serializable {
}
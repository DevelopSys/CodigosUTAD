package com.example.comunicacion.model

import java.io.Serializable

class Modelo(
    var marca: String,
    var modelo: String,
    var percio: Double,
    var cv: Int,
    var imagen: Int
) : Serializable {
}
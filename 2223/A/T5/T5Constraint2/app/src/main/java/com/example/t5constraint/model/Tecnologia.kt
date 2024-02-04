package com.example.t5constraint.model

data class Tecnologia(var nombre: String, var imagen: String) {

    private var version: Int =0;

    constructor(nombre: String, imagen: String, version: Int) : this(nombre,imagen) {
        this.version =version
    }
}
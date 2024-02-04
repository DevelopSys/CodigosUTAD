package com.example.t6recycler.model

class Juego (var titulo: String, var compania: String, var anio: Int, var tipo: String, var imagen: String) {

    var presupuesto: Int = 0;

    constructor(titulo: String, compania: String, anio: Int, tipo: String, imagen: String, presupuesto: Int)
            : this(titulo,compania,anio,tipo, imagen) {
        this.presupuesto = presupuesto
    }

}
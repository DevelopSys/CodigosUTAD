package com.example.t6recycler.model

class Juego (var nombre: String, var genero: String, var imagen: String,var anioDesarrollo: Int) {

    var compania: String? = null
    var presupuesto: Int? = null

    constructor(nombre: String, genero: String, imagen: String, anioDesarrollo: Int, compania: String)
            :this(nombre,genero,imagen,anioDesarrollo){
        this.compania = compania
    }

    constructor(nombre: String, genero: String, imagen: String, anioDesarrollo: Int, presupuesto: Int)
            :this(nombre,genero,imagen,anioDesarrollo){
        this.presupuesto = presupuesto
    }

}
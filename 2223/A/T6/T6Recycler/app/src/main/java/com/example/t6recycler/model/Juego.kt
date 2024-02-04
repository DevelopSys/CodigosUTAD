package com.example.t6recycler.model

data class Juego (var nombre: String, var genero: String, var anioDesarrollo: Int, var imagen: String){

    var presupuesto: Int =0;
    var compania: String? = null

    constructor(nombre: String, genero: String, anioDesarrollo: Int, imagen: String, presupuesto: Int)
            :this(nombre,genero,anioDesarrollo,imagen){
                this.presupuesto = presupuesto;
    }

    constructor(nombre: String, genero: String, anioDesarrollo: Int, imagen: String, compania: String)
            :this(nombre,genero,anioDesarrollo,imagen){
        this.compania = compania;
    }

}
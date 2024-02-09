package com.example.primerproyecto.model

open class Usuario(var nombre: String? = null, var correo: String? = null, var pass: String? = null) {

    var telefono: Int? = null
    var direccion: String? = null

    constructor(
        nombre: String,
        correo: String,
        pass: String,
        telefono: Int,
        direccion: String
    ) : this(nombre, correo, pass) {

        this.telefono = telefono;
        this.direccion = direccion
    }

    // void -> Unit
    // Object -> Any
    open fun mostrarDatos(){

        println("Nombre: $nombre")
        println("Numero de caracteres del nombre: ${nombre!!.length }")

    }

    open fun mostrarDatos(numero: Int){

        // for(Integer i : coleccion ) {}
        // for (int i=0;i<numero;i++){}
        /*for (i in 0 until numero){ }*/
        (0..numero).forEach {
            mostrarDatos()
        }

        when(numero){
            0->{
                println("No se van a mostrar datos")
            }
            1->{
                mostrarDatos()
            }
        }

    }

}
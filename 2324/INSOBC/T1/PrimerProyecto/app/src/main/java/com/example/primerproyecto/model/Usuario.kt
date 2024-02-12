package com.example.primerproyecto.model

open class Usuario(var nombre: String?=null, var pass: String?=null) {

    // attr

    var correo: String? = null
    var telefono: Int? = null

    // val DNI = "asdasdA"
    // var codPost: Int =0
    // fun
    // const
    // get set

    constructor(nombre: String, pass: String, correo: String, telefono: Int) : this(nombre, pass) {
        this.correo = correo;
        this.telefono = telefono
    }

    open fun mostarDatos(){
        println("Nombre: $nombre")
        println("Pass: $pass")
        println("Telefono: $telefono")
        println("Correo: $correo")
        println("Numero de digigtos del telefono: ${telefono?.toString()?.length ?: 0 }")
    }

    fun mostarDatos(nVeces: Int){
         for (i in 0 until nVeces){
             mostarDatos()
         }

        (0 until nVeces-1).forEach {
            mostarDatos()
        }

        when(nVeces){
            1->{}
            2->{}
            3->{}
            4->{}
        }


    }


}
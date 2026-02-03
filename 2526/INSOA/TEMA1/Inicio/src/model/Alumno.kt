package model

import java.io.Serializable


// atributos, constructores, metodos (getter/setter)

class Alumno(var nombre: String? = null, var apellido: String? = null) : Serializable {

    var correo: String? = null
    /*get() {
        it
    }
    set(value) {}

     */

    constructor(nombre: String, apellido: String, correo: String?=null)
            : this(nombre, apellido) {
        this.correo = correo
    }

    fun mostarDatos() {
        println("nombre = ${nombre}")
        println("apellido = ${apellido}")
        println("correo = ${correo ?: "no hay asignado"}")
    }
}
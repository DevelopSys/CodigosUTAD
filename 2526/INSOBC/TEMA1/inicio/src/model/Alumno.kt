package model

import java.io.Serializable


// variables, funciones (constructor - normales - getter/setter)
class Alumno(var nombre: String, var apellido: String): Serializable
{

    var correo: String? = null

    // public Alumno(String nombre){}
    constructor(nombre: String, apellido: String, correo: String)
            : this(nombre, apellido) {
        this.correo = correo
    }
}
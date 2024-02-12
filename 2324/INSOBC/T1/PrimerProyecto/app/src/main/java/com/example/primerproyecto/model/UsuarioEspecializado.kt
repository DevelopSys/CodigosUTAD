package com.example.primerproyecto.model

class UsuarioEspecializado (nombre: String, pass: String, var salario: Int) : Usuario(nombre,pass) {

    override fun mostarDatos() {
        super.mostarDatos()
        println("Salario $salario")
    }

}

var usuario: Usuario = Usuario("asd","asd")
var usuario1: Usuario = Usuario("asd","asd","asd",123)
var usuario2: Usuario = Usuario("asd")
var usuario3: Usuario = Usuario(pass = "asdasd")

package com.example.primerproyecto.model

class UsuarioEspecializado(nombre: String, correo: String, pass: String, var salario: Int) :
    Usuario(nombre, correo, pass) {

    override fun mostrarDatos() {
        super.mostrarDatos()
        println("Salario $salario")
        val usuario = Usuario(correo="asd")
    }
}
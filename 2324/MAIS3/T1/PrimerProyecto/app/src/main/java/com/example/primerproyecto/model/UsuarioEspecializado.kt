package com.example.primerproyecto.model

class UsuarioEspecializado(nombre: String, pass: String, correo: String, var salario: Int) :
    Usuario(nombre, pass) {

    override fun mostrarDatos() {
        super.mostrarDatos()
        println("Salario $salario")
    }
}

/*val usuario: Usuario = Usuario("Borja","Pass","correo",123)
val usuario1: Usuario = Usuario()*/
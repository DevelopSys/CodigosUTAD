package com.example.inicio.model

import java.io.Serializable

// constructores - primarios/secundarios - attr - funciones
// val user = User()
class User(
    var correo: String? = null, var pass: String? = null, var perfil: String? = null
) :
    Serializable {

    private var direccion: String? = null
    private var telefono: Int? = null

    constructor(correo: String?, pass: String?, perfil: String?, direccion: String?, telefono: Int?)
            : this(correo, pass, perfil) {
        this.direccion = direccion
        this.telefono = telefono
    }
}
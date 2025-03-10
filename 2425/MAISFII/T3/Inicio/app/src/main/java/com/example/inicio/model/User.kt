package com.example.inicio.model

import java.io.Serializable

// constructores (primario -pedir datos obligatorios- y secundario), attr, function
class User(
    private var correo: String? = null,
    private var pass: String? = null,
    private var perfil: String? = null
) : Serializable {

    // getter y setter
    private var direccion: String? = null
    private var telefono: Int? = null

    // constructor secudario
    constructor(correo: String?, pass: String?,perfil:String?, direccion: String?, telefono: Int?)
            : this(correo, pass, perfil) {
        this.telefono = telefono
        this.direccion = direccion
    }

    fun getCorreo(): String? {
        return this.correo
    }

    fun getPerfil(): String? {
        return this.perfil
    }

    fun setCorreo(correo: String) {
        this.correo = correo
    }

    fun getPass(): String? {
        return this.pass
    }

    fun setPass(pass: String) {
        this.pass = pass
    }
}
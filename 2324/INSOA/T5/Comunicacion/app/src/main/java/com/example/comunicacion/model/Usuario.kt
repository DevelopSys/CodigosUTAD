package com.example.comunicacion.model

import java.io.Serializable

class Usuario(
    var nombre: String?=null,
    var correo: String?=null,
    var pass: String?=null,
    var genero: String?=null,
    var perfil: String?=null
) : Serializable {
}
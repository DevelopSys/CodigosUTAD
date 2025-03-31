package com.example.inicio.model

import java.io.Serializable

class User(
    var nombre: String?=null,
    var telefono: Int?=null,
    var correo: String?=null,
    var pass: String?=null
): Serializable
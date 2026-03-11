package com.example.inicio.model

import java.io.Serializable

class UserData(
    var nombre: String,
    var apellido: String,
    var correo: String,
    var pass: String,
    var edad: Int
): Serializable
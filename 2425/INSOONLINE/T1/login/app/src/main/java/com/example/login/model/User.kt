package com.example.login.model

import java.io.Serializable

data class User(var correo: String = "defecto@gmail.com", var pass: String? = "1234")
    : Serializable
package com.example.inicio.model

import java.io.Serializable

data class Usuario(var mail: String,
              var pass: String,
              var perfil: String,
              var recordar: Boolean) : Serializable
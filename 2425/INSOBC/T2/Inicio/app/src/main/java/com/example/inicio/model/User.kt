package com.example.inicio.model

import java.io.Serializable

// constructores
    // primarios (1) -> attr obligatorios
    // secundario (n) -> attr que no estan en el primario. Pero siempre se basa en un primario
// metodos attr

class User(var nombre: String?=null, var pass: String?=null, var perfil: String?=null)
    : Serializable {

    private var telefono:Int?=null

    constructor(n: String, p: String, pr: String, telfono: Int):this(n,p,pr){
        this.telefono = telefono
    }

}
package com.example.t12firebase.model

// FB
class Producto(var nombre: String? = null, var descripcion: String?= null, var precio: Int?=null, var stock: Int?=null) {

    override fun toString(): String {
        return "Producto(nombre='$nombre', descripcion='$descripcion', precio=$precio, stock=$stock)"
    }
}
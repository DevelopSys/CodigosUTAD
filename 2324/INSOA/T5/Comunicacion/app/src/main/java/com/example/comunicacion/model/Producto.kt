package com.example.comunicacion.model

import java.io.Serializable

class Producto(
    var id: Int?=null,
    var title: String?=null,
    var description: String?=null,
    var thumbnail: String?=null,
    var category: String?=null,
    var price: Double?=null,
): Serializable {
}
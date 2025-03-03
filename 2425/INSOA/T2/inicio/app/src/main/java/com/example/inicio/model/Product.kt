package com.example.inicio.model

import java.io.Serializable

class Product(var title: String, var price: Double,
              var description: String, thumbnail: String) : Serializable{
}
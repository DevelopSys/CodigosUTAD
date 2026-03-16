package com.example.inicio.data

import android.content.Intent
import com.example.inicio.model.Product
import com.example.inicio.model.User

class DataSet {
    companion object data {
        private val listaUsuarios: ArrayList<User> = arrayListOf(
            User("Admin", "Admin", "admin@admin.com", "admin", 20),
            User("Guest", "Guest", "guest@guest.com", "guest", 20)
        )

        private val listaProductos: ArrayList<Product> = arrayListOf(
            Product(
                "Camiseta", 10.90, "Camiseta de vestir", "Camisetas",
                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRT8lfob4bbMV9zIq_w3QYdRE1irSA2oFmQ2w&s"
            ),
            Product(
                "Zapaitillas", 50.50, "Zapatillas casual", "Zapatillas",
                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSbJqdYTohZhroUJUWiVl23HbhD1FRw2CIV_g&s"
            ),
            Product(
                "Pantalones", 20.90, "Pantalones vaqueros", "Pantalones",
                "https://cdn.grupoelcorteingles.es/statics/manager/contents/images/uploads/2025/03/H1-jwm6c3Jg.jpeg?impolicy=Resize&width=800&height=800"
            )
        )

        // funciones de usuarios
        fun addUser(user: User): Boolean {
            // listaUsuarios.find { it.correo == user.correo } ?: listaUsuarios.add(user)
            if (listaUsuarios.find { it.correo == user.correo } == null) {
                listaUsuarios.add(user)
                return true
            } else {
                return false
            }
        }


        // funciones de productos
        fun getAllProducts(): ArrayList<Product>{
            return listaProductos
        }
    }
}

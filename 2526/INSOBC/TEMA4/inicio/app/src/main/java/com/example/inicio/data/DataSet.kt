package com.example.inicio.data

import com.example.inicio.model.Product
import com.example.inicio.model.UserData

class DataSet {
    companion object {
        private val listUsers: ArrayList<UserData> = arrayListOf(
            UserData("Admin", "Admin", "admin@admin.com", "admin", "test", 20),
            UserData("Guest", "Guest", "guest@guest.com", "guest", "test", 20),
        )
        private val listProducts: ArrayList<Product> = arrayListOf(
            Product(
                "Zapatillas",
                "Zapatillas casual",
                30.80,
                "zapatillas",
                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSbJqdYTohZhroUJUWiVl23HbhD1FRw2CIV_g&s"
            ),
            Product(
                "Camiseta",
                "Camiseta casual",
                15.80,
                "camisetas",
                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRT8lfob4bbMV9zIq_w3QYdRE1irSA2oFmQ2w&s"
            ),
            Product(
                "Pantalones",
                "Pantalones vaqueros",
                20.90,
                "pantalones",
                "https://cdn.grupoelcorteingles.es/statics/manager/contents/images/uploads/2025/03/H1-jwm6c3Jg.jpeg?impolicy=Resize&width=800&height=800"
            )
        )

        // funciones de los usuarios
        fun addUser(user: UserData): Boolean {
            // logica de "bd"
            // no -> alguien el la lista ya tiene ese correo
            // si

            if (listUsers.find { it.mail == user.mail } == null) {
                listUsers.add(user)
                return true
            }
            return false
        }

        // funciones de los productos
        fun getAllProducts(): ArrayList<Product> {
            return listProducts
        }
    }
}
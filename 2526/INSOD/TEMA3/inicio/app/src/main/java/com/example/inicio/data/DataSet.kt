package com.example.inicio.data

import com.example.inicio.model.Product
import com.example.inicio.model.UserData

class DataSet {

    companion object {
        private val listaUsuarios: ArrayList<UserData> = arrayListOf(
            UserData("Admin", "Admin A", "admin", "admin", -1),
            UserData("Guest", "Guest A", "guest@guest.com", "guest", -1)
        )
        private val listaProductos: ArrayList<Product> = arrayListOf(
            Product(
                "Zapatillas",
                "Zapatillas casual",
                "zapatillas",
                20.50,
                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSbJqdYTohZhroUJUWiVl23HbhD1FRw2CIV_g&s"
            ),
            Product(
                "Camiseta",
                "Camiseta casual",
                "camisetas",
                10.50,
                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRT8lfob4bbMV9zIq_w3QYdRE1irSA2oFmQ2w&s"
            ),
            Product(
                "Vaqueros",
                "Pantalones vaquetos",
                "pantalnes",
                40.50,
                "https://cdn.grupoelcorteingles.es/statics/manager/contents/images/uploads/2025/03/H1-jwm6c3Jg.jpeg?impolicy=Resize&width=800&height=800"
            )
        )


        fun getUsers(): ArrayList<UserData> {
            return listaUsuarios
        }

        fun addUser(user: UserData): Boolean {
            // no puedo agregar el usuario cuando
            // el correo del usuario ya existe
            // find -> UserData?
            // filter -> List<UserData>

            // listaUsuarios.find { it.mail == user.mail } ?: listaUsuarios.add(user)
            if (listaUsuarios.find { it.mail == user.mail } == null) {
                listaUsuarios.add(user)
                return true;
            }
            return false


        }

    }
}
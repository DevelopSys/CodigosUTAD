package com.example.inicio.data

import com.example.inicio.model.ProductDATA
import com.example.inicio.model.UserData

class DataSet {

    companion object {
        private val listaUsuarios: ArrayList<UserData> = arrayListOf(
            UserData("Admin", "Admin A", "admin", "admin", -1),
            UserData("Guest", "Guest A", "guest@guest.com", "guest", -1)
        )
        private val listaProductos: ArrayList<ProductDATA> = arrayListOf(
            ProductDATA(
                "Zapatillas",
                "Zapatillas casual",
                "zapatillas",
                20.50,
                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSbJqdYTohZhroUJUWiVl23HbhD1FRw2CIV_g&s"
            ),
            ProductDATA(
                "Camiseta",
                "Camiseta casual",
                "camisetas",
                10.50,
                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRT8lfob4bbMV9zIq_w3QYdRE1irSA2oFmQ2w&s"
            ),
            ProductDATA(
                "Vaqueros",
                "Pantalones vaquetos",
                "pantalnes",
                40.50,
                "https://cdn.grupoelcorteingles.es/statics/manager/contents/images/uploads/2025/03/H1-jwm6c3Jg.jpeg?impolicy=Resize&width=800&height=800"
            ),
            ProductDATA(
                "Vaqueros",
                "Pantalones vaquetos",
                "pantalnes",
                40.50,
                "https://cdn.grupoelcorteingles.es/statics/manager/contents/images/uploads/2025/03/H1-jwm6c3Jg.jpeg?impolicy=Resize&width=800&height=800"
            ),
            ProductDATA(
                "Vaqueros",
                "Pantalones vaquetos",
                "pantalnes",
                40.50,
                "https://cdn.grupoelcorteingles.es/statics/manager/contents/images/uploads/2025/03/H1-jwm6c3Jg.jpeg?impolicy=Resize&width=800&height=800"
            ),
            ProductDATA(
                "Vaqueros",
                "Pantalones vaquetos",
                "pantalnes",
                40.50,
                "https://cdn.grupoelcorteingles.es/statics/manager/contents/images/uploads/2025/03/H1-jwm6c3Jg.jpeg?impolicy=Resize&width=800&height=800"
            ),
            ProductDATA(
                "Vaqueros",
                "Pantalones vaquetos",
                "pantalnes",
                40.50,
                "https://media.istockphoto.com/id/1688015574/es/foto/zapatilla-blanca-aislada-sobre-fondo-blanco.jpg?s=612x612&w=0&k=20&c=93ocRK27C437j3akPfTpBrg24w0hXPc6Or1PuVIBRSU="
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

        fun getAllProducts(): ArrayList<ProductDATA> {
            return listaProductos
        }


    }
}
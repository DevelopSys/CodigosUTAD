package com.example.inicio.data

import com.example.inicio.model.UserData

class DataSet {

    companion object {
        private val listaUsuarios: ArrayList<UserData> = arrayListOf(
            UserData("Admin","Admin A","admin@admin.com","admin",-1),
            UserData("Guest","Guest A","guest@guest.com","guest",-1)
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
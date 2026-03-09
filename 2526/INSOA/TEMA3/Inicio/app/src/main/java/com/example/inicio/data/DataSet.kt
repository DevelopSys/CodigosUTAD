package com.example.inicio.data

import android.content.Intent
import com.example.inicio.model.User

class DataSet {
    companion object data {
        private val listaUsuarios: ArrayList<User> = arrayListOf(
            User("Admin","Admin","admin@admin.com","admin",20),
            User("Guest","Guest","guest@guest.com","guest",20)
        )

        fun addUser(user: User): Boolean {
            // listaUsuarios.find { it.correo == user.correo } ?: listaUsuarios.add(user)
            if (listaUsuarios.find { it.correo == user.correo } == null) {
                listaUsuarios.add(user)
                return true
            } else {
                return false
            }
        }
    }
}

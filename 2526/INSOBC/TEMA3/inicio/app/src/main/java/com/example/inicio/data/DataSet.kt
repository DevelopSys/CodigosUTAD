package com.example.inicio.data

import com.example.inicio.model.UserData

class DataSet {
    companion object {
        private val listUsers: ArrayList<UserData> = arrayListOf(
            UserData("Admin", "Admin", "admin@admin.com", "admin", "test", 20),
            UserData("Guest", "Guest", "guest@guest.com", "guest", "test", 20),
        )

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
    }
}
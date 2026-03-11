package com.example.inicio.data

import com.example.inicio.model.UserData

class DataSet {

    companion object {

        private val listaUsuarios: ArrayList<UserData> = arrayListOf(
            UserData("Admin","Admin Apellido","admin@admin.com","admin",20),
            UserData("Guest","Guest Apellido","guest@guest.com","guest",20),
        )

        fun addUser(user: UserData): Boolean {
            // hay un correo ya registrado???
            // recorro -> coincide  -> false
            //                          -> true -> agregarp
            // find , filter
            if (listaUsuarios.find { it.correo == user.correo } == null) {
                listaUsuarios.add(user)
                return true
            }
            return false
        }
        fun getLogin(mail: String, pass: String): UserData?{
            return listaUsuarios.find { it.correo == mail && it.pass == pass }
        }

    }


}
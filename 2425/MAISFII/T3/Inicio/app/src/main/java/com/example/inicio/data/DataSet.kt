package com.example.inicio.data

import com.example.inicio.model.Contact

class DataSet {

    // static List<Contact> lista = new Arraylist()
    companion object {
        val lista: List<Contact> = arrayListOf(
            Contact("Contacto1", 123123, "Las rozas", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTnSA1zygA3rubv-VK0DrVcQ02Po79kJhXo_A&s"),
            Contact("Contacto2", 234567, "Pozuelo", "https://cdn-icons-png.flaticon.com/512/219/219969.png"),
            Contact("Contacto3", 345678, "Majadahonda", "https://cdn1.iconfinder.com/data/icons/website-internet/48/website_-_female_user-512.png"),
            Contact("Contacto4", 456789, "Madrid", "https://static.vecteezy.com/system/resources/thumbnails/000/439/863/small_2x/Basic_Ui__28186_29.jpg"),
            Contact("Contacto5", 987654, "Las matas", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQVmYRyE5fsXGuaJ4ToH5UOj1oWc9bU0rLr3A&s")
        )

    }

}
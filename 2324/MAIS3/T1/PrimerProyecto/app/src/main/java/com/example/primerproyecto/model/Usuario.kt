package com.example.primerproyecto.model

open class Usuario(var nombre: String? = null, var pass: String? = null) {
    // atributos
    // acceso tipo nombre;
    // Any
    var correo: String? = null
        /*get() = field
        set(value) {
            field = value
        }*/
    var telefono: Int? = null;

    // val DNI = "asdasdasd"
    // metodos
    // constructor -> public Usuario(){}

    constructor(nombre: String, pass: String, correo: String, telefono: Int) : this(nombre, pass) {
        this.correo = correo
        this.telefono = telefono
    }

    // Unit
    open fun mostrarDatos() {

        println("Nombre: $nombre")
        println("Pass: $pass")
        println("Telefono: $telefono")
        println("Correo: $correo")
        // quiero sacar cuantos numeros tiene tu telefono
        println("Tu telefono tiene ${telefono?.toString()?.length ?: 0}")

    }
    fun mostrarDatos(nVeces: Int) {

        // for (int i=0;i<nVeces; i++){ mostrarDatos() }
        for (i in 0 until nVeces) {
            mostrarDatos()
        }

        (0 until nVeces).forEach {
            mostrarDatos()
        }

        when(nVeces){
           1->{}
           2->{}
           3->{}
           4->{}
        }


        // for (Tipo item: coleccion) {}

    }
}
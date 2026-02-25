open class Usuario(var nombre: String, var correo: String) {
    // constructores -> primario / secundarios
    // atributos
    // metodos
    var telefono: Int?=null
    constructor(nombre: String, correo: String, telefono:Int):this(nombre,correo){
        this.telefono = telefono;
    }

    open fun mostrarDatos(){
        println("nombre = ${nombre}")
        println("correo = ${correo}")
        println("telefono = ${telefono?:"no indicado"}")
    }
}
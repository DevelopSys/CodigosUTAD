// public static void main(String[]args)
// fun nombreMetodo(param: Tipo): TipoRetorno { }
fun main(args: Array<String>): Unit {
    /*
    // mutables o no mutables
    // var - val
    // var nombreVariable: Tipo = valor
    val DNI = "1234A"
    var nombre: String = "Borja"
    var edad: Int = 40
    var correo: String? = null
    lateinit var direccionCasa: String
    // readLn()
    println("Hola mi nombre es $nombre, tengo $edad y mi din es $DNI")
    //println("Mi correo es ${correo ?: "si definir"}")
    println("Mi correo es ${correo?.length ?: 0}")
    direccionCasa = "Las Rozas"
    println("La direccion de mi casa es $direccionCasa")*/

    // saludar("Juan",1)
    // saludar("Juan",8)
    saludar(veces = 3, nombre = "Marcos")
}

fun saludar(nombre: String, veces: Int = 1) {
    for (i in 0..veces - 1 step 2) {
        println("Hola $nombre te saludo desde kotlin")
    }
}

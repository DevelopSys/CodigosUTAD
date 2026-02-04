// public static void main(String[] args){}
// fun main(){}
// fun main(args:Tipo,args1:Tipo,args2:Tipo) : Tipo {}

fun main() {
    println("Primer programa en Kotlin")
    // val/var nombre : Tipo = valor
    var miNombre: String = "Borja"
    var edad: Int = 42
    val dni = "123123A"
    var correo: String? = null

    println("Mi nombre es $miNombre tengo ${edad / 2} años y mi dni es $dni")
    println("Mi dni tiene ${dni.length} digitos")
    println("Mi correo es ${correo ?: "sin definir"}")
    println("Mi correo tiene ${correo?.length ?: "0"} letras")
    // parametros posicionales
    saludar("Borja", 2)
    // parametros nominales
    saludar(veces = 3, nombre = "Maria")
    saludar(nombre = "Juan")
    saludar("Juan")
    saludar(veces = 8)
    val usuario0 = Usuario()
    val usuario1 = Usuario(nombre = "Borja", apellido = "Martin")
    val usuario2 = Usuario("Borja", "Martin", "correo@gmail.com")
}

fun saludar(nombre: String = "Marta", veces: Int = 1): Unit {

    // for (int i=0;i<10;i++){}
    // for ( String item : lista ){}
    for (i in 0..veces - 1) {
        println("Enhorabuena $nombre, has completado el proyecto")
    }

}
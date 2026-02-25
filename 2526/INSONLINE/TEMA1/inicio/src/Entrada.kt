// fun nombre(arg: TIPO){}

fun main() {
    // var o val nombre: tipo = valor
    var nombre = "Borja"
    nombre = "Borja Martin"
    val DNI = "123123A"
    var edad:Int?=null;
    // DNI = "123123"
    println("Esta es la primera app Koltin")
    println("Mi nombre es ${nombre} y mi dni es ${DNI}")
    println("Mi DNI tiene una cantidad de ${DNI.length}")
    println("Mi edad es de ${edad?.times(8) ?: "0" }")
    // parametros posicionales -> saludar("Borja",5)
    //saludar(veces = 2, nombre = "Juan")
    // saludar("Marta")
    saludar(veces = 4)
    var usuario1 = Usuario(nombre="Maria", correo = "maria@gmail.com")
    var usuario2 = Usuario(nombre="Borja", correo = "borja@gmail.com", telefono = 123123)
    // usuario1.mostrarDatos()
    var profesor: Profesor = Profesor("Marcos","Martin",5)
    profesor.mostrarDatos()
}

fun saludar(nombre: String="Luis", veces: Int=1) {
    for (i in 0..veces-1){
        println("Hola $nombre, has completado el proyecto")
    }
}
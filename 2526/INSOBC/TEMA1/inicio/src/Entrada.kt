import model.Alumno

// public static void main(String[] args){}
// fun nombre(param:Tipo):retorno{}
fun main() {
    // val
    // var nombre = valor
    var nombre = "Borja";
    var edad = 42
    var telefono = 911111111
    val dni = "123123A"
    var correo: String? = null

    println("Primer programa kotlin")
    println("Mi nombre es ${nombre} y tengo ${edad}")
    println("Mi dni tiene una longitud de ${dni.length}")
    println("Mi correo es ${correo?.length ?: "sin definir"}")
    // parametros posicionales
    saludar("Borja",2)
    // parametros nominales
    saludar(veces = 3, nombre = "Juan")
    saludar(veces = 8)
    var alumno1 = Alumno("Borja","Martin")
    var alumno2 = Alumno("Borja","Martin","asdasdasd")
}

// fun nombre(param:tipo){}
fun saludar(nombre: String="fulanito", veces: Int=1) {

    // for (int i=0;i<10;i+=2){}
    for (i in 0..veces - 1 ) {
        println("Enhorabuena $nombre, has completado el primer proyecto")
    }
}
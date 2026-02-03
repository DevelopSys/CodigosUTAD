import model.Alumno

// public static void main(String[] arg){}
fun main() {
    // var-val nombre: Tipo = valor
    var nombre: String = "Borja"
    var edad: Int = 42
    var correo: String? = null;
    val DNI = "123123A"
    println("Primer programa en kotlin")
    println("mi nombre es ${nombre} y tengo ${edad}")
    println("mi correo tiene ${correo?.length ?: "0"} letras")
    // saludar(1)
    // saludar("juan",4)
    //  saludar(veces = 4, nombre = "juan")
    var alumno = Alumno()
    var alumno1 = Alumno(nombre = "Borja", apellido = "Martin")
    var alumno2 = Alumno(nombre = "Borja", apellido = "Martin",correo="borja@gmail.com")
    alumno2.mostarDatos()
}

fun saludar(nombre: String = "borja", veces: Int) {

    // for(int i=0; i<veces;i++){}
    for (i in 0..veces - 1) {
        println("Enhorabuena $nombre has completado el prouecto")
    }

}
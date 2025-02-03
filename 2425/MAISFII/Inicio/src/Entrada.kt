// variable
// metodo
// clase
// public static void main(String[] args)

// fun nombreMetodo(param:Tipo, param:Tipo){
// return 7
// }
fun main() {

    // no mutable val nombre: Tipo = valor
    val DNI: String = "1234A"
    // mutables var edad: Tipo = valor
    var nombre: String = "Borja"
    var apellido: String? = "Martin"
    lateinit var asignatura: String
    var edad: Int = 40
    var experiencia: Boolean = true
    println("Mi nombre es $nombre, mi edad es $edad")
    println("Mi apellido es ${apellido?.length}")
    asignatura = "Desarrollo movil"
    println("La asignatura que imparto es ${asignatura}")
    saludar(veces = 1)
    val usuario: Usuario = Usuario("Borja", "correo","1234A")
    usuario.mostrarDatos()

}

fun recorrerElementos(){
    // Array -> estático
    // ArrayList -> dinámico
    val elementosArray: Array<String> = arrayOf("Palabra1", "Palabra2")
    // val elementos: ArrayList<String> = arrayListOf("asdasdasd")


}

fun saludar(nombre: String?=null, veces: Int){

    for (i in 0..veces-1){
        println("Hola ${nombre?:"sin nombre"} este es tu primer programa Kotlin")
    }
}

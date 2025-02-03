import kotlin.text.substring as substring1

// fun nombre(nArg:Tipo, nArg:Tipo):TipoRetorno { }
// public static void main(String[] args){}
fun main(){
    // mutables -> var
    // no mutables -> constantes -> final -> val
    // tipo nombre = valor
    var nombre = "Borja"
    val DNI: String = "1234A"
    var edad: Int = 40
    var correo: String? = "borja@gmail.com"
    println("Hola esta es mi primera app koltin")
    println("Mi nombre es ${nombre} y tengo ${edad} años")
    println("Mi correo tiene ${correo?.length ?: "sin correo" }")
    realizarDivision(y=6)
    realizarDivision()
}

fun realizarDivision(x: Int=20, y: Int=10) {
    val resultado = x.toDouble() /y
    println("El resultado es $resultado")
}


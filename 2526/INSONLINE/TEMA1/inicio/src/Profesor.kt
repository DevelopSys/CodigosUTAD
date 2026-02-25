import java.io.Serializable

class Profesor(nombre: String, correo: String, var horasDocencia: Int)
    : Usuario(nombre,correo), Serializable{

    override fun mostrarDatos() {
        super.mostrarDatos()
        println("horasDocencia = ${horasDocencia}")
    }


}
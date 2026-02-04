import java.io.Serializable

// constructores
// atributos
// metodos - getter setter
class Usuario(var nombre: String?=null, var apellido: String?=null) : Serializable {

    var correo: String? = null

    constructor(nombreS: String, apellidoS: String, correo: String)
            : this(nombreS, apellidoS) {
        this.correo = correo
    }


}
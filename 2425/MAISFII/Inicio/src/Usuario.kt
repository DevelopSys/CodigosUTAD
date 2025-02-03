class Usuario(var nombre: String, var correo: String, var pass: String) {

    var direccion: String?=null;
    var direccionAlternativa: String?=null;

    init {

    }
    constructor(nombre: String,correo: String, pass: String, direccion: String)
            : this(nombre, correo, pass){
        this.direccion = direccion;
    }

    constructor(nombre: String,correo: String, pass: String, direccion: String, direccionAlternativa: String)
            : this(nombre, correo, pass){
        this.direccion = direccion;
        this.direccionAlternativa = direccionAlternativa
    }

    fun mostrarDatos(): Unit {
        println("Nombre usuario: $nombre")
        println("Nombre usuario: $correo")
        println("Nombre usuario: $pass")
        println("Nombre usuario: ${direccion ?: "2sin definir"}")
    }

}
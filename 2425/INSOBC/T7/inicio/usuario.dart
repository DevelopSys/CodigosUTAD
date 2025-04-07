class Usuario{

  String nombre;
  String correo;
  String? direccion;

  Usuario(this.nombre, this.correo);
  Usuario.conDireccion(this.nombre, this.correo, this.direccion);

}
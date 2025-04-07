import 'dart:core';

class Usuario {
  String correo;
  String pass;
  String? nombre;
  int? telefono;

  Usuario(this.nombre, this.correo, this.pass);

  Usuario.telefono(this.nombre, this.correo, this.pass, this.telefono);

  Usuario.nombre(this.correo, this.pass, this.telefono);

  mostrarDatos() {
    print("Nombre ${nombre ?? "no indicado"}");
    print("Correo $correo");
    print("Pass $pass");
    print("Telefono ${telefono ?? "no definido"}");
  }
}

import 'Usuario.dart';

void main() {
  // definir variables
  var nombre = "Borja";
  String apellido = "Martin";
  String? correo = null;
  late String direccion;
  direccion = "Pozuelo";

  // saludoNormal(nombre, apellido, correo);
  /*saludoNominal(
      nombreParametro: nombre,
      apellidoParametro: apellido,
      correoParametro: correo);*/
  Usuario usuario = new Usuario("Borja", "Borja@gmail.com", "1234");
  usuario.mostrarDatos();
}

saludoNormal(String nombre, String apellido, String? correo,
    [String direccion = "las rozas"]) {
  print("Nombre: $nombre Apellido: $apellido "
      "Correo: ${correo ?? "sin correo"} Direccion: ${direccion}");
}

saludoNominal(
    {required var nombreParametro,
    required var apellidoParametro,
    required var correoParametro,
    var direccionParametro = "las rozas"}) {
  print("Nombre: $nombreParametro Apellido: $apellidoParametro "
      "Correo: ${correoParametro ?? "sin correo"} Direccion: ${direccionParametro}");
}

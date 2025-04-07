

import 'usuario.dart';

void main() {
  // variables mutables
  String nombre = "Borja";
  String correo = "borja@gmail.com";
  String pass = "1234A";
  String? direccion = null;
  late int telefono;
  late var experiencia;

  telefono = 123;
  experiencia = true;

  /*print("Nombre: $nombre Correo: $correo Pass: $pass "
      "Direccion: ${direccion ?? "sin direccion"} "
      "Telefono $telefono Experiencia $experiencia");*/
  // saludo(nombre, correo, null);
  Usuario usuario = new Usuario("nombre", "correo");
  saludoNominal(nombreP: nombre, correoP: correo, direccionP: "Las Rozas");
}

saludo(String nombre, String correo, [String? direccion = "Pozuelo"]) {
  print(
      "Nombre: $nombre Correo: $correo Direccion: ${direccion ?? "sin direccion"}");
}

saludoNominal(
    {required String nombreP,
    required String correoP,
    String direccionP = "Pozuelo"}) {
  print("Nombre: $nombreP Correo: $correoP Direccion: ${direccionP}");
}

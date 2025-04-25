// public void nombreMetodo(){}

void main(){

  // mutables -> var
  // no mutables -> val

  // no mutables en flutter
  const DNI = "asdasdA";
  final NIF = "asdasdaddsa";

  // mutables
  String nombre ="Borja";
  String? apellido;
  late String correo;
  // dynamic
  var direccion;
  direccion = "asdasd";
  direccion = false;
  correo = "correo@gmail.com";
  // print("Nombre: $nombre Apellido: ${apellido ?? "sin apellido"} Correo: $correo");
  // saludar(nombre, "Lunes");
  saludarNominal(nombre: "Borja", dia: "Lunes");
}

saludar(String nombre, [String dia="viernes"]){
  print("Enhorabuena $nombre, primera app Dart completa hoy $dia");
}

saludarNominal({required String nombre, String dia="Viernes"}){
  print("Enhorabuena $nombre, primera app Dart completa hoy $dia");
}
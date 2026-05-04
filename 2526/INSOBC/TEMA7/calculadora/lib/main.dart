import 'package:calculadora/CalculadoraPage.dart';
import 'package:flutter/material.dart';

void main() {
  runApp(const MyApp());
  // definicion de variables
  int edad = 40;
  String nombre = "Borja";
  double altura = 1.70;
  late String correo;
  String? direccion = null;
  // print("Mi direccion de correo es ${direccion ?? 'asdasd'}");
  var elemento = 10; // dynamic
  pasoPametros(2, 7);
  pasoPametrosNombre("cosa", op1: false, op2: 4);
}

/*
class Nombre{
  atributos
  constructores
 }*/
class User {
  final String nombre;
  final String apellido;
  String? correo;

  User(this.nombre, this.apellido);
  User.wMail(this.nombre, this.apellido, this.correo);
}

// tipoRetorno? nombre (parametros){}

void pasoPametrosNombre(String dato, {var op1, required int op2}) {}

void pasoPametros(int op1, int op2) {}

String mostrarDatos() {
  return "";
}

mostrarCosas() {}

class MyApp extends StatelessWidget {
  const MyApp({super.key});
  // This widget is the root of your application.
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      title: 'Flutter Demo',
      theme: ThemeData(
        colorScheme: ColorScheme.fromSeed(seedColor: Colors.blueAccent),
      ),
      home: CalculadoraPage(),

    );
  }
}






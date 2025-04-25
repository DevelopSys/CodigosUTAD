import 'dart:ffi';

void main(){
  // tipo nombre valor
  String nombre ="Borja";

  // KOTLIN
  // var -> mutables
  // val -> no mutables

  // DART
  // dinamica
  var apellido;
  Int? edad;

  apellido = "Martin";
  apellido = 23;

  print("Este es mui primer programa en DART");
  print("Mi nombre es $nombre $apellido y tengo ${edad ?? "sin datos"}");
}

// investigar como funcionan los metodos, como se pasan parametros (nominales y posicionales)
// investigar como funcionan los objetos (las clases) con los constructores primarios y nominales

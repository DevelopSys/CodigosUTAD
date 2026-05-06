import 'package:flutter/material.dart';

void main() {
  runApp(const MyApp());
  String nombre = "Borja";
  String? correo;
  print("Mi correo es ${correo ?? 'asdfghjk'}");
  late String direccion;
  const String DNI = "123123";
  final String DNIFinal = "123123";
  var dato; // dynamic

  saludar();
  saludarVacio();
  saludarParametro("nombre");
  saludarParametroNominal(1, nombre: null);
  saludarParametroNominal(5);
}

saludarParametroNominal(int veces, {String? nombre, var apellido}) {}

saludarParametro(String nombre) {}

saludarVacio() {
  return 1;
}

void saludar() {}

class Usuario {
  final String nombre;
  final String apellido;
  String? correo;

  Usuario(this.nombre, this.apellido);

  Usuario.conCorreo(this.nombre, this.apellido, this.correo);
}

class MyApp extends StatelessWidget {
  const MyApp({super.key});

  // This widget is the root of your application.
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      title: 'Flutter Demo',
      theme: ThemeData(
        colorScheme: ColorScheme.fromSeed(seedColor: Colors.blue),
      ),
      home: CalculadoraPage(),
    );
  }
}

class CalculadoraPage extends StatefulWidget {
  @override
  State<CalculadoraPage> createState() => _CalculadoraState();
}

class _CalculadoraState extends State<CalculadoraPage> {
  int resultado = 0;
  TextEditingController editOP1 = new TextEditingController();
  TextEditingController editOP2 = new TextEditingController();

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(title: Text("Calculadora APP")),
      floatingActionButton: FloatingActionButton(
        child: Text("Calcular"),
        onPressed: () {
          // capturar los valores de los textfield
          int? op1 = int.tryParse(editOP1.text);
          int? op2 = int.tryParse(editOP2.text);
          // operar
          // modifciar resultado
          setState(() {
            resultado = op1!!+op2!!;
          });
        },
      ),
      body: Container(
        padding: EdgeInsets.all(24),
        child: Center(
          child: Column(
            mainAxisAlignment: MainAxisAlignment.center,

            children: [
              Text("Calculadora APP"),
              Padding(padding: EdgeInsets.only(bottom: 24)),
              Text("Por favor introduce los datos en los inputs"),
              Padding(padding: EdgeInsets.only(bottom: 24)),
              Row(
                mainAxisAlignment: MainAxisAlignment.center,
                children: [
                  Expanded(
                    child: TextField(
                      controller: editOP1,
                      decoration: InputDecoration(
                        border: OutlineInputBorder(),
                        label: Text("operando 1"),
                      ),
                    ),
                  ),
                  Padding(padding: EdgeInsets.only(right: 16)),
                  Expanded(
                    child: TextField(
                      controller: editOP2,
                      decoration: InputDecoration(
                        border: OutlineInputBorder(),
                        label: Text("opernado 2"),
                      ),
                    ),
                  ),
                ],
              ),
              Padding(padding: EdgeInsets.only(bottom: 24)),
              Text("El resultado de la operacion es $resultado"),
            ],
          ),
        ),
      ),
    );
  }
}

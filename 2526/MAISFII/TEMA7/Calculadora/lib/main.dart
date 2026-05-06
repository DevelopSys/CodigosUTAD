import 'package:flutter/material.dart';

void main() {
  runApp(const MyApp());
  String nombre = "Borja";
  const String DNI = "123123";
  final String DNIFinal = "123123";
  String? correo;
  late String direccion;
  var dato; // dynamic
  print("EL correo es ${correo ?? 'asdfghjk'}");
  saludar();
  saludarNada();
  saludaroParametros("Borja");
  saludaroParametrosNominal("adsasd", asd: "false");
}

saludaroParametrosNominal(String nombre, {String? asd}) {}

saludaroParametros(String nombre) {}

saludarNada() {
  return "1";
}

void saludar() {}

class Usuario {
  final String nombre;
  final String apellido;
  String? dni;

  Usuario(this.nombre, this.apellido);

  Usuario.condni(this.nombre, this.apellido, this.dni);
}

class MyApp extends StatelessWidget {
  const MyApp({super.key});

  // variables y funciones

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      title: 'Flutter Demo',
      theme: ThemeData(
        colorScheme: ColorScheme.fromSeed(seedColor: Colors.deepPurple),
      ),
      home: CalculadoraPage(nombreAPP: 'Calculadora UTAD'),
    );
  }
}

class CalculadoraPage extends StatefulWidget {
  final String nombreAPP;

  const CalculadoraPage({super.key, required this.nombreAPP});

  @override
  State<CalculadoraPage> createState() => _CalculadoraState();
}

class _CalculadoraState extends State<CalculadoraPage> {
  // variables y funciones
  int resultado = 0;
  TextEditingController editOP1 = new TextEditingController();
  TextEditingController editOP2 = new TextEditingController();

  @override
  Widget build(BuildContext context) {
    // TODO: implement build
    return Scaffold(
      appBar: AppBar(title: Text(widget.nombreAPP)),
      body: Container(
        padding: EdgeInsets.all(24),
        child: Center(
          child: Column(
            mainAxisAlignment: MainAxisAlignment.center,
            children: [
              const Text("Calculadora APP"),
              const Padding(padding: EdgeInsets.only(top: 24)),
              const Text("Por favor introduce los datos de la calculadora"),
              const Padding(padding: EdgeInsets.only(top: 24)),
              Container(
                padding: EdgeInsets.only(left: 128, right: 128),
                child: Row(
                  mainAxisAlignment: MainAxisAlignment.center,
                  children: [
                    Expanded(
                      child: TextField(
                        controller: editOP1,
                        decoration: const InputDecoration(
                          border: OutlineInputBorder(),
                          label: Text("Introduce operando 1"),
                        ),
                      ),
                    ),
                    const Padding(padding: EdgeInsets.only(right: 48)),
                    Expanded(
                      child: TextField(
                        controller: editOP2,
                        decoration: const InputDecoration(
                          border: OutlineInputBorder(),
                          label: Text("Introduce operando 1"),
                        ),
                      ),
                    ),
                  ],
                ),
              ),
              const Padding(padding: EdgeInsets.only(top: 24)),
              Text("El resultado de la suma es $resultado"),
            ],
          ),
        ),
      ),
      floatingActionButton: FloatingActionButton(
        onPressed: () {
          // capturar los elementos de los textfield
          // pasar a numero
          int? op1 = int.tryParse(editOP1.text);
          int? op2 = int.tryParse(editOP2.text);
          if (op1 != null && op2 != null) {
            // sumar
            // asignar a la variable
            setState(() {
              resultado = op1 + op2;
            });
          } else {
            // Find the ScaffoldMessenger in the widget tree
            // and use it to show a SnackBar.
            ScaffoldMessenger.of(context).showSnackBar(
              SnackBar(content: Text('Los datos son incorrectos')),
            );
          }
        },
        child: Text("Calcular"),
      ),
    );
  }
}

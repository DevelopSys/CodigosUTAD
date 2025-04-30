import 'package:flutter/material.dart';

class CalculadoraPage extends StatefulWidget {
  @override
  State<StatefulWidget> createState() {
    return CalculadoraState();
  }
}

class CalculadoraState extends State<CalculadoraPage> {
  int resultado = 0;
  TextEditingController controller1 = TextEditingController();
  TextEditingController controller2 = TextEditingController();

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(title: Text("Calculadora APP")),
      body: Container(
        padding: EdgeInsets.all(24),
        child: Center(
          child: Column(
            mainAxisAlignment: MainAxisAlignment.center,
            crossAxisAlignment: CrossAxisAlignment.center,
            children: [
              const Text("Introduce datos para realizar la suma"),
              const Padding(padding: EdgeInsets.only(bottom: 24)),
              Row(
                mainAxisAlignment: MainAxisAlignment.center,
                crossAxisAlignment: CrossAxisAlignment.center,
                children: [
                  Expanded(
                    child: TextField(
                      controller: controller1,
                      decoration: InputDecoration(
                        border: OutlineInputBorder(),
                        labelText: 'Operador 1',
                      ),
                    ),
                  ),
                  Padding(padding: EdgeInsets.only(left: 12, right: 12)),
                  Expanded(
                    child: TextField(
                      controller: controller2,
                      decoration: InputDecoration(
                        border: OutlineInputBorder(),
                        labelText: 'Operador 2',
                      ),
                    ),
                  ),
                ],
              ),
              const Padding(padding: EdgeInsets.only(bottom: 24)),
              const Text("Pulsa el boton para calcular"),
              const Padding(padding: EdgeInsets.only(bottom: 24)),
              ElevatedButton(
                onPressed: () {
                  // capturar lo que hay en los TF
                  int op1 = int.parse(controller1.text);
                  int op2 = int.parse(controller2.text);
                  // realizar operacion
                  int resultadoOp = op2+op1;
                  // asociar al resultado
                  setState(() {
                    resultado = resultadoOp;
                  });
                },
                child: Text("Calcular"),
              ),
              const Padding(padding: EdgeInsets.only(bottom: 24)),
              Text("El resultado es: $resultado"),
            ],
          ),
        ),
      ),
    );
  }
}

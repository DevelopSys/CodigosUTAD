import 'package:flutter/material.dart';

class CalculadoraPage extends StatefulWidget {
  @override
  State<StatefulWidget> createState() {
    return CalculadoraState();
  }
}

class CalculadoraState extends State<CalculadoraPage> {
  double resultado = 0.0;
  TextEditingController controllerOp1 = TextEditingController();
  TextEditingController controllerOp2 = TextEditingController();
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(title: Text("Calculadora APP")),
      body: Container(
        padding: EdgeInsets.all(24.0),
        child: Center(
          child: Column(
            mainAxisAlignment: MainAxisAlignment.center,
            crossAxisAlignment: CrossAxisAlignment.center,
            children: [
              Text("El resultado de la operacion es $resultado"),
              Padding(padding: EdgeInsets.all(12)),
              Row(
                crossAxisAlignment: CrossAxisAlignment.center,
                mainAxisAlignment: MainAxisAlignment.center,
                children: [
                  Expanded(
                    child: TextField(
                      controller: controllerOp1,
                      obscureText: true,
                      decoration: InputDecoration(
                        border: OutlineInputBorder(),
                        labelText: 'Introduce operando 1',
                      ),
                    ),
                  ),
                  Padding(padding: EdgeInsets.all(24)),
                  Expanded(
                    child: TextField(
                      controller: controllerOp2,
                      obscureText: true,
                      decoration: InputDecoration(
                        border: OutlineInputBorder(),
                        labelText: 'Introduce operando 2',
                      ),
                    ),
                  ),
                ],
              ),
              Padding(padding: EdgeInsets.all(12)),
              ElevatedButton(onPressed: (){
                setState(() {
                  double op1 = double.parse(controllerOp1.text);
                  double op2 = double.parse(controllerOp2.text);
                  resultado = op1+op2;
                });
              }, child: const Text("Calcular"))
            ],
          ),
        ),
      ),
    );
  }
}

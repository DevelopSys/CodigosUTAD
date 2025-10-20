import 'package:flutter/material.dart';

class CalculadoraPage extends StatefulWidget {
  @override
  State<StatefulWidget> createState() {
    return CalculadoraState();
  }
}

class CalculadoraState extends State<CalculadoraPage> {

  int resultado = 10;
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
              Text("Introduce los datos en los inputs"),
              Padding(padding: EdgeInsets.only(bottom: 24)),
              Row(
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
                  Padding(padding: EdgeInsets.all(12)),
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
              Padding(padding: EdgeInsets.only(bottom: 24)),
              ElevatedButton(onPressed: (){
                int? operando1 = int.tryParse(controller1.text) ;
                int? operando2 = int.tryParse(controller2.text) ;
                setState(() {
                  if (operando1!=null && operando2!=null){
                    controller1.text = "";
                    controller2.text = "";

                    resultado = operando1+operando2;
                  } else {
                    // print("Datos introducidos incorrectos");
                    ScaffoldMessenger.of(context).showSnackBar(
                      SnackBar(
                        content: const Text('Datos introducidos incorrectos'),
                        action: SnackBarAction(
                          label: 'Poner datos de ejemplo',
                          onPressed: () {
                            controller1.text = "2";
                            controller2.text = "2";
                          },
                        ),
                      ),
                    );
                  }

                });
              }, child: Text("Calcular")),
              Padding(padding: EdgeInsets.only(bottom: 24)),
              Text("El resultado es ${resultado}")

            ],
          ),
        ),
      ),
    );
  }
}

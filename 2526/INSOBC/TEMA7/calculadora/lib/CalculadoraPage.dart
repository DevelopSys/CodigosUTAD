import 'package:flutter/material.dart';

class CalculadoraPage extends StatefulWidget {
  const CalculadoraPage({super.key});

  @override
  State<CalculadoraPage> createState() => _CalculadoraState();
}

class _CalculadoraState extends State<CalculadoraPage> {
  int result =0;
  TextEditingController editingController1 = TextEditingController();
  TextEditingController editingController2 = TextEditingController();

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: const Text('Calculadora Flutter'),
        actions: <Widget>[
          IconButton(
            icon: const Icon(Icons.add_alert),
            tooltip: 'Show Snackbar',
            onPressed: () {
              ScaffoldMessenger.of(context).showSnackBar(
                const SnackBar(content: Text('This is a snackbar')),
              );
            },
          ),
        ],
      ),
      body: Container(
        padding: EdgeInsets.all(32),
        child: Center(
          child: Column(
            mainAxisAlignment: MainAxisAlignment.center,
            crossAxisAlignment: CrossAxisAlignment.center,
            children: [
              const Text("Elemento 1"),
              const Padding(padding: EdgeInsets.only(bottom: 16)),
              const Text("Elemento como ejemplo 2"),
              const Padding(padding: EdgeInsets.only(bottom: 16)),
              const Text("Elemento 3"),
              const Padding(padding: EdgeInsets.only(bottom: 16)),
              Container(
                padding: EdgeInsets.only(left: 48, right: 48, top: 32, bottom: 32),
                child: Row(
                  mainAxisAlignment: MainAxisAlignment.center,
                  crossAxisAlignment: CrossAxisAlignment.center,
                  children: [
                    Expanded(
                      child: TextField(
                        controller: editingController1,
                        decoration: InputDecoration(
                          border: OutlineInputBorder(),
                          label: const  Text("Operando 1"),
                        ),
                      ),
                    ),
                    Padding(padding: EdgeInsets.only(right: 16)),
                    Expanded(
                      child: TextField(
                        controller: editingController2,
                        decoration: InputDecoration(
                          border: OutlineInputBorder(),
                          label: const Text("Operando 2"),
                        ),
                      ),
                    ),
                  ],
                ),
              ),
              Padding(padding: EdgeInsets.only(bottom: 16)),
              Text("El resutlado es $result")
            ],
          ),
        ),
      ),
      floatingActionButton: FloatingActionButton(
        child: const Text("Calcular"),
        onPressed: () {
          int? op1 = int.tryParse(editingController1.text);
          int? op2 = int.tryParse(editingController2.text);

          if(op1 == null || op2 == null){
            ScaffoldMessenger.of(context).showSnackBar(
              const SnackBar(content: Text('Los datos no son correctos')),
            );
          } else {
            setState(() {
              result = op1+op2;
            });
          }

        },
      ),
    );
  }
}

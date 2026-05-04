import 'package:flutter/material.dart';

void main() {
  runApp(const MyApp());
}

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

class CalculadoraPage extends StatefulWidget {
  const CalculadoraPage({super.key});

  @override
  State<CalculadoraPage> createState() {
    return _CalculadoraState();
  }
}

class _CalculadoraState extends State<CalculadoraPage> {
  int resultado = 0;
  TextEditingController controllerOP1 = new TextEditingController();
  TextEditingController controllerOP2 = new TextEditingController();

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        backgroundColor: Theme.of(context).colorScheme.inversePrimary,
        title: Text("Calculadora Flutter"),
      ),
      body: Container(
        padding: EdgeInsets.all(16.0),
        child: Center(
          child: Column(
            mainAxisAlignment: MainAxisAlignment.center,
            crossAxisAlignment: CrossAxisAlignment.center,
            children: [
              Text("Calculadora Flutter"),
              Padding(padding: EdgeInsets.only(top: 16)),
              Text("Introduce los elementos para poder operarlos"),
              Padding(padding: EdgeInsets.only(top: 16)),
              Container(
                padding: EdgeInsets.only(left: 32, right: 32),
                child: Row(
                  mainAxisAlignment: MainAxisAlignment.center,
                  crossAxisAlignment: CrossAxisAlignment.start,
                  children: [
                    Expanded(
                      child: TextField(
                        controller: controllerOP1,
                        decoration: InputDecoration(
                          border: OutlineInputBorder(),
                          labelText: 'Operando 1',
                        ),
                      ),
                    ),
                    Padding(padding: EdgeInsets.only(left: 16)),
                    Expanded(
                      child: TextField(
                        controller: controllerOP2,
                        decoration: InputDecoration(
                          border: OutlineInputBorder(),
                          labelText: 'Operando 2',
                        ),
                      ),
                    ),
                  ],
                ),
              ),
              Padding(padding: EdgeInsets.only(top: 32)),
              Text("El resultado de la operacion es $resultado")

            ],
          ),
        ),
      ),
      floatingActionButton: FloatingActionButton(
        // TODO calcular el resultado
        onPressed: () {
          int op1 = int.parse(controllerOP1.text);
          int op2 = int.parse(controllerOP2.text);
          setState(() {
            resultado = op1 + op2;
          });
        },
        child: Padding(
          padding: const EdgeInsets.all(16.0),
          child: Text("Calcular"),
        ),
      ),
    );
  }
}

class MyHomePage extends StatefulWidget {
  const MyHomePage({super.key, required this.title});

  final String title;

  @override
  State<MyHomePage> createState() => _MyHomePageState();
}

class _MyHomePageState extends State<MyHomePage> {
  int _counter = 0;

  void _incrementCounter() {
    setState(() {
      _counter++;
    });
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        backgroundColor: Theme.of(context).colorScheme.inversePrimary,

        title: Text(widget.title),
      ),
      body: Center(
        child: Column(
          mainAxisAlignment: MainAxisAlignment.center,
          children: <Widget>[
            const Text('Pulsado:'),
            Text(
              '$_counter',
              style: Theme.of(context).textTheme.headlineMedium,
            ),
          ],
        ),
      ),
      floatingActionButton: FloatingActionButton(
        onPressed: _incrementCounter,
        tooltip: 'Increment',
        child: const Icon(Icons.add),
      ),
    );
  }
}

import 'package:flutter/material.dart';

class CalculadoraWidget extends StatefulWidget {
  @override
  State<StatefulWidget> createState() {
    return CalculadoraState();
  }
}


class CalculadoraState extends State<CalculadoraWidget> {

  TextEditingController controllerEdit1 = TextEditingController();
  TextEditingController controllerEdit2 = TextEditingController();
  int operando1 = 0;
  int operando2 = 0;
  int resultado = 0;
  @override
  void setState(VoidCallback fn) {
    // TODO: implement setState
    super.setState(fn);
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
        appBar: AppBar(title: Text("Calculadora"),),
        body: Center(child: Column(mainAxisAlignment: MainAxisAlignment.center,
          crossAxisAlignment: CrossAxisAlignment.center, children: [
            Text(resultado.toString()),
            Row(mainAxisAlignment: MainAxisAlignment.center,children: [ Expanded( // <-- le da un ancho al TextField dentro del Row
              child: TextField(
                controller: controllerEdit1,
                decoration: InputDecoration(
                  hintText: 'Introduce operando 1',
                  border: OutlineInputBorder(),
                ),
              ),
            ),Expanded( // <-- le da un ancho al TextField dentro del Row
              child: TextField(
                controller: controllerEdit2,
                decoration: InputDecoration(
                  hintText: 'Introduce operando 2',
                  border: OutlineInputBorder(),
                ),
              ),
            )],),
            ElevatedButton(onPressed: () {
              setState((){
                resultado = int.parse(controllerEdit1.text) + int.parse(controllerEdit2.text);
              });
            }, child: Text("Calcular"))
          ],),),
        floatingActionButton: FloatingActionButton(onPressed: () {})
    );
  }

}
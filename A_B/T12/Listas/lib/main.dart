import 'package:flutter/material.dart';
import 'package:listas/ListActivity.dart';

void main() {
  runApp(MyAppRoutes());
}

class MyAppRoutes extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    // TODO: implement build

    return MaterialApp(
        routes: {
          "lista": (context) => ListActivity(),
          "formulario": (context) => ListaElementos()
        },
        home: NavegacionPrincipal());
  }
}

class NavegacionPrincipal extends StatelessWidget{
  const NavegacionPrincipal({super.key});

  @override
  Widget build(BuildContext context) {
    // TODO: implement build
    return Scaffold(
        appBar: AppBar(title: Text("Aplicacions de lisaws")),
        body: Column(
          mainAxisAlignment: MainAxisAlignment.center,
          crossAxisAlignment: CrossAxisAlignment.center,
          children: [
            ElevatedButton(
                onPressed: () {
                  Navigator.pushNamed(context, "lista");
                },
                child: Text("Pantalla 1")),
            ElevatedButton(onPressed: () {
              Navigator.pushNamed(context, "formulario");
            }, child: Text("Pantalla 2"))
          ],
        ));
  }

}

class MyApp extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    // TODO: implement build
    return MaterialApp(
      home: Scaffold(
          appBar: AppBar(title: Text("Proyecto de listas")),
          body: ListaCartas()),
    );
  }
}

class ListaCartas extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    var asignaturas = ["C1", "C2", "C3", "C4", "C5"];

    return ListView.builder(itemBuilder: (context, index) {
      children:
      <Widget>[
        const Card(
          child: ListTile(
            leading: FlutterLogo(size: 56.0),
            title: Text('Two-line ListTile'),
            subtitle: Text('Here is a second line'),
            trailing: Icon(Icons.more_vert),
          ),
        ),
      ];
    });
  }
}

class ListaElementos extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    var asignaturas = ["PMDM", "AD", "DI", "PSP", "SGE"];

    return ListView.builder(
      itemCount: asignaturas.length,
      itemBuilder: (context, index) {
        return ListTile(
            onTap: () {},
            title: Text(asignaturas[index]),
            leading: Checkbox(
              value: true,
              onChanged: (bool? value) {},
            ));
      },
    );
  }
}

class ListaNormal extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return ListView(
      children: <Widget>[
        ListTile(title: Text("Elemento 1")),
        ListTile(title: Text("Elemento 2")),
        ListTile(title: Text("Elemento 3")),
        ListTile(title: Text("Elemento 4"))
      ],
    );
  }
}

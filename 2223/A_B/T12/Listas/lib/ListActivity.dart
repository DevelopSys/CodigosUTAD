import 'package:flutter/material.dart';
import 'package:listas/Usuarios.dart';

class ListActivity extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    final List<Usuario> usuarios = [
      Usuario("Borja", "Martin", 39),
      Usuario("Juan", "Sanchez", 30),
      Usuario("Celia", "Martin", 25),
      Usuario("Claudia", "Martin", 20)
    ];
    // TODO: implement build

    return Scaffold(
        appBar: AppBar(title: Text("Aplicacions de lisaws")),
        body: Center(
          child: ListView.builder(
              itemBuilder: (context, index) {
                return ListTile(
                    title: Text(usuarios[index].nombre), onTap: () {
                  ScaffoldMessenger.of(context).showSnackBar(
                    SnackBar(
                      content: Text('El nombre del usuario es '+usuarios[index].apellido),
                      action: SnackBarAction(
                        label: 'Action',
                        onPressed: () {
                          // Code to execute.
                        },
                      ),
                    ),
                  );
                });
              },
              itemCount: usuarios.length),
        ));
  }
}

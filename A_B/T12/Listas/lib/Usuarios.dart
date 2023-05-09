class Usuario{

  String _nombre;
  String _apellido;
  int _edad;
  int? _salario;

  Usuario(this._nombre, this._apellido, this._edad);
  Usuario.fromParametros(String nombre, String apellido, int edad, int salario):
        this._nombre = nombre, this._apellido = apellido, this._edad = edad, this._salario = salario;
  String get nombre{
    return this._nombre;
  }

  String get apellido{
    return this._apellido;
  }
}
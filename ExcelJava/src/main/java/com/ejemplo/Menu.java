package com.ejemplo;

import java.util.Scanner;

public class Menu {

public void iniciar() {

Scanner sc = new Scanner(System.in);

ExcelDAO excel = new ExcelDAO();

System.out.println("==== MENU ====");
System.out.println("1. Agregar empleado");
System.out.println("2. Buscar empleado");
System.out.println("3. Modificar empleado");
System.out.println("4. Eliminar empleado");
System.out.println("5. Listar empleados");
System.out.print("Opción: ");

int opcion = sc.nextInt();

switch (opcion) {

case 1:

System.out.print("ID: ");
int id = sc.nextInt();

sc.nextLine();

System.out.print("Nombre: ");
String nombre = sc.nextLine();

Empleado empleado =
new Empleado(id, nombre);

excel.guardarEmpleado(empleado);

break;

case 2:

System.out.print("ID a buscar: ");
int idBuscar = sc.nextInt();

excel.buscarEmpleado(idBuscar);

break;

case 3:

System.out.print("ID a modificar: ");
int idMod = sc.nextInt();

sc.nextLine();

System.out.print("Nuevo nombre: ");
String nuevoNombre = sc.nextLine();

excel.actualizarEmpleado(idMod, nuevoNombre);

break;

case 4:

System.out.print("ID a eliminar: ");
int idEliminar = sc.nextInt();

excel.eliminarEmpleado(idEliminar);

break;

case 5:

excel.listarEmpleados();

break;

default:

System.out.println("Opción no válida");

}

sc.close();
}
}
package com.ejemplo;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDAO {

public void guardarEmpleado(Empleado emp) {

try {

File archivoExcel = new File("empleados.xlsx");

XSSFWorkbook libro;
XSSFSheet hoja;

if (archivoExcel.exists()) {

FileInputStream fis = new FileInputStream(archivoExcel);

libro = new XSSFWorkbook(fis);
hoja = libro.getSheetAt(0);

fis.close();

} else {

libro = new XSSFWorkbook();

hoja = libro.createSheet("Empleados");

Row encabezado = hoja.createRow(0);

encabezado.createCell(0).setCellValue("ID");

encabezado.createCell(1).setCellValue("Nombre");
}

int ultimaFila = hoja.getLastRowNum();

Row fila = hoja.createRow(ultimaFila + 1);

fila.createCell(0)
.setCellValue(emp.getId());

fila.createCell(1)
.setCellValue(emp.getNombre());

FileOutputStream fos =
new FileOutputStream(archivoExcel);

libro.write(fos);

fos.close();
libro.close();

System.out.println("Empleado agregado");

} catch (Exception e) {

e.printStackTrace();

}
}
public void buscarEmpleado(int idBuscar) {

try {

File archivoExcel =
new File("empleados.xlsx");

if (!archivoExcel.exists()) {

System.out.println("No existe el archivo Excel");
return;
}

FileInputStream fis =
new FileInputStream(archivoExcel);

XSSFWorkbook libro =
new XSSFWorkbook(fis);

XSSFSheet hoja =
libro.getSheetAt(0);

boolean encontrado = false;

for (Row fila : hoja) {

if (fila.getRowNum() == 0) {
continue;
}

int id =
(int) fila.getCell(0)
.getNumericCellValue();

if (id == idBuscar) {

String nombre =
fila.getCell(1)
.getStringCellValue();

System.out.println("Empleado encontrado");
System.out.println("ID: " + id);
System.out.println("Nombre: " + nombre);

encontrado = true;
break;
}
}

if (!encontrado) {
System.out.println("ID no encontrado");
}
libro.close();
fis.close();

} catch (Exception e) {

e.printStackTrace();

}
}
public void actualizarEmpleado(int idBuscar, String nuevoNombre) {

try {

File archivoExcel =
new File("empleados.xlsx");

if (!archivoExcel.exists()) {

System.out.println("No existe el archivo Excel");
return;
}

FileInputStream fis =
new FileInputStream(archivoExcel);

XSSFWorkbook libro =
new XSSFWorkbook(fis);

XSSFSheet hoja =
libro.getSheetAt(0);

boolean encontrado = false;

for (Row fila : hoja) {

if (fila.getRowNum() == 0) {
continue;
}

int id =
(int) fila.getCell(0)
.getNumericCellValue();

if (id == idBuscar) {

fila.getCell(1)
.setCellValue(nuevoNombre);

encontrado = true;
break;
}
}

fis.close();

if (encontrado) {

FileOutputStream fos =
new FileOutputStream(archivoExcel);

libro.write(fos);

fos.close();

System.out.println("Empleado actualizado");

} else {

System.out.println("ID no encontrado");
}

libro.close();

} catch (Exception e) {

e.printStackTrace();

}
}
public void eliminarEmpleado(int idBuscar) {

try {

File archivoExcel =
new File("empleados.xlsx");

if (!archivoExcel.exists()) {

System.out.println("No existe el archivo Excel");
return;
}

FileInputStream fis =
new FileInputStream(archivoExcel);

XSSFWorkbook libro =
new XSSFWorkbook(fis);

XSSFSheet hoja =
libro.getSheetAt(0);

boolean encontrado = false;

for (int i = 1; i <= hoja.getLastRowNum(); i++) {

Row fila = hoja.getRow(i);

if (fila == null) {
continue;
}

int id =
(int) fila.getCell(0)
.getNumericCellValue();

if (id == idBuscar) {

hoja.removeRow(fila);

if (i < hoja.getLastRowNum()) {

hoja.shiftRows(
i + 1,
hoja.getLastRowNum(),
-1);
}

encontrado = true;
break;
}
}

fis.close();

if (encontrado) {

FileOutputStream fos =
new FileOutputStream(archivoExcel);

libro.write(fos);

fos.close();

System.out.println("Empleado eliminado");

} else {

System.out.println("ID no encontrado");
}

libro.close();

} catch (Exception e) {

e.printStackTrace();

}
}
public void listarEmpleados() {

try {

File archivoExcel =
new File("empleados.xlsx");

if (!archivoExcel.exists()) {

System.out.println("No existe el archivo Excel");
return;
}

FileInputStream fis = new FileInputStream(archivoExcel);

XSSFWorkbook libro = new XSSFWorkbook(fis);

XSSFSheet hoja = libro.getSheetAt(0);

System.out.println("\nLISTA DE EMPLEADOS");
System.out.println("------------------");

for (Row fila : hoja) {

if (fila.getRowNum() == 0) {
continue;
}

int id = (int) fila.getCell(0)
.getNumericCellValue();

String nombre = fila.getCell(1).getStringCellValue();

System.out.println("ID: " + id +" Nombre: " + nombre);
}

libro.close();
fis.close();

} catch (Exception e) {

e.printStackTrace();

}
}
}
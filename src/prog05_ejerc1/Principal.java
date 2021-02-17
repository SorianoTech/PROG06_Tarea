
/*
Referencias utilizadas
# Como crear un objeto en un swith case.
https://stackoverflow.com/questions/30448705/java-trying-to-create-an-object-using-switch-statement-with-different-parameters

#Sacar los años entre dos fechas
https://stackoverflow.com/questions/7906301/how-can-i-find-the-number-of-years-between-two-dates

## Posibles mejoras
 - 1. Cambiar los datos de la fecha a int
 - 2. Validar los tipos datos de entrada de cada una de las opciones.

 */
package prog05_ejerc1;

import java.util.Scanner;
import prog05_ejerc1_util.*; //importamos el paquere de utilidades

/**
 * Esta es la clase principal. Consiste en una aplicación para mostrar
 * informaciñon sobre vehiculos. Muestra un menu para añadir y modificar
 * información sobre los vehiculos.
 *
 * @author Sergio Soriano
 *
 */
public class Principal {
    /**
     * @param args Devuelve el menu principal
     *
    **/
    //Metodo principal main
    public static void main(String[] args)  {

        String marca;
        String DeNI;
        String matricula;
        int num_km = 0; //incializamos a 0 para poder validar
        int mas_km;
        String dia, mes, ano;
        String descripcion;
        double precio;
        String nombre_propietario;
        int opcion;
        Scanner teclado = new Scanner(System.in);
        Vehiculo mi_coche = null; //Inicializamos mi_coche a null;
        String fecha = ""; //para almacenar la fecha en un string
        
                
            
        do {//Muestra el menu mientras que opcion no sea igual a 9

            System.out.println("Bienvenido, selecciona una opcion del 1 al 9.");
            System.out.println("1. Nuevo Vehiculo");
            System.out.println("2. Ver Matricula");
            System.out.println("3. Ver número de Kilómetros");
            System.out.println("4. Actualizar KM");
            System.out.println("5. Ver años de antigüedad");
            System.out.println("6. Mostrar propietario");
            System.out.println("7. Mostrar descripcion");
            System.out.println("8. Mostrar precio");
            System.out.println("9. Salir");

            opcion = teclado.nextInt();
            teclado.nextLine(); //Pedimos la opcion por teclado

            try {
                switch (opcion) {
                    case 1:
                        //Pedir valores por pantalla     
                        System.out.println("Introduce la Marca: ");
                        marca = teclado.nextLine();
                        System.out.println("Introduce la Matricula: ");
                        matricula = teclado.nextLine();
                        System.out.println("Introduce los Kilometros: ");
                        num_km = teclado.nextInt();
                        teclado.nextLine();
                        System.out.println("Introduce el día de Matriculación: ");
                        dia = teclado.nextLine();//teclado.nextLine();
                        System.out.println("Introduce el mes de Matriculación en formato númerico: ");
                        mes = teclado.nextLine();//teclado.nextLine();
                        System.out.println("Introduce el año de Matriculación: ");
                        ano = teclado.nextLine();//teclado.nextLine();
                        System.out.println("Introduce la descripcion del vehiculo: ");
                        descripcion = teclado.nextLine();
                        System.out.println("Introduce el precio: ");
                        precio = teclado.nextInt();
                        teclado.nextLine();
                        System.out.println("Introduce el propietario: ");
                        nombre_propietario = teclado.nextLine();

                        do {//Validamos el documento de identidad
                            System.out.println("Introduce el  DNI: ");
                            DeNI = teclado.nextLine();
                            if (!DNI.validarNIF(DeNI)) {
                                System.out.println("DNI Invalido, introduce uno valido");
                            };
                        } while (!DNI.validarNIF(DeNI));
                        //Fin pedir valores por pantalla
                        
                        //Añade un 0 si se introduce el dia en formato individual.
                        int diaNumero = Integer.parseInt(dia);
                        int mesNumero = Integer.parseInt(mes);
                        if (diaNumero < 10) {
                            dia = "0" + dia;
                        }
                        if (mesNumero < 10) {
                            mes = "0" + mes;
                        }

                        fecha = ano + "-" + mes + "-" + dia;//metemos los valores en una variable para pasarsela al metodo getAnios

                        //Código para crear el vehículo
                        
                        mi_coche = new Vehiculo(marca, matricula, num_km, dia, mes, ano, descripcion, precio, nombre_propietario, DeNI);
                        
                        
                        
                        break;
                    case 2: //llamamos al metodo para obtener la matricula
                        System.out.println(mi_coche.getMatricula());
                        break;
                    case 3: //Ver Num_km
                        System.out.println(mi_coche.getNum_km());
                        break;
                    case 4:
                        //Actualizar KM
                        if (num_km != 0) {
                            System.out.println("¿Cuántos Kilometros quieres añaidr?");
                            mas_km = teclado.nextInt();
                            teclado.nextLine();
                            mi_coche.setNum_km(mas_km);
                            System.out.println("El coche ahora tiene " + mi_coche.getNum_km());
                        } else {
                            System.out.println("!!!!!!!!!!Primero debes crear un Vehiculo");
                        }
                        break;
                    case 5: //ver años antiguedad
                        if (fecha != "") {//Comprueba si hay una fecha asignada
                            System.out.println("El coche tiene "+ Metodos.getAnios(fecha)+ " Años");
                        } else {//Delve un mensaje de error
                            System.out.println("!!!!!!!!!!Primero debes crear un Vehiculo");
                        }
                        break;
                    case 6: // Mostrar propietario
                        System.out.println(mi_coche.getNombre_propietario());
                        break;
                    case 7: //Mostrar descripcion
                        System.out.println(mi_coche.getDescripcion());
                        break;
                    case 8:
                        System.out.println(mi_coche.getPrecio());
                        break;
                }
            } catch (NullPointerException e) {//Captura si no se ha creado el objeto 
                //mensaje de error para indicar que no existen vehículos creados
                System.out.println("No existe ningun vehiculo creado");
                System.out.println("Presiona intro para volver al menu.................");
                teclado.nextLine();
            }
        } while (opcion != 9);
    }

}

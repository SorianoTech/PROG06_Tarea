
/*
En esta clase solo se debe utilizar la clase Concesionario
Referencias utilizadas
Array de objetos: https://javadesdecero.es/arrays/unidimensionales-multidimensionales/#24_Arrays_de_objetos

Errores: Error al introducir una letra en el campo actualizarkm
Solucion: se añade un teclado.nextLine(); para liberar el buffer

## Posibles mejoras
 - 1. Cambiar los datos de la fecha a int
 - 2. Validar los tipos datos de entrada de cada una de las opciones.
##

Mejoras para Unidadad 6
#001 - Cambiar el metodo getAnios() a la clase Vehiculo.
#002 - Verificar las validades (todas) en la clase metodos del paquete util
#003 - Implementar clase Concesionario. max 50 Vehiculos.
#004 - Modificar menu para los requisitos nuevos.
#005 - Extraer método mostrarMenu() en la clase metodos.
#006 - Validar mediante exp. reg el DNI y la matrícula. Tan solo el formato
#007 - Validar mediante clase string el nombre y dos apellidos, max 40 char
#008 - Verificar que la matrícula introducida no existe, mensaje y mostrar menu de nuevo.
#009 - Añadir logica para insertarVehiculos() al concesionario
#010 - Añadir lógica para buscarVehiculo()
#011 - Añadir lógica para listarVehiculos()
#012 - Añadir lógica para actualizarKms()
#013 - Validar que le propietario tiene un nombre y apellido con un max de 40 caracteres.

Error
#014 - Error al introducir una letra en el campo actualizarkm

 */
package prog06_ejerc1;

import java.util.InputMismatchException;
import java.util.Scanner;
import prog06_ejerc1_util.Metodos;

/**
 * Esta es la clase principal. Consiste en una aplicación para crear un
 * concesionaro de vehiclos. Muestra un menu para añadir, modificar y buscar los
 * vehiculos. En esta clase se debe implementar : - Instanciar un objeto
 * Concesionario. - Pintar el menú y solicitar datos por teclado al usuario. -
 * Realizar las validaciones de datos de entrada. - Mostrar datos por pantalla
 *
 * @author Sergio Soriano
 *
 */
public class Principal {

    /**
     * @param args Devuelve el menu principal
     *
     *
     */
    //Metodo principal main
    public static void main(String[] args) {

        String marca;
        String DeNI;
        String matricula = "";
        int num_km = 0; //incializamos a 0 para poder validar
        int mas_km;
        String dia, mes, ano;
        String descripcion;
        double precio;
        String nombre_propietario;
        int opcion;
        Scanner teclado = new Scanner(System.in);
        Concesionario concesionarioObj = new Concesionario();
        String fecha = ""; //para almacenar la fecha en un string

        do {
            Metodos.mostrarMenu(); //Extraemos el menu a un metodo
            opcion = teclado.nextInt();
            teclado.nextLine(); //Pedimos la opcion por teclado

            try {
                switch (opcion) {
                    case 1:
                        //Pedir valores por pantalla 
                        marca = "Opel";
                        matricula = "9167";
                        num_km = 1000;
                        dia = "10";
                        mes = "2";
                        ano = "2000";
                        descripcion = "nueva des";
                        precio = 1000;
                        nombre_propietario = "Pepe";
                        DeNI = "53499944N";

                        //System.out.println("Introduce la Marca: ");
                        //marca = teclado.nextLine();
                        do { // Bucle para comprobar que la matricula esta en formato correcto
                            System.out.println("Introduce la Matricula: ");
                            matricula = teclado.nextLine();
                        } while (!Metodos.formatoMatricula(matricula));
                        /*
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
                        */
                        do{ //Pedimos el nombre hasta que tenga 3 elementos separados por algun espacio
                            System.out.println("Introduce el propietario: ");
                            nombre_propietario = teclado.nextLine();
                        } while(!Metodos.validarNombre(nombre_propietario));
                        

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
                        int estado = concesionarioObj.insertarVehiculo(marca, matricula, num_km, dia, mes, ano, descripcion, precio, nombre_propietario, DeNI); // Capturamos la variable estado

                        switch (estado) { //Imprimimos errores segun el valor de la variable estado.
                            case -2:
                                System.out.println("El vehiculo ya existe.... No se puede añadir....");
                                break;
                            case -1:
                                System.out.println("El concesionario esta lleno.");
                                break;
                            default:
                                System.out.println("Vehiculo añadido correctamente");
                                break;
                        }

                        break;

                    case 2: //Opcion para mostrar todos los vehiculos
                        concesionarioObj.listarVehiculos();
                        Metodos.mensajePausa();
                        break;
                    case 3: //Opcion para buscar vehiculo
                        System.out.println("Introduce la matricula del vehiculo que quieres buscar");
                        matricula = teclado.nextLine();
                        if (concesionarioObj.buscarVehiculo(matricula) == null) { //Si el valor recibido es null imprimo un mensaje
                            System.out.println("Vehiculo no Encontrado!");
                            Metodos.mensajePausa();

                        } else {
                            System.out.println(concesionarioObj.buscarVehiculo(matricula)); // Imprimo el String que me devuelve del coche
                            Metodos.mensajePausa();
                        }
                        break;
                    case 4: //Opción para actualizar los KM de un vehiculo.
                        //Actualizar KM
                        System.out.println("¿Introduce la matricula del vehiculo?");
                        String buscaMatricula = teclado.nextLine();
                        System.out.println("¿Cuántos Kilometros quieres añadir?");
                        mas_km = teclado.nextInt();
                        teclado.nextLine();
                        if (concesionarioObj.actualizarKms(buscaMatricula, mas_km)) {//Comprobamos si existe el vehiculo devuleve true si esa asi
                            System.out.println("Kilometros actualizados");
                        } else {//Si no esta la matricula imprime un error
                            System.out.println("Error... matricula no encontrada");
                        }
                        break;
                    default:
                        System.out.println("Opcion incorrecta...");
                }

            } catch (InputMismatchException e) {//Captura si se introduce un valor no valido
                
                System.out.println("Dato erroneo");
                teclado.nextLine();
                Metodos.mensajePausa();
            }
        } while (opcion != 5);
    }

}

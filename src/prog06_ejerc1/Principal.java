
/*
Referencias utilizadas
# Como crear un objeto en un swith case.
https://stackoverflow.com/questions/30448705/java-trying-to-create-an-object-using-switch-statement-with-different-parameters

#Sacar los años entre dos fechas
https://stackoverflow.com/questions/7906301/how-can-i-find-the-number-of-years-between-two-dates

## Posibles mejoras
 - 1. Cambiar los datos de la fecha a int
 - 2. Validar los tipos datos de entrada de cada una de las opciones.
##

Mejoras para Unidadad 6
#001 - Cambiar el metodo getAnios() a la clase Vehiculo.
#002 - Verificar las validades (todas) en el clase metodos del paquete util
#003 - Implementar clase Concesionario. max 50 Vehiculos.
#004 - Modificar menu para los requisitos nuevos.
#005 - Extraer método mostrarMenu() en la clase metodos.
#006 - Validar mediante exp. reg el DNI y la mátricula.
#007 - Validar mediante clase string el nombre y dos apellidos, max 40 char
#008 - Verificar que la metricula introducida no existe, mensaje y mostrar menu de nuevo.
 */
package prog06_ejerc1;

import prog06_ejerc1_util.DNI;
import java.util.Scanner;
import prog06_ejerc1_util.Metodos;

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
        
                
            
        do {
            Metodos.mostrarMenu(); //Extraemos el menu a un metodo

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
                            }
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
                    case 2: //Opcion para mostrar todos los vehiculos
                        System.out.println(mi_coche.getMatricula());
                        break;
                    case 3: //Opcion para buscar vehiculo
                        System.out.println(mi_coche.getNum_km());
                        break;
                    case 4: //Opción para modificar los KM de un vehiculo.
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
                    
                }
            } catch (NullPointerException e) {//Captura si no se ha creado el objeto 
                //mensaje de error para indicar que no existen vehículos creados
                System.out.println("No existe ningun vehiculo creado");
                System.out.println("Presiona intro para volver al menu.................");
                teclado.nextLine();
            }
        } while (opcion != 5);
    }


}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prog06_ejerc1_util;

import java.time.*;
import java.util.Date;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * La clase Metodos contiene los metodos funcionales necesarios para validad los
 * datos y obtener los años que tiene el vehiculo
 *
 * @author Sergio Soriano
 */
public class Metodos {//Clase publica para poder acceder dese otro paquete

    static Scanner teclado = new Scanner(System.in);

    /**
     * Muestra el menu con las opciones disponibles
     *
     */
    public static void mostrarMenu() {
        //Muestra el menu 
        System.out.println("************************************************");
        System.out.println("Bienvenido, selecciona una opcion del 1 al 5:");
        System.out.println("1. Nuevo Vehículo");
        System.out.println("2. Listar Vehículos");
        System.out.println("3. Buscar Vehículo");
        System.out.println("4. Modificar Kms de vehículo");
        System.out.println("5. Salir");
        System.out.println("************************************************");
    }

    /**
     * Método estático para hacer una pausa y presionar enter
     *
     */
    public static void mensajePausa() {
        System.out.println("Presiona intro para volver al menu.................");
        teclado.nextLine();
        for (int i = 0; i < 10; i++) { // 
            System.out.print("\n"); // Imprime espacios en blanco
        }
    }

    /**
     * Método para comprobar el patron del DNI, solo el formato
     *
     * @param dni
     * @return true si es correcto y false si no lo es
     */
    public static boolean dniRegex(String dni) {
        Pattern patronDNI = Pattern.compile("([XY]?)([0-9]{1,9})([A-Za-z])"); //Creamos el patron del DNI
        Matcher matcher = patronDNI.matcher(dni); // Se lo pasamos a la clase matcher
        boolean dniValido = matcher.matches(); // comprobamos si es correcto con el metodo matches()
        return dniValido; //devolvemos true o false
    }

    /**
     * Método para comprobar el formato de la matricula
     *
     * @param matricula
     * @return verdadero si la matricula es válida
     */
    public static boolean formatoMatricula(String matricula) {
        Pattern patronMatricula = Pattern.compile("([0-9]{4})([A-Z]{3})");
        Matcher matcher = patronMatricula.matcher(matricula.toUpperCase()); //Le pasamos el patron pasandolo a mayusculas
        boolean matriculaValida = matcher.matches();
        if (matriculaValida) {
            System.out.println("Matrícula válida");
            return true;
        } else {
            System.out.println("Matrícula inválida");
            return false;
        }
    }
    /**
     * Meteodo para comprobar el nombre del propietario
     * @param nombre
     * @return verdadero si el nombre tiene 3 o mas espacios y menos de 40 carácteres
     */
    
    public static boolean validarNombre(String nombre) {
        //definimos variables para conocer la cantidad espacios y caracteres
        int cantidadEspacios = nombre.split("\\s+|\n|,").length;
        int cantidadCaracteres =nombre.length();
        if (cantidadEspacios >= 3 && cantidadCaracteres<40) { //Evaluamos si cumple con la condición
            return true;
        } else {
            System.out.println("Nombre incorrecto, por favor introduzca nombre y dos apellidos.");
            return false;
        }

    }

}

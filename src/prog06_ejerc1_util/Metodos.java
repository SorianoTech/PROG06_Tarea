/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prog06_ejerc1_util;

import java.time.*;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * La clase Metodos contiene los metodos funcionales necesarios para validad los
 * datos y obtener los años que tiene el vehiculo
 *
 * @author Sergio Soriano
 */
public class Metodos {//Clase publica para poder acceder dese otro paquete

    /**
     * Muestra el menu con las opciones disponibles
     *
     */
    public static void mostrarMenu() {
        //Muestra el menu 
        System.out.println("Bienvenido, selecciona una opcion del 1 al 9.");
        System.out.println("1. Nuevo Vehiculo");
        System.out.println("2. Listar Vehiculos");
        System.out.println("3. Buscar Vehiculo");
        System.out.println("4. Modificar Kms de vehiculo");
        System.out.println("5. Salir");
    }

    /**
     * Metodo para comprobar el patron del DNI, solo el formato
     *
     * @param dni
     * @return true si es correcto y false si no lo es
     */
    public boolean dniRegex(String dni) {
        Pattern patronDNI = Pattern.compile("[0-9]{7,8}[A-Z a-z]"); //Creamos el patron del DNI
        Matcher matcher = patronDNI.matcher(dni); // Se lo pasamos a la clase matcher
        boolean dniValido = matcher.matches(); // comprobamos si es correcto con el metodo matches()
        return dniValido; //devolvemos true o false

    }

    /**
     * Meotodo para comprobar el formato de la matricula
     * @param matricula
     * @return 
     */
    public boolean formatoMatricula(String matricula) {
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

}

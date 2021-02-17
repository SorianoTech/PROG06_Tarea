/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prog06_ejerc1_util;

import java.time.*;
import java.util.Date;

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

}

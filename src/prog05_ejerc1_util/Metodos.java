/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prog05_ejerc1_util;

import java.time.*;
import java.util.Date;

/**
 * La clase Metodos contiene los metodos funcionales necesarios para validad los
 * datos y obtener los años que tiene el vehiculo
 *
 * @author Sergio Soriano
 */
public class Metodos {//Clase publica para poder acceder dese otro paquete

    //atributos de clase
    //metodo estatico getAnios()
    /**
     *
     * @param dateMatricula Recibe la fecha de matriculacion en formato String
     * @return anosFinal valor de años de matriculacion
     */
    public static int getAnios(String dateMatricula) {
        int anosFinal = 0;
        LocalDate startDate = LocalDate.now(); //Contiene la fecha actual
        LocalDate endDate = LocalDate.parse(dateMatricula);
        Period anos = Period.between(endDate, startDate); //calclo de la fecha utilizando la clase Period
        anosFinal = anos.getYears(); //asignamos a la variable con el metodo getYears
        return anosFinal;//devolvemos la variable.
    }

}

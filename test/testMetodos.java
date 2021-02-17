
import java.time.*;
//import java.time.LocalDate;
//import java.time.Period;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Administrador
 */
public class testMetodos {

    public static void main(String[] args) {
        String a = String.valueOf(20);
        System.out.println(String.valueOf(20)); 
        System.out.println(a.getClass().getName()); 
        //--Pruebas para obtener los años de matriculacion---//
        LocalDate startDate = LocalDate.now(); //Contiene la fecha actual
        //LocalDate startDate = LocalDate.parse("2015-03-15");
        //--LocalDate endDate = LocalDate.parse(dateMatricula);
        LocalDate endDate = LocalDate.parse("2019-01-15");
        Period anos = Period.between(endDate, startDate );

        if (startDate.isAfter(endDate)) {
            System.out.println("Bien la fecha de matriculacion es anterior a HOY!!");
        }

        long years = java.time.temporal.ChronoUnit.YEARS.between(endDate, startDate);
        
        System.out.println("start: " + startDate + " | stop: " + endDate + " | years: " + years);
        System.out.println(startDate);
        System.out.println(anos.getYears()+" Años y" + anos.getMonths()+" Meses");
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prog05_ejerc1;

/**
 *
 * @author Administrador
 */
public class Concesionario {

    //Definicion de atributos de la clase
    String estaVehiculo; //variable para devolver el vehiculo encontrado
    boolean kmActualizados; // variable para saber si se han actualizado los km
    int contVehiculos = 0; //variable para conocer el numero de vehiculos en el concesionario

    /**
     * Metodo para buscar un vehiculo Recibe como parámetro una matrícula,
     * buscar el vehículo en el concesionario y devuelve una cadena con los
     * datos del vehículo o null si el vehículo buscado no existe
     *
     * @param matricula
     * @return
     */
    public String buscarVehiculo(String matricula) {
        //logica para buscar el vehiculo y ver si existe
        return estaVehiculo;
    }

    /**
     * Metodo para insertar un vehiculo Recibe todos los datos de un vehículo y
     * trata de insertarlo en el concesionario.
     *
     * @param
     * @return estado Devuelve 0 si se hizo con éxito, -1 si el concesionario
     * esta lleno y -2 si la matrícula ya existe.
     */
    public int insertarVehiculo() {
        //logica para insertar el vehiculo o mostrar devolver error que luego podemos capturar
        int estado = 0;
        return estado;
    }

    /**
     * Metodo para mostrar todos los vehiculos del concesionario Imprimre todos
     * los vehiculos, no devuelve valores
     */
    public void listarVehiculos() {
        //Imprime todos los vehiculos
    }

    /**
     * Metodo actualizaKms: Recibe por parámetro una matrícula y un número de
     * kilómetros, busca el vehículo con la cuya matrícula coincida y actualiza
     * sus kilómetros. Devuelve true si se hizo con éxito y false en caso
     * contrario.
     * @param matricula 
     * @param kilometros
     * @return devuelve true si se han actualizado o false si ha habido algún problema
     *
     */
    public boolean actualizarKms(String matricula, int kilometros) {
        //Logica del metodo
        return kmActualizados;
    }
}

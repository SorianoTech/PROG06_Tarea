/*
 * Referencias utilizadas
 * Array de Obetjos: https://www.discoduroderoer.es/arrays-de-objetos-en-java/
 */
package prog06_ejerc1;

import prog06_ejerc1_util.Metodos;



/**
 * La clase concesionario se encarga de las tareas de 
 * @author Administrador
 */
public class Concesionario {

   

    //Definicion de atributos de la clase
    
    
    static final int MAXVEHICULOS = 50;
    String estaVehiculo; //variable para devolver el vehiculo encontrado
    boolean kmActualizados; // variable para saber si se han actualizado los km
    static private int contVehiculos = 0; //variable para conocer el número de vehiculos en el concesionario
    Vehiculo[] arrayCoches = new Vehiculo[MAXVEHICULOS]; //instanciamos un objeto de la clase Vehiculo en forma de array

    
    
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
     * @param marca
     * @param matricula
     * @param num_km
     * @param dia
     * @param mes
     * @param ano
     * @param descripcion
     * @param nombre_propietario
     * @param precio
     * @param DeNI
     * @return estado Devuelve 0 si se hizo con éxito, -1 si el concesionario
     * esta lleno y -2 si la matrícula ya existe.
     */
    public int insertarVehiculo(String marca, String matricula, int num_km, String dia, String mes, String ano, String descripcion, double precio, String nombre_propietario, String DeNI) {
        
        //logica para insertar el vehiculo o mostrar devolver error que luego podemos capturar
        arrayCoches[contVehiculos] = new Vehiculo(marca, matricula, num_km, dia, mes, ano, descripcion, precio, nombre_propietario, DeNI);
        contVehiculos = contVehiculos + 1;
        //contVehiculos++;
        int estado = 0;
        Metodos.mensajePausa();
        return estado;
    }

    /**
     * Metodo para mostrar todos los vehiculos del concesionario Imprimre todos
     * los vehiculos, no devuelve valores
     */
    public void listarVehiculos() {
        //Imprime todos los vehiculos
        for (int i = 0; i < contVehiculos; i++) {
            System.out.println(">>Vehiculo número:" + i);
            System.out.println("----------------------");
            System.out.println("Marca: "+ arrayCoches[i].getMarca());
            System.out.println("Matrícula: "+ arrayCoches[i].getMatricula());
            System.out.println("Precio: "+ arrayCoches[i].getPrecio()+" €");
            System.out.println("Kilómetros: "+ arrayCoches[i].getNum_km());
            System.out.println("Descripción: "+ arrayCoches[i].getDescripcion());
            System.out.println("----------------------");
        }
        
      
        
    }

    /**
     * Metodo actualizaKms: Recibe por parámetro una matrícula y un número de
     * kilómetros, busca el vehículo con la cuya matrícula coincida y actualiza
     * sus kilómetros. Devuelve true si se hizo con éxito y false en caso
     * contrario.
     *
     * @param matricula
     * @param kilometros
     * @return devuelve true si se han actualizado o false si ha habido algún
     * problema
     *
     */
    public boolean actualizarKms(String matricula, int kilometros) {
        //Logica del metodo
        return kmActualizados;
    }
    
     /**
     * @return the contVehiculos
     */
    protected int getContVehiculos() {
        return contVehiculos;
    }

    
}

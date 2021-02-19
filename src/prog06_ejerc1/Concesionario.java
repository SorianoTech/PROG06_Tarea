/*
 * Referencias utilizadas
 * Array de Objetos: https://www.discoduroderoer.es/arrays-de-objetos-en-java/
 * Buscar un dato en un array: https://www.youtube.com/watch?v=qS6Q8aUg-wM
 */
package prog06_ejerc1;

import prog06_ejerc1_util.Metodos;

/**
 * La clase concesionario se encarga de las tareas de - Añadir vehiculo - Listar
 * Vehiculos - modificar kms Vehiculo
 *
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
        int estado = 5;//asigno un valor
        //logica para insertar el vehiculo o mostrar devolver error que luego podemos capturar
        if (buscarVehiculo(matricula) == null) {// Si es igual a null es que no existe el vehiculo 
            if (contVehiculos != 50) {
                arrayCoches[contVehiculos] = new Vehiculo(marca, matricula, num_km, dia, mes, ano, descripcion, precio, nombre_propietario, DeNI);
                contVehiculos++; // Añade uno al contador de vehiculos
                //contVehiculos++;
                estado = 0; //Vehiculo insertado correctamente
                Metodos.mensajePausa();
            } else if (contVehiculos == 50) {
                estado = -1;
            }

        } else {
            estado = -2; //El vehiculo existe
        }
        return estado;
    }

    /**
     * Metodo void para mostrar todos los vehiculos del concesionario Imprimre
     * todos los vehiculos, no devuelve valores
     */
    public void listarVehiculos() {
        //Imprime todos los vehiculos
        if (contVehiculos == 0) {
            System.out.println("NO EXISTE NIGÚN VEHICULO");
        }
        for (int i = 0; i < contVehiculos; i++) {
            vehicuoEncontrado(i);
        }

    }

    /**
     * Metodo para buscar un vehiculo Recibe como parámetro una matrícula,
     * buscar el vehículo en el concesionario y devuelve una cadena con los
     * datos del vehículo o null si el vehículo buscado no existe
     *
     * @param matricula
     * @return coche Un string con los valores del coche
     */
    public String buscarVehiculo(String matricula) {
        //logica para buscar el vehiculo y ver si existe
        String coche = null; // Asignamos por defecto a null
        for (int i = 0; i < contVehiculos; i++) {
            //while (i<=contVehiculos){
            if (matricula.equals(arrayCoches[i].getMatricula())) { //comparo el string                
                coche = vehicuoEncontradoString(i); //Devuelve el vehiculo encontrado  
            }
        }
        return coche;//Devolvera null si no lo encuentra
    }

    /**
     * Meotod void para imprimir todos los valore de un vehiculo al ser
     * encontrado (sin string utilizado en listarVehiculos())
     *
     * @param i posición de la array del coche
     */
    public void vehicuoEncontrado(int i) {
        //Como la array empieza por 0, cuado inserte el primer vehiculo contVehiculos valdra 1
        System.out.println(">>Vehiculo número:" + i);
        System.out.println("----------------------");
        System.out.println("Marca: " + arrayCoches[i].getMarca());
        System.out.println("Matrícula: " + arrayCoches[i].getMatricula());
        System.out.println("Precio: " + arrayCoches[i].getPrecio() + " €");
        System.out.println("Kilómetros: " + arrayCoches[i].getNum_km());
        System.out.println("Descripción: " + arrayCoches[i].getDescripcion());
        System.out.println("----------------------");
    }

    /**
     * Metodo para devolver los valores del vehiculo en un String
     *
     * @param i posición de la array del coche
     * @return coche con los valores del vehichulo
     */
    public String vehicuoEncontradoString(int i) {
        //Como la array empieza por 0, cuado inserte el primer vehiculo contVehiculos valdra 1
        String coche = "";
        coche = ">>Vehiculo número:" + i + "\n" + "Marca: " + arrayCoches[i].getMarca() + "\nMatrícula: " + arrayCoches[i].getMatricula() + "\nPrecio: " + arrayCoches[i].getPrecio() + " €" + "\nKilómetros: " + arrayCoches[i].getNum_km() + "\nDescripción: " + arrayCoches[i].getDescripcion();
        return coche;
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
        //Logica del metodo actualizarKMS
        kmActualizados = false;
        for (int i = 0; i < contVehiculos; i++) {
            if (matricula.equals(arrayCoches[i].getMatricula())) { //comparo el string                
                arrayCoches[i].setNum_km(kilometros);
                kmActualizados = true;
                return kmActualizados;
            }
        }
        return kmActualizados;
    }

    /**
     * @return the contVehiculos
     */
    protected int getContVehiculos() {
        return contVehiculos;
    }

}

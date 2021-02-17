
package prog06_ejerc1;

import java.time.LocalDate;
import java.time.Period;



/**
 * La clase vehiculo permite generar un vehiculo nuevo
 *
 * @author Sergio Soriano
 */
public class Vehiculo {

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
        Period anos = Period.between(endDate, startDate); //calculo de la fecha utilizando la clase Period
        anosFinal = anos.getYears(); //asignamos a la variable con el metodo getYears
        return anosFinal; //devolvemos la variable.
    }

    //atributos de clase
    private String marca;
    private String matricula;
    private int num_km;
    private String dia, mes, ano;
    private String descripcion;
    private double precio;
    private String nombre_propietario;
    private String DNI;

    /**
    *Constructor de la clase vehiculo 
    @param  marca asigna la marca
    @param  matricula asgina la matricula
    @param  num_kum asgina el numero de kilometros
    @param  dia asigna el dia de matriculacion en formato string
    @param  mes asgina el mes en formato string
    @param  ano asgina el año en formato string
    @param  descripcion asgna la descripcion del vehiculo
    @param  precio asigna el precio
    @param  nombre_propietario asigna el nombre del propietario
   
    * 
    
    * 
    */
    
    
    public Vehiculo(String marca, String matricula, int num_km, String dia, String mes, String ano, String descripcion, double precio, String nombre_propietario, String DNI) {
        this.marca = marca;
        this.matricula = matricula;
        this.num_km = num_km;
        this.dia = dia;
        this.mes = mes;
        this.ano = ano;
        this.descripcion = descripcion;
        this.precio = precio;
        this.nombre_propietario = nombre_propietario;
        this.DNI = DNI;
    }
    //Metodos Get y Set
    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String Matricula) {
        this.matricula = matricula;
    }

    public int getNum_km() {
        return num_km;
    }

    public void setNum_km(int num_km) {
        this.num_km = num_km+ this.num_km; //sumamos los km que recibamos a los que tiene el objeto
    }

    public String getDia() {
        return dia;
    }

    
    public String getMes() {
        return mes;
    }

   
    public String getAno() {
        return ano;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getNombre_propietario() {
        return nombre_propietario;
    }

    public void setNombre_propietario(String nombre_propietario) {
        this.nombre_propietario = nombre_propietario;
    }

    public String getDNI() {
        return DNI;
    }

    public void setDNI(String DNI) {
        this.DNI = DNI;
    }

}

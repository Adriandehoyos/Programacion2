
import java.time.LocalDate;

public class Trabajador {



    private String nombre;
    private LocalDate fechaNacimiento;
    private String dni;
    private String direccion;
    private String numeroSS;

    public Trabajador(String nombre, LocalDate fechaNacimiento, String dni, String direccion, String numeroSS){
        this.nombre = nombre;
        this.fechaNacimiento = fechaNacimiento;
        this.dni = dni;
        this.direccion = direccion;
        this.numeroSS = numeroSS;
    }

    public String getNombre() {
        return nombre;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public String getDni() {
        return dni;
    }
    
    public String getDireccion() {
        return direccion;
    }

    public String getNumeroSS() {
        return numeroSS;
    }

    //mostrar info trabajador
    public String mostrarInfoTrabajador(){
        String infoTrabajador = String.format("Trabajador - Nombre: %s FechaNacimiento: %s Dni: %s Direccion: %s NumeroSS: %s ", 
        this.nombre, this.fechaNacimiento, this.dni,this.direccion, this.numeroSS);
        return infoTrabajador;
    }



}//

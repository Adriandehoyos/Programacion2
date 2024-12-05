
import java.time.LocalDate;

public class Cliente {

    private String dni;
    private String nombre;
    private String numSocio;
    private String direccion;
    private LocalDate fechaNacimiento;
    private LocalDate fechaBaja;
    private Pelicula [] peliculasAlquiladas;
    private int nPeliculas;
    private static int contador = 0;

    public Cliente(String dni, String nombre, String direccion, LocalDate fechaNacimiento){
        this.dni = dni;
        this.nombre = nombre;
        this.numSocio = "S" + contador;
        contador++;
        this.direccion = direccion;
        


        
    }












}//

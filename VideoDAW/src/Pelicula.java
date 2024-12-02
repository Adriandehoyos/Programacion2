
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Pelicula {

    private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");

    private int codigo;
    private String titulo;
    private Genero genero;
    private LocalDate FechaRegistro;
    private LocalDate FechaBaja;
    private LocalDateTime FechaAlquiler;
    private boolean isAlquilada;
    private static int contador = 0;

    public Pelicula(String titulo, Genero genero){
        this.titulo = titulo;
        this.genero = genero;
        this.FechaRegistro = LocalDate.now();
        this.FechaBaja = LocalDate.now();
        this.FechaAlquiler = LocalDateTime.now();
        this.codigo = contador;
        contador++;
        
    }

    public int getCodigo(){
        return this.codigo;
    }

    public String getTitulo(){
        return this.titulo;
    }

    public Genero getGenero(){
        return this.genero;
    }

    public LocalDate getFechaRegistro(){
        return this.FechaRegistro;
    }

    public LocalDate getFechaBaja(){
        return this.FechaBaja;
    }

    public LocalDateTime getFechaAlquiler(){
        return this.FechaAlquiler;
    }

}//

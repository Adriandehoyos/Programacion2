
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Pelicula {

    private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");

    private String codigo;
    private String titulo;
    private Genero genero;
    private LocalDate FechaRegistro;
    private LocalDate FechaBaja;
    private LocalDateTime FechaAlquiler;
    private boolean isAlquilada;

    public Pelicula(String codigo, String titulo, Genero genero){
        this.codigo = codigo;
        this.titulo = titulo;
        this.genero = genero;
        this.FechaRegistro = LocalDate.now();
        this.FechaBaja = LocalDate.now();
        this.FechaAlquiler = LocalDateTime.now();
        
    }

    public String getCodigo(){
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

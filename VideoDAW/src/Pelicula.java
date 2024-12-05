
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Pelicula {

    private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");

    private String codigo;
    private String titulo;
    private Genero genero;
    private LocalDate fechaRegistro;
    private LocalDate fechaBaja;
    private LocalDateTime fechaAlquiler;
    private boolean isAlquilada;
    private static int contador = 0;

    public Pelicula(String titulo, Genero genero){
        this.titulo = titulo;
        this.genero = genero;
        this.fechaRegistro = LocalDate.now();
        this.codigo = "P" + contador;
        contador++;

        this.isAlquilada = false;
        
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
        return this.fechaRegistro;
    }

    public LocalDate getFechaBaja(){
        return this.fechaBaja;
    }

    public LocalDateTime getFechaAlquiler(){
        return this.fechaAlquiler;
    }

    public void setFechaAlquiler(LocalDateTime fechaAlq){
        this.fechaAlquiler = fechaAlq;
        if(fechaAlquiler != null){
            this.isAlquilada = true;
        }
        else{
            this.isAlquilada = false;
        }
        
    }

    public boolean getIsAlquilada(){
        return this.isAlquilada;
    }

    public String mostrarInfoPelicula(){
        String info = String.format("Pelicula - codigo: %s Titulo: %s Genero: %s fechaRegistro: %s fechaBaja: %s fechaAlquiler: %s isAlquilada: %s ", this.codigo, 
        this.titulo, this.genero, this.fechaRegistro.format(formatter), this.fechaBaja.format(formatter), this.fechaAlquiler.format(formatter), this.isAlquilada);
        return info;
    }

}//
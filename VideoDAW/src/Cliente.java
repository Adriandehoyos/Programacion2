
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Cliente {

    private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");

    public static int getContador() {
        return contador;
    }

    private String dni;
    private String nombre;
    private String numSocio;
    private String direccion;
    private LocalDate fechaNacimiento;
    private LocalDate fechaBaja;
    private Pelicula [] peliculas;
    private int nPeliculas;
    private int nAlquiladas;
    private static int contador = 0;

    public Cliente(String dni, String nombre, String direccion, LocalDate fechaNacimiento){
        this.dni = dni;
        this.nombre = nombre;
        this.numSocio = "S" + contador;
        contador++;
        this.direccion = direccion;
        this.fechaNacimiento = fechaNacimiento;
        this.peliculas = new Pelicula[50];
        this.nPeliculas = 0;
        this.nAlquiladas = 0;
    }

    public String getDni() {
        return dni;
    }

    public String getNombre() {
        return nombre;
    }

    public String getNumSocio() {
        return numSocio;
    }

    public String getDireccion() {
        return direccion;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public LocalDate getFechaBaja() {
        return fechaBaja;
    }

    //meter pelicula
    public boolean insertarPelicula(Pelicula p1){
        boolean isadd = false;
        if(p1 != null){
            this.peliculas[nPeliculas] = p1;
            this.nPeliculas++;
            this.nAlquiladas++;
            isadd = true;
        }
        return isadd;
    }

    //eliminar pelicula
    public boolean quitarPelicula(Pelicula p1){
        boolean isremoved = false;
        if(p1 != null){
            nAlquiladas--;
        }
        return isremoved;
    }

    //mostrar info cliente
    public String mostrarInfoCliente(){
        String infoCliente = String.format("Cliente - Dni: %s Nombre: %s NumSocio: %s Direccion: %s FechaNacimiento: %s NAlquiladas %s ",
        this.dni, this.nombre, this.numSocio, this.direccion, this.fechaNacimiento.format(formatter), this.nAlquiladas);
        return infoCliente;
    }

    //mostrar peliculas cliente
    public String mostrarPeliculasAlquiladas(){
        String info = "";
        for(int i = 0; i < nPeliculas; i++){
            info += peliculas[i].mostrarInfoPelicula();
        }
        return info;
    }











}//

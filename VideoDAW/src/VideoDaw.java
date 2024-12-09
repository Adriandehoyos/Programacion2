import java.time.LocalDate;

public class VideoDaw {

    private String cif;
    private String direccion;
    private LocalDate fechaAlta;
    private int nPeliculas;
    private int nClientes;
    
    private Cliente [] clientes;
    private Pelicula [] peliculas;

    public VideoDaw(String cif, String direccion){
        this.cif = cif;
        this.direccion = direccion;
        this.fechaAlta = LocalDate.now();
        this.peliculas = new Pelicula[50];
        this.nPeliculas = 0;
        this.clientes = new Cliente[50];
        this.nClientes = 0;
    }

    public String getCif() {
        return cif;
    }

    public String getDireccion() {
        return direccion;
    }

    public LocalDate getFechaAlta() {
        return fechaAlta;
    }

    public String mostrarInfoVideoclub(){
        String infoVideoclub = String.format("Info Video Club - Cif: %s, Direccion: %s, FechaAlta: %s, Peliculas registradas: %s, Clientes registrados: %s",
        this.cif, this.direccion, this.fechaAlta, this.nPeliculas, this.nClientes);
        return infoVideoclub;
    }


    //Nuevo cliente
    public boolean nuevoCliente(Cliente n1){
        boolean isAdd = false;
        if (n1 != null) {
                this.clientes[nClientes] = n1;
                nClientes++;
                isAdd = true;
        }
        return isAdd;
    }

    //mostrar cliente
    public String mostrarClientes(){
        String info = "";
        if(clientes != null){
            for (int i = 0; i < nClientes; i++) {
                System.out.println(i + "." + clientes[i].mostrarInfoCliente());
            }
        }
        return info;
    }

    //Nueva pelicula
    public boolean nuevaPelicula(Pelicula n2){
        boolean isAdd = false;
        if (n2 != null){
            this.peliculas [nPeliculas] = n2;
            nPeliculas++;
            isAdd = true;
        }
        return isAdd;
    }

    //mostrar peliculas registradas
    public String mostrarPeliculasRegistradas(){
        String info = "";
        for(int i = 0; i < nPeliculas; i++){
        System.out.println(i + "." + peliculas[i].mostrarInfoPelicula());
        }
    return info;
    }

    //mostrar peliculas no alquiladas
    public String mostrarPeliculasNoAlquiladas(){
        String info = "";
        if(nPeliculas > 0){
        for(int i = 0; i < nPeliculas; i++){
            if (peliculas[i].IsAlquilada() == false){
                info += (peliculas[i].mostrarInfoPelicula());
            }
        }
        }else{
            info = "No hay peliculas disponibles ";
        }
    return info;
    }
    
    //Metodos para obtener datos
    public Pelicula obtenerPeliculaPorPosicion(int i){
        return this.peliculas[i];
    } 

    public Cliente obtenerClientePorPosicion(int i){
        return this.clientes[i];
    }

    //Metodos para modificar datos
    public void alquilarPelicula(int c, int p){
        this.obtenerClientePorPosicion(c);
        Pelicula movie = this.obtenerPeliculaPorPosicion(p);
        movie.alquilado();
        this.clientes[c].insertarPelicula(movie);
    }

    public void devolverPelicula(int c, int p){
        this.obtenerClientePorPosicion(c);
        Pelicula movie = this.obtenerPeliculaPorPosicion(p);
        movie.devolucion();
        this.clientes[c].quitarPelicula(movie);
    }

    //Dar de baja un cliente
    public boolean darBajaCliente(Cliente c, int nSocio){
        boolean isremoved = false;
        if(this.clientes != null){
            this.clientes [nSocio] = null;
            for(int i = nSocio + 1; i < nClientes; i++){
                this.clientes [i-1] = this.clientes[i];
            }
            this.clientes [nClientes-1] = null;
            nClientes--;
            isremoved = true;
            System.out.println("Cliente eliminado.");
        }
        
    return isremoved;
    }

    //Dar de baja una pelicula
    public boolean darBajaPelicula(Pelicula p, int codigo){
        boolean isremoved = false;
        if (codigo >= 0 && codigo< nPeliculas) {
            this.peliculas [codigo] = null;
            
            for(int i = codigo + 1; i < nPeliculas; i++){
                this.peliculas [i-1] = this.peliculas[i];
            }
            this.peliculas [nPeliculas-1] = null;
            nPeliculas--;
            isremoved = true;
            System.out.println("Pelicula eliminada.");
        }
    return isremoved;
    }

}//

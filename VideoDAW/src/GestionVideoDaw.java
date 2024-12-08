import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.util.Scanner;

public class GestionVideoDaw {
public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        final String patroncif = "[A-Z]{1}[0-9]{8}";
        final String patrondni = "[0-9]{8}[A-Z]{1}";
        VideoDaw v1 = null;
        Cliente cliente = null;
        Pelicula nuevaPelicula = null;

        System.out.println("Bienvenido al menu de gestion de VideoDaw");
        String opcion;
        do { 
            System.out.println("1-Crear y registrar VideoClub");
            System.out.println("2-Registrar pelicula");
            System.out.println("3-Crear y registrar cliente");
            System.out.println("4-Alquilar pelicula");
            System.out.println("5-Devolver película");
            System.out.println("6-Dar de baja cliente");
            System.out.println("7-Dar de baja pelicula");
            System.out.println("8-Salir");
            System.out.print("Selecciona una opcion: ");
            opcion = entrada.nextLine();

            switch (opcion) {
                case "1":
                    String cif = MiUtils.comprobarPatronRepetidamente(patroncif, "Introduce el CIF del videoclub");

                    String direccion = MiUtils.leerTextoPantalla("Introduce la direccion del videoclub");

                    VideoDaw videoclub = new VideoDaw(cif, direccion);
                    v1 = videoclub;
                    System.out.println(videoclub.mostrarInfoVideoclub());
                    break;

                case "2":
                    if(v1 != null){
                        entrada = new Scanner (System.in);
                        System.out.println("Registrar Pelicula");
                        String titulo = MiUtils.leerTextoPantalla("Introduce el titulo de la pelicula");

                        for(int i = 0; i < 1; i++){
                            System.out.println("\n¿Cual es el genero de la pelicula? " + "\n1.-Comedia" + 
                            "\n2.-Drama" + "\n3.-Terror" + "\n4.-Suspense" + "\n5.-Aventura " + "\n6.-Fantasia" + "\n7-Ciencia Ficcion");
                            entrada = new Scanner(System.in);
                            int nGenero = entrada.nextInt();
    
                            if (nGenero == 1){
                                nuevaPelicula = new Pelicula(titulo, Genero.COMEDIA);	
                            }
                            if (nGenero == 2){
                                nuevaPelicula = new Pelicula(titulo, Genero.DRAMA);
                            }
                            if (nGenero == 3){
                                nuevaPelicula = new Pelicula(titulo, Genero.TERROR);
                            }
                            if (nGenero == 4){
                                nuevaPelicula = new Pelicula(titulo, Genero.SUSPENSE);
                            }
                            if (nGenero == 5){
                                nuevaPelicula = new Pelicula(titulo, Genero.AVENTURA);
                            }
                            if (nGenero == 6){
                                nuevaPelicula = new Pelicula(titulo, Genero.FANTASIA);
                            }
                            if(nGenero == 7){
                                nuevaPelicula = new Pelicula(titulo, Genero.CIENCIA_FICCION);
                            }
                            else if(nGenero > 7 || nGenero < 1){
                                System.out.println("ERROR, el dato introducido no es valido");
                                i -= 1;
                            }
                        }
                    if (nuevaPelicula != null){
                        System.out.println("Pelicula registrada correctamente");

                        System.out.println(nuevaPelicula.mostrarInfoPelicula());

                        v1.nuevaPelicula(nuevaPelicula);
                    }
                    } else{
                        System.out.println("Antes de registrar una pelicula, cree un videoclub.");
                    }
                    break;

                case "3":
                entrada = new Scanner (System.in);
                    if(v1 != null){
                        String dni = MiUtils.comprobarPatronRepetidamente(patrondni, "Introduce el dni del cliente"); 

                        String nombre = MiUtils.leerTextoPantalla("Introduce el nombre del cliente");

                        String direccionCliente = MiUtils.leerTextoPantalla("Introduce la direccion del cliente");

                        LocalDate fechaNacimiento = MiUtils.leerFecha();

                        LocalDate hoy = LocalDate.now();

                        Period mayorEdad = Period.between(fechaNacimiento, hoy);

                        if(mayorEdad.getYears() > 18){
                            Cliente c = new Cliente(dni, nombre, direccionCliente, fechaNacimiento);
                            v1.nuevoCliente(c);
                            cliente = c;
                            System.out.println(c.mostrarInfoCliente());
                        } else{
                        System.out.println("La edad minima para registrarse como cliente es de 18.");
                        }
                    } else{
                        System.out.println("Antes de registrar un cliente, crea un videoclub.");
                    }
                    break;

                case "4":
                entrada = new Scanner (System.in);

                    if(v1!=null || cliente != null || nuevaPelicula != null){
                        System.out.println("Quien va a alquilar la pelicula?");
                        v1.mostrarClientes();
                        int c = entrada.nextInt();
                        System.out.println("Que pelicula quieres alquilar?");
                        v1.mostrarPeliculasNoAlquiladas();
                        int p1 = entrada.nextInt();
                       // v1.alquilarPelicula(c, Pelicula);
						//v1.obtenerClientePorPosicion(c).insertarPelicula(v1.obtenerPeliculaPorPosicion(Pelicula));
                    } else{
                        System.out.println("Antes de alquilar una pelicula, registrala en el videoclub.");
                    }
                    break;
                case "5":
                entrada = new Scanner (System.in);
                    if(v1 != null && cliente != null && nuevaPelicula != null){
                        System.out.println("Selecciona el cliente que quiere devolver una pelicula.");
                        v1.mostrarClientes();
                        int c = entrada.nextInt();
                        
                        System.out.println("Que pelicula va a devolver");
                       // v1.mostrarPeliculasAlquiladas();
                        int p1 = entrada.nextInt();
                        v1.devolverPelicula(c, p1);
                        //v1.posicionCliente(c).quitarPelicula(v1.posicionPelicula(p1));
                       // v1.posicionCliente(c).mostrarPeliculas();
                        LocalDateTime fechaDevolucion = LocalDateTime.now();
                        Period dias = Period.between(nuevaPelicula.getFechaAlquiler().toLocalDate(), fechaDevolucion.toLocalDate());
                        if(dias.getDays() >= 2){
                            System.out.println("Has excedido el tiempo de alquiler. Deberas pagar una multa.");
                        }
                    } else{
                        System.out.println("Antes de devolver una pelicula, registrala en el videoclub.");
                    }

                    break;
                case "6":
                    if(v1 != null && cliente != null){
                        System.out.println("Selecciona el cliente que quieres dar de baja.");
                        v1.mostrarClientes();
                        int c = entrada.nextInt();
                        v1.darBajaCliente(cliente, c);
                    } else{
                        System.out.println("Para dar de baja a un cliente primero tienes que registrarlo.");
                    }
                    break;
                case "7":
                    if(v1 != null && nuevaPelicula != null){
                        System.out.println("Selecciona la pelicula que quieres dar de baja.");
                        v1.mostrarPeliculasNoAlquiladas();
                        int p = entrada.nextInt();
                        v1.darBajaPelicula(nuevaPelicula, p);
                    } else{
                        System.out.println("Para dar de baja a una pelicula primero tienes que registrarla.");
                    }
                    break;
                case "8":
                    System.out.println("Saliendo del menu de Gestion");
                    break;
                default:
                    System.out.println("Introduce una opcion valida");
            }
        } while (!opcion.equals("8"));
    }

}//

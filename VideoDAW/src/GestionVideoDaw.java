import java.time.LocalDate;
import java.util.Scanner;

public class GestionVideoDaw {
public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        final String patroncif = "[A-Z]{1}[0-9]{8}";
        final String patrondni = "[0-9]{8}[A-Z]{1}";
        VideoDaw video = null;
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
            opcion = reader.nextLine();

            switch (opcion) {
                case "1":
                reader = new Scanner(System.in);
                    String cif = MiUtils.comprobarPatronRepetidamente(patroncif, "Introduce el CIF del videoclub");

                    String direccion = MiUtils.leerTextoPantalla("Introduce la direccion del videoclub");

                    VideoDaw videoclub = new VideoDaw(cif, direccion);
                    video = videoclub;
                    System.out.println(videoclub.mostrarInfoVideoclub());
                    break;

                case "2":
                reader = new Scanner (System.in);
                    if(video != null){
                        System.out.println("Registrar Pelicula");
                        String titulo = MiUtils.leerTextoPantalla("Introduce el titulo de la pelicula");

                        for(int i = 0; i < 1; i++){
                            System.out.println("\n¿Cual es el genero de la pelicula? " + "\n1.-Comedia" + 
                            "\n2.-Drama" + "\n3.-Terror" + "\n4.-Suspense" + "\n5.-Aventura " + "\n6.-Fantasia" + "\n7-Ciencia Ficcion");
                            reader = new Scanner(System.in);
                            int nGenero = reader.nextInt();
                            reader.nextLine(); // Limpia el buffer
    
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
                                System.out.println("ERROR, el dato introducido no es valido.");
                                i -= 1;
                            }
                        }
                    if (nuevaPelicula != null){
                        System.out.println("Pelicula registrada correctamente.");

                        System.out.println(nuevaPelicula.mostrarInfoPelicula());

                        video.nuevaPelicula(nuevaPelicula);
                    }
                    } else{
                        System.out.println("Antes de registrar una pelicula, cree un videoclub.");
                    }
                    break;

                case "3":
                reader = new Scanner (System.in);
                    if(video != null){
                        String dni = MiUtils.comprobarPatronRepetidamente(patrondni, "Introduce el dni del cliente."); 

                        String nombre = MiUtils.leerTextoPantalla("Introduce el nombre del cliente.");

                        String direccionCliente = MiUtils.leerTextoPantalla("Introduce la direccion del cliente.");

                        LocalDate fechaNacimiento = MiUtils.leerFecha();

                        LocalDate hoy = LocalDate.now();

                        int n = hoy.getYear() - fechaNacimiento.getYear();

                        if(n >= 18){
                            Cliente c = new Cliente(dni, nombre, direccionCliente, fechaNacimiento);
                            video.nuevoCliente(c);
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
                    reader = new Scanner(System.in);
                    if(video != null && cliente != null && nuevaPelicula != null){
                        System.out.println("¿Quien va alquilar la pelicula?");
                        System.out.println(video.mostrarClientes());
                        int cl = reader.nextInt();
                        reader.nextLine(); // Limpia el buffer

                        System.out.println("¿Que pelicula quieres alquilar?");
                        System.out.println(video.mostrarPeliculasNoAlquiladas());
                        int pl = reader.nextInt();
                        reader.nextLine(); // Limpia el buffer

                        video.alquilarPelicula(cl, pl);

                    }else{
                        System.out.println("Faltan datos revisa el VideoDaw");
                    }
                    break;
                case "5":
                    reader = new Scanner(System.in);
                    if(video != null && cliente != null && nuevaPelicula != null){
                        System.out.println("¿Quien va ha devolver la pelicula?");
                        System.out.println(video.mostrarClientes());
                        int cl = reader.nextInt();
                        reader.nextLine(); // Limpia el buffer

                        System.out.println("¿Que pelicula quieres devolver?");
                        System.out.println(video.mostrarPeliculasRegistradas());
                        int pl = reader.nextInt();
                        reader.nextLine(); // Limpia el buffer

                        video.devolverPelicula(cl, pl);

                    }else{
                        System.out.println("Faltan datos revisa el VideoDaw");
                    }

                    break;
                case "6":
                    reader = new Scanner(System.in);
                    if(video != null && cliente != null){
                        System.out.println("Selecciona el cliente que quieres dar de baja.");
                        video.mostrarClientes();
                        int c = reader.nextInt();
                        reader.nextLine(); // Limpia el buffer
                        video.darBajaCliente(cliente, c);
                    } else{
                        System.out.println("El cliente no esta registrado.");
                    }
                    break;
                case "7":
                    reader = new Scanner(System.in);
                    if(video != null && nuevaPelicula != null){
                        System.out.println("Selecciona la pelicula que quieres dar de baja.");
                        video.mostrarPeliculasNoAlquiladas();
                        int p = reader.nextInt();
                        reader.nextLine(); // Limpia el buffer
                        video.darBajaPelicula(nuevaPelicula, p);
                    } else{
                        System.out.println("Esta pelicula no esta registrada.");
                    }
                    break;
                case "8":
                    System.out.println("Saliendo del menu de Gestion.");
                    break;
                default:
                    System.out.println("Introduce una opcion valida.");
            }
        } while (!opcion.equals("8"));
    }

}//

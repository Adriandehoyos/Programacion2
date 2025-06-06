package com.decroly;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner reader = new Scanner(System.in);
        int opcion;
        SQLAccesVideoDaw miMDdata = new SQLAccesVideoDaw();

        final String patronDNI = "[0-9]{8}[A-Z]{1}"; //Patron para el DNI
        final String patronCIF = "[A-Z]{1}[0-9]{8}"; //Patron para el CIF




        do {
            System.out.println("\nMenú de VideoClub");
            System.out.println("1. Crear y registrar VideoClub en la franquicia.");
            System.out.println("2. Registrar Película en el videoclub.");
            System.out.println("3. Registrar Videojuego en el Videoclub");
            System.out.println("4. Crear y registrar cliente en videoclub.");
            System.out.println("5. Alquilar.");
            System.out.println("6. Devolver.");
            System.out.println("7. Dar de baja cliente.");
            System.out.println("8. Dar de baja articulo.");
            System.out.println("9. Salir. Termina el programa.");
            System.out.print("Seleccione una opción: ");
            
            while (!reader.hasNextInt()) {
                System.out.println("Entrada no válida. Por favor, ingrese un número.");
                reader = new Scanner(System.in);// Limpiar buffer
            }
            opcion = reader.nextInt();
            reader = new Scanner(System.in);// Limpiar buffer después de leer el número
            
            switch (opcion) {
                case 1:// Código para crear y registrar VideoClub
                reader = new Scanner(System.in);//Limpiar buffer
                    String cif = myUtils.comprobarPatronRepetidamente(patronCIF, "Introduce el CIF del VideoClub (A12345678) ");

                    System.out.println("Donde esta ubicado el VideoClub(Direccion): ");
                    String direccion = reader.nextLine();

                    VideoDaw v1 = new VideoDaw(cif, direccion);
                    int response1 = miMDdata.crearVideoClub(v1);
                    System.out.println("Se han insertado " + response1 + " elementos");

                    break;



                case 2:// Código para registrar película
                //Creamos el articulo primero
                reader = new Scanner(System.in);//Limpiar buffer
                String cod = miMDdata.generarcod();

                System.out.println("Introduce el titulo de la Pelicula: ");
                String titulo = reader.nextLine();

                Articulo a1 = new Articulo(cod, titulo, null, null);
                miMDdata.insertarArticulo(a1);

                //Ahora pasamos los datos para crear la pelicula
                //Mostramos los generos de Pelicula
                List<GenerosP> infoGP = miMDdata.getGenerosPeli();
                for (GenerosP infGenerosP : infoGP) {
                    System.out.println(infGenerosP);
                }
                System.out.println("Elige el genero de la Pelicula: ");
                int generoNP = reader.nextInt();

                Pelicula p1 = new Pelicula(cod, titulo, null, null, generoNP, null, false);
                int response2 = miMDdata.insertarPelicula(p1);
                System.out.println("Se han insertado " + response2 + " elementos");
                    break;


                //codigo para registrar videojuego
                case 3:
                //Creamos el articulo primero
                reader = new Scanner(System.in);//Limpiar buffer
                String cod2 = miMDdata.generarcod();

                System.out.println("Introduce el titulo: ");
                String titulo2 = reader.nextLine();

                Articulo a2 = new Articulo(cod2, titulo2, null, null);
                miMDdata.insertarArticulo(a2);

                //Ahora pasamos los datos del videojuego
                //Mostramos los generos de Pelicula
                List<GenerosV> infoGV = miMDdata.getGenerosVideojuego();
                for (GenerosV infGenerosV : infoGV) {
                    System.out.println(infGenerosV);
                }
                System.out.println("Elige el genero de la Pelicula: ");
                int generoNV = reader.nextInt();

                VideoJuego vN1 = new VideoJuego(cod2, titulo2, null, null, generoNV, null, false);
                int response3 = miMDdata.insertarVideojuego(vN1);
                System.out.println("Se han insertado " + response3 + " elementos");

                    break;

                // Código para registrar cliente
                case 4:
                reader = new Scanner(System.in);//Limpiar buffer
                //Primero los datos de persona
                String dni = myUtils.comprobarPatronRepetidamente(patronDNI, "Introduce el DNI del Cliente; ");
                String nombreP = myUtils.leerTextoPantalla("Como se llama el Cliente: ");
                String direccionP = myUtils.leerTextoPantalla("Cual es su direccion: ");
                String fechaInput = myUtils.leerTextoPantalla("Cual es su fecha de nacimiento (YYYY-MM-DD): ");

                LocalDate fechaNacimiento = LocalDate.parse(fechaInput);

                Persona per1 = new Persona(dni, nombreP, direccionP, fechaNacimiento);
                miMDdata.insertarPersona(per1);

                //Ahora creamos el cliente y mostramos si se ha insertado
                String numSocio = miMDdata.generarNumSocio();

                Cliente cli1 = new Cliente(dni, nombreP, direccionP, fechaNacimiento, numSocio, fechaNacimiento,0);
                int response4 = miMDdata.insertarCliente(cli1);
                System.out.println("Se han insertado " + response4 + " elementos");
                    break;

                // Código para alquilar
                case 5:
                System.out.println("1. Alquilar Pelicula");
                System.out.println("2. Alquilar VideoJuego");
                String menu = reader.nextLine();

                    //Codigo Alquilar Pelicula
                    if(menu.equals("1")){

                        //Enseñamos las Peliculas
                            String getAll = "SELECT articulo.titulo, pelicula.cod, pelicula.isAlquilada, articulo.fechabaja " +
                            "FROM pelicula "+
                            "INNER JOIN articulo ON pelicula.cod = articulo.cod "+ 
                            "Where articulo.fechaBaja IS NULL AND pelicula.isAlquilada = false";
                            //la consulta de mySQL que solo muestra los articulos que son peliculas y no estan alquiladas ni dadas de baja con su titulo y codigo
                            try (Connection connection = SQLAccesManager.getConnection(); Statement statement = connection.createStatement();
                            ResultSet dataSet = statement.executeQuery(getAll);) {
                                while(dataSet.next()){
                                    String TituloP = dataSet.getNString(1);
                                    String codP = dataSet.getNString(2);
                                    Boolean alquilado = dataSet.getBoolean(3);

                                    System.out.println(TituloP + " -- Codigo = "+codP + " -- Esta alquilada = " +alquilado);

                                }
                            } catch (Exception e) {
                                System.out.println(e.getMessage());
                            }

                            //Pedimos el codigo de la Pelicula que quiere alquilar
                            String codAlquilarP = myUtils.leerTextoPantalla("Cual es el codigo de la Pelicula que quieres alquilar: ");
                            miMDdata.alquilarPelicula(codAlquilarP);
                            

                            //Mostramos los clientes para que diga quien la va alquilar
                            String getClientes = "SELECT persona.dni, cliente.numSocio, cliente.articulosAlquilados, cliente.fechabaja " +
                            "FROM persona "+
                            "INNER JOIN cliente ON persona.dni = cliente.dni "+ 
                            "Where cliente.fechaBaja IS NULL ";
                            //la consulta de mySQL que solo muestra los clientes que no esten dados de baja con su numSocio y dni y los articulos que tiene alquilados
                            try (Connection connection = SQLAccesManager.getConnection(); Statement statement = connection.createStatement();
                            ResultSet dataSet = statement.executeQuery(getClientes);) {
                                while(dataSet.next()){
                                    String dniSelect = dataSet.getNString(1);
                                    String numSocioSelect = dataSet.getNString(2);
                                    int articulosAlquiladosSelect = dataSet.getInt(3);

                                    System.out.println(numSocioSelect + " -- DNI = "+dniSelect + " -- Articulos Alquilados = " +articulosAlquiladosSelect);

                                }
                            } catch (Exception e) {
                                System.out.println(e.getMessage());
                            }
                            //Pedimos el numSocio que va alquilar
                            String socioAlqP = myUtils.leerTextoPantalla("Que cliente quiere alquilar la Pelicula (Introduce en numero de socio)");
                            //Sumamos alquilar
                            miMDdata.sumarYActualizarAlquilado(socioAlqP);


                    //Codigo alquilar VideoJuego
                    }else if(menu.equals("2")){
                        reader = new Scanner(System.in);//Limpiar buffer

                        //Enseñamos los videojuegos
                        String getAll = "SELECT articulo.titulo, videojuego.cod, videojuego.isAlquilada, articulo.fechabaja " +
                        "FROM videojuego "+
                        "INNER JOIN articulo ON videojuego.cod = articulo.cod "+ 
                        "Where videojuego.isAlquilada = false AND articulo.fechabaja is null";
                        //la consulta de mySQL que solo muestra los articulos que son videojuegos y no estan alquilados ni dados de baja con su titulo y codigo
                        try (Connection connection = SQLAccesManager.getConnection(); Statement statement = connection.createStatement();
                        ResultSet dataSet = statement.executeQuery(getAll);) {
                            while(dataSet.next()){
                                String TituloP = dataSet.getNString(1);
                                String codP = dataSet.getNString(2);
                                Boolean alquilado = dataSet.getBoolean(3);

                                System.out.println(TituloP + " -- Codigo = "+codP + " -- Esta alquilado = " +alquilado);

                            }
                        } catch (Exception e) {
                            System.out.println(e.getMessage());
                        }
                        
                        //Pedimos el cod del Videojuego
                        String codAlquilarV = myUtils.leerTextoPantalla("Cual es el codigo del Videojuego que quieres alquilar: ");

                        miMDdata.alquilarVideojuego(codAlquilarV);

                        //Mostramos los clientes para que diga quien la va alquilar
                        String getClientes = "SELECT persona.dni, cliente.numSocio, cliente.articulosAlquilados, cliente.fechabaja " +
                        "FROM persona "+
                        "INNER JOIN cliente ON persona.dni = cliente.dni "+ 
                        "Where cliente.fechaBaja IS NULL ";
                        //la consulta de mySQL que solo muestra los clientes que no esten dados de baja con su numSocio y dni y los articulos que tiene alquilados
                        try (Connection connection = SQLAccesManager.getConnection(); Statement statement = connection.createStatement();
                        ResultSet dataSet = statement.executeQuery(getClientes);) {
                            while(dataSet.next()){
                                String dniSelect = dataSet.getNString(1);
                                String numSocioSelect = dataSet.getNString(2);
                                int articulosAlquiladosSelect = dataSet.getInt(3);

                                System.out.println(numSocioSelect + " -- DNI = "+dniSelect + " -- Articulos Alquilados = " +articulosAlquiladosSelect);

                            }
                        } catch (Exception e) {
                            System.out.println(e.getMessage());
                        }

                        //Pedimos el numSocio que va alquilar
                        String socioAlqV = myUtils.leerTextoPantalla("Que cliente quiere alquilar el VideoJuego (Introduce en numero de socio)");
                        //Sumamos alquilar
                        miMDdata.sumarYActualizarAlquilado(socioAlqV);
                    }


                    break;


                // Código para devolver
                case 6:
                System.out.println("1. Devolver Pelicula");
                System.out.println("2. Devolver VideoJuego");
                String menu2 = reader.nextLine();

                    //Codigo devolver Pelicula
                    if(menu2.equals("1")){
                        reader = new Scanner(System.in);//Limpiar buffer
                        //Enseñamos las Peliculas
                        String getAll = "SELECT articulo.titulo, pelicula.cod, pelicula.isAlquilada, articulo.fechabaja " +
                            "FROM pelicula "+
                            "INNER JOIN articulo ON pelicula.cod = articulo.cod "+ 
                            "Where articulo.fechaBaja IS NULL AND pelicula.isAlquilada = true";
                        //la consulta de mySQL que solo muestra los articulos que son peliculas y que estan alquiladas ni dadas de baja con su titulo y codigo
                        try (Connection connection = SQLAccesManager.getConnection(); Statement statement = connection.createStatement();
                        ResultSet dataSet = statement.executeQuery(getAll);) {
                            while(dataSet.next()){
                                String TituloP = dataSet.getNString(1);
                                String codP = dataSet.getNString(2);
                                Boolean alquilado = dataSet.getBoolean(3);

                                System.out.println(TituloP + " -- Codigo = "+codP + " -- Esta alquilada = " +alquilado);

                            }
                        } catch (Exception e) {
                            System.out.println(e.getMessage());
                        }

                        //Pedimos el cod y lo pasamos por el update
                        String codDevolverP = myUtils.leerTextoPantalla("Introduce el codigo de la Pelicula que quieres devolver: ");
                        miMDdata.devolverPelicula(codDevolverP);

                        //Mostramos los clientes para que diga quien la va a devolver
                        String getClientesDv = "SELECT persona.dni, cliente.numSocio, cliente.articulosAlquilados, cliente.fechabaja " +
                        "FROM persona "+
                        "INNER JOIN cliente ON persona.dni = cliente.dni "+ 
                        "Where cliente.fechaBaja IS NULL ";
                        //la consulta de mySQL que solo muestra los clientes que no esten dados de baja con su numSocio y dni y los articulos que tiene alquilados
                        try (Connection connection = SQLAccesManager.getConnection(); Statement statement = connection.createStatement();
                        ResultSet dataSet = statement.executeQuery(getClientesDv);) {
                            while(dataSet.next()){
                                String dniSelect = dataSet.getNString(1);
                                String numSocioSelect = dataSet.getNString(2);
                                int articulosAlquiladosSelect = dataSet.getInt(3);

                                System.out.println(numSocioSelect + " -- DNI = "+dniSelect + " -- Articulos Alquilados = " +articulosAlquiladosSelect);

                            }
                        } catch (Exception e) {
                            System.out.println(e.getMessage());
                        }

                        //Pedimos el numSocio que va devolver
                        String socioDvP = myUtils.leerTextoPantalla("Que cliente quiere devolver la Pelicula (Introduce en numero de socio)");
                        //restamos alquilar
                        miMDdata.restarYActualizarAlquilado(socioDvP);
                        
                        }


                    //Codigo devolver VideoJuego
                    else if (menu2.equals("2")){
                        reader = new Scanner(System.in);//Limpiar buffer
                        //Enseñamos los videojuegos
                        String getAll = "SELECT articulo.titulo, videojuego.cod, videojuego.isAlquilada, articulo.fechabaja " +
                        "FROM videojuego "+
                        "INNER JOIN articulo ON videojuego.cod = articulo.cod "+ 
                        "Where videojuego.isAlquilada = true AND articulo.fechabaja is null";
                        //la consulta de mySQL que solo muestra los articulos que son videojuegos y que estan alquilados con su titulo y codigo
                        try (Connection connection = SQLAccesManager.getConnection(); Statement statement = connection.createStatement();
                        ResultSet dataSet = statement.executeQuery(getAll);) {
                            while(dataSet.next()){
                                String TituloP = dataSet.getNString(1);
                                String codP = dataSet.getNString(2);
                                Boolean alquilado = dataSet.getBoolean(3);

                                System.out.println(TituloP + " -- Codigo = "+codP + " -- Esta alquilada = " +alquilado);

                            }
                        } catch (Exception e) {
                            System.out.println(e.getMessage());
                        }

                        //Pedimos el cod y lo pasamos por el update
                        String codDevolverV = myUtils.leerTextoPantalla("Introduce el codigo del VideoJuego que quieres devolver: ");
                        miMDdata.devolverVideojuego(codDevolverV);


                        //Mostramos los clientes para que diga quien la va a devolver
                        String getClientesDv = "SELECT persona.dni, cliente.numSocio, cliente.articulosAlquilados, cliente.fechabaja " +
                        "FROM persona "+
                        "INNER JOIN cliente ON persona.dni = cliente.dni "+ 
                        "Where cliente.fechaBaja IS NULL ";
                        //la consulta de mySQL que solo muestra los clientes que no esten dados de baja con su numSocio y dni y los articulos que tiene alquilados
                        try (Connection connection = SQLAccesManager.getConnection(); Statement statement = connection.createStatement();
                        ResultSet dataSet = statement.executeQuery(getClientesDv);) {
                            while(dataSet.next()){
                                String dniSelect = dataSet.getNString(1);
                                String numSocioSelect = dataSet.getNString(2);
                                int articulosAlquiladosSelect = dataSet.getInt(3);

                                System.out.println(numSocioSelect + " -- DNI = "+dniSelect + " -- Articulos Alquilados = " +articulosAlquiladosSelect);

                            }
                        } catch (Exception e) {
                            System.out.println(e.getMessage());
                        }

                        //Pedimos el numSocio que va devolver
                        String socioDvV = myUtils.leerTextoPantalla("Que cliente quiere devolver el Videojuego (Introduce en numero de socio)");
                        //restamos alquilar
                        miMDdata.restarYActualizarAlquilado(socioDvV);
                        }
                break;

                    // Código para dar de baja cliente
                case 7:
                reader = new Scanner(System.in);//Limpiar buffer
                    //Mostramos los clientes 
                    String getClientesDv = "SELECT persona.dni, persona.nombre, cliente.numSocio, cliente.fechabaja " +
                    "FROM persona "+
                    "INNER JOIN cliente ON persona.dni = cliente.dni "+ 
                    "Where cliente.fechaBaja IS NULL ";
                    //la consulta de mySQL que solo muestra los clientes que no esten dados de baja con su numSocio y dni y nombre
                    try (Connection connection = SQLAccesManager.getConnection(); Statement statement = connection.createStatement();
                    ResultSet dataSet = statement.executeQuery(getClientesDv);) {
                        while(dataSet.next()){
                            String dniSelect = dataSet.getNString(1);
                            String nombreSelect = dataSet.getNString(2);
                            String numSocioSelect = dataSet.getNString(3);

                            

                            System.out.println(numSocioSelect + " -- DNI = "+dniSelect + " -- Nombre = " +nombreSelect);

                        }
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }

                    String bajaC = myUtils.leerTextoPantalla("Introduce el numero de socio del cliente que quieras dar de baja: ");
                    miMDdata.bajaCliente(bajaC);
                    break;


                    // Código para dar de baja artículo
                case 8:
                reader = new Scanner(System.in);//Limpiar buffer
                    //Primero mostramos los articulos
                    List<Articulo> infoAr = miMDdata.getInfoArticulos();
                    for (Articulo infA : infoAr) {
                        System.out.println(infA);
                    }
                    //Pasamos los datos
                    String bajaAr = myUtils.leerTextoPantalla("Introduce el codigo del Articulo que quieres dar de baja: ");
                    miMDdata.bajaArticulo(bajaAr);
                    break;
                case 9:
                System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        } while (opcion != 9);
        
        reader.close();
    }//
}//

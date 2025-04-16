package com.decroly;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner reader = new Scanner(System.in);
        int opcion;
        SQLAccesVideoDaw miMDdata = new SQLAccesVideoDaw();
        do {
            System.out.println("\nMenú de VideoClub");
            System.out.println("1. Crear y registrar VideoClub en la franquicia.");
            System.out.println("2. Registrar Película en el videoclub.");
            System.out.println("3. Registrar Videojuego en el Videoclub");
            System.out.println("3. Crear y registrar cliente en videoclub.");
            System.out.println("4. Alquilar.");
            System.out.println("5. Devolver.");
            System.out.println("6. Dar de baja cliente.");
            System.out.println("7. Dar de baja articulo.");
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
                    System.out.println("Introduce el CIF del VideoClub (A12345678) ");
                    String cif = reader.nextLine();

                    System.out.println("Donde esta ubicado el VideoClub(Direccion): ");
                    String direccion = reader.nextLine();

                    VideoDaw v1 = new VideoDaw(cif, direccion);
                    int response1 = miMDdata.crearVideoClub(v1);
                    System.out.println("Se han insertado " + response1 + " elementos");

                    break;



                case 2:// Código para registrar película
                //Creamos el articulo primero
                reader = new Scanner(System.in);//Limpiar buffer
                System.out.println("Primero vamos a crear un articulo: ");
                System.out.println("Introduce la referencia para el articulo(A0000): ");
                String cod = miMDdata.generarNuevoNumSocio();

                System.out.println("Introduce el titulo: ");
                String titulo = reader.nextLine();

                Articulo a1 = new Articulo(cod, titulo, null, null);
                int response2 = miMDdata.insertarArticulo(a1);
                System.out.println("Se han insertado " + response2 + " elementos");

                //Ahora vamos a mostrar los articulos para que elija la referencia para la pelicula
                List<Articulo> info = miMDdata.getInfoArticulos();
                for (Articulo art : info) {
                    System.out.println(art);
                }

                //Ahora pasamos los datos para crear la pelicula
                reader = new Scanner(System.in);//Limpiar buffer
                System.out.println("Cual es la referencia de la pelicula que quieres registrar(A0000): ");
                String codNP = reader.nextLine();

                //Mostramos los generos de Pelicula
                List<GenerosP> infoGP = miMDdata.getGenerosPeli();
                for (GenerosP infGenerosP : infoGP) {
                    System.out.println(infGenerosP);
                }
                System.out.println("Elige el genero de la Pelicula: ");
                int generoNP = reader.nextInt();

                Pelicula p1 = new Pelicula(codNP, titulo, null, null, generoNP, null, false);
                int response3 = miMDdata.insertarPelicula(p1);
                System.out.println("Se han insertado " + response3 + " elementos");
                    break;


                //codigo para registrar videojuego
                case 3:
                //Creamos el articulo primero
                reader = new Scanner(System.in);//Limpiar buffer
                System.out.println("Primero vamos a crear un articulo: ");
                System.out.println("Introduce la referencia para el articulo(A0000): ");
                String cod2 = reader.nextLine();

                System.out.println("Introduce el titulo: ");
                String titulo2 = reader.nextLine();

                Articulo a2 = new Articulo(cod2, titulo2, null, null);
                int response4 = miMDdata.insertarArticulo(a2);
                System.out.println("Se han insertado " + response4 + " elementos");

                //Ahora vamos a mostrar los articulos para que elija la referencia para el videojuego
                List<Articulo> info2 = miMDdata.getInfoArticulos();
                for (Articulo art : info2) {
                    System.out.println(art);
                }

                //Ahora pasamos los datos del videojuego
                reader = new Scanner(System.in);//Limpiar buffer
                System.out.println("Cual es la referencia del VideoJuego que quieres registrar(A0000): ");
                String codNV = reader.nextLine();

                //Mostramos los generos de Pelicula
                List<GenerosV> infoGV = miMDdata.getGenerosVideojuego();
                for (GenerosV infGenerosV : infoGV) {
                    System.out.println(infGenerosV);
                }
                System.out.println("Elige el genero de la Pelicula: ");
                int generoNV = reader.nextInt();

                VideoJuego vN1 = new VideoJuego(codNV, titulo2, null, null, generoNV, null, false);
                int response5 = miMDdata.insertarVideojuego(vN1);
                System.out.println("Se han insertado " + response5 + " elementos");

                    break;
                case 4:
                    // Código para registrar cliente
                    break;
                case 5:
                    // Código para alquilar
                    break;
                case 6:
                    // Código para devolver
                    break;
                case 7:
                    // Código para dar de baja cliente
                    break;
                case 8:
                    // Código para dar de baja artículo
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

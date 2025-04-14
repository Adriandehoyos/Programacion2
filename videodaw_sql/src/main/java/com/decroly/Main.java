package com.decroly;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner reader = new Scanner(System.in);
        int opcion;
        SQLAccesVideoDaw miMDdata = new SQLAccesVideoDaw();
        do {
            System.out.println("\nMenú de VideoClub");
            System.out.println("1. Crear y registrar VideoClub en la franquicia.");
            System.out.println("2. Registrar película en videoclub.");
            System.out.println("3. Crear y registrar cliente en videoclub.");
            System.out.println("4. Alquilar.");
            System.out.println("5. Devolver.");
            System.out.println("6. Dar de baja cliente.");
            System.out.println("7. Dar de baja articulo.");
            System.out.println("8. Salir. Termina el programa.");
            System.out.print("Seleccione una opción: ");
            
            while (!reader.hasNextInt()) {
                System.out.println("Entrada no válida. Por favor, ingrese un número.");
                reader = new Scanner(System.in);// Limpiar buffer
            }
            opcion = reader.nextInt();
            reader = new Scanner(System.in);// Limpiar buffer después de leer el número
            
            switch (opcion) {
                case 1:// Código para crear y registrar VideoClub
                reader = new Scanner(System.in);
                    System.out.println("Introduce el CIF del VideoClub (A12345678) ");
                    String cif = reader.nextLine();

                    System.out.println("Donde esta ubicado el VideoClub(Direccion): ");
                    String direccion = reader.nextLine();

                    VideoDaw v1 = new VideoDaw(cif, direccion);
                    int response2 = miMDdata.crearVideoClub(v1);
                    System.out.println("Se han insertado " + response2 + " elementos");

                    break;



                case 2:// Código para registrar película
                    
                System.out.println();

                    break;
                case 3:
                    // Código para registrar cliente
                    break;
                case 4:
                    // Código para alquilar
                    break;
                case 5:
                    // Código para devolver
                    break;
                case 6:
                    // Código para dar de baja cliente
                    break;
                case 7:
                    // Código para dar de baja artículo
                    break;
                case 8:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        } while (opcion != 8);
        
        reader.close();
    }//
}//

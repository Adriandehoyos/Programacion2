package com.decroly;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        int opcion;
        SQLaccesMercaDaw miMDdata = new SQLaccesMercaDaw();

        System.out.println("BIENVENIDO AL MENU DE GESTION DE MERCADAW");


        do {
            System.out.println("\nMenú de Inventario");
            System.out.println("1. Mostrar todos los Productos en el Inventario.");
            System.out.println("2. Buscar producto por referencia.");
            System.out.println("3. Buscar productos por tipo.");
            System.out.println("4. Buscar producto por cantidad.");
            System.out.println("5. Insertar un nuevo producto (no permitir referencias repetidas).");
            System.out.println("6. Eliminar Producto por referencia.");
            System.out.println("7. Actualizar producto (descripción, cantidad, precio, descuento, AplicarDto).");
            System.out.println("8. Insertar un nuevo tipo de producto.");
            System.out.println("9. Salir.");
            System.out.print("Seleccione una opción: ");
            
            opcion = reader.nextInt();
            
            switch (opcion) {

                //Mostrar todos los Productos
                case 1:
                    
                    List<String> nombres = miMDdata.getallInfo();

                    for (String pro : nombres){
                        System.out.println(pro);
                    }
                    break;

                    // Código para buscar producto por referencia
                case 2:
                reader.nextLine();
                    try {
                        System.out.println("Introduce una referencia = REF0000 ");
                        String ref = reader.nextLine();
                        List<Producto> busRef = miMDdata.getProductoPorReferencia(ref);
                        for (Producto bR : busRef) {
                            System.out.println(bR);
                        }
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                    // Código para buscar productos por tipo
                case 3:
                    reader.nextLine();
                    List<Tipos> tipo = miMDdata.getTipos();

                    for (Tipos pro : tipo){
                        System.out.println(pro);
                    }
                    //Hasta aqui mostramos los tipos para que sepa que tipo quiere buscar
                    System.out.println("\nIntroduce el numero del tipo que quieras buscar");
                    int idTipo = reader.nextInt();
                    List<Producto> busTipo = miMDdata.getProductoPorTipo(idTipo);
                    for (Producto bProducto : busTipo) {
                        System.out.println(bProducto);
                    }


                    
                    break;

                    // Código para buscar producto por cantidad
                case 4:
                    
                    break;
                case 5:
                    // Código para insertar un nuevo producto
                    break;
                case 6:
                    // Código para eliminar producto por referencia
                    break;
                case 7:
                    // Código para actualizar producto
                    break;
                case 8:
                    // Código para insertar un nuevo tipo de producto
                    break;
                case 9:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        } while (opcion != 9);
        
        reader.close();
    }


    
    
    
}//
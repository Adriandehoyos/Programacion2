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
                    
                    List<Producto> info = miMDdata.getallInfo();

                    for (Producto pro : info){
                        System.out.println(pro);
                    }
                    break;

                    // Código para buscar producto por referencia
                case 2:
                reader = new Scanner(System.in);
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
                reader = new Scanner(System.in);
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
                reader = new Scanner(System.in);
                    System.out.println("Introduce una Cantidad");
                    int bCantidad = reader.nextInt();
                    List<Producto> busRef = miMDdata.getProductoPorCantidad(bCantidad);
                    for (Producto bR : busRef) {
                        System.out.println(bR);
                    }
                    break;


                    // Código para insertar un nuevo producto
                case 5:
                reader = new Scanner(System.in);
                try {
                    System.out.println("\nInsertar un nuevo Producto");
    
                    System.out.print("Ingrese referencia (7 caracteres): ");
                    String referencia = reader.nextLine();
                    //En la base de datos he metido que la referencia sea unique para que no deje insertar si esta repita la referencia
                    
                    System.out.print("Ingrese nombre del producto: ");
                    String nombre = reader.nextLine();
            
                    System.out.print("Ingrese descripción del producto: ");
                    String descripcion = reader.nextLine();
            
                    System.out.print("Ingrese tipo (ID de tipo): ");
                    int idtipo = reader.nextInt();
            
                    System.out.print("Ingrese cantidad disponible: ");
                    int cantidad = reader.nextInt();
            
                    System.out.print("Ingrese precio del producto: ");
                    double precio = reader.nextDouble();
            
                    System.out.print("Ingrese descuento aplicado: ");
                    int descuento = reader.nextInt();
            
                    System.out.print("Ingrese valor del IVA: ");
                    int iva = reader.nextInt();
            
                    System.out.print("¿Aplicar Descuento? (true/false): ");
                    boolean aplicarDto = reader.nextBoolean();
    
                    Producto nuevoPro = new Producto(referencia, nombre, descripcion, idtipo, cantidad, precio, descuento, iva, aplicarDto);
    
                    int response2 = miMDdata.insertarProducto(nuevoPro);
                    System.out.println("Se han insertado " + response2 + " elementos");
    
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;


                    // Código para eliminar producto por referencia
                case 6:
                reader = new Scanner(System.in);
                    //Mostramos Los Productos con sus referencias
                    List<Producto> infoElim = miMDdata.getInfoEliminar();

                    for (Producto pro : infoElim){
                        System.out.println("Producto con su Referencia = [" + pro.getReferencia() + " --- " +pro.getNombre() + "]");
                    }
                    
                    //Ahora Eliminamos
                    System.out.println("Introduce la referencia del Producto que quieres eliminar");
                    String refElim = reader.nextLine();
                    int response = miMDdata.eliminarPorReferencia(refElim)  ;
                    System.out.println("Se han borrado " + response + " elementos");

                    break;

                    // Código para actualizar producto
                case 7:
                    //Mostramos los productos con su referencia para que elija el producto que quiere modificar
                    List<Producto> infoActualizar = miMDdata.getInfoEliminar();

                    for (Producto pro : infoActualizar){
                        System.out.println("Producto con su Referencia = [" + pro.getReferencia() + " --- " +pro.getNombre() + "]");
                    }
                    //Cogemos los datos del update
                    reader = new Scanner(System.in);
                    System.out.println("Elige la referencia del Producto que quieres actualizar: ");
                    String refActu = reader.nextLine();

                    System.out.println("Introduce su nueva descripcion: ");
                    String nDescripcion = reader.nextLine();

                    System.out.println("Introduce su nueva cantidad: ");
                    int nCantidad = reader.nextInt();

                    System.out.println("Introduce su nuevo precio: ");
                    double nPre = reader.nextDouble();

                    System.out.println("Se aplica Descuento (true/false): ");
                    boolean nAplicarDto = reader.nextBoolean();

                    Producto actProducto = new Producto(refActu, nDescripcion, nCantidad, nPre, nAplicarDto);
                    miMDdata.updateProductobyRef(actProducto);

                    break;

                    // Código para insertar un nuevo tipo de producto
                case 8:
                reader = new Scanner(System.in);
                    System.out.println("Introduce el nuevo tipo: ");
                    String nuevoTipo = reader.nextLine();

                    Tipos nt = new Tipos(nuevoTipo);
    
                    int responseT = miMDdata.insertarTipo(nt);
                    System.out.println("Se han insertado " + responseT + " elementos");

                    //Mostramos los tipos actualizados
                    List<Tipos> tipoN = miMDdata.getTipos();

                    for (Tipos pro : tipoN){
                        System.out.println(pro);
                    }

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
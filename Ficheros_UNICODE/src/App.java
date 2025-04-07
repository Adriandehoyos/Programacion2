import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class App {
    public static void main(String[] args){
        Scanner reader = new Scanner(System.in);
        List <Producto> productos = new LinkedList<>();
        try (FileOutputStream fichero = new FileOutputStream("recursos\\almacen.dat", false)) {   
        } catch (Exception e) {
            System.out.println("fichero no encontrado");
        }

        String opcion;
        do { 
            System.out.println("Menú");
            System.out.println("1. Crear producto");
            System.out.println("2. Mostrar productos");
            System.out.println("3. Eliminar producto por codigo.");
            System.out.println("4. Guardar producto en el fichero.");
            System.out.println("5. Salir.");

            opcion = reader.nextLine();

            switch (opcion) {
                case "1":

                System.out.println("Vamos a crear un producto");
                System.out.println("Introduce el codigo: ");
                String codigo = reader.nextLine();
                System.out.println("Introduce el nombre del producto: ");
                String nombre = reader.nextLine();
                System.out.println("Introduce la cantidad del producto: ");
                int cantidad = reader.nextInt();
                System.out.println("Introduce el precio del producto: ");   
                double precio = reader.nextDouble();
                Producto producto = new Producto(codigo, nombre, cantidad, precio);
                System.out.println("Producto creado: " + producto);
                    productos.add(producto);
                    break;


                case "2":

                    System.out.println("Productos registrados: ");
                    for (Producto p : productos) {
                        System.out.println(p);
                    }
                    break;


                case "3":
                    try {
                        System.out.println("intoduce el codigo del producto que quieres eliminar");
                        String cod = reader.nextLine();

                        Producto eliminaProducto = null;
                            for (Producto proE : productos) {
                                if(cod.equalsIgnoreCase(proE.getCodigo())){
                                    eliminaProducto = proE;
                                }
                            }
                            productos.remove(eliminaProducto);
                            System.out.println("el producto se elimino");
                    } catch (Exception e) {
                        System.out.println("Hubo un problema para eliminar: " + e.getMessage());
                    }



                case "4":
                    
                    try (PrintWriter writer = new PrintWriter(new FileWriter("recursos\\almacen.dat", false))) {
                        for (Producto prod : productos) {
                            String comando = "Producto = " + prod.getCodigo() + "," + prod.getNombre() + "," + prod.getCantidad() + "," + prod.getPrecio();

                            writer.println(comando);
                        }
                            System.out.println("Productos guardados en el fichero.");
                        } catch (IOException e) {
                            System.out.println("Error al guardar productos: " + e.getMessage());
                        }
                    break; 
                case "5":
                    System.out.println("Hasta luego");
                    break;}
        } while (!opcion.equals("5"));
        reader.close();
        }

        

}//

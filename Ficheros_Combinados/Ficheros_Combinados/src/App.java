import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {

    Scanner entrada = new Scanner(System.in);
    LinkedList<Producto> productos = new LinkedList<>(); 
        String opcion;

    do {
            System.out.println("1. Mostrar Productos en el Inventario.");
            System.out.println("2. Eliminar Producto por referencia.");
            System.out.println("3. Guardar y Salir.");
            opcion = entrada.nextLine();

        switch (opcion) {
            case "1":
            try(FileReader file =  new FileReader("Recursos\\productos.csv"); BufferedReader reader = new BufferedReader(file);) {
                String linea = reader.readLine();
                
                while (linea != null) {
                    String[] datos = linea.split("/");
                    Producto p = new Producto(datos[0], datos[1], datos[2], datos[3]);
                    productos.add(p);
                    linea = reader.readLine();
                }

            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
            for(Producto p : productos){
                System.out.println(p);
            }

            int i = 0;
            boolean eof = false;
            try(FileInputStream fichero = new FileInputStream("Recursos\\almacen.dat"); DataInputStream lector = new DataInputStream(fichero)) {
                while (!eof) {
                    int cantidad = lector.readInt();
                    double precio = lector.readDouble();
                    int descuento = lector.readInt();
                    int IVA = lector.readInt();
                    boolean aplicarDto = lector.readBoolean();

                    productos.get(i).setCantidad(cantidad);
                    productos.get(i).setPrecio(precio);
                    productos.get(i).setDescuento(descuento);
                    productos.get(i).setIva(IVA);
                    productos.get(i).setAplicarDto(aplicarDto);
                    

                }
            } catch (Exception e) {
                // TODO: handle exception
            }
            
            for(Producto p : productos){
                System.out.println(p);
            }
                break;
        
            case "2":

                break;

            case "3":

                break;
            default:
                System.out.println("La oopcion elegida no exite en el menu");
        }


    } while (!opcion.equals("3"));
    }//
}//

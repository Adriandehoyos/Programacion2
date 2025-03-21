import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;

public class App {
    public static void main(String[] args) throws Exception {
         //ejercicio 1

        Producto producto1 = new Producto("copas", 20);
        Producto producto2 = new Producto("tenedores", 15);
        Producto producto3 = new Producto("platos", 30);
        Producto producto4 = new Producto("cuchillos", 40);
        Producto producto5 = new Producto("cuencos", 10);

        //ejercicio 2

        LinkedList<Producto> productos = new LinkedList<Producto>();

         //ejercicio 3

        productos.add(producto1);
        productos.add(producto2);
        productos.add(producto3);
        productos.add(producto4);
        productos.add(producto5);

        //ejercicio 4

        Iterator<Producto> itera = productos.iterator();
        Producto p1;
        while (itera.hasNext()) {
            p1 = itera.next();
            System.out.println(p1);
            
        //ejercicio 5 eliminando con itera 
        if (p1.equals(producto4)) {
            itera.remove();
        }
        }
        
        //ejercicio 5 eliminado sin itera(puede fallar en ocasiones)
        productos.remove(producto3);

        System.out.println("\nRecorrido despues de las eliminaciones: ");
        for (Producto producto : productos) {
            System.out.println(producto);
        }   

        //ejercicio 6
        Producto nuevoPro = new Producto("vasos", 40);
        productos.add(2, nuevoPro);

        //ejercicio 7
        System.out.println("\ncomprobacion que se añadio en la posicion 3 en el array: ");
        for (Producto producto : productos) {
            System.out.println(producto);
        }

        //ejercicio 8
        System.out.println("\nRecorrido ordenado por el Nombre");
        Collections.sort(productos, Comparator.comparing(Producto::getNombre));
        for (Producto producto : productos) {
            System.out.println(producto);
        }

        //ejercicio 9
        productos.clear();

        System.out.println("\nProductos despues de eliminar todo: ");

        for (Producto producto : productos){
            System.out.println(producto);
        }


    
    }
}

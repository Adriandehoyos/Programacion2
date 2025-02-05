
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {

        Scanner reader = new Scanner(System.in);
        inventario inv = new inventario();
        String opcion = "";
        String tipo = "";

        System.out.println("SISTEMA DE INVENTARIO DE MASCOSTAS"); 

        do { 
            System.out.println("1-Insertar animal");
            System.out.println("2-Mostrar lista de animales");
            System.out.println("3-Mostrar datos de un animal concreto");
            System.out.println("4-Mostrar todos los datos de todos los animales");
            System.out.println("5-Eliminar animal");
            System.out.println("6-Vaciar inventario");
            System.out.println("7-Salir");
            
            System.out.print("\nSeleccione una opción: ");
            opcion = reader.nextLine();

            switch (opcion) {
                case "1":
                System.out.println("Tipo de animal a insertar:");
                System.out.println("1. Perro");
                System.out.println("2. Gato");
                System.out.println("3. Loro");
                System.out.println("4. Canario");
                System.out.print("Seleccione tipo: ");
                tipo = reader.nextLine();

                //Datos comunes para todos
                System.out.print("Nombre: ");
                String nombre = reader.nextLine();
                System.out.print("Edad: ");
                int edad = reader.nextInt();
                reader = new Scanner(System.in);
                System.out.print("Estado (Vivo/Muerto): ");
                String estado = reader.nextLine();
                System.out.print("Fecha de nacimiento (YYYY-MM-DD): ");
                String fechaNacimiento = reader.nextLine();

                    switch (tipo) {
                        case "1"://perro
                            System.out.print("¿Que raza es: ");
                            String raza = reader.nextLine();
                            System.out.print("¿Tiene pulgas? (Si/No): ");
                            String pulgas = reader.nextLine();
                            inv.insertarAnimal(new Perro(nombre, edad, estado, fechaNacimiento, raza, pulgas));
                            break;
                        case "2"://gato
                            System.out.println("¿De que color es su pelo: ");
                            String color = reader.nextLine();
                            System.out.println("¿Tiene el pelo largo? (Si/No): ");
                            String pelo = reader.nextLine();
                            inv.insertarAnimal(new Gato(nombre, edad, estado, fechaNacimiento, color, pelo));
                            break;
                        case "3"://loro
                            System.out.println("¿Que pico tiene?: ");
                            String pico = reader.nextLine();
                            System.out.print("¿Puede volar? (Si/No): ");
                            String vuela = reader.nextLine();
                            System.out.print("Origen: ");
                            String origen = reader.nextLine();
                            System.out.print("¿El loro Habla? (Si/No) ");
                            String habla = reader.nextLine();
                            inv.insertarAnimal(new Loro(nombre, edad, estado, fechaNacimiento, pico, vuela, origen, habla));
                            break;
                        case "4"://canario
                            System.out.print("Tipo de pico: ");
                            String picoCanario = reader.nextLine();
                            System.out.print("¿Puede volar? (Si/No): ");
                            String vuelaCanario = reader.nextLine();
                            System.out.print("Color: ");
                            String colorCanario = reader.nextLine();
                            System.out.print("¿Canta? (Si/No): ");
                            String canta = reader.nextLine();
                            inv.insertarAnimal(new Canario(nombre, edad, estado, fechaNacimiento, picoCanario, vuelaCanario, colorCanario, canta));
                            break;
                        default:
                            System.out.println("Introduce una opcion correcta: ");
                    }



                    break;
                case "2":
                    inv.mostrarListaAnimales();
                    break;
                case "3":
                    System.out.println("Introduce su indice:");
                    int indice = reader.nextInt();
                    inv.mostrarAnimal(indice);
                    break;
                case "4":
                    inv.mostrarTodosLosDatos();
                    break;
                case "5":
                    System.out.println("Introduce su indice:");
                    int indiceEliminar = reader.nextInt();
                    inv.eliminarAnimal(indiceEliminar);
                    break;
                case "6":
                    inv.vaciarInventario();
                    System.out.println("Se ha vaciado el inventario");
                    break;
                default:
                    System.out.println("Introduzca una opcion correcta del menu");
                    break;
            }
        } while (!opcion.equals("7"));

    }
}//


import java.util.Scanner;

public class ProgramaAgenda {
    public static void main(String[] args) throws Exception {
        
        Agenda menu = new Agenda();
        Scanner reader = new Scanner(System.in);
        String opcion;

        do{
            System.out.println("\nMenú de Agenda:");
            System.out.println("1. Agregar contacto");
            System.out.println("2. Eliminar contacto");
            System.out.println("3. Buscar contacto");
            System.out.println("4. Listar todos los contactos");
            System.out.println("5. Salir");
            opcion = reader.nextLine();

            switch (opcion) {
                case "1": //agregar contacto
                String nombre;
                do {
                    System.out.print("Ingresa el nombre del contacto: ");
                    nombre = reader.nextLine();
                    if (menu.existeContacto(nombre)) {
                        System.out.println("Dos contactos no pueden tener el mismo nombre.");
                    }
                } while (menu.existeContacto(nombre));
                System.out.print("Ingresa el numero de teléfono: ");
                String  telefono = reader.nextLine();
                Contactos c = new Contactos(nombre, telefono);
                menu.añadirContacto(c);
                System.out.println("Contacto agregado correctamente.");
                    break;

                case "2": //eliminar contacto
                System.out.print("Introduce el nombre del contacto que quieras eliminar: ");
                String nombreEliminar = reader.nextLine();  
                if (menu.eliminarContacto(nombreEliminar)) {
                    System.out.println("Contacto eliminado correctamente.");
                } else {
                    System.out.println("No se pudo eliminar el contacto.");
                }
                    break;

                case "3"://buscar contacto
                    System.out.print("Ingresa el nombre del contacto a buscar: ");
                    String nombreBuscar = reader.nextLine();
                    int indice = menu.buscaContacto(nombreBuscar);
                    if (indice != -1) {
                        System.out.println("Contacto encontrado: " + menu.getContacto(indice));
                    } else {
                        System.out.println("Contacto no encontrado.");
                    }
                    break;

                case "4"://listar todos los contactos
                    menu.listarContactos();
                    break;

                case "5"://salir
                System.out.println("Saliendo del Programa");
                    break;
                default:
                    System.out.println("Ingresa una opcion valida");
            }

        }while(!opcion.equals("5"));
    }
}//

import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner reader = new Scanner(System.in);
        Agenda agenda = new Agenda();
        int opcion;

        do {
            System.out.println("\nMenú:");
            System.out.println("1-Añadir contacto");
            System.out.println("2-Buscar contacto");
            System.out.println("3-Eliminar contacto");
            System.out.println("4-Visualizar agenda");
            System.out.println("5-Número de contactos");
            System.out.println("6-Salir");
            System.out.print("Seleccione una opción: ");
            opcion = reader.nextInt();
            reader.nextLine();

            switch (opcion) {
                case 1:
                    System.out.print("Nombre: ");
                    String nombre = reader.nextLine();
                    System.out.print("Teléfono: ");
                    String telefono = reader.nextLine();
                    System.out.print("Correo: ");
                    String correo = reader.nextLine();

                    if (agenda.anadeContacto(nombre, telefono, correo)) {
                        System.out.println("Contacto añadido correctamente.");
                    } else {
                        System.out.println("El contacto ya existe o los datos son inválidos.");
                    }
                    break;

                case 2:
                    System.out.print("Nombre a buscar: ");
                    nombre = reader.nextLine();
                    Contacto c = agenda.buscaContacto(nombre);
                    System.out.println(c != null ? c.getNombre() + " - " + c.getTelefono() + " - " + c.getCorreo() : "Contacto no encontrado.");
                    break;

                case 3:
                    System.out.print("Nombre a eliminar: ");
                    nombre = reader.nextLine();
                    System.out.println(agenda.eliminaContacto(nombre) ? "Contacto eliminado." : "Contacto no encontrado.");
                    break;

                case 4:
                    for (Contacto contacto : agenda.getContactos()) {
                        System.out.println(contacto.getNombre() + " - " + contacto.getTelefono() + " - " + contacto.getCorreo());
                    }
                    break;

                case 5:
                    System.out.println("Número de contactos: " + agenda.numeroContactos());
                    break;
                    
                case 6:
                    System.out.println("Cerrando la Agenda");
                    return;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        }while (opcion != 6);
    }
}

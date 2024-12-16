import java.time.LocalDate;
import java.util.Scanner;

public class Gestionex {
public static void main(String[] args) throws Exception{
        Scanner reader = new Scanner(System.in);
        final String patroncif = "[A-Z]{1}[0-9]{8}";
        final String patrondni = "[0-9]{8}[A-Z]{1}";
        final String patronss = "[0-9]{10}";

        Trabajador trabajador = null;
        Empresa empresa = null;

        String nombreEmpresa = MiUtils.leerTextoPantalla("Introduce el nombre de la empresa");
        
        String cif = MiUtils.comprobarPatronRepetidamente(patroncif,"Introduce el cif de la empresa");

        System.out.println("¿Cuantos trabajadores maximos vas a tener?");
        int trabajadoresMax = reader.nextInt();

        Empresa empresa1 = new Empresa(nombreEmpresa, cif, trabajadoresMax);
        empresa = empresa1;

            System.out.println("Bienvenido al menu de gestion ");
            String opcion;
            do { 
                System.out.println("1-Crear persona");
                System.out.println("2-Registrar trabajador en empresa");
                System.out.println("3-Mostrar informacion general de la empresa");
                System.out.println("4-Mostrar el numero de trabajadores actuales");
                System.out.println("5-Mostrar informacion de todos los trabajadores");
                System.out.println("6-Eliminar trabajador de la empresa");
                System.out.println("7-Eliminar persona del programa");
                System.out.println("8-Salir");
                System.out.println("Selecciona una opcion: ");
                opcion = reader.nextLine();

                switch (opcion) {
                    case "1":
                        reader = new Scanner(System.in);
                        String nombre = MiUtils.leerTextoPantalla("Introduce el nombre del trabajador ");

                        LocalDate fechaNacimiento = MiUtils.leerFecha();

                        String dni = MiUtils.comprobarPatronRepetidamente(patrondni, "Introduce el DNI del trabajador ");

                        String direccion = MiUtils.leerTextoPantalla("Introduce la direccion ");

                        String numeroSS = MiUtils.comprobarPatronRepetidamente(patronss, "Introduce el numero de la seguridad social");

                        Trabajador currante = new Trabajador(nombre, fechaNacimiento, dni, direccion, numeroSS);
                        trabajador = currante;
                        System.out.println(currante.mostrarInfoTrabajador());
                        empresa.meterTrabajador(currante);
                        break;

                    case "2":
                        reader = new Scanner(System.in);

                        System.out.println("Que trabajador quieres contratar ");
                        System.out.println(empresa.mostrarTrabajadores());
                        int ntrabajador = reader.nextInt();
                        empresa.meterTrabajador(ntrabajador);

                        break;

                    case "3":
                    
                        System.out.println(empresa.mostrarInfoEmpresa());

                        break;

                    case "4":
                        
                        System.out.println(empresa.getnTraActuales());

                        break;
                    case "5":
                        
                        System.out.println(empresa.mostrarTrabajadores());

                        break;
                    case "6":
                        reader = new Scanner(System.in);
                        System.out.println("Que trabajador quieres despedir ");
                        System.out.println(empresa.mostrarTrabajadores());
                        int ntrabajador2 = reader.nextInt();
                        empresa.meterTrabajador(ntrabajador2);

                        break;
                    case "7":
                        
                        break;
                    case "8":
                        System.out.println("Saliendo del menu de Gestion.");
                        break;
                    default:
                        System.out.println("Introduce una opcion valida.");
                }
            } while (!opcion.equals("8"));
    }
}//

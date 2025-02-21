import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {

        Scanner entrada = new Scanner(System.in);
        Taller taller = new Taller();
        
        String opcion;
        entrada = new Scanner(System.in);
        do { 
            System.out.println("1. Añadir coche");
            System.out.println("2. Eliminar coche");
            System.out.println("3. Salir");
            opcion = entrada.nextLine();
            switch (opcion) {
                case "1":
                    Coche coche;
                    System.out.println("Introduce el color del coche que quieres registrar:");
                    String color = entrada.nextLine();
                    System.out.println("Introduce la marca del coche que quieres registrar:");
                    String marca = entrada.nextLine();
                    System.out.println("Introduce la matricula del coche que quieres registrar:");
                    String matricula = entrada.nextLine();
                    taller.meterCoche(matricula, color, marca);
                    break;
                case "2":
                    System.out.println("Introduce la matricula del coche que quieres eliminar:");
                    matricula = entrada.nextLine();

                    taller.borrarCoche(matricula);
                    break;
                case "3":
                    System.out.println("Saliendo del taller");
                    System.out.println("Las matriculas son: "); taller.visualizaMatriculas();
                    System.out.println("Los coches en el taller: ");taller.visualizaCoches();
                    System.out.println("Detalles del tayer: ");taller.visualizaTaller();
                    break;
                default:
                    System.out.println("Introduce un valor correcto");
            }
        } while (!opcion.equals("3"));
    } 
}//

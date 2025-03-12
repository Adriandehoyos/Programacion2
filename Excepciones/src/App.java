import java.util.LinkedList;
import java.util.Scanner;

public class App {
    public static void main(String[] args){

    //ejercicio 1
    Scanner reader = new Scanner(System.in);
    //System.out.println("EJERCICIO 1");

 //   try {
 //       System.out.println("Introduce un valor entero para A: ");
 //       int valorA = reader.nextInt();
 //       System.out.println("El Valor Introducido es: "+valorA);
 //   } catch (InputMismatchException e) {
 //       System.out.println("El Valor Introducido es Incorrecto");
 //   }

    //ejercicio 2
    //System.out.println("EJERCICIO 2");

    // try {
    //     System.out.println("Dame un Valor A para una division: ");
    //     int valorA = reader.nextInt();
    //     System.out.println("Dame un Valor B para una division: ");
    //     int valorB = reader.nextInt();
    //     int resultado = valorA/valorB;
    //     System.out.println("El resultado de la division es: "+ resultado);
    // } catch (InputMismatchException e) {
    //     System.err.println("Uno de los valores introducidos son incorrectos");
    // }catch (ArithmeticException e){
    //     System.err.println("No se puede hacer una division entre cero");
    // }

    //ejercicio 3
    //System.out.println("EJERCICIO 3");

    // double [] numeros = new double[5];
    
    // for (int i = 0; i < numeros.length; i++) {
    //     try {
    //         reader = new Scanner(System.in); 
    //         System.out.println("Introduce un numero " +(i+1) + ":");
    //         numeros[i] = reader.nextDouble();
    //     } catch (InputMismatchException e) {
    //         System.out.println("El caracter introducido no es valido");
    //     }
    // }

    // for(double n : numeros){
    //     System.out.println("Los valores introducidos en el vector son: "+ n);
    // }

    //ejercicio 4
    //System.out.println("EJERCICIO 4");

    // String opcion;
    // try {
    //     do{
    //     System.out.println("1. Probar número positivo");
    //     System.out.println("2. Probar número negativo");
    //     System.out.println("3. Salir");
    //     System.out.print("Seleccione una opción: ");
    //     opcion = reader.nextLine();
        
        
        
    //     switch (opcion) {
    //         case "1":
    //             System.out.print("Introduzca un número: ");
    //             int numero1 = reader.nextInt();
    //             imprimePositivo(numero1);
    //             break;
    //         case "2":
    //             System.out.print("Introduzca un número: ");
    //             int numero2 = reader.nextInt();
    //             imprimeNegativo(numero2);
    //             break;
    //         case "3":
    //                 System.out.println("¡Hasta luego!");
    //                 break;
    //         default:
    //             System.out.println("Opción no válida");
    //     }
    // }while(!opcion.equals("3"));

    // } catch (Exception e) {
    //     System.out.println("el numero no es correcto: " + e.getMessage());
    // }

    // //ejercicio 5
    // System.out.println("EJERCICIO 5");

    // System.out.println("Vamos a Regitrar un gato");
    // System.out.println("¿Como se llama?");
    // String nombre = reader.nextLine();

    // System.out.println("¿Cuantos años tiene el gato?");
    // int edad = reader.nextInt();

    // try {
    //     Gato gato = new Gato(nombre, edad);
    //     System.out.println(gato.toString());
    // } catch (Exception e) {
    //     System.out.println("Hubo un Error: "+ e.getMessage());
    // }

    //ejercicio 6
    System.out.println("EJERCICIO 6");
    
    LinkedList <Gato> gatos = new LinkedList<Gato>();

    do { 
        try {
            System.out.println("Gato " + (gatos.size()+1)+ ": Introduce el nombre:");
            String nombre = reader.nextLine();
            System.out.println("Gato " + (gatos.size()+1)+ ": Introduce la edad:");
            String edadString = reader.nextLine();
            int edad = Integer.parseInt(edadString);
            //le pongo un parseInt por que da fallo el scanner y es la unica manera que encontre de solucionarlo

            Gato gato  = new Gato(nombre, edad);
            gatos.add(gato);
            System.out.println("Añadido correctamente " +gato.toString());

        } catch (NumberFormatException e) {
            System.out.println("El valor introducido no es valido");
        } catch (Exception e) {
            System.out.println("Hubo un Error: " + e.getMessage());
        }
    } while (gatos.size()<5);

    System.out.println("Estos son los gatos Almacenados en el Sistema: ");
    for (Gato gato : gatos) {
        System.out.println(gato.toString());
    }

    }//

    //Excepciones ejercicio 4
    public static void imprimePositivo(int p) throws Exception{
        if (p < 0){
            throw new Exception("Se Necesita un Valor Mayor que 0");
        }
        System.out.println("El numero introducido es valido: "+ p);
    } 

    public static void imprimeNegativo(int n) throws Exception{
        if (n >= 0){
            throw new Exception("Se Necesita un Valor Menor o Igual que 0");
        }
        System.out.println("El numero introducido es valido: "+ n);
    }
}//

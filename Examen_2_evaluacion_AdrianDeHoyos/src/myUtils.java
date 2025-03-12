import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class myUtils {
    Scanner reader = new Scanner(System.in);

    public static void imprimir(String mensaje){//MOSTRAMOS UN MENSAJE EN PANTALLA
        System.out.println(mensaje);
    }

    public static String leerTextoPantalla(String mensaje){//MOSTRAMOS MENSAJE Y LEEMOS TEXTO
        Scanner reader = new Scanner(System.in);
        System.out.println(mensaje);
        String valor = reader.nextLine();
        return valor;
    }

    public static LocalDate leerFecha(String mensaje){
        Scanner reader = new Scanner(System.in);
        DateTimeFormatter formatter =  DateTimeFormatter.ofPattern("dd/MM/yyyy");
        System.out.println("\nEscribe tu fecha de nacimiento en formato DD/MM/AAAA");
        String dateString = reader.next();
        LocalDate fechaLocalDate = LocalDate.parse(dateString, formatter);
        return fechaLocalDate;
    }
    
    public static boolean comprobarPatron(String patron, String texto){
        boolean isOk = false;
        Pattern pat = Pattern.compile(patron); //"[0-9]{7,8}[A-Za-z]"
        Matcher mat = pat.matcher(texto);
        isOk = mat.matches();
        return isOk;
        }

    public static String comprobarPatronRepetidamente(String patron, String mensaje){//COMPROBAMOS UN PATRON HASTA QUE SE CUMPLA
        boolean isOk = false;
        String texto;
        do { 
            texto = myUtils.leerTextoPantalla(mensaje);
            isOk = myUtils.comprobarPatron(patron, texto);
            if(!isOk){
                myUtils.imprimir("El formato es incorrecto");
            }
        } while (!isOk);
        return texto;
    }

    public static Departamento menuDep(){
        Scanner entrada = new Scanner(System.in);

        Departamento dept =  null;
        System.out.println("Seleccione el departamento:");
        for (int i = 0; i < Departamento.values().length; i++) {
            System.out.println((i+1) + ". " + Departamento.values()[i]);
        }
        System.out.println("Introduce el numero relacionado con el nombre del departamento");
        int opcion = entrada.nextInt();
        if (opcion >= 1 && opcion <= Departamento.values().length){
            dept = Departamento.values()[opcion - 1];
            System.out.println("El genero seleccionado es: " + dept);
        }
        return dept;
    }

    }//

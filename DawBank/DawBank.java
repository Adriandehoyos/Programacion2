
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DawBank {
    public static void main(String[] args) throws Exception {
        Scanner reader = new Scanner(System.in);
        String Iban = null;
        System.out.println("Bienvenido a DawBank");
        
        Pattern pat = Pattern.compile("[A-Z]{2}[0-9]{22}");
        System.out.println("Introduce el IBAN de la cuenta bancaria: ");
        Iban = reader.nextLine();
        Matcher mat = pat.matcher(Iban);

        while(!mat.matches()){

            System.out.println("El IBAN introducido es incorrecto, por favor, introduzca un IBAN válido.");

            System.out.print("Introduce un IBAN correcto:");

            Iban = reader.nextLine();

            mat = pat.matcher(Iban);

        }
        System.out.println("Bien, el IBAN " + Iban + " es un IBAN válido");

        System.out.println("Introduce el titular de la cuenta");
        String titular = reader.nextLine();

        CuentaBancaria cuenta = new CuentaBancaria(Iban, titular);
        
        String menu = "";

        do{
        //reader = new Scanner(System.in);
        System.out.println("1-Datos de la cuenta\n"+
                "2-IBAN\n"+
                "3-Titular\n"+
                "4-Saldo \n"+
                "5-Ingreso\n"+
                "6-Retirada\n"+
                "7-movimientos\n"+
                "8-salir\n");
        menu = reader.nextLine();    

        if (menu.equals("1")) {
            System.out.println("IBAN: "+ cuenta.getIban()+ " Titular: "+ cuenta.getTitular()+ " Saldo: "+ cuenta.getSaldo()+"EUR");

        }else if (menu.equals("2")) {
            System.out.println("El IBAN es : "+ cuenta.getIban()); 

        }else if (menu.equals("3")) {
            System.out.println("El Titular es: "+ cuenta.getTitular());

        }else if (menu.equals("4")) {
            System.err.println("El saldo actual es: "+ cuenta.getSaldo()+"EUR");

        }else if (menu.equals("5")) {
            System.out.println("Introduce la cantidad que quieres ingresar: ");
            double ingreso = reader.nextDouble();
            Movimiento ingresado = new Movimiento(true, ingreso);
            cuenta.ingresar(ingresado);

        }else if (menu.equals("6")) {
            System.out.println("Introduce la cantidad que quieres retirar: ");
            double retirada = reader.nextDouble();
            Movimiento retirado = new Movimiento(true, retirada);
            cuenta.retirada(retirado);
        }else if (menu.equals("7")) {
            System.out.println(cuenta.mostrarMovimiento());

        } else if (menu.equals("8")) {  
            System.out.println("Cerrando Aplicacion");

        }else {
            System.out.println("Elige una de las opciones validas del menu");
        }


        }while(!menu.equals("8"));


    }
}


import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DawBank {
    public static void main(String[] args) throws Exception {
        Scanner reader = new Scanner(System.in);
        String IbanIntroducido = null;
        System.out.println("Bienvenido a DawBank");
        
        Pattern pat = Pattern.compile("[A-Z]{2}[0-9]{22}");
        System.out.println("Introduce el IBAN de la cuenta bancaria: ");
        IbanIntroducido = reader.nextLine();
        Matcher mat = pat.matcher(IbanIntroducido);

        while(!mat.matches()){

            System.out.println("El IBAN introducido es incorrecto, por favor, introduzca un IBAN válido.");

            System.out.print("Introduce un IBAN correcto:");

            IbanIntroducido = reader.nextLine();

            mat = pat.matcher(IbanIntroducido);

        }
        System.out.println("Bien, el IBAN " + IbanIntroducido + " es un IBAN válido");

        System.out.println("Introduce el titular de la cuenta");
        String titular = reader.nextLine();


        String menu = "";

        do {
        reader = new Scanner(System.in);
        System.out.println("1-Datos de la cuenta \n"+"2-IBAN \n"+"3-Titular \n"+"4-Saldo \n"+"5-Ingreso \n"+"6-Retirada \n"+"7-movimientos \n"+"8-salir \n");
        menu = reader.nextLine();    







        } while (true);












    }
}

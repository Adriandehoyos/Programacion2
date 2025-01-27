
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner reader = new Scanner(System.in);

        String opciones = "";

        Astro [] astros = new Astro[100]; 
    
        System.out.println("\n Pon las medidas necesarias del Astro\n");

        System.out.println("Masa del cuerpo");
        double masa = reader.nextDouble();

        System.out.println("Diámetro medio");
        double diametro = reader.nextDouble();

        System.out.println("Período de rotación sobre su propio eje");
        double rotacion = reader.nextDouble();

        System.out.println("Período de traslación alrededor del cuerpo que orbitan");
        double translacion = reader.nextDouble();

        System.out.println("Distancia media al cuerpo");
        double distancia = reader.nextDouble();

        Astro Info = new Astro(masa, diametro, rotacion, translacion, distancia);

        System.out.println(Info);


        System.out.println("¿Que es tu astro?");

        reader = new Scanner(System.in);
            System.out.println("1) Planeta");
            System.out.println("2) Satelite");
            System.out.println("3) Ninguna de las dos");
            opciones = reader.nextLine();

            reader = new Scanner(System.in);
            if (opciones.equals("1")){
                System.out.println("Pon los datos necesarios para un Planeta:\n");
                System.out.println("Distancia al Sol:");
                double distanciaSol = reader.nextDouble();

                System.out.println("Orbita al Sol:");
                double orbitaSol = reader.nextDouble();

                System.out.println("¿Tiene satelites?:");
                
                
                System.out.println("escribe 'si' o 'no'");

                reader = new Scanner(System.in);

                boolean tieneSatelites = false;

                String tieneSatelitesSi = reader.nextLine();
                    
                    if (tieneSatelitesSi.equalsIgnoreCase("si")){
                        tieneSatelites = true;
                    
                    }else if (tieneSatelitesSi.equalsIgnoreCase("no")){
                        tieneSatelites = false;
                    
                    }else System.out.println("tienes que escribir 'si' o 'no'");

                Planetas Info2 = new Planetas (masa, diametro, rotacion, translacion, distancia,distanciaSol,orbitaSol,tieneSatelites); 
                System.out.println(Info2);

            }if (opciones.equals("2")){

                System.out.println("Pon los datos necesarios para un Satelite:\n");
                System.out.println("Distancia al Planeta:");
                double distanciaPlaneta = reader.nextDouble();

                System.out.println("Orbita al Planeta:");
                double orbitaPlaneta = reader.nextDouble();

                reader = new Scanner(System.in);
                System.out.println("planeta al que pertenece");
                String planetaAlQuePertenece = reader.nextLine();

                Satelites Info3 = new Satelites(masa, diametro, rotacion, translacion, distancia,distanciaPlaneta,orbitaPlaneta,planetaAlQuePertenece);
                System.out.println(Info3);

            }if (opciones.equals("3")){
            
            System.out.println("ya estaria terminado");
            }
    }
}

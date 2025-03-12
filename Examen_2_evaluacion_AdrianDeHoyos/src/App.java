import java.time.LocalDate;
import java.util.Scanner;

public class App {
    public static void main(String[] args){
    Scanner reader = new Scanner(System.in);
    final String patroncif = "[A-Z]{1}[0-9]{10}";
    final String patrondni = "[0-9]{8}[A-Z]{1}";
    Trabajador nTrabajador = null;
    GerenteDep gerente = null;
    Director dire = null;
    Empresa empresa1 = null;

    System.out.println("Introduce el Nombre de la empresa: ");
    String nombreE = reader.nextLine();

    try {
        String cif = myUtils.comprobarPatronRepetidamente(patroncif, "Introduce el CIF de la Empresa: ");
    } catch (Exception e) {
        System.out.println("El CIF de la empresa esta mal introducido");
    }

    Empresa e = new Empresa(nombreE, patroncif);
    System.out.println(e.toString());
    
    String opcion;

    do { 
        System.out.println("Bienvenido al Menu de la empresa: "+ e);
        System.out.println("1. Registrar trabajador en la empresa");
            System.out.println("2. Mostrar informacion general de la empresa");
            System.out.println("3. Mostrar el numero de trabajadores actuales y el organigrama de la empresa");
            System.out.println("4. Mostrar informacion de un departamento");
            System.out.println("5. Eliminar trabajador de la empresa");
            System.out.println("6. Agenda Director");
            System.out.println("7. Salir");
            System.out.print("Selecciona una opcion: ");
            opcion = reader.nextLine();

            switch (opcion) {
                case "1":
                    String opcion2;
                    System.out.println("1- Registrar el director(solo se puede 1)");
                    System.out.println("2-Registrar Gerente");
                    System.out.println("3-Registrar Trabajador Normal");
                    opcion2 = reader.nextLine();

                    if(opcion2.equals("1")){
                        reader = new Scanner(System.in);
                        if(dire == null){
                            String nombre  = myUtils.leerTextoPantalla("Introcude el nombre del Director:");
                            String dni = myUtils.comprobarPatronRepetidamente(patrondni, "Introduce el DNI del Director: ");
                            System.out.println("Esta en la oficina(true/False): ");
                            boolean fuera = reader.nextBoolean();
                            System.out.println("Esta en Reunido (true/False): ");
                            boolean reunido = reader.nextBoolean();
                            System.out.println("Cual es su numero de telefono: ");
                            int telefono = reader.nextInt();
                            String direccion  = myUtils.leerTextoPantalla("Introcude la direccion del Director:");
                            LocalDate fechaNacimiento = myUtils.leerFecha("Escribe la fecha de nacimiento del Director con el siguiente formato: DD/MM/YYYY");
                            String correo  = myUtils.leerTextoPantalla("Introcude el correo del Director:");
                            System.out.println("Cuanto es su salario: ");
                            double salario = reader.nextDouble();
                            Departamento departamentos = myUtils.menuDep();
                            System.out.println("Esta trabajando ahora mismo? (true/False): ");
                            boolean trabajando = reader.nextBoolean();
                            Director d1;
                            try {
                                d1 = new Director(fuera, reunido, telefono, dni, nombre, direccion, fechaNacimiento, correo, salario, departamentos, trabajando);
                                dire = d1;
                                empresa1.registrarDirector(dire);
                            } catch (TrabajadorYaRegistradoException e1) {
                                System.out.println("El trabajador ya existia");
                            }catch(Exception e1){
                                System.out.println("Error en la creacion del Director");
                            }
                        }else{
                            System.out.println("Ya hay un director de Empresa");
                        }

                    }else if (opcion2.equals("2")){
                        String nombre  = myUtils.leerTextoPantalla("Introcude el nombre del Gerente:");
                        String dni = myUtils.comprobarPatronRepetidamente(patrondni, "Introduce el DNI del Gerente: ");
                        System.out.println("Cual es su numero de telefono: ");
                        int telefono = reader.nextInt();
                        String direccion  = myUtils.leerTextoPantalla("Introcude la direccion del Gerente:");
                        LocalDate fechaNacimiento = myUtils.leerFecha("Escribe la fecha de nacimiento del Gerente con el siguiente formato: DD/MM/YYYY");
                        String correo  = myUtils.leerTextoPantalla("Introcude el correo del gerente:");
                        System.out.println("Cuanto es su salario: ");
                        double salario = reader.nextDouble();
                        Departamento departamentos = myUtils.menuDep();
                        System.out.println("Esta trabajando ahora mismo? (true/False): ");
                        boolean trabajando = reader.nextBoolean();
                        System.out.println("Cuantos trabajadores tiene en su departamento");
                        int tra = reader.nextInt();
                        GerenteDep g1;
                        try {
                            g1 = new GerenteDep(dni, nombre, direccion, fechaNacimiento, correo, salario, departamentos, trabajando, telefono);
                            gerente = g1;
                            empresa1.registrarGerente(gerente);
                        } catch (TrabajadorYaRegistradoException e2) {
                        System.out.println("Este trabajador ya existe");
                        }catch(Exception e2){
                            System.out.println("Hubo un problema con la creacion revise los datos");
                        }

                    }else if (opcion2.equals("3")){
                        String nombre  = myUtils.leerTextoPantalla("Introcude el nombre del Trabajador:");
                        String dni = myUtils.comprobarPatronRepetidamente(patrondni, "Introduce el DNI del Trabajador: ");
                        String direccion  = myUtils.leerTextoPantalla("Introcude la direccion del Trabajador:");
                        LocalDate fechaNacimiento = myUtils.leerFecha("Escribe la fecha de nacimiento del Trabajador con el siguiente formato: DD/MM/YYYY");
                        String correo  = myUtils.leerTextoPantalla("Introcude el correo del Trabajador:");
                        System.out.println("Cuanto es su salario: ");
                        double salario = reader.nextDouble();
                        Departamento departamentos = myUtils.menuDep();
                        System.out.println("Esta trabajando ahora mismo? (true/False): ");
                        boolean trabajando = reader.nextBoolean();
                        Trabajador t1;
                        try {
                            t1 = new Trabajador(dni, nombre, direccion, fechaNacimiento, correo, salario, departamentos, trabajando);
                            nTrabajador = t1;
                            empresa1.registrarTrabajador(nTrabajador)   ;
                        } catch (TrabajadorYaRegistradoException e2) {
                        System.out.println("Este trabajador ya existe");
                        }catch(Exception e2){
                            System.out.println("Hubo un problema con la creacion revise los datos");
                        }
                    }else{
                        System.out.println("Introduce una opcion valida");
                    }

                break;

                case "2":
                    empresa1.mostrarinfoTrabajadores();
                    // System.out.println(dire.toString());
                    // System.out.println(gerente.toString());
                break;

                case "3":
                    
                break;

                case "4":
                    
                break;

                case "5":
                System.out.println("Selecciona el cliente que quieres dar de baja.");
                System.out.println(empresa1.mostrarinfoTrabajadores());
                int codSocio = reader.nextInt();
                empresa1.eliminarTrabajador(dni);
                break;

                case "6":
                    
                break;

                case "7":
                    
                break;

            }

    } while (!opcion.equals("7"));

    }//
}//

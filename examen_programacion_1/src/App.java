import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Examen");

        Scanner reader = new Scanner(System.in);

        System.out.println("Introduce la cantidad total de numeros a almacenar: ");
        int x = reader.nextInt(); //pedimos la cantidad de numeros de la coleccion

        double array[] = new double[x]; //array de la coleccion

        int posicion;
        double valor = 0.0;
        String menu;

        do { 
            reader = new Scanner(System.in);

            System.out.println("1-Modificar coleccion");
            System.out.println("2-Estadisticas de la coleccion");
            System.out.println("3-Ampliar el valor de la coleccion");
            System.out.println("4-Salir");
            menu = reader.nextLine();

            if(menu.equals("1")){
                String submenu1;
                
                    System.out.println("1-Insertar número");
                    System.out.println("2-Borrar número de una posicion especifica");
                    System.out.println("3-Modificar número de una  posicion especifica");
                    submenu1 = reader.nextLine();
                        
                        if(submenu1.equals("1")){
                            System.out.print("Introduce la posición: ");
                            posicion = reader.nextInt();
                            System.out.print("Introduce el valor: ");
                            valor = reader.nextInt();

                                if (posicion >= 0 && posicion < array.length) {
                                    array[posicion] = valor;
                                    System.out.println("Valor " + valor + " introducido en la posición " + posicion);
                                }else {
                                    System.out.println("posicion no valida.");
                                }               
                        }   else if(submenu1.equals("2")){
                            System.out.print("Introduce la posición: ");
                            posicion = reader.nextInt();

                                if (posicion >= 0 && posicion < array.length) {
                                    array[posicion] = 0;
                                    System.out.println("Borrado el numero de la posicion "+ posicion);
                                }else {
                                    System.out.println("posicion no valida.");
                                }  
                        } else if(submenu1.equals("3")){
                            System.out.print("Introduce la posición a modificar: ");
                            posicion = reader.nextInt();
                            System.out.print("Introduce el nuevo valor: ");
                            valor = reader.nextInt();

                                if (posicion >= 0 && posicion < array.length) {
                                    array[posicion] = valor;
                                    System.out.println("Valor " + valor + " modificado en la posición " + posicion);
                                }else {
                                    System.out.println("posicion no valida.");
                                }
                        }
                   


            }else if(menu.equals("2")){
                String submenu2;
                double suma = 0.0;
                int noNulo = 0;
                double media;
                double maximo = 0.0;
                double minimo = array[0];
                
                for(int i = 0; i < x; i++) {
                    suma += array[i]; // Acumulamos la suma.       
                    maximo= Math.max(array[i], maximo);//el valor maximo

                    if(array[i] < minimo){ //caculamos el valor minimo
                        minimo = array[i];
                    }    
                    
                    if(array [i]!= 0){ //contamos cuantos numeros del array son no nulos para hacer la media bien
                        noNulo++;
                       
                    }
                }
                
                    System.out.println("1-Media de todos los valores no nulos");
                    System.out.println("2-Suma de todos los valores");
                    System.out.println("3-Maximo de la coleccion");
                    System.out.println("4-Minimo de la coleccion");
                    submenu2 = reader.nextLine();

                        if(submenu2.equals("1")){
                            media = suma / noNulo;  //calculamos la media
                            System.out.println("La media de los valores no nulos es: "+media);

                        }else if(submenu2.equals("2")){
                            System.out.println("La suma de todos los valores es: " +suma);

                        }else if(submenu2.equals("3")){
                            System.out.println("El numero maximo de la coleccion es: " +maximo);
                        }else if(submenu2.equals("4")){
                            System.out.println("El numero minimo de la coleccion es: "+minimo);
                        }

            }else if(menu.equals("3")){
                System.out.println("Introduce la nueva cantidad total de numeros de la coleccion: ");
                x = reader.nextInt();
                
            }




        } while(!menu.equals("4"));


    }//
}//

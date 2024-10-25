package com.decroly.daw;

import java.util.Scanner;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner reader = new Scanner(System.in);
		
		//ejercicio1
		
		double[] nums = new double[10];
		
		
		System.out.println("Introduce 10 numeros reales");
		
		for(int i = 0; i < nums.length; i++)
			nums[i] = reader.nextDouble();
		
		System.out.println("Los numeros introducidos son: ");
		
		for(int i = 0; i < nums.length; i++)
			System.out.println(nums[i]+ "");
		
		//ejercicio 2
		reader = new Scanner(System.in);
		
		double[] vector = new double[10];
		
		
		double suma = 0.0;
		
		System.out.println("Introduce 10 numeros reales");
		
		for(int u = 0; u < vector.length; u++)
			vector[u] = reader.nextDouble();
		
		for(int u = 0; u < vector.length; u++) {
			
			suma += vector[u];
		}
		
		System.out.println("La suma de todos los valores son:"+suma);

		//ejercicio 3
		
		reader = new Scanner(System.in);
		
		double[] vector1 = new double[10];
		
		
		
		System.out.println("Introduce 10 numeros reales");
		
		for(int i = 0; i < vector1.length; i++)
			vector1[i] = reader.nextDouble();
		
		double maximo = 0.0;
		double minimo = vector1[0];
		
		
		for(int i = 0; i < vector1.length; i++) {
					
			maximo= Math.max(vector1[i], maximo);
			minimo= Math.min(vector1[i], minimo);
		}
		
		System.out.println("El numero máximo es: "+ maximo);
		System.out.println("El numero minimo es: " + minimo);
	

		//ejercicio 4
		
		reader = new Scanner(System.in);
				
		int[] vector2 = new int[20];

		
				
		System.out.println("Introduce 20 numeros reales");
		int sumaNega = 0;
		int sumaPosi = 0;
				
		for(int i = 0; i < vector2.length; i++) {
			vector2[i] = reader.nextInt();
				

			
			if(vector2[i] > 0) {
				sumaPosi += vector2[i];
			}else if(vector2[i]< 0) {
				sumaNega += vector2[i];
			}
		
		}
		System.out.println("La suma de los numeros positivos es: "+ sumaPosi);
		System.out.println("La suma de los numeros negativos es: "+ sumaNega);
		
		
		//ejercicio 5

		reader = new Scanner(System.in);
		
		double[] vector3 = new double[20];

		System.out.println("Introduce 20 numeros reales");	

		double sumamedia = 0.0;
		double media = 0.0;
		
		for(int i = 0; i < vector3.length; i++) {
			vector3[i] = reader.nextDouble();
			
			sumamedia += vector3[i];
			media = sumamedia/20;
			
		}
		
		System.out.println("La media de los valores introducidos es:" + media);



		//ejercicio 6

		reader = new Scanner(System.in);
		
		System.out.println("Dame un valor N");
		int n = reader.nextInt();
		
		System.out.println("Dame un valor M");
		int m = reader.nextInt();
		
		int vector4[] = new int[n];
		
		for(int i = 0; i < n; i++)
			vector4[i] = m;
			
		System.out.println("el resultado del array es: ");

		for(int i = 0; i < n; i++)
			System.out.println(vector4[i]+ "");
		
		
		//ejercicio 7
		
		reader = new Scanner(System.in);
				
		System.out.println("Dame un valor P");
		int P = reader.nextInt();
				
		System.out.println("Dame un valor Q");
		int Q = reader.nextInt();
		
		if(P>Q) {
			System.out.println("El valor P tiene que ser menor que Q");
		}else {
			int array = Q - P;
			int vector5[] = new int[array];
			for(int i = 0; i < array; i++) {
			
			vector5[i]= P + i;
		System.out.println("El array desde P hasta Q es: " + vector5[i]);	
			}
		}
		
		//ejercicio 8
		
		reader = new Scanner(System.in);
		int contador = 0;

		double vector6[] = new double[100];
		
		System.out.println("Dame un numero entre el 0.0 y el 1.0");
		double R = reader.nextDouble();
		
		
		for(int i = 0; i < vector6.length; i++) {
			vector6[i] = Math.random();
		
				if(vector6[i] >= R) {
					contador++;
				}
		}
		System.out.println("Hay "+ contador+ "numeros mayores o iguales que "+R);
		
		
		//ejercicio 9
		
		reader = new Scanner(System.in);
		
		
		System.out.println("Dame un valor entre 1 y 10");
		int N = reader.nextInt();
		boolean existe = false;
		
		int vector7[] = new int[100];
		for(int i = 0; i < vector7.length; i++) {
			vector7[i] = (int)(1+Math.random()*10);
			
			if(vector7[i] == N) {
				existe = true;
				System.out.println("Aparece en la posicion "+ i);
			}
		}
		
		//ejercicio 10
		
		reader = new Scanner(System.in);
		
		System.out.println("Introduce el numero de personas");
		int N2 = reader.nextInt();
		
		double alturas[] = new double[N2];
		for(int i = 0; i < N2; i++) {
			System.out.println("Introduce la altura de la persona");
			 alturas[i] = reader.nextDouble();
		}
		
		double suma_altura = 0.0;
		double alturamax = alturas[0];
		double alturamin = alturas[0];
		
		for(int i = 0; i < N2; i++) {
			suma_altura += alturas[i];
			if(alturamax < alturas[i]){
				alturamax = alturas[i];
			}
			if(alturamin > alturas[i]){
				alturamin = alturas[i];
			}
		}
		
		double media2 = suma_altura /N2;
		
		double Emedia = 0;
		double Dmedia = 0;
		
		for(int i = 0; i < N2; i++) {
			if(alturas[i] > media2) {
				Emedia++;
			}else {
				Dmedia++;
			}
		}
		
		System.out.println("La altura media es: " + media2);
        System.out.println("La altura maxima es: " + alturamax);
        System.out.println("La altura minima es: " + alturamin);
        System.out.println("Hay " + Emedia + " personas por encima de la media de altura");
        System.out.println("Hay " + Dmedia + " personas por debajo de la media de altura");
        
		//ejercicio 11
		
		System.out.println("Primer array");
		int vector8[] = new int[100];
		for(int i = 0; i < vector8.length; i++) {
			vector8[i]=i+1;
			System.out.println(vector8[i]+"");
		}
		
		System.out.println("Segundo array");
		
		int alreves[] = new int[100];
		for(int i = 0; i < alreves.length; i++) {
			alreves[i] = vector8[100 -1 -i];
			System.out.println(alreves[i]+"");
		}
		
		//ejercicio 12
		
		int enteros[] = new int[10];
		
		String menu;
		
		do {
	     	reader  = new Scanner(System.in);
			
			System.out.println("a. Mostrar valores");
			System.out.println("b. Introducir valor");
			System.out.println("c. salir");
			menu = reader.nextLine();
			
			if(menu.equals("a")){
				 
			     for (int i = 0; i < enteros.length; i++) {
		    			 
			    	 System.out.println("El valor del numero "+(i+1) + " es "+ enteros[i] );
			    	 
			     }
				
				 
	         }else if(menu.equals("b"))
	         {
	        	 System.out.print("Introduce la posición (0-9): ");
                 int posicion = reader.nextInt();
                 System.out.print("Introduce el valor: ");
                 int valor = reader.nextInt();

                 
                 if (posicion >= 0 && posicion < enteros.length) {
                     enteros[posicion] = valor;
                     System.out.println("Valor " + valor + " introducido en la posición " + posicion);
                 }else {
                	 System.out.println("posicion no valida, debe estar entre 0 y 9,");
                 }
                 
                 
	        	 }else if(menu.equals("c")){
	        	 System.out.println("Hasta pronto");
	        	 
	         }else { 
	        	 System.out.println("Añade una opcion que sea correcta en el menu");
	         }
			
	     }while(!menu.equals("c"));
		
		
		//ejercicio 13
		
		reader  = new Scanner(System.in);
		
		System.out.println("Dame un valor inicial");
		int V = reader.nextInt();
		
		System.out.println("Dame un valor para los intervalos");
		int I = reader.nextInt();
		
		System.out.println("Numero de valores a crear");
		int N3 = reader.nextInt();
		
		int vector9[] = new int[N3];
		
		for(int i = 0; i < vector9.length; i++) {
			System.out.println("El array resultante es: "+ (V+i*I));
		}
		
		//ejercicio 14
		
		int vector10[] = new int[55];
		int valores = 0;
		
		for (int i = 1; i <= 10; i++) { 
	           for (int x = 0; x < i; x++){
	                vector10[valores] = i;
	                valores++;
	            }
	        }
	             
	    System.out.println("Los valores son: "); 
			for(int i : vector10) {
				System.out.println(i+"");
			}
		
		
	}//

}//
	



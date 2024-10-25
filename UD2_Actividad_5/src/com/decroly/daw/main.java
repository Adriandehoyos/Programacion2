package com.decroly.daw;

import java.util.Scanner;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	
		Scanner reader = new Scanner(System.in);
		
		//ejercicio 1
		
		System.out.println("Introduce la cadena de texto: ");
		String S = reader.nextLine();
		
		String[] palabras = S.split(" ");
		
		for(String palabra : palabras) {
			System.out.println(palabra);
		}
		
		//ejercicio 2
		
		reader = new Scanner(System.in);
		
		
		System.out.println("Introduce la cadena de texto 1: ");
		String cadena = reader.nextLine();
		
		System.out.println("Introduce la cadena de texto 2: ");
		String cadena2 = reader.nextLine();
		
		if(cadena.equalsIgnoreCase(cadena2)) {
			System.out.println("La cadena 1 y la 2 son iguales");
		}else {
			System.out.println("La cadena 2 y la 2 no son iguales");
		}
		
		//ejercicio 3
		
		reader = new Scanner(System.in);
				
				
		System.out.println("Introduce tu nombre: ");
		String nombre = reader.nextLine();
				
		System.out.println("Introduce tu primer apellido: ");
		String apellido = reader.nextLine();
				
		System.out.println("Introduce tu segundo apellido: ");
		String apellido2 = reader.nextLine();
				
		String concatenacion = nombre.substring(0,3)
		       + apellido.substring(0,3)
		       + apellido2.substring(0,3);
				
		System.out.println("El codigo del usuario es: " + concatenacion.toUpperCase());
				
				
		//ejercicio4
		reader = new Scanner(System.in);
				
		 System.out.println("Introduce una frase: ");
		 String frase = reader.nextLine().toLowerCase();
		 int a = 0; 
		 int e = 0;
		 int i = 0;
		 int o = 0;
		 int u = 0;
			        
			        
		for (char c : frase.toCharArray()) {
		    if (c == 'a'){
		           a ++;
		   } else if (c == 'e'){
		          e ++;
		   } else if (c == 'i'){
		          i ++;
		   } else if (c == 'o'){
		          o ++;
		   } else if(c == 'u'){
		          u ++;
		         }
		   }
		System.out.println("Hay " + a + " a en la frase");
		System.out.println("Hay " + e + " e en la frase");
		System.out.println("Hay " + i + " i en la frase");
		System.out.println("Hay " + o + " o en la frase");
		System.out.println("Hay " + u + " u en la frase");
		
	
		//ejercicio 5
		
		reader = new Scanner(System.in);
		
		System.out.println("Introduce una frase: ");
		String palindromo = reader.nextLine();
		
		String sinEspacios = palindromo.replace(" ", "").toLowerCase();
		
		String reverso = new StringBuilder(sinEspacios).reverse().toString();
		
		 if (sinEspacios.equals(reverso)) {
	            System.out.println("La frase es un palíndromo");
	        } else {
	            System.out.println("La frase no es un palíndromo");
	        }
		
		
		
	}//

}//	
	



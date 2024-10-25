package com.decroly.daw;

import java.util.Scanner;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner reader = new Scanner(System.in);
		
		 //Ejercicio 1
		
	    int [][] matriz = new int[5][5];
	    int numero = 1;

	    for (int i = 0; i < matriz.length; i++) {
	        for (int j = 0; j < matriz.length; j++) {
	        matriz[i][j] = numero++;
	        }
	    }
	    
	    
	    for (int i = 0; i < matriz.length; i++) {
	        System.out.println("Fila "+ i + ": " );
	        for (int j = 0; j < matriz.length; j++) {
	            System.out.println(matriz[i][j] + " ");
	        }
	    }
	    
	    
	    //Ejercicio 2
	    
	    int [][] matriz1 = new int [10][10];

	    for (int i = 0; i < matriz1.length; i++) {
	        for (int j = 0; j < matriz1.length; j++) {
	        matriz1[i][j] = (i + 1) * (j +1);
	        }
	    }

	    for (int i = 0; i < matriz1.length; i++) {
	        System.out.println("Fila "+ i + ": " );
	        
	        for (int j = 0; j < matriz1.length; j++) {
	            System.out.println(matriz1[i][j] + "\t");
	        }
	    }
	    

	    //Ejericio 3
	    
	    reader = new Scanner (System.in);
	    
	    System.out.println("Introduce el valor para n:");
	    int N = reader.nextInt();
	    
	    System.out.println("Introduce un valor para m: ");
	    int M = reader.nextInt();
	    
	    int [][] matriz2 =  new int [N][M];

	    System.out.println("Introduce los valores de la matriz:");
	    for (int i = 0; i < N; i++) {
	        for (int j = 0; j < M; j++){
	            System.out.println("Valor en la posicion:" + i + j);
	            matriz2 [i][j] =  reader.nextInt();
	        }
	    }
	    
	    int igual = 0;
	    int mayor = 0;
	    int menor = 0;

	    
	    for (int i = 0; i < N; i++) {
	        for (int j = 0; j < M; j++){
	            if (matriz2[i][j] == 0){
	                igual ++;
	            }else if (matriz2[i][j] < 0) {
	                mayor ++;
	            }else{
	                menor ++;
	            }
	        }
	    }
	    
	    System.out.println("Hay " + igual + " valores iguales a cero.");
	    System.out.println("Hay " + mayor + " valores mayores a cero.");
	    System.out.println("Hay " + menor + " valores menores a cero.");


	    //Ejercicio 4
	    
	    int alumnos = 4;
	    int asignaturas = 5;
	    double [][] calificaciones = new double[alumnos][asignaturas];
	    for (int i = 0; i < alumnos; i++) {
	        System.out.println("Introduce las notas del alumno " + (1 + i) + " : ");
	        for (int j = 0; j < asignaturas; j++) {
	            System.out.println("Asignatura " + (j + 1) + " : ");
	            calificaciones[i][j] = reader.nextDouble();
	        }
	    }

	    for (int i = 0; i < alumnos; i++) {
	        double notamin = calificaciones[i][0];
	        double notamax = calificaciones[i][0];
	        double suma = 0;
	        for (int j = 0; j < asignaturas; j++) {
	            notamin = Math.min(notamin, calificaciones[i][j]);
	            notamax = Math.max(notamax, calificaciones[i][j]);
	            suma += calificaciones[i][j];
	        }
	        System.out.println("Resultados para alumno: " + (i + 1) + " : ");
	        System.out.println("La nota minima es: " + notamin);
	        System.out.println("La nota maxima es: " + notamax);
	        System.out.println("La nota media es: " + suma/asignaturas);
	    }


	    //Ejercicio 5
	    
	    System.out.println("Introduce el numero de trabajadores:");
	    int x = reader.nextInt();
	    
	    
	    double sueldo[][] = new double [x][2];
	    for (int i = 0; i < x; i++) {
	        System.out.println("El trabajador " + (i + 1) + " :");
	        
	        System.out.println("Introduce 0 para genero masculino y 1 para genero femenino");
	        sueldo [i][0] = reader.nextDouble();
	        
	        System.out.println("Sueldo: ");
	        sueldo [i][1] = reader.nextDouble();     
	    }

	    double sumhombres = 0;
	    double summujeres = 0;
	    int hombres = 0;
	    int mujeres = 0;

	    for (int i = 0; i < x; i++) {
	        if (sueldo[i][0] == 0){
	            hombres ++;
	            sumhombres += sueldo[i][1];
	        } else{
	            mujeres ++ ;
	            summujeres += sueldo[i][1];
	        }
	    }
	    System.out.println("El sueldo medio de los hombres es: " + sumhombres/hombres);
	    System.out.println("El sueldo medio de las mujeres es: " + summujeres/mujeres);

	    if(sumhombres/hombres > summujeres/mujeres){
	        System.out.println("Existe una brecha salarial a favor de los hombres");
	    }else{
	        System.out.println("Existe una brecha salarial a favor de las mujeres");
	    }

		
		
	}//

}//
	

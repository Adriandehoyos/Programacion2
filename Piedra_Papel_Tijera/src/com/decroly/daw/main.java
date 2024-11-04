package com.decroly.daw;

import java.util.Random;
import java.util.Scanner;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println("Esto es un juego de piedra papel o tijera");
		System.out.println("Deberas elegir en las opciones entre piedra papel o tijera y segun tu eleccion habras ganado, perdido o empatado");
		System.out.println("cuando quieras dejar de jugar solo tendras que selecionar salir del juego");

		Scanner reader = new Scanner(System.in);

		String opcion = "";
		Random random = new Random();

		do{
			int opcionOrdenador = random.nextInt(3); //0= piedra 1= papel 2= tijera

			
			System.out.println("P para piedra");
			System.out.println("L para papel");
			System.out.println("T para tijera");
			System.out.println("S para dejar de jugar");
			opcion = reader.nextLine();

			

			if(opcion.equals("P")){

				if(opcionOrdenador == 0){
					System.out.println("La maquina ha escogido piedra has empatado");
				}else if(opcionOrdenador == 1){
					System.out.println("La maquina ha escogido papel has perdido");
				}else if(opcionOrdenador == 2){
					System.out.println("La maquina ha escogido tijera has ganado");
				}
			
			}
			else if(opcion.equals("L")){

				if(opcionOrdenador == 0){
					System.out.println("La maquina ha escogido piedra has ganado");
				}else if(opcionOrdenador == 1){
					System.out.println("La maquina ha escogido papel has empatado");
				}else if(opcionOrdenador == 2){
					System.out.println("La maquina ha escogido tijera has perdido");
				}

			}
			else if(opcion.equals("T")){

				if(opcionOrdenador == 0){
					System.out.println("hLa maquina ha escogido piedra has perdido");
				}else if(opcionOrdenador == 1){
					System.out.println("La maquina ha escogido papel has ganado");
				}else if(opcionOrdenador == 2){
					System.out.println("La maquina ha escogido tijera has empatado");
				}

			}

			


		}while(!opcion.equals("S"));{
			System.out.println("Has salido del juego");
		}

	}//

}//

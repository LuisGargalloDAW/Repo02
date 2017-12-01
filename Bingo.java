import java.util.Scanner;
public class Bingo {
	public static void main(String[] args) {
		Scanner teclado = new Scanner (System.in);

		int numerosBingo[]= new int[90];
		int ordenBingo[]=new int[90];
		int numerosAleatorios[]= new int [90];
		int numerosAleatoriosBingo[]= new int [90];
		int numeroCarton[]=new int[90];
		int linea[]=new int[3];
		
		
		int correctos=0;

		String carton[]=new String[15];
		String numerosJugados = "";
		boolean bingo=false, lineaCorrecta=false;
		int conta=0;

		System.out.println("---- Bienvenido al juego ----");

		for (int k = 0; k < 90; k++){
			numerosBingo[k]=k+1;
		}

		for (int k = 0; k < 90; k++){
			numerosAleatorios[k]=k;
			numerosAleatoriosBingo[k]=k;
		}

		//Algoritmo de Fisher-Yates
		for (int i = numerosAleatorios.length; i > 0; i--) {
			int posicion = (int)(Math.random()*i);
			int tmp = numerosAleatorios[i-1];
			numerosAleatorios[i - 1] = numerosAleatorios[posicion];
			numerosAleatorios[posicion] = tmp;
		}

		//Algoritmo de Fisher-Yates
		for (int i = numerosAleatoriosBingo.length; i > 0; i--) {
			int posicion = (int)(Math.random()*i);
			int tmp = numerosAleatoriosBingo[i-1];
			numerosAleatoriosBingo[i - 1] = numerosAleatoriosBingo[posicion];
			numerosAleatoriosBingo[posicion] = tmp;
		}

		for (int k = 0; k < 15; k++){
			carton[k]="" + numerosBingo[numerosAleatorios[k]];
			numeroCarton[k]=0;
		}


		for (int k = 0; k < 90; k++){
			ordenBingo[k]=numerosBingo[numerosAleatoriosBingo[k]];
		}


		do{
			System.out.println();
			System.out.println("---- Este es tu carton de juego ----");
			System.out.println();
			for (int k = 0; k < 15; k++){
				if(k%5==0){
					System.out.println();
				}System.out.printf("%6s", carton[k]);
			}

			System.out.println("\n -----------------------------------");

			int numeroActual=ordenBingo[conta];
		
			
			for (int k = 0; k < 15; k++){
				if(carton[k].equals(""+numeroActual)){
					carton[k]=numeroActual + "X";
					numeroCarton[k]=1;
					if (k<5) {
							linea[0]++;
						}
					
					
					if (k >= 5 && k < 10){
							linea[1]++;
						}
					
					if ( k >= 10) {
							linea[2]++;
						}
			}
			}
	
			correctos=0;
			for (int k = 0; k < 15; k++){
				correctos=correctos+numeroCarton[k];
			}
			
	
			
			
			
			System.out.println("El numero que acaba de salir es: " + numeroActual);	
			numerosJugados=numerosJugados + numeroActual + " " ;

			System.out.println("Los numeros jugados hasta el momento son: " + numerosJugados);	
			System.out.println("Introduce una letra para sacar el siguiente numero");
			
			if(linea[0]==5 && lineaCorrecta==false) {
				System.out.println("¡ENHORABUENA HAS HECHO LINEA!");
				System.out.println("Vamos para bingo...");
				lineaCorrecta=true;
			}else if(linea[1]==5 && lineaCorrecta==false) {
				System.out.println("¡ENHORABUENA HAS HECHO LINEA!");
				System.out.println("Vamos para bingo...");
				lineaCorrecta=true;
			}else if (linea[2]==5 && lineaCorrecta==false) {
				System.out.println("¡ENHORABUENA HAS HECHO LINEA!");
				System.out.println("Vamos para bingo...");
				lineaCorrecta=true;
			}
			
			String letraControl = "";
			letraControl=teclado.nextLine();

			if (correctos==15) {
				bingo=true;
			}
			
			conta++;

		}while(bingo==false || conta == 0);
		
		System.out.println("¡EnhoraBuena! HAS CONSEGUIDO BINGO");




	}
}

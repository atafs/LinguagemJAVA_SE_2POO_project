package control_1Logica;

import java.util.Scanner;
import java.util.Random;

/** Conceitos: switch
    @autor Americo Tomas	
*/

public class FluxoJogoDadosRandom {

	public static void main(String[] args) {

		//class Scanner: inicializar, fazer uma pergunta ao utilizador e guardo o valor numa variavel		
		@SuppressWarnings("resource")
		Scanner s = new Scanner(System.in);
		System.out.println("Qual o seu palpite do valor do dado? ");
		int palpite = s.nextInt();
		
		//excepcao
		if(palpite > 6) throw new IllegalStateException("Insira outro valor (entre 1 e 6)");
		
		//class Random: inicializar uma variavel de nome n, do tipo Random e dar um valor ao mesmo
		Random r = new Random();	
		int dado = r.nextInt(6) + 1;			//0-5... mas eu quero de 1-6	
		
		//verificar os valores inseridos		
		System.out.println("Palpite = " + palpite);
		System.out.println("Dado = " + dado);
	
		//fluxo condicional
		if(palpite == dado) {
			System.out.println("\nParabens!! Acertou no valor!!!\n");		
		} else {
			System.out.println("\nFoi ao lado!! Esta errado!!\n");	
		}
	}
}

//excepcao que nao funciona muito bem
//if(palpite > 6) System.out.println("\nInsira outro valor (entre 1 e 6)\n"); 


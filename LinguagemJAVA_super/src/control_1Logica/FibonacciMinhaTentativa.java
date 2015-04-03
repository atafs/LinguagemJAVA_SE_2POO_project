package control_1Logica;

import java.util.ArrayList;
import java.util.Scanner;


/** @autor Americo Tomas, 54149 */

public class FibonacciMinhaTentativa {


	public static void main(String[] args) {


		/* Sequencia Fibonacci */
		ArrayList<String> sequencia = new ArrayList<String>();			//class ArryList
		@SuppressWarnings("resource")
		Scanner s = new Scanner(System.in);
		System.out.println("Qual a quantidade de numeros Fibonacci pretende calcular? (ex: n=7; 0112358)");
		
		int numero = s.nextInt();
		String numero1 = "0";
		String numero2 = "1";
		
		int j = 0;
		String[] contador = new String[numero];
		for (int i=0; i < numero; i++) {
			contador[j] = numero1 + numero2;
			sequencia.add(contador[j]);
			i++;  
		}
		System.out.println(sequencia.toString());
	}
}

/*
Desafio:

comeca-se a serie a 0 e 1;
obtém-se o proximo numero Fibonacci somando-se os dois anteriores e assim, sucessivamente e infinitamente

ex: 1+2[3]   2+3[5]   3+5[8]   ...

0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, ...

*/

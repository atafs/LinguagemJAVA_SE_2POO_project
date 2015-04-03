package control_1Logica;


/** @autor Americo Tomas, 54149 */

/* Sequencia Fibonacci: calcular de forma progressiva */
/* ex:     1+2[3]   2+3[5]   3+5[8]   ... */
/* 0, 1,    1, 2,    3, 5,   8, 13,    21, 34, 55, 89, ... */


public class Fibonacci1 {


	public static void main(String[] args) {

		int anterior = 0;
		int proximo = 1;
		System.out.print(anterior);
		System.out.print(proximo);

		/* Fluxo de repetição: while */		
		while(proximo < 50000) {
			proximo = proximo + anterior;
			anterior = proximo - anterior;
			System.out.print(proximo);
		} 	
		System.out.println();

	
		






	}
}

/*
Desafio:

comeca-se a serie a 0 e 1;
obtém-se o proximo numero Fibonacci somando-se os dois anteriores e assim, sucessivamente e infinitamente

ex: 1+2[3]   2+3[5]   3+5[8]   ...

0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, ...

  - raciocinio:
int anterior = 1;
int proximo = 2;
System.out.print(anterior);
System.out.print(proximo);

proximo[3: novo proximo] = proximo[2] + anterior[1];
anterior[2: novo anterior] = proximo[3: novo proximo] - anterior[1];
System.out.print(proximo + "\n");

*/

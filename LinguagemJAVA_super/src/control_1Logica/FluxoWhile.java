package control_1Logica;

import java.util.ArrayList;
import java.util.Scanner;

/** Conceitos:
    @autor Americo Tomas	
*/

public class FluxoWhile {

	public static void main(String[] args) {

		/* fluxo de repeticao "while" */
		int i = 3;
		while(i < 2) {
			System.out.print(i + ", ");
			i++; 					//atencao aos ciclos infinitos: sem esta incrementacao, vai executar infinitamente.
			if (i >= 2) System.out.println("\n");
		}

		/* equivalente ao for */
		for (int j=0; j<2; j++) System.out.println(j + ", "); 

		/* fluxo de repeticao "do while"*/
		//int k = 3;
		do {
			System.out.println(i);
			i++;
		} while (i < 2);

		/* Recolhe uma lista de produtos digitados pelo utilizador */
		ArrayList<String> produtos = new ArrayList<String>();			//class ArrayList		
		@SuppressWarnings("resource")
		Scanner s = new Scanner(System.in);					//class Scanner	

		System.out.println("Liste seus produtos: Para sair digite FIM");	//explicar para o utilizar do que se trata este programa
		String produto;
		
		while (!"FIM".equals(produto = s.nextLine())) {
			produtos.add(produto);
		}	
		System.out.println(produtos.toString());		
	}

	
}

/*
semelhante a estrutura for
tem apenas o criterio de avaliacao
do... vai ser executada pelo menos uma vez

while() {...} - a instrucao e executada de 0-n vezes
do{....} while (condicao) - a instrucao e executada 1-n vezes, mas sempre pelo menos 1 vez

== operador de comparacao deve ser usado para valores primitivos ou objectos... valores de objectos podemos precisar de uma metodo auxiliar
("XX".equals(nome))

__________________________________________

String produtos;
produtos = s.nextLine();
while ("FIM".equals(produtos)) {  - levanta um problema, pois a variavel produtos esta fora do ciclo (nao pode ser lida)

String produtos;
while ("FIM".equals(produtos = s.nextLine();)) { - dentro do ciclo while, a guardar o nemo escrito pelo utilizador em produtos
						 - e a fazer a comparacao com a String "FIM"


*/

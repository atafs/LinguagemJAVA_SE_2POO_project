package control_1Logica;


import java.util.ArrayList;

/**
 * Conceitos:
 * 
 * @autor Americo Tomas
 */

public class FluxoForEach {

	public static void main(String[] args) {

		int[] pares = { 2, 4, 6, 8 };
		for (int i = 0; i < pares.length; i++) { // verifico se a minha
													// variavel: menos que o
													// comprimento do array
			int par = pares[i];
			System.out.println(par + ", "); // recupero o n par de cada uma das
											// posicoes
		}

		System.out.println();

		/* estrutura do foreach */
		for (int par : pares) { // ler: percorra cada elemento par do tipo int
								// existente dentro de pares
			System.out.println(par + ", ");
		}
		/*
		 * limitacoes do foreach: - nao temos acesso a variavel i do for
		 * tradicional (nao posso comecar a meio) - o percorre os elementos para
		 * a frente (tradicional posso andar para frente e para tras; controlo
		 * total fluxo)
		 */

		ArrayList<Integer> list = new ArrayList<Integer>(); // class ArrayList,
															// logo tenho que a
															// inicializar

		/* for */
		for (int i = 0; i < 10; i++) { // adicionar dez numeros a minha lista
			list.add(i);
		}
		System.out.println(list + "\n");

		/* foreach */
		for (Integer numero : list) { /*
									 * sintaxe: percorra cada elemento de numero
									 * do tipo Integer existente dentro de list
									 */
			System.out.print(numero + ", ");
		}
	}

}

/*
 * for: Array ou ArrayList... percorrer elementos em ambos
 * 
 * foreach: todos os elementos dentro de um Array ou ArrayList
 */

package control_1Logica;

import java.util.Arrays;

/** @autor Americo Tomas
    	
*/

public class ArraySimples {
	
	//método main:	
	public static void main(String[] args) {
	
		String[] paises = {"Brasil", "Russia", "India", "China"};	//inicializado
	
		System.out.println(paises[0]);								//imprimir uma posicao	
		System.out.println(Arrays.toString(paises));				//imprimir numa matriz o conteudo 
	
		int posicao = Arrays.binarySearch(paises, "Russia");		//em que Array e qual é o que procuro	
		System.out.println(posicao);								//saber em que posicao existe um conteudo

		Arrays.sort(paises, 0, paises.length);						//ordenar Arrays: qual, onde comeco, onde termino.
		System.out.println(Arrays.toString(paises));				//imprimir a Arrays para ver o resultado da ordenacao

		Double[] valores = {12.35, 3456.3456};						//classe WRAPPER
		System.out.println(valores[0].doubleValue());				//aceder directamente a classe Wrapper

		//indice = valor											//comeca sempre na posicao zero
		//String pais1 = "Brasil";
		//String pais2 = "Russia";
		//String pais3 = "India";
		//String pais4 = "China";

		int[] impares = new int[5];					//inicializado
		impares[0] = 1;	
		impares[1] = 3;
		impares[2] = 5;	
		impares[3] = 7;	
		impares[4] = 9;	
		System.out.println(paises.length);
	

		
	}
}



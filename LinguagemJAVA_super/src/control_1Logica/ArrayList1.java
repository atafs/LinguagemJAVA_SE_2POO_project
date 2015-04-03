package control_1Logica;

import java.util.ArrayList;

/** @autor Americo Tomas
    	
*/
public class ArrayList1 {


	public static void main(String[] args) {

		ArrayList <String> cores = new ArrayList<String>();		//colocar o tipo de dados <>; a partir da versao 7, só a 1º é preciso
		cores.add(0, "Azul");									//(Onde coloco a String; Qual String)
		cores.add("Branco");
		cores.add("Vermelho");									//nao existe limite para os que quero criar
								
		System.out.println(cores.toString());
		System.out.println("Tamanho: " + cores.size());
		System.out.println("Elemento: " + cores.get(2));
		System.out.println("Indice do Branco: " + cores.indexOf("Branco"));

		cores.remove("Branco");
		System.out.println("Tem Amarelo: " + cores.contains("Amarelo"));//metodo boolean

	}

}



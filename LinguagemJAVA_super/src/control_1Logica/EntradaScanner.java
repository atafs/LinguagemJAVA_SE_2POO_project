package control_1Logica;

import java.util.Scanner;

/** Apresentar conceitos de Variaveis
    @autor Americo Tomas	

*/

public class EntradaScanner {
	
	public static void main (String[] args) {

		//muito pouco interativo: recuperacao dos dados feito na chamada do programa
		//System.out.println("\n" + args[0] + "\n"); 

		//interagir com o usuario: objecto Scanner, System.in para dar entrada e nao saida; sem o import dá erro
			
		
		@SuppressWarnings("resource")
		Scanner s = new Scanner(System.in);			//1- inicializar o Scanner:	
		System.out.print("Qual o Seu nome: ");			//2- fazer uma pergunta ao utilizador
		String nome = s.nextLine(); 				//3- guardo a resposta na variavel nome de s.nextLine();	

									//4- saudacao ao utilizador
		System.out.println("\nBenvindo " + nome + "!! Vamos a caminho de um novo patamar de notas ;-)\n");
	}


}


/*
como recuperar as informacoes do usuario

java.lang
Scanner: class que esta no java.util
de momento não esta visivel para o nosso programa
universo muito extenso de classes para nao pesar o programa

erro:	System.out.println(s.nextLine());
certo:	String nome = s.nextLine();		guardar a informcao inserida pelo utilizador

interface grafica - 

*/			

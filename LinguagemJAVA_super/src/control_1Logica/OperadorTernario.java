package control_1Logica;

import java.util.Scanner;

/** Apresentar conceitos de Variaveis
    @autor Americo Tomas	
*/

public class OperadorTernario {
	
	//método main:	
	public static void main (String[] args) {
		
		//INTERACT WITH USER
		@SuppressWarnings("resource")
		Scanner s = new Scanner (System.in);
		System.out.print("Informe o Raio: ");
		double raio = s.nextDouble();
		
		System.out.print("Informe a sua Idade: ");
		int idade = s.nextInt();
		
		//avaliar: Se a idade for maior ou igual a 18, entao (?) apresenta o texto "blabla",  Caso contrario (:) "blabla";
		//operador ternario - aceita 3 operandos
		String x = (idade >= 18) ? "\nMaior de Idade\n" : "\nMenor de Idade";
		System.out.println(x);

		//String sexo = "M", pais = "Brasil";			//suprimir o tipo, pois sao ambos do mesmo tipo
		
		//diametro de um circulo : 2raio
		//double raio = 10;					//programa mais interativo
		Double diametro = 2 * raio;
		System.out.println("Diametro="+diametro);

		//circunferencia : 2 PI r
		double pi = Math.PI;
		double circunferencia = 2 * pi * raio;	
		System.out.println("Circunferencia="+circunferencia);

		//Area: PI r^2
		double area = pi * raio * raio;
		System.out.println("Area="+area+"\n");

	}
}

/*



*/

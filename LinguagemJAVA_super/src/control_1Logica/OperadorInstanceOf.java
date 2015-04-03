package control_1Logica;


/** Apresentar conceitos de Variaveis
    @autor Americo Tomas	
*/

public class OperadorInstanceOf {
	
	//método main:	
	public static void main (String[] args) {
	
		int x = 6;
		x %= 3;						//x = x + 3; -=, +=, /=, *=;
		System.out.println(x);	

		//x == 6 : true;				// = atribuicao; == comparacao
		//boolean true false;

		System.out.println(!(x == 6));			//so consigo comparar tipos semelhantes
		System.out.println(x != 7);
		System.out.println(x > 5);
		System.out.println((x >= 1) || (x <= 5));
		System.out.println();				//paragrafo

		//instanceof compara tipos de dados (valido para objectos)
		Integer y = 6;		
		System.out.println(y instanceof Integer);	//class Wrapper
		System.out.println("Ola" instanceof String);

		


	}
}

/*
Operadores de comparacao Java
Operador logicos: && e; || ou, ! negacao; ou basta uma verdadeira; && tem que ser os dois verdadeiros;

operdaores de atribuicao
+=, -=, 

Operadores especiais: 



*/

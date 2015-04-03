package control_1Logica;


/** Apresentar conceitos de Variaveis
    @autor Americo Tomas	

*/

public class OperadorUnarioBinario {
	
	//método main:	
	public static void main (String[] args) {
	
		//2 + 3 operador binario
		//-2 operador unario (um operando)
		//true ? "Sim" : "Não"; operador ternario

		int x = 9 + 4; 			//atribuir o valor da soma a x
		System.out.println(x);		
		x++;
		String s = ", Ola Programador Java!!";
		System.out.println(x + s);

		String y = "9" + "4";			//concatenar a String
		System.out.println(y);

   		double z = 7 - 4 + 3 * 2;
		System.out.println(z);

		double k = (7 - 4 + 3) * 2;		//eu defini a precedencia dos operadores
		System.out.println(k);

		double j = 7 * 3;			
		System.out.println(j);

		double l = 7 % 3;
		System.out.println(l);			//operando impar
		
		double q = -(-3);			//operador pode mudar o sinal do operando unario
		System.out.println(q);

		// equivalente a g = g + x		
		int p = 6;
		int g = --p;				//antes: pre incremento ++p; pos incremento p++ feito na proxima linha;
		System.out.println("p = " + p);		// x = x + 1;
		System.out.println("g = " + g);


		
	}
}

/*
expressão: 2 + 3
2 e 3 são operando
unidos por um operador, realizando uma operacao entre dois operandos
opera * dores binarios, unarios e trenarios
bi = 2 operados; 
= e um operador de atribuicao
% modulo

+,-,*,/,% (resto da divisao por um numero)
+, para concatenar String
+,-, operadores unarios
<,>,<=,>=, de comparacao
++,--, incrementar ou decrementar
==, !=, comparacao
[]
(), chamar metodos
?: trabalhar com bites directamente
! negacao
instanceOf, verifica o tipo de objecto




*/

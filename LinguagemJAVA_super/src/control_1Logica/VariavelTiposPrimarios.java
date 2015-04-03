package control_1Logica;


/** Apresentar conceitos de Variaveis
    @autor Americo Tomas	

*/

public class VariavelTiposPrimarios {
	
	public static void main (String[] args) {
		
		String nome = "Americo Tomas";
		int idade = 33; 
		boolean casado = true;
		char sexo = 'M';

		byte b = 127; 			//cem
		short s = 31523; 		//32mil
		int i = 2000000000; 		//2 bilioes
		long l = 900000000;	// 9 quintilhoes

		i = s; 		//conversao: um short num int, cast implicito
		System.out.println("\nConversao: Short " + s + " num Int: " + i); 

		i = (int) l; 	//consersao ou cast explicito: cast (tipo);
		System.out.println("Conversao: Long " + l + " num Int: " + i); 
		
		//IEEE 754 de padrão		
		double d = 1.2343223563435;
		float f = 123F;

		//byte na forma binária: começar com o prefixo 0b (indica que está na forma binária)	
		//byte bb = 0b01010010;				//8 bites ou 1 byte
		//short ss = 0b0101001001010010;			//16 bites de espaco ou 2 bytes de informacao
		//int ii = 0b01010010010100100101001001010010;

		System.out.println("\nTexto\n");
		System.out.print("O meu nome é " + nome + " sou do sexo " + sexo +  ", tenho de idade " + idade + "." ); 		
		System.out.println(" e sou Casado (" + casado + ") ");
		System.out.println("\nRepresentar Numeros:\n" + "byte: " + b + "; short: " + s + " \n");
		System.out.println("Representar Numeros: " + i + " " + l + " " + d + " " + f + " \n"); 

		
    
	}
} 



/*
a = 1;
b = 2;

variáveis
operador de atribuição =
variaveis com letra minuscula
logica de programacao - IP
orientacao objectos - POO

int - valor sem fraccao
double - receber numero facionario
char - representa uma letra e apenas uma, '' pelicas simples, caracter chines, arabe,..
boolean - verdadeiro ou falso

tamanho de informação que podes colocar dentro dele
1 bit é um zero ou um
true - 1
false - 0 ... ocupa 1 bit




*/

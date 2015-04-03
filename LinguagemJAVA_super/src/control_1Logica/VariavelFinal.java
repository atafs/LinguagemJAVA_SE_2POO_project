package control_1Logica;


/** Apresentar conceitos de Variaveis
    @autor Americo Tomas	

*/

public class VariavelFinal {
	
	public static void main (String[] args) {
		
		//variaveis primitivas
		int x = 8;
		x = 9;				//substitui x para 9, apagando o anterior

		//variavel de referencia:
		String y = "XTI";
		y = "XTI.com.br";		//novo objecto criado como novo valor de y, mas o objecto anterior ainda está na memoria
		y = null;			//novo objecto, nao esta com link a ninguem

		System.out.println("\n" + x + " " + y);

//>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>

		int populacaoBrasileira = 203429773;
		populacaoBrasileira = 456876545;
		
		//modificar final não pode ser mofificado
		//PI = 4565421.2554;				//dá erro pois não posso modificar estes valores
	
		final double PI = 3.141596535;
		final char SEXO_MASCULINO = 'M'; 
		final char SEXO_FEMININO = 'F'; 
		

		System.out.println("\n" + PI + " " + populacaoBrasileira + "\n");
		System.out.println(SEXO_MASCULINO + " " + SEXO_FEMININO + "\n");
		
	}
		

}


/*


tipos primitivos: char, int, double, float, ...
variável de referencia: aponta para um objecto

variavel x = 7 = 01000111; binário
x é um copo e o seu conteúdo x

variavel continua a ser um repositorio: copo
mas a sua referencia um controlo remoto para a referencia em si
o objecto esta na memoria do computador
link ao valor daquela variavel

GC - garbage colector, faz gerencia de forma a eleminar os objectos nao utilizados

constantes: são valores que não podem ser moficadas pelo sistema
modificador public, private


*/

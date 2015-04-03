package control_1Logica;



/** Conceitos: switch
    @autor Americo Tomas	
*/

public class FluxoFor {

	public static void main(String[] args) {
		
		//escrever numa String os numeros pares
		String texto = "";		
		for (int i=0; i<=20; i++) {			//noutra direccao: for (int i=0; i<3; i++) {		
			if (i % 2 == 0) {
				texto += i + ", ";		//o contexto dela esta limitada ao bloco do for
			}
		}
		System.out.println(texto);


		//escrever um Quadrado com asteriscos
		int tamanho = 5;						//tamanho do quadrado		
		for (int x=0; x<tamanho; x++) {				
			for (int i=0; i<tamanho; i++) {			//enquanto i for menor que o meu tamanho		
				System.out.print("* ");				//em vez de asteriscos, posso por o que eu quizer,
			}							//ex: (Math.random()*100) + ", ")
			System.out.println();	
		}
		
		


	}

}

/*
fluxo de repetição: for
for (int i=0; i<3; i++) {....}
4 partes: 	inicialização: 	inicializar a variável
		teste:		enquanto esse teste for verdadeiro, 
		accao:		o bloco de acção e executado
		actualizacao:	actualizacao da variavel

Atencao aos ciclos infinitos...

*/

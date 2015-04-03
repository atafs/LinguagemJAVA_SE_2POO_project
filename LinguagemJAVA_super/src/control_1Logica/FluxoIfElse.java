package control_1Logica;



/** Apresentar conceitos de Variaveis
    @autor Americo Tomas	

*/

public class FluxoIfElse {

	public static void main (String[] args) {
		
		/* fluxo condicional */
		int nota = (int)(Math.random() * 10);
		if(nota >= 7){	//quero fazer um teste, se for True, executo uma série de instruções dentro do if
			System.out.println("\nPassou!!\n");
		} else {
			System.out.println("\nReprovou!!\n");		
			if (nota >= 6){
				System.out.println("\nReprovou mas pode fazer recuperacao!!\n");
			}
			
		}

		//... se a condição não for verdadeira, o programa vai ignorar o código e passar para a linha seguinte

		//int idade = 10;
		//boolean passou = true;
		
		//int numero = 11;
		//if((numero % 2) == 0){	//quero fazer um teste, se for True, executo uma série de instruções dentro do if
		
/*
		int idade = 19;
		if(idade <= 11){	//quero fazer um teste, se for True, executo uma série de instruções dentro do if
			System.out.println("\nCrianca!!\n");
		} else if (idade > 11 && idade < 18){
			System.out.println("\nAdolescente!!\n");		
		} else if (idade > 18){
			System.out.println("\nAdulto\n");
		}
*/
	}
}


/*
if else
ou fluxo condicional
fazer uma avaliação 

____________________________________________________
Fluxo condicional:

if (se)					else (senao)

fizer sol vamos para o Clube		Vamos ao shopping





*/

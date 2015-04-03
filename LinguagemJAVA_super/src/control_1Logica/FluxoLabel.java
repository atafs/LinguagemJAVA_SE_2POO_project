package control_1Logica;


/** @autor Americo Tomas, 54149 */

public class FluxoLabel {

	
	public static void main(String[] args) {

		boolean[][] matrix = 
		{
			{false, true, false, false, false},
			{false, false, false, false, false}
		};	

		/* codigo que localize o value true dentro da matrix*/	
		busca:									//rotulo
		for(int a=0; a<matrix.length; a++){
			System.out.print("A ");	
			for(int b=0; b<matrix[a].length; b++) {
				if(matrix[a][b] == true){				
					System.out.print("True ");
					break busca;					//quebrar o fluxo mais interno
				}
			System.out.print("B ");	
			}
		}


	}


	

}

/*
Acelerar o processo de pesquisa dentro da matrix
Quando encontrou um true, nao pesquisou mais... apoiar os fluxos de repeticao
*/

package control_1Logica;



/** Conceitos: switch
    @autor Americo Tomas	
*/

public class FluxoSwitch {


	public static void main(String[] args) {
	

		//fluxo condicional: switch (avaliacao unica: se e igual a outros)
		char sexo = 'F';
		switch(sexo){								//precisa ser passado uma unica vez
			case 'M' :
				System.out.println("\nMasculino!!\n");
				break;
			case 'F' : 
				System.out.println("\nFeminino!!\n");
				break;
			default :
				System.out.println("\nPor definir...\n");
		}


		//fluxo condicional: if else (permite mais variantes de comparacoes: && || etc...)
		char estadoCivil = 'K';
		
		if (estadoCivil == 'S') {
			System.out.println("\nSolteiro(a)!!\n");
		}
		else if (estadoCivil == 'C') { 
			System.out.println("\nCasado(a)!!\n");
		}
		else { 
			System.out.println("\nPor definir...\n");
		}

		/*
		//fluxo condicional: switch
		String tecnologia = "postgresql";
		switch(tecnologia){    //permitido no java 7
			case "java" : //...;
			case "c++" : //...;
			//fluxo condicional, if else: if(tecnologia == "java" || tecnologia == "c++" ...){			

			case "cobol" : 
				System.out.println("\nLinguagem de Programacao!\n"); 
				break;
			case "oracle" : //...;
			case "sqlserver" : //...;
			case "postgresql" : 
				System.out.println("\nBase de Dados\n"); 
				break;
			default : System.out.println("\nTecnologia por investigar... \n"); 
		}
		
			*/

	}



}
/*
fluxo condicional: avaliar condições
switch: mais específica do que o if else (velocidade superior)...

break: 	parar a minha sequencia de avaliacoes
	não é obrigatorio


*/

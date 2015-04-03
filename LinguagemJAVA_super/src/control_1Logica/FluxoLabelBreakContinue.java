package control_1Logica;


/** @autor Americo Tomas, 54149 */

public class FluxoLabelBreakContinue {


	public static void main(String[] args) {

		/* Fluxo de repeticao: for */	
		//um:		
		//for() {		
			dois:			
			for(int i=0; i<10; i++) {
				if(i == 5) {
					continue dois;	//saltar esta execucao: parar a interacao actual			
				}					
				System.out.print(i);			
			}
		//}	

		/* Fluxo de repeticao: while */	
		while(true) {
			System.out.println("\nEntrou");	
			break; 				//parar a execucao do loop inteiro
		}	

	}

}

/*
continue: encerrar apenas a actual
break: encerra tudo; (usamos no swith, fluxo condicional)

break ou continue: parar a execucao mais interna

break, continue... auxiliares dos fluxos de repeticao, sao usadas para encerrar loops
break: encerra to ciclo completo
continue: apenas ma parte

rotulos: qual loop quer parar ou continuar
*/

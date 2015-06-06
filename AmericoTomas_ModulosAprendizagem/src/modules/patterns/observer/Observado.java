package modules.patterns.observer;
import java.util.Observable;
import java.util.Scanner;


public class Observado extends Observable {

	public Observado(){}
	
	public void read() {
		System.out.println("Inicio...");
		
		Scanner teclado = new Scanner(System.in);
		String linhaConsola = "test";
		while(!linhaConsola.equals("exit")) {
			System.out.print("> ");
			linhaConsola = teclado.nextLine();
//			System.out.println("Plavra: " + linhaConsola);
			
			if(linhaConsola.equals(linhaConsola.toUpperCase())){
				// Notificar Observers
				setChanged();
				notifyObservers(linhaConsola);
				
				//END
				System.out.println("Fim...");
				return;
			}
		}
		teclado.close();
	}
	
	
	
	
	
}

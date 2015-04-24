package control_0Pattern.observer.week9_poo;
import java.util.Observable;
import java.util.Scanner;


public class Observado extends Observable {

	public Observado(){}
	
	public void read() {
		System.out.println("Inicio...");
		
		Scanner teclado = new Scanner(System.in);
		String linhaConsola = "";
		while(!linhaConsola.equals("exit")) {
			System.out.print("> ");
			linhaConsola = teclado.nextLine();
//			System.out.println("Plavra: " + linhaConsola);
			
			if(linhaConsola.equals(linhaConsola.toUpperCase())){
				// Notificar Observers
				setChanged();
				notifyObservers(linhaConsola);
			}
		}
		
		teclado.close();
		System.out.println("Fim...");
	}
	
	
	
	
	
}

package modules.patterns.observer;

public class Teste {
	public static void main(String[] args) {
		
		//TESTS FOR PATTERN
		Observador observador = new Observador();
		Observado observado = new Observado();
		
		observado.addObserver(observador);
		
		observado.read();
	}
}

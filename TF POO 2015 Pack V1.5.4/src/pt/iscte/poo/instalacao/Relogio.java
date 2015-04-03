package pt.iscte.poo.instalacao;

public class Relogio {

	// ATTRIBUTE is the class itself. Only one that exists
	private static Relogio instance = null;
	private int counter;

	/**
	 * PRIVATE CONSTRUCTOR: using Singleton pattern, having only one instance.
	 * No more instances can be created except one
	 */
	private Relogio() {
		this.counter = 0;
	}

	/** SINGLETON PATTERN: static because we do not have objects */
	public static Relogio getInstanciaUnica() {

		if (instance == null) {
			instance = new Relogio();
		}
		return instance;
	}

	// METHOD
	/**
	 * DESCRICAO: incrementa mais uma unidade (simular unidades de tempo), ao
	 * contador.
	 */
	public void tique() {
		counter++;
	}

	// GETTERS AND SETTERS
	/**
	 * DESCRICAO: permite saber qual o valor actual de unidades guardadas na
	 * variavel (simulando qual o quantidade de tempo que passou desde o
	 * arranque do programa).
	 */
	public int getCounter() {
		return counter;
	}

	public void setCounter(int counter) {
		this.counter = counter;
	}
}

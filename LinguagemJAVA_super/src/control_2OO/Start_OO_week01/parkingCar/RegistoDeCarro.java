package control_2OO.Start_OO_week01.parkingCar;

public class RegistoDeCarro {

	// ATTRIBUTES
	private String matricula;
	private int numeroDeEntradas;

	// CONSTRUCTOR
	public RegistoDeCarro(String matricula) {
		this.matricula = matricula;
		this.numeroDeEntradas = 0;
	}

	public RegistoDeCarro(String matricula, int numeroDeEntradas) {
		this.matricula = matricula;
		this.numeroDeEntradas = numeroDeEntradas;
	}

	// GETTERS and SETTERS
	public int getNumeroDeEntradas() {
		return numeroDeEntradas;
	}

	/** TO BUY MORE ENTRANCES */
	public void setNumeroDeEntradas(int numeroDeEntradas) {
		this.numeroDeEntradas = numeroDeEntradas;
	}

	public String getMatricula() {
		return matricula;
	}

	// METHODS
	/** DECREMENT BY ONE FOR EACH ENTRANCE */
	public void registarEntrada() {
		numeroDeEntradas--;
	}

	// toSTRING
	@Override
	public String toString() {
		return "[Matricula: " + matricula + ", NumeroEntradas: "
				+ numeroDeEntradas + "];";
	}

}

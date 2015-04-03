package control_2OO.Start_OO_week01.parkingCar;

public class ParqueDeEstacionamento {

	// ATTRIBUTES
	private static final int MAX_REGISTOS = 100;
	private static final int MAX_ENTRADAS = 10;

	private RegistoDeCarro[] vectorRegistos;
	private int index;

	// CONSTRUCTOR
	public ParqueDeEstacionamento() {
		this.vectorRegistos = new RegistoDeCarro[MAX_REGISTOS];
		this.index = 0;
	}

	// GETTERS and SETTERS
	/** GET TOTAL OF CARS PARKED */
	public int getIndex() {
		return index;
	}

	// METHODS
	/** GET CAR REGISTERED */
	public RegistoDeCarro getRegisto(String matricula) {

		RegistoDeCarro registo = null;
		for (int i = 0; i < index; i++) {
			if (vectorRegistos[i].getMatricula().equals(matricula))
				registo = vectorRegistos[i];
		}
		return registo;
	}

	/** ADD CARS (pode comprar ate 10 entradas...) */
	public void adicionarRegisto(String matricula) {
		RegistoDeCarro registoExistente = getRegisto(matricula);

		// AVOID REGISTER AN EXISTING CAR ALREADY
		if (registoExistente == null) {
			RegistoDeCarro novoRegisto = new RegistoDeCarro(matricula);
			vectorRegistos[index] = novoRegisto;
			index++;
		}
	}

	/** LOAD MORE ENTRANCES TO TICKET */
	public void carregarEntradas(String matricula, int numeroDeEntrada) {
		RegistoDeCarro registoExistente = getRegisto(matricula);

		if (registoExistente != null) {
			int entradas = Math.min(MAX_ENTRADAS, registoExistente.getNumeroDeEntradas() + numeroDeEntrada);
			registoExistente.setNumeroDeEntradas(entradas);
		}
	}

	/** CAR ATTEMPTED TO ENTER */
	public String tentativaDeEntrada(String matricula) {
		RegistoDeCarro registoExistente = getRegisto(matricula);
		
		//03 CASES POSSIBLE
		if (registoExistente == null) {
				return "ERROR: NAO EXISTE NENHUM REGISTO DA MATRICULA [" + matricula + "]";
		} else {
			if(registoExistente.getNumeroDeEntradas() == 0) {
				return "ERROR: O CARRO [" + matricula + "] NAO TEM ENTRADAS PAGAS";
			}
			else {
				registoExistente.registarEntrada();
				return "O CARRO COM MATRICULA [" + matricula + "] ENTROU NO PARQUE";
			}
		}
	}
	
	//toSTRING
	@Override
	public String toString() {
		String s = "";
		
		for (int i = 0; i < index; i++) {
			s += vectorRegistos[i].getMatricula() + "\n";
		}
		
		return s;
	}
}

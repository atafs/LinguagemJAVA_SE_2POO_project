package pt.iscte.poo.instalacao.aparelhos;

public class MicroOndas extends AparelhoPotenciaVariavel {

	// CONSTRUCTOR
	public MicroOndas(String name, int id) {
		super(name, id);
	}
	
	public MicroOndas(String name, double id) {
		super(name, id);
	}

	// TOSTRING
	@Override
	public String toString() {
		return super.toString();
	}
	
	@Override
	public double potenciaMaxima() {
		return super.getPotenciaMaxima();
	}

	@Override
	public double potenciaAtual() {
		return 0;
	}

}

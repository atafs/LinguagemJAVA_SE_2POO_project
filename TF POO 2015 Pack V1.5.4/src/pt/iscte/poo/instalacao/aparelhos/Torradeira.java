package pt.iscte.poo.instalacao.aparelhos;

public class Torradeira extends AparelhoPotenciaFixa{
	
	//CONSTRUCTOR
	public Torradeira(String name, int id) {
		super(name, id);
	}

	//TOSTRING
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
		return super.getPotenciaActual();
	}

}

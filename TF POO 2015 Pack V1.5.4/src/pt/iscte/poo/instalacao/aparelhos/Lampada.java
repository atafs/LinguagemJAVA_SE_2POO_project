package pt.iscte.poo.instalacao.aparelhos;

public class Lampada extends AparelhoPotenciaFixa{

	//CONSTRUCTOR
	public Lampada(String nome, double potenciaMaxima) {
		super(nome, potenciaMaxima);
	}
	
	//GETTERS AND SETTERS
	public String getId() {
		return super.getNome();
	}

}

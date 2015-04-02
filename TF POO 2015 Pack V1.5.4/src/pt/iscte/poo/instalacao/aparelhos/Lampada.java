package pt.iscte.poo.instalacao.aparelhos;

import pt.iscte.poo.instalacao.Tomada;
import pt.iscte.poo.instalacao.enums.AparelhoEstado;

public class Lampada extends AparelhoPotenciaFixa{

	//CONSTRUCTOR
	/** */
	public Lampada(String nome, double potenciaMaxima, AparelhoEstado estadoAparelho, Tomada tomada) {
		super(nome, potenciaMaxima, estadoAparelho, tomada);
	}

	//USED BY THE JUnit
	public Lampada(String nome, int potenciaMaxima) {
		super(nome, potenciaMaxima);
	}
	
	public Lampada(String nome, double potenciaMaxima) {
		super(nome, potenciaMaxima);
	}
	
	//TOSTRING
	@Override
	public String toString() {
		return super.toString();
	}

	//JUnit METHODS
	/** */
	public double potenciaMaxima() {
		return super.getPotenciaMaxima();
	}
	
	//PotenciaActual == PotenciaMaxima (AparelhoPotenciaFixa)
	public double potenciaAtual() {
		if (super.getEstadoAparelho() == AparelhoEstado.ON) {
			super.setPotenciaActual(super.getPotenciaMaxima());
		}
		return super.getPotenciaActual();
	}

	//GETTERS AND SETTERS
	public String getId() {
		return super.getNome();
	}

}

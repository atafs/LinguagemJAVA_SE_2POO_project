package pt.iscte.poo.instalacao.aparelhos;

import pt.iscte.poo.instalacao.Aparelho;
import pt.iscte.poo.instalacao.Tomada;
import pt.iscte.poo.instalacao.enums.AparelhoEstado;

public abstract class AparelhoPotenciaFixa extends Aparelho{

	//CONSTRUCTORS
	public AparelhoPotenciaFixa(String nome, double potenciaMaxima, AparelhoEstado estadoAparelho, Tomada tomada) {
		super(nome,potenciaMaxima, estadoAparelho, tomada);
	}
	
	public AparelhoPotenciaFixa(String nome, double potenciaMaxima) {
		super(nome, potenciaMaxima);
	}
	
	
}

package pt.iscte.poo.instalacao.aparelhos;

import pt.iscte.poo.instalacao.Aparelho;
import pt.iscte.poo.instalacao.Tomada;
import pt.iscte.poo.instalacao.enums.AparelhoEstado;
import pt.iscte.poo.instalacao.interfaces.Variavel;

public abstract class AparelhoPotenciaVariavel extends Aparelho {

	//CONSTRUCTOR
	public AparelhoPotenciaVariavel(String nome, double potenciaMaxima, AparelhoEstado estadoAparelho, Tomada tomada) {
		super(nome, potenciaMaxima, estadoAparelho, tomada);
	}
	
	public AparelhoPotenciaVariavel(String nome,  double potenciaMaxima) {
		super(nome, potenciaMaxima);
	}

}

package pt.iscte.poo.instalacao.aparelhos;

import pt.iscte.poo.instalacao.Aparelho;
import pt.iscte.poo.instalacao.enums.AparelhoEstado;
import pt.iscte.poo.instalacao.enums.NovoAparelho_Potencia;

public abstract class AparelhoPotenciaFixa extends Aparelho{

	//CONSTRUCTOR
	public AparelhoPotenciaFixa(String nome, double potenciaMaxima) {
		super(nome, potenciaMaxima);
		super.setPotenciaAparelho(NovoAparelho_Potencia.POTENCIA_MAXIMA);
	}

	@Override
	public double potenciaAtual() {
		if (super.getEstadoAparelho() == AparelhoEstado.LIGA) {
			super.setPotenciaActual(super.potenciaMaxima());
		}
		return super.potenciaActual();
	}
	
	
}

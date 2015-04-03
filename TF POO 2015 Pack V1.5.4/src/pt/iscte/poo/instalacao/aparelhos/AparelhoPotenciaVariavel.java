package pt.iscte.poo.instalacao.aparelhos;

import pt.iscte.poo.instalacao.Aparelho;
import pt.iscte.poo.instalacao.enums.NovoAparelho_Potencia;

public abstract class AparelhoPotenciaVariavel extends Aparelho {

	//CONSTRUCTOR
	public AparelhoPotenciaVariavel(String nome,  double potenciaMaxima) {
		super(nome, potenciaMaxima);
		//ALWAYS START WITH ZERO POWER
		super.setPotenciaActual(0.0);
		super.setPotenciaAparelho(NovoAparelho_Potencia.POTENCIA);
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

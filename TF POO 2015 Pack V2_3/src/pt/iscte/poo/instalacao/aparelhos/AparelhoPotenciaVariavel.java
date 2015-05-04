package pt.iscte.poo.instalacao.aparelhos;

import org.json.simple.JSONObject;

import pt.iscte.poo.instalacao.Aparelho;
import pt.iscte.poo.instalacao.enums.Ligavel_Potencia;

public abstract class AparelhoPotenciaVariavel extends Aparelho {

	//CONSTRUCTOR
	public AparelhoPotenciaVariavel(String nome,  double potenciaMaxima) {
		super(nome, potenciaMaxima);
		//ALWAYS START WITH ZERO POWER
		super.setPotenciaActual(0.0);
		super.setPotenciaAparelho(Ligavel_Potencia.POTENCIA);
	}
	
	//OVERLOAD
	public AparelhoPotenciaVariavel(JSONObject obj) {
		super((String)obj.get("id"), (double)obj.get("potencia"));
		super.setPotenciaAparelho(Ligavel_Potencia.POTENCIA);
	}

	@Override
	public double potenciaAtual() {
		return 0;
	}

}

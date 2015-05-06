package pt.iscte.poo.instalacao.aparelhos;

import org.json.simple.JSONObject;

import pt.iscte.poo.instalacao.Aparelho;
import pt.iscte.poo.instalacao.enums.LigavelEstado;
import pt.iscte.poo.instalacao.enums.Ligavel_Potencia;
import pt.iscte.poo.instalacao.enums.Ligavel_Tipo;

public abstract class AparelhoPotenciaVariavel extends Aparelho {

	//CONSTRUCTOR
	public AparelhoPotenciaVariavel(String nome,  double potenciaMaxima) {
		super(nome, potenciaMaxima);
		//ALWAYS START WITH ZERO POWER
		super.setPotenciaActual(0.0);
		super.setPotenciaAparelho(Ligavel_Potencia.POTENCIA);
	}
	
	public AparelhoPotenciaVariavel(String nome, double potencia, double potenciaActual, LigavelEstado estadoAparelho, Ligavel_Tipo tipoAparelho, Ligavel_Potencia potenciaAparelho, long tempoInicio, long tempoFim) {
		super(nome, potencia, potenciaActual, estadoAparelho, tipoAparelho, potenciaAparelho, tempoInicio, tempoFim);
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

package pt.iscte.poo.instalacao.aparelhos;

import org.json.simple.JSONObject;

import pt.iscte.poo.instalacao.Aparelho;
import pt.iscte.poo.instalacao.enums.LigavelEstado;
import pt.iscte.poo.instalacao.enums.Ligavel_Potencia;
import pt.iscte.poo.instalacao.enums.Ligavel_Tipo;

public abstract class AparelhoPotenciaFixa extends Aparelho{

	//CONSTRUCTOR
	public AparelhoPotenciaFixa(String nome, double potenciaMaxima) {
		super(nome, potenciaMaxima);
		super.setPotenciaAparelho(Ligavel_Potencia.POTENCIA_MAXIMA);
	}
	
	public AparelhoPotenciaFixa(String nome, double potencia, double potenciaActual, LigavelEstado estadoAparelho, Ligavel_Tipo tipoAparelho, Ligavel_Potencia potenciaAparelho) {
		super(nome, potencia, potenciaActual, estadoAparelho, tipoAparelho, potenciaAparelho);
		super.setPotenciaAparelho(Ligavel_Potencia.POTENCIA_MAXIMA);
	}
	
	//OVERLOAD
	public AparelhoPotenciaFixa(JSONObject obj) {
		super((String)obj.get("id"), (double)obj.get("potencia"));
		super.setPotenciaAparelho(Ligavel_Potencia.POTENCIA_MAXIMA);
	}


	@Override
	public double potenciaAtual() {
		if (super.getEstadoAparelho() == LigavelEstado.LIGA) {
			super.setPotenciaActual(super.potenciaMaxima());
		}
		return super.potenciaActual();
	}	
}

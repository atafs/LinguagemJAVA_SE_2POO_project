package pt.iscte.poo.instalacao.aparelhos;

import org.json.simple.JSONObject;

public class Lampada extends AparelhoPotenciaFixa{

	//CONSTRUCTOR
	public Lampada(String nome, double potenciaMaxima) {
		super(nome, potenciaMaxima);
	}
	
	//OVERLOAD
	public Lampada(JSONObject obj) {
		super(obj);
	}
	
}

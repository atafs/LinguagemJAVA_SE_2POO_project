package pt.iscte.poo.instalacao.aparelhos;

import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import pt.iscte.poo.instalacao.aparelhos.maq_lavar.Programa;
import pt.iscte.poo.instalacao.enums.MaqLavarRoupaEstado;

public class MaquinaLavarRoupa extends AparelhoPotenciaVariavel {

	//ATTRIBUTES
	private ArrayList<Programa> programas = new ArrayList<Programa>();
	private Programa programaSelecionado = null;
	private MaqLavarRoupaEstado estado;
	
	
	
	//CONSTRUCTOR
	public MaquinaLavarRoupa(String nome, double potenciaMaxima) {
		super(nome, potenciaMaxima);
	}
	
	public MaquinaLavarRoupa(JSONObject obj) {
		super(obj);
		
		JSONArray tempPrograma = (JSONArray) obj.get("programas");
		for (Object o : tempPrograma) {
			JSONObject p = (JSONObject) o;
			programaSelecionado = null/*p.selecionado()*/;
			programas.add(new Programa(p));
			
		}
	}
	
	//METHOD
	public void inicio(String p) {
		//String nome Programa
		//se existir, guardo em Programa
		
		//int tempoInicial
		//Relogio.getInstanciUnica = instanciaActual
		//Ti Tf
		
		
	}
	
	//GETTERS AND SETTERS
	public MaqLavarRoupaEstado getEstado() {
		return estado;
	}

	public void setEstado(MaqLavarRoupaEstado estado) {
		this.estado = estado;
	}

	public ArrayList<Programa> getProgramas() {
		return programas;
	}

	public void setProgramas(ArrayList<Programa> programas) {
		this.programas = programas;
	}

	public Programa getProgramaSelecionado() {
		return programaSelecionado;
	}

	public void setProgramaSelecionado(Programa programaSelecionado) {
		this.programaSelecionado = programaSelecionado;
	}
	

}

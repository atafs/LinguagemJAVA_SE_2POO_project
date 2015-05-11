package pt.iscte.poo.instalacao.aparelhos.maq_lavar;

import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import pt.iscte.poo.instalacao.Relogio;

/** DAO */
public class Programa {
	
	//ATTRIBUTES
	private String id;
	private Ciclo selecionado;
	private ArrayList<Ciclo> ciclos;
	
	// GUARDAR TEMPOS DE INICIO E FIM
	private long tempoInicio = 0;
	private long tempoFim = 0;
	
	//CONSTRUCTOR
	public Programa(String id, Ciclo selecionado) {
		this.id = id;
		this.selecionado = selecionado;
		ciclos = new ArrayList<Ciclo>();
	}
	
	public Programa(JSONObject obj) {
		id = (String)obj.get("id");
		JSONArray tempCiclos = (JSONArray) obj.get("Ciclos");
		
		for (Object o : tempCiclos) {
			JSONObject p = (JSONObject) o;
			ciclos.add(new Ciclo(obj));		
		}
	}

	//GETTERS AND SETTERS
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public Ciclo getCiclo() {
		return selecionado;
	}
	
	public void setCiclo(Ciclo selecionado) {
		this.selecionado = selecionado;
	}
	
	public long getTempoFim() {
		return tempoFim;
	}

	public void setTempoFim(long tempoFim) {
		this.tempoFim = tempoFim;
	}

	public long getTempoInicio() {
		return tempoInicio;
	}

	public void setTempoInicio(long tempoInicio) {
		this.tempoInicio = tempoInicio;
	}

	/*
	 * 				ligavel2.setTempoInicio(Relogio.getInstanciaUnica().getCounter());
					long fimContador = Relogio.getInstanciaUnica().getCounter() + evento1.getTempo();
					ligavel2.setTempoFim(fimContador);
	 * */
	
}

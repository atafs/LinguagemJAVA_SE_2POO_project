package pt.iscte.poo.instalacao.aparelhos.maq_lavar;

import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

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
		JSONArray tempCiclos = (JSONArray) obj.get("ciclos");
		
		for (Object o : tempCiclos) {
			JSONObject p = (JSONObject) o;
			ciclos.add(new Ciclo((p)));		
		}
	}
	
	// TOSTRING
	@Override
	public String toString() {
		String toReturn = "";
		toReturn += "\n-> ID: " + this.id;
		toReturn += "\n-> CICLO SELECIONADO: " + this.selecionado;
		toReturn += "\n-> ArrayList<Ciclo>: " + this.ciclos;
		toReturn += "\n-> TEMPO_INICIAL: " + this.tempoInicio;
		toReturn += "\n-> TEMPO_FINAL: " + 	this.tempoFim;
		toReturn += "\n";
		return toReturn;
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

}

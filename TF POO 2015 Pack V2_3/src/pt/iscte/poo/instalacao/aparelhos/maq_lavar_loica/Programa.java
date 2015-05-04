package pt.iscte.poo.instalacao.aparelhos.maq_lavar_loica;

import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

/** DAO */
public class Programa {
	
	//ATTRIBUTES
	private String id;
	private Ciclo selecionado;
	private ArrayList<Ciclo> ciclos;
	
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

}

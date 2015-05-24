package pt.iscte.poo.instalacao.aparelhos.maq_lavar;

import java.util.ArrayList;

/** DAO */
public class Programa {
	
	//ATTRIBUTES
	private String id;
	private Ciclo selecionado;
	private ArrayList<Ciclo> ciclos;
	
	// GUARDAR TEMPOS DE INICIO E FIM
	private long tempoInicio = 0;
	//private long tempoFim = 0;
	
	//CONSTRUCTOR
	public Programa(String id) {
		this.id = id;
		ciclos = new ArrayList<Ciclo>();
	}
	
	// TOSTRING
	@Override
	public String toString() {
		String toReturn = "";
		toReturn += "\n-> ID: " + this.id;
		toReturn += "\n-> CICLO SELECIONADO: " + this.selecionado;
		for (Ciclo ciclo : ciclos) {
			toReturn += "\n-> Ciclo: " + ciclo;
		}
		toReturn += "\n-> TEMPO_INICIAL: " + this.tempoInicio;
		//toReturn += "\n-> TEMPO_FINAL: " + 	this.tempoFim;
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
	
	public Ciclo programa() {
		return selecionado;
	}
	
	public void setCiclo(Ciclo selecionado) {
		this.selecionado = selecionado;
	}
	
//	public long getTempoFim() {
//		return tempoFim;
//	}
//
//	public void setTempoFim(long tempoFim) {
//		this.tempoFim = tempoFim;
//	}

	public long getTempoInicio() {
		return tempoInicio;
	}

	public void setTempoInicio(long tempoInicio) {
		this.tempoInicio = tempoInicio;
	}

	public Ciclo getSelecionado() {
		return selecionado;
	}

	public void setSelecionado(Ciclo selecionado) {
		this.selecionado = selecionado;
	}

	public ArrayList<Ciclo> getCiclos() {
		return ciclos;
	}

	public void setCiclos(ArrayList<Ciclo> ciclos) {
		this.ciclos = ciclos;
	}

}

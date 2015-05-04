package pt.iscte.poo.instalacao.aparelhos.maq_lavar_loica;

import org.json.simple.JSONObject;

/** DAO */
public class Ciclo {
	
	//ATTRIBUTES
	private int duracao;
	private double potencia;
	
	//CONSTRUCTOR
	public Ciclo(int duracao, double potencia) {
		this.duracao = duracao;
		this.potencia = potencia;
	}
	
	public Ciclo(JSONObject obj) {
		//...
	}

	//GETTERS AND SETTERS
	public int getDuracao() {
		return duracao;
	}
	public void setDuracao(int duracao) {
		this.duracao = duracao;
	}
	public double getPotencia() {
		return potencia;
	}
	public void setPotencia(double potencia) {
		this.potencia = potencia;
	}

}

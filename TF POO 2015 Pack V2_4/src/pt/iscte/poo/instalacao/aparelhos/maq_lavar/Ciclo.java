package pt.iscte.poo.instalacao.aparelhos.maq_lavar;

import org.json.simple.JSONObject;

/** DAO */
public class Ciclo {
	
	//ATTRIBUTES
	private long duracao;
	private double potencia;
	
	//CONSTRUCTOR
	public Ciclo(int duracao, double potencia) {
		this.duracao = duracao;
		this.potencia = potencia;
	}
	
	public Ciclo(JSONObject obj) {
		long duracao = (long)obj.get("duracao");
		double potencia = (double)(long)obj.get("potencia");
		
		this.duracao = duracao;
		this.potencia = potencia;
		
	}
	
	// TOSTRING
	@Override
	public String toString() {
		String toReturn = "";
		toReturn += "\n-> DURACAO: " + this.duracao;
		toReturn += "\n-> POTENCIA: " + this.potencia;
		toReturn += "\n";
		return toReturn;
	}

	//GETTERS AND SETTERS
	public long getDuracao() {
		return duracao;
	}
	public void setDuracao(long duracao) {
		this.duracao = duracao;
	}
	public double getPotencia() {
		return potencia;
	}
	public void setPotencia(double potencia) {
		this.potencia = potencia;
	}

}

package pt.iscte.poo.instalacao.eventos;

import pt.iscte.poo.instalacao.enums.AparelhoEstado;;

public abstract class Evento {
	
	//ATTRIBUTES
	private String accao;
	private String idAparelho;
	private long tempo;
	private AparelhoEstado estado = AparelhoEstado.STAND_BY;
	
	//CONSTRUCTOR
	public Evento(String accao, String idAparelho, long tempo) {
		this.accao = accao;
		this.idAparelho = idAparelho;
		this.tempo = tempo;
	}
	
	// TOSTRING
	@Override
	public String toString() {
		String toReturn = ""/* super.toString() */;
		toReturn += "accao: " + this.accao;
		toReturn += "\n-> idAparelho: " + idAparelho;
		toReturn += "\n-> tempo: " + tempo;
		toReturn += "\n-> estado: " + estado;
		toReturn += "\n";
		return toReturn;
	}
	
	//METHOD
	public void executa() {
		//...
	}
	
	//GETTERS AND SETTERS
	public String getAccao() {
		return accao;
	}

	public void setAccao(String accao) {
		this.accao = accao;
	}

	public String getIdAparelho() {
		return idAparelho;
	}

	public void setIdAparelho(String idAparelho) {
		this.idAparelho = idAparelho;
	}

	public long getTempo() {
		return tempo;
	}

	public void setTempo(long tempo) {
		this.tempo = tempo;
	}
	
	public AparelhoEstado getEstado() {
		return estado;
	}

	public void setEstado(AparelhoEstado liga) {
		this.estado = liga;
	}
	
}

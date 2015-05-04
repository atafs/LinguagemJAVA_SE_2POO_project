package pt.iscte.poo.instalacao.ligacoes;

public class Ligacao {
	
	//ATTRIBUTES
	private String aparelho;
	private String ligadoA;
	
	//CONSTRUCTOR
	public Ligacao(String aparelho, String ligadoA) {
		this.aparelho = aparelho;
		this.ligadoA = ligadoA;
	}

	public String getAparelho() {
		return aparelho;
	}

	public void setAparelho(String aparelho) {
		this.aparelho = aparelho;
	}
	
	// TOSTRING
	@Override
	public String toString() {
		String toReturn = "";
		toReturn += "aparelho: " + this.aparelho;
		toReturn += "\n-> ligadoA: " + ligadoA;
		toReturn += "\n";
		return toReturn;
	}

	//GETTERS AND SETTERS
	public String getLigadoA() {
		return ligadoA;
	}

	public void setLigadoA(String ligadoA) {
		this.ligadoA = ligadoA;
	}
	


}

package pt.iscte.poo.instalacao.ligacoes;

public class Ligacao {
	
	//ATTRIBUTES
	private String id;
	private String ligadoA;
	
	//CONSTRUCTOR
	public Ligacao(String aparelho, String ligadoA) {
		this.id = aparelho;
		this.ligadoA = ligadoA;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	// TOSTRING
	@Override
	public String toString() {
		String toReturn = "";
		toReturn += "aparelho: " + this.id;
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

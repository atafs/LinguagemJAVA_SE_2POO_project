package pt.iscte.poo.instalacao.eventos;

import pt.iscte.poo.instalacao.aparelhos.maq_lavar.Programa;

public class EventoPrograma extends Evento{

	//ATTRIBUTE EXTRA
	private String id;
	private Programa programa;
	
	//CONSTRUCTOR
	public EventoPrograma(String accao, String idAparelho, long tempo, String programa) {
		super(accao, idAparelho, tempo);
		this.id = programa;
		
		//TO DELETE
		startProgram();
	}
	
	// TOSTRING
	@Override
	public String toString() {
		String toReturn = "" + super.toString();
		toReturn += "-> programa: " + id;
		toReturn += "\n";
		return toReturn;
	}

	//GETTERS AND SETTERS
	public String getPrograma() {
		return id;
	}

	public void setPrograma(String programa) {
		this.id = programa;
	}
	
	//OTHER METHODS
	public void startProgram() {
		programa = new Programa(id, null);
		System.err.println(programa.toString());
	}
	

	
}

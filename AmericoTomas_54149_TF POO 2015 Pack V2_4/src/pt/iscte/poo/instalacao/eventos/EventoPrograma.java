package pt.iscte.poo.instalacao.eventos;

public class EventoPrograma extends Evento{

	//ATTRIBUTE EXTRA
	private String id;
	private String programa;
	
	//CONSTRUCTOR
	public EventoPrograma(String accao, String idAparelho, long tempo, String programa) {
		super(accao, idAparelho, tempo);
		this.programa = programa;
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
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPrograma() {
		return programa;
	}

	public void setPrograma(String programa) {
		this.programa = programa;
	}

	

}

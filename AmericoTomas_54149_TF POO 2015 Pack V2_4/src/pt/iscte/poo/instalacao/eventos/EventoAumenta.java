package pt.iscte.poo.instalacao.eventos;

public class EventoAumenta extends Evento{

	//ATTRIBUTE EXTRA
	private double aumenta;
	
	//CONSTRUCTOR
	public EventoAumenta(String accao, String idAparelho, long tempo, double aumenta) {
		super(accao, idAparelho, tempo);
		this.aumenta = aumenta;
	}
	
	// TOSTRING
	@Override
	public String toString() {
		String toReturn = "" + super.toString();
		toReturn += "-> aumenta: " + aumenta;
		toReturn += "\n";
		return toReturn;
	}

	//GETTERS AND SETTERS
	public double getAumenta() {
		return aumenta;
	}

	public void setValor(double valor) {
		this.aumenta = valor;
	}
}

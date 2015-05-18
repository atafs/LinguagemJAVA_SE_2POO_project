/** 
 * americoLIB concept 
 * @author Americo Tomas (atafs): 15/03/2015 
*/

package pt.iscte.poo.instalacao.enums;

import org.json.simple.JSONObject;

import pt.iscte.poo.instalacao.aparelhos.maq_lavar.Programa;
import pt.iscte.poo.instalacao.eventos.Evento;
import pt.iscte.poo.instalacao.eventos.EventoAumenta;
import pt.iscte.poo.instalacao.eventos.EventoDesliga;
import pt.iscte.poo.instalacao.eventos.EventoLiga;
import pt.iscte.poo.instalacao.eventos.EventoPrograma;

public enum LigavelEstado {
	
	//STATUS
	/** INSERT DIFERENT STATES IN THE DEVICES
	 * LIGA = is consuming energy
	 * AUMENTA = the power s increased
	 * PROGRAMA: it will run a washing machine program (with several states and powers associated)
	 * EM_ESPERA = is plugged in but no consuming
	 * DESLIGA = is not plugged in */
	LIGA("LIGA"), AUMENTA("AUMENTA"), PROGRAMA("PROGRAMA"), EM_ESPERA("ESPERA"), DESLIGA("DESLIGA");
	
	// ATTRIBUTES
	private String text;

	// CONSTRUCTOR
	private LigavelEstado(String text) {
		this.text = text;
	}

	// TOSTRING
	@Override
	public String toString() {
		String toReturn = "";
		toReturn += text;
		return toReturn;
	}
	
	// STATIC METHOD (from the class, not the instance)
	/** Seleccao do novo evento */
	public static Evento guardaEventos(JSONObject obj) {

		//JSONObject attributes
		String accao = (String) obj.get("accao");
		String idAparelho = (String) obj.get("idAparelho");	
		long tempo = (long) obj.get("tempo");
			
		// .toUpperCase() lets you select type and still match
		String tipoUpperCase = accao.toUpperCase();
		try {
			// Enum.valueOf() throws an exception if the input is not valid
			LigavelEstado estado = LigavelEstado.valueOf(tipoUpperCase);

			switch (estado) {
			case LIGA:
				EventoLiga eventoLiga = new EventoLiga(accao, idAparelho,tempo);	
				eventoLiga.setEstado(LigavelEstado.LIGA);
				return eventoLiga;
	
			case AUMENTA:
				EventoAumenta eventoAumenta = new EventoAumenta(accao, idAparelho, tempo, (double) obj.get("valor"));	
				eventoAumenta.setEstado(LigavelEstado.AUMENTA);
				return eventoAumenta;
				
			case PROGRAMA:
				EventoPrograma eventoPrograma = new EventoPrograma(accao, idAparelho, tempo, (String) obj.get("programa"));	
				eventoPrograma.setEstado(LigavelEstado.PROGRAMA);
				return eventoPrograma;
				
			case DESLIGA:
				EventoDesliga eventoDesliga = new EventoDesliga(accao, idAparelho,tempo);	
				eventoDesliga.setEstado(LigavelEstado.DESLIGA);
				return eventoDesliga;
				
			case EM_ESPERA:
				System.err.print("EVENTO EM ESPERA...");
				return null;
			}
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		}
		return null;
	}
	


}

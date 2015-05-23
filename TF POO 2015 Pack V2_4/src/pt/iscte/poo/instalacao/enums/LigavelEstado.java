/** 
 * americoLIB concept 
 * @author Americo Tomas (atafs): 15/03/2015 
*/

package pt.iscte.poo.instalacao.enums;

import java.util.List;

import org.json.simple.JSONObject;

import pt.iscte.poo.instalacao.Aparelho;
import pt.iscte.poo.instalacao.Ligavel;
import pt.iscte.poo.instalacao.Relogio;
import pt.iscte.poo.instalacao.aparelhos.MaquinaLavarRoupa;
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

	public static void selecionaNovoEvento(Evento evento1, List<Ligavel> ligaveis) {

		// PERCORRER A LISTA DE LIGAVEIS
		for (Ligavel ligavel2 : ligaveis) {

			// EXISTIR O TEMPO IGUAL TEMPO ACTUAL
			if (Relogio.getInstanciaUnica().getTempoAtual() == (int) evento1
					.getTempo()) {

				// EXISTIR NA LISTA DE EVENTOS O LIGAVEL
				if (ligavel2.getId().equals(evento1.getIdAparelho())) {

					// MUDAR ESTADO LIGAVEL E TEMPOS INICIO E FIM
					ligavel2.setEstadoAparelho(evento1.getEstado());

					// TO DELETE
					try {
						Thread.sleep(250);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

					// local variables
					Aparelho aparelho = null;
					MaquinaLavarRoupa maquinaLavarRoupa = null;
					Ligavel ligavelTemp = null;

					// ADICIONA STRING COM O PROGRAMA SE A ACCAO FOR PROGRAMA
					if (evento1.getIdAparelho().equals(Ligavel_Tipo.MAQLAVARROUPA.toString())
							&& evento1.getAccao().equals(LigavelEstado.PROGRAMA.toString())) {

						// ligavelTemp = ligavel2;
						aparelho = (Aparelho) ligavel2;
						// ligaveis.remove(ligavel2);
						maquinaLavarRoupa = (MaquinaLavarRoupa) aparelho;
						EventoPrograma eventoPrograma = (EventoPrograma) evento1;
						maquinaLavarRoupa.setProgramaSelecionado(eventoPrograma.getPrograma());
						maquinaLavarRoupa.setEstadoAparelho(LigavelEstado.LIGA);

						// ligaveis.add((Ligavel)maquinaLavarRoupa);
					}

					// LIGA MAQUINA LAVAR ROUPA COLOCANDO O TEMPO NUMA VARIAVEL
					if (evento1.getIdAparelho().equals(Ligavel_Tipo.MAQLAVARROUPA.toString())
							&& evento1.getAccao().equals(LigavelEstado.LIGA.toString())) {

						// ligavelTemp = ligavel2;
						aparelho = (Aparelho) ligavel2;
						// ligaveis.remove(ligavel2);
						maquinaLavarRoupa = (MaquinaLavarRoupa) aparelho;

						// TO DELETE
						System.err.println("I AM HERE");

						for (Programa programa : maquinaLavarRoupa.getProgramas()) {
							if (programa.getId().equals(
								maquinaLavarRoupa.getProgramaSelecionado())) {
								programa.setTempoInicio(evento1.getTempo());
							}
						}
						maquinaLavarRoupa.setPotenciaActual(maquinaLavarRoupa.potenciaActualMaquina());
						// ligaveis.add((Ligavel)maquinaLavarRoupa);
					}

					// AUMENTA VALOR DO APARELHO
					if (evento1.getAccao().equals(LigavelEstado.AUMENTA.toString())) {
						
						aparelho = (Aparelho) ligavel2;
						EventoAumenta eventoAumenta = (EventoAumenta) evento1;
						aparelho.aumenta((int) eventoAumenta.getAumenta());
						
						//MANTER LIGADO O MESMO APOS AUMENTAR
						aparelho.setEstadoAparelho(LigavelEstado.LIGA);
						// VOLTA A COLOCAR NA LISTA
						ligavel2 = (Ligavel) aparelho;
					}
					// EXIT LOOP
					break;
				}
			}

			// EXIT: SE O TEMPO DO EVENTO FOR MAIOR QUE O TEMPO ACTUAL, INTERROMPE O METODO
			else if (Relogio.getInstanciaUnica().getTempoAtual() < (int) evento1.getTempo()) {
				return;
			}

			// EXIT: SE O TEMPO ACTUAL FOR MAIOR QUE O EVENTO, INTERROMPE O CICLO
			else if (Relogio.getInstanciaUnica().getTempoAtual() > (int) evento1.getTempo()) {
				break;
			}
		}
	}


}

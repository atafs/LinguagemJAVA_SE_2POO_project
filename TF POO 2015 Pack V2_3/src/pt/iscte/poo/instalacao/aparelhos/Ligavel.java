/** 
 * americoLIB concept 
 * @author Americo Tomas (atafs): 22/03/2015 
*/

package pt.iscte.poo.instalacao.aparelhos;

import pt.iscte.poo.instalacao.Tomada;
import pt.iscte.poo.instalacao.enums.LigavelEstado;
import pt.iscte.poo.instalacao.enums.Ligavel_Potencia;

public interface Ligavel {
	
	/** */
	public void liga();

	/** */
	public void desliga();
	
	/** */
	public boolean estaLigado();
	
	//CLASS INSTALACAO
	/** */
	public String getId();
	
	/** */
	public void setEstadoAparelho(LigavelEstado estadoAparelho);
	
	/** */
	public void setTomada(Tomada tomada);
	
	//CLASS TOMADA
	/** */
	public double potenciaMaxima();
	
	/** */
	public double potenciaActual();
	
	/** */
	public Ligavel_Potencia getPotenciaAparelho();
	
	//
	/** */
	public String toString();
	
	/** */
	public long getTempoInicio();
	public void setTempoInicio(long tempo);
	
	public long getTempoFim();
	public void setTempoFim(long tempo);
	


	
}
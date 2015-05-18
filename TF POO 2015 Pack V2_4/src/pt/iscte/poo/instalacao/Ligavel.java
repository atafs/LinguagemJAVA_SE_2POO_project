/** 
 * americoLIB concept 
 * @author Americo Tomas (atafs): 22/03/2015 
*/

package pt.iscte.poo.instalacao;

import pt.iscte.poo.instalacao.enums.LigavelEstado;
import pt.iscte.poo.instalacao.enums.Ligavel_Potencia;
import pt.iscte.poo.instalacao.enums.Ligavel_Tipo;

public interface Ligavel {
	
	/** */
	public void liga();

	/** */
	public void desliga();
	
	/** */
	public boolean estaLigado();

	//GETTERS AND SETTERS
	/** */
	public String toString();
	
	public String getId();

	public void setNome(String nome);

	public double potenciaMaxima();

	public void setPotenciaMaxima(double potenciaMaxima);

	public LigavelEstado getEstadoAparelho();

	public void setEstadoAparelho(LigavelEstado estadoAparelho);

//	public Tomada getTomada();
//
//	public void setTomada(Tomada tomada);


	public double potenciaActual();

	public void setPotenciaActual(double potenciaActual);

	public Ligavel_Tipo getTipoAparelho();

	public void setTipoAparelho(Ligavel_Tipo tipoAparelho);

	public Ligavel_Potencia getPotenciaAparelho();

	public void setPotenciaAparelho(Ligavel_Potencia potenciaAparelho);

}
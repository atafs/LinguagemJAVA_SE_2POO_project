/** 
 * americoLIB concept 
 * @author Americo Tomas (atafs): 15/03/2015 
*/

package pt.iscte.poo.instalacao.enums;

public enum AparelhoEstado {
	
	//STATUS
	/** INSERT DIFERENT STATES IN THE DEVICES
	 * LIGA = is consuming energy
	 * AUMENTA = the power s increased
	 * PROGRAMA: it will run a washing machine program (with several states and powers associated)
	 * EM_ESPERA = is plugged in but no consuming
	 * DESLIGA = is not plugged in */
	LIGA, AUMENTA, PROGRAMA, EM_ESPERA, DESLIGA

}

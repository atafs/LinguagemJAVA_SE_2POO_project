/** 
 * americoLIB concept 
 * @author Americo Tomas (atafs): 22/03/2015 
*/

package pt.iscte.poo.instalacao.aparelhos;
import pt.iscte.poo.instalacao.Tomada;
import pt.iscte.poo.instalacao.enums.AparelhoEstado;

public class Computador extends AparelhoPotenciaFixa{

	public Computador(String nome, double potenciaMaxima, AparelhoEstado estadoAparelho, Tomada tomada) {
		super(nome,potenciaMaxima, estadoAparelho, tomada);
	}
	
	public Computador(String nome, double potencia) {
		super(nome, potencia);	
	}

	@Override
	public double potenciaMaxima() {
		return super.getPotenciaMaxima();
	}

	@Override
	public double potenciaAtual() {
		return super.getPotenciaActual();
	}
}

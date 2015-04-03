package pt.iscte.poo.instalacao;

import java.util.ArrayList;

import pt.iscte.poo.instalacao.enums.LinhaTomadaEstado;
import pt.iscte.poo.instalacao.enums.NovoAparelho_Potencia;

public class Tomada {

	// ATTRIBUTES
	private String nome;
	private LinhaTomadaEstado estadoLinha;
	private ArrayList<Aparelho> listaAparelhos = new ArrayList<Aparelho>();
	

	// CONSTRUCTOR
	public Tomada(String nome, LinhaTomadaEstado estadoLinha, ArrayList<Aparelho> listaAparelhos) {
		this.nome = nome;
		this.listaAparelhos = listaAparelhos;
		this.estadoLinha = estadoLinha;
	}

	public Tomada() {
		this("", LinhaTomadaEstado.FREE, new ArrayList<Aparelho>());
	}

	// TOSTRING
	@Override
	public String toString() {
		String toReturn = "";
		for (Aparelho aparelho : listaAparelhos) {
			toReturn = "-> NOME: " + aparelho.getNome() 
					+ " -> POTENCIA: " + aparelho.getPotenciaMaxima() 
					+ " -> ESTADO: " + aparelho.getEstadoAparelho();
		}
		return toReturn;
	}

	// OTHER METHODS
	/**
	 * Procura na lista de aparelhos todos os que tem potencia diferente de zero
	 * e acrescenta a uma variavel da class
	 */
	public double somaPotenciaTomada() {
		//LIMPAR CONTADOR
		double potenciaNaTomada = 0.0;
		for (Aparelho aparelho : listaAparelhos) {
			//APARELHOS POTENCIA FIXA
			if (aparelho.estaLigado() && aparelho.getPotenciaAparelho().equals(NovoAparelho_Potencia.POTENCIA_MAXIMA) ) {
				potenciaNaTomada += aparelho.getPotenciaMaxima();	
			} 
			//APARELHOS POTENCIA VARIAVEL
			else if (aparelho.estaLigado() && aparelho.getPotenciaAparelho().equals(NovoAparelho_Potencia.POTENCIA)) {
				potenciaNaTomada += aparelho.getPotenciaActual();	
			}		
		}
		return potenciaNaTomada;
	}

	// GETTERS AND SETTERS
	public ArrayList<Aparelho> getListaAparelhos() {
		return listaAparelhos;
	}

	public void setListaAparelhos(ArrayList<Aparelho> listaAparelhos) {
		this.listaAparelhos = listaAparelhos;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public LinhaTomadaEstado getEstadoLinha() {
		return estadoLinha;
	}

	public void setEstadoLinha(LinhaTomadaEstado estadoLinha) {
		this.estadoLinha = estadoLinha;
	}
}

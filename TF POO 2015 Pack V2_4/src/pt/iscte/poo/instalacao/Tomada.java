package pt.iscte.poo.instalacao;

import java.util.ArrayList;

import pt.iscte.poo.instalacao.enums.LinhaTomadaEstado;
import pt.iscte.poo.instalacao.enums.Ligavel_Potencia;

public class Tomada {

	// ATTRIBUTES
	private String nome;
	private LinhaTomadaEstado estadoLinha;
	private Ligavel ligavel;
	private Aparelho aparelho;
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
		toReturn += "\n-> LIGAVEL - " + ligavel;
		toReturn += "-> ESTADO: " + estadoLinha + "\n";
		
//		for (Aparelho aparelho : listaAparelhos) {
//			toReturn = "-> NOME: " + aparelho.getId() 
//					+ " -> POTENCIA: " + aparelho.potenciaMaxima() 
//					+ " -> ESTADO: " + aparelho.getEstadoAparelho();
//		}
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
			if (aparelho.estaLigado() && aparelho.getPotenciaAparelho().equals(Ligavel_Potencia.POTENCIA_MAXIMA) ) {
				potenciaNaTomada += aparelho.potenciaMaxima();
			} 
			//APARELHOS POTENCIA VARIAVEL
			else if (aparelho.estaLigado() && aparelho.getPotenciaAparelho().equals(Ligavel_Potencia.POTENCIA)) {
				potenciaNaTomada += aparelho.potenciaActual();		
			}		
		}

		return potenciaNaTomada;
	}
	
	// GETTERS AND SETTERS
	public String getId() {
		return nome;
	}

	public void setId(String nome) {
		this.nome = nome;
	}

	public LinhaTomadaEstado getEstadoLinha() {
		return estadoLinha;
	}

	public void setEstadoLinha(LinhaTomadaEstado estadoLinha) {
		this.estadoLinha = estadoLinha;
	}

	public Ligavel getLigavel() {
		return ligavel;
	}

	public void setLigavel(Ligavel ligavel) {
		this.ligavel = ligavel;
	}

	public Aparelho getAparelho() {
		return aparelho;
	}

	public void setAparelho(Aparelho aparelho) {
		this.aparelho = aparelho;
	}

	public ArrayList<Aparelho> getListaAparelhos() {
		return listaAparelhos;
	}

	public void setListaAparelhos(ArrayList<Aparelho> listaAparelhos) {
		this.listaAparelhos = listaAparelhos;
	}
}

package pt.iscte.poo.instalacao;

import pt.iscte.poo.instalacao.aparelhos.Ligavel;
import pt.iscte.poo.instalacao.enums.LinhaTomadaEstado;
import pt.iscte.poo.instalacao.enums.Ligavel_Potencia;

public class Tomada {

	// ATTRIBUTES
	private String nome;
	private LinhaTomadaEstado estadoLinha;
	private Ligavel ligavel;
	//private ArrayList<Aparelho> listaAparelhos = new ArrayList<Aparelho>();
	

	// CONSTRUCTOR
	public Tomada(String nome, LinhaTomadaEstado estadoLinha, Ligavel ligavel/*ArrayList<Aparelho> listaAparelhos*/) {
		this.nome = nome;
		this.ligavel = ligavel;
		//this.listaAparelhos = listaAparelhos;
		this.estadoLinha = estadoLinha;
	}

	public Tomada() {
		this("", LinhaTomadaEstado.FREE, null/*new ArrayList<Aparelho>()*/);
	}

	// TOSTRING
	@Override
	public String toString() {
		String toReturn = "";
		toReturn += " -> LIGAVEL: " + ligavel;
		toReturn += " -> ESTADO: " + estadoLinha;
		
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
		/*for (Aparelho aparelho : listaAparelhos) {
			//APARELHOS POTENCIA FIXA*/
		if (ligavel.estaLigado() && ligavel.getPotenciaAparelho().equals(Ligavel_Potencia.POTENCIA_MAXIMA)) {
			potenciaNaTomada += ligavel.potenciaMaxima();
		}
		// APARELHOS POTENCIA VARIAVEL
		else if (ligavel.estaLigado()&& ligavel.getPotenciaAparelho().equals(Ligavel_Potencia.POTENCIA)) {
			potenciaNaTomada += ligavel.potenciaActual();
		}		
		//}
		return potenciaNaTomada;
	}

	// GETTERS AND SETTERS
//	public ArrayList<Aparelho> getListaAparelhos() {
//		return listaAparelhos;
//	}
//
//	public void setListaAparelhos(ArrayList<Aparelho> listaAparelhos) {
//		this.listaAparelhos = listaAparelhos;
//	}

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

	public Ligavel getLigavel() {
		return ligavel;
	}

	public void setLigavel(Ligavel ligavel) {
		this.ligavel = ligavel;
	}
}

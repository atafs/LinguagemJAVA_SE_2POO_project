package pt.iscte.poo.instalacao;

import java.util.ArrayList;

import pt.iscte.poo.instalacao.enums.LinhaTomadaEstado;

public class Linha {

	// ATTRIBUTES
	private String nome;
	private LinhaTomadaEstado estadoLinha;
	private ArrayList<Tomada> listaTomadas = new ArrayList<Tomada>();

	// CONSTRUCTOR
	public Linha(String nome) {
		this.nome = nome;
		this.estadoLinha = LinhaTomadaEstado.FREE;
		this.listaTomadas = new ArrayList<Tomada>();
	}

	// TOSTRING
	@Override
	public String toString() {
		String toReturn = "";
		toReturn = "nome: " + nome;
		toReturn = "estadoLinha: " + estadoLinha;
		toReturn = "listaTomadas: " + listaTomadas;
		return toReturn;
	}

	// OTHER METHODS
	/**
	 * DESCRICAO: devolve um double com a soma de todas as linhas e aparelhos
	 * ligados as tomadas. Fazendo a destincao entre aparelhos de potencia fixa
	 * ou variavel, de forma a incrementar o seu valor de potencia maxima ou
	 * potencia actual (respectivamente).
	 */
	public double somaPotenciaLinha() {
		// LIMPAR CONTADOR
		double potenciaNaLinha = 0.0;
		for (Tomada tomada : listaTomadas) {
			potenciaNaLinha += tomada.somaPotenciaTomada();
		}
		return potenciaNaLinha;
	}

	/** Recebe um numero de tomadas inteiro e inicializa as listas desta linha */
	public void instalarTomadas(int numeroTomadas) {
		for (int i = 0; i < numeroTomadas; i++) {
			listaTomadas.add(new Tomada());
		}
	}

	// GETTERS AND SETTERS
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public ArrayList<Tomada> getListaTomadas() {
		return listaTomadas;
	}

	public void setListaTomadas(ArrayList<Tomada> listaTomadas) {
		this.listaTomadas = listaTomadas;
	}

	public LinhaTomadaEstado getEstadoLinha() {
		return estadoLinha;
	}

	public void setEstadoLinha(LinhaTomadaEstado estadoLinha) {
		this.estadoLinha = estadoLinha;
	}
}

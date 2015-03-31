package pt.iscte.poo.instalacao;

import java.util.ArrayList;

import pt.iscte.poo.instalacao.enums.LinhaTomadaEstado;

public class Linha {

	// ATTRIBUTES
	private int id;
	private String nome;
	private LinhaTomadaEstado estadoLinha;
	private ArrayList<Tomada> listaTomadas = new ArrayList<Tomada>();

	// CONSTRUCTOR
	public Linha(String nome, int id, LinhaTomadaEstado estadoLinha, ArrayList<Tomada> listaTomadas) {
		this.nome = nome;
		this.id = id;
		this.listaTomadas = listaTomadas;
		this.estadoLinha = estadoLinha;
	}
	
	public Linha(String nome, int id) {
		this.nome = nome;
		this.id = id;
		this.estadoLinha = LinhaTomadaEstado.FREE;
		this.listaTomadas = new ArrayList<Tomada>();

	}
	
	public Linha(String nome) {
		this.nome = nome;
		this.id = 0;
		this.estadoLinha = LinhaTomadaEstado.FREE;
		this.listaTomadas = new ArrayList<Tomada>();

	}
	
	public Linha() {
		this("", 0, LinhaTomadaEstado.DAMAGED, new ArrayList<Tomada>());
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
	
	//OTHER METHODS
	/**
	 * Procura na lista de tomadas todas as que tem potencia diferente de zero
	 * e acrescenta a uma variavel da class
	 */
	public double somaPotenciaLinha() {
		//LIMPAR CONTADOR
		double potenciaNaLinha = 0.0;
		for (Tomada tomada : listaTomadas) {
			potenciaNaLinha += tomada.somaPotenciaTomada();	
		}
		return potenciaNaLinha;
	}
	
	/** Recebe um numero de tomadas inteiro e inicializa as listas desta linha*/
	public void instalarTomadas(int numeroTomadas) {
		for (int i = 0; i < numeroTomadas; i++) {
			listaTomadas.add(new Tomada());
		}
	}

	// GETTERS AND SETTERS
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

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

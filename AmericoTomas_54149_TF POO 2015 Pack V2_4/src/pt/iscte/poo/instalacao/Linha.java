package pt.iscte.poo.instalacao;

import java.util.ArrayList;

import pt.iscte.poo.instalacao.aparelhos.Tripla;
import pt.iscte.poo.instalacao.enums.LinhaTomadaEstado;

public class Linha {

	// ATTRIBUTES
	private String id;
	private int numeroTomadas;
	private LinhaTomadaEstado estadoLinha;
	private ArrayList<Tomada> listaTomadas = new ArrayList<Tomada>();
	private ArrayList<Tripla> listaTriplas = new ArrayList<Tripla>();

	// CONSTRUCTOR
	public Linha(String id, int nTomadas) {
		this.id = id;
		this.numeroTomadas = nTomadas;
		this.estadoLinha = LinhaTomadaEstado.FREE;
		this.listaTomadas = new ArrayList<Tomada>();
	}

	
	public Linha(String id) {
		this.id = id;
		this.estadoLinha = LinhaTomadaEstado.FREE;
		this.listaTomadas = new ArrayList<Tomada>();
	}

	// TOSTRING
	@Override
	public String toString() {
		String toReturn = "";
		toReturn += "ID: " + id;
		toReturn += ", NumeroTomadas: " + numeroTomadas;
		toReturn += ", EstadoLinha: " + estadoLinha;
		toReturn += ", ListaTomadas: " + listaTomadas;
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
	public void instalarTomadas(long numeroTomadas) {
		for (int i = 0; i < numeroTomadas; i++) {
			listaTomadas.add(new Tomada());
		}
	}
	
	public void instalarTomadas(long numeroTomadas, String id) {
		for (int i = 0; i < numeroTomadas; i++) {
			Tomada tomada = new Tomada();
			tomada.setId(id);
			listaTomadas.add(tomada);
		}
	}

	// GETTERS AND SETTERS
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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
	
	public long getNumeroTomadas() {
		return numeroTomadas;
	}

	public void setNumeroTomadas(int numeroTomadas) {
		this.numeroTomadas = numeroTomadas;
	}
	
	/** */
	//2�parte project
	public void addTripla(Tripla t) {
		listaTriplas.add(t);
		listaTomadas.addAll(t.getListaTomadas());
	}


}

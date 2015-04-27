package pt.iscte.poo.instalacao;

import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import pt.iscte.poo.graficos.Chart;
import pt.iscte.poo.instalacao.aparelhos.Ligavel;
import pt.iscte.poo.instalacao.enums.AparelhoEstado;
import pt.iscte.poo.instalacao.enums.LinhaTomadaEstado;

public class Instalacao {

	// ATTRIBUTES
	private static Instalacao instance = null;
	private ArrayList<Linha> listLinhas;

	// private Aparelho aparelho;

	// CONSTRUCTOR
	private Instalacao(ArrayList<Linha> listLinhas) {
		this.listLinhas = listLinhas;
	}

	private Instalacao() {
		this.listLinhas = new ArrayList<Linha>();
	}

	/** SINGLETON PATTERN: nao existe mas nenhuma instancia do mesmo */
	public static Instalacao getInstanciaUnica() {
		if (instance == null) {
			instance = new Instalacao();
		}
		return instance;
	}

	// GETTERS AND SETTERS
	public ArrayList<Linha> getListLinhas() {
		return listLinhas;
	}

	public void setListLinhas(ArrayList<Linha> listLinhas) {
		this.listLinhas = listLinhas;
	}

	// TOSTRING
	@Override
	public String toString() {
		String toReturn = "t = " + Relogio.getInstanciaUnica().getCounter()
				+ "\n";
		for (Linha linha : listLinhas) {
			toReturn += linha.getNome() + " " + linha.somaPotenciaLinha()
					+ "W\n";
		}
		return toReturn;
	}

	// METHODS FROM JUNIT
	/**
	 * DESCRICAO: a partir dos parametros nome da linha e numero de tomadas
	 * nessa linha, instancio uma linha nova. A partir do metodo
	 * instalarTomadas(), percorro o numero de tomadas dado e adiciono nos
	 * objectos Tomada a lista de tomadas. Que posteriormente adiciono a lista
	 * de linhas.
	 * 
	 */
	public void novaLinha(String string, long i) {
		Linha linha = new Linha(string);
		linha.instalarTomadas(i);
		listLinhas.add(linha);
	}

	/** */
	public String getTomadaLivre(String nome) {
		String toReturn = "";
		for (Linha linha : listLinhas) {
			if (linha.getNome().equals(nome)) {
				for (Tomada tomada : linha.getListaTomadas()) {
					if (tomada.getEstadoLinha() == LinhaTomadaEstado.FREE) {
						toReturn = tomada.getNome();
						return toReturn;
					} else {
						System.out.println("ERROR: NENHUMA TOMADA ESTA LIVRE");
					}
				}
			}
		}
		return null;
	}

	/**
	 * Procura na lista de linhas todas as que tem potencia diferente de zero e
	 * acrescenta a uma variavel da class
	 */
	public double potenciaNaLinha(String name) {
		// LIMPAR CONTADOR
		double potenciaNaInstalacao = 0.0;
		for (Linha linha : listLinhas) {
			if (name.equals(linha.getNome())) {
				potenciaNaInstalacao += linha.somaPotenciaLinha();
			}
		}
		return potenciaNaInstalacao;
	}

	/**
	 * DESCRICAO: percorro a lista de linhas. Se encontrar alguma com o mesmo
	 * nome que o parametro dado, percorro a lista de tomadas. Se a lista de
	 * tomadas estiver livre ou receba varios aparelhos por tomada, entao mudo
	 * os estados tanto da tomada como do aparelho. Guardo num atributo do
	 * aparelho em que tomada ele esta ligado. E termino adicionando a lista de
	 * aparelhos o respectivo.
	 * 
	 */
	public void ligaAparelhoATomadaLivre(String name, Aparelho aparelho) {
		// ADICIONA A LINHA name o APARELHO aparelho
		for (Linha linha : listLinhas) {
			// ASSUMIR QUE SO EXISTE UMA LINHA COM O MESMO NOME
			if (linha.getNome().equals(name)) {
				for (Tomada tomada : linha.getListaTomadas()) {
					// COLOCO NA PRIMEIRA TOMADA LIVRE
					if (tomada.getEstadoLinha() == LinhaTomadaEstado.FREE
							|| tomada.getEstadoLinha() == LinhaTomadaEstado.BEING_USED_SEVERAL_PLUGINS) {
						// ASSUMIR QUE SO EXISTE UM APARELHO POR TOMADA
						// (estados)
						tomada.setEstadoLinha(LinhaTomadaEstado.BEING_USED_ONE_PLUGIN);
						aparelho.setEstadoAparelho(AparelhoEstado.STAND_BY);
						// GUARDAR EM QUE TOMADA O APARELHO ESTA LIGADO
						aparelho.setTomada(tomada);
						// ADICIONAR A TOMADA
						tomada.getListaAparelhos().add(aparelho);
						return;
					}
				}
			}
		}
	}

	/** */
	public void removeTodasAsLinhas() {
		// REMOVE ALL
		listLinhas.removeAll(listLinhas);
	}

	/** */
	public Aparelho getAparelho(String aparelho) {

		for (Linha linha : listLinhas) {
			for (Tomada tomada : linha.getListaTomadas()) {
				for (Aparelho aparelho1 : tomada.getListaAparelhos()) {
					if (aparelho.equals(aparelho1.getId())) {
						return aparelho1;
					}
				}
			}
		}
		return null;
	}
	
	//ADD METHODS FROM MAIN
	/** */
	public void addObserver(Chart grafico){
		
	}
	
	/** */
	public List<Ligavel> lerAparelhos(JSONArray listaAparelhos){
		
		//INITIALZE
		List<Ligavel> aparelhos = new ArrayList<>();
		
		//RETURN
		return aparelhos;
	}
	
	/** */
	//OBJ: criar instalacao
	public void init(JSONArray objectos){
		
		for(Object object: objectos) {
			JSONObject obj = (JSONObject) object;
			
			//LE DO JSONObject NOME E NUM_TOMADAS
			String nome = (String) obj.get("nome");
			long tomadas = (long) obj.get("tomadas");
			
			novaLinha(nome, tomadas);
			//Aparelho.novoAparelho(obj);
		}
	}
	
	/** */
	public void lerLigacoes(JSONArray listaLigacoes, List<Ligavel> aparelhos){
		
	}
	
	/** */
	public void lerEventos(JSONArray listaEventos){
		
	}
	
	/** */
	public void simula(long fim){
		
	}
	
}

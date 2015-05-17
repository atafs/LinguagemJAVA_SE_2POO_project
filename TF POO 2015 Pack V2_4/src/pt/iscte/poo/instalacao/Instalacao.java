package pt.iscte.poo.instalacao;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import pt.iscte.poo.graficos.Chart;
import pt.iscte.poo.instalacao.enums.LigavelEstado;
import pt.iscte.poo.instalacao.enums.LinhaTomadaEstado;
import pt.iscte.poo.instalacao.eventos.Evento;
import pt.iscte.poo.instalacao.ligacoes.Ligacao;

public class Instalacao extends Observable {

	//ATTRIBUTES
	private static Instalacao instance = null;
	
	//LISTS
	private ArrayList<Linha> listLinhas;
	private List<Ligavel> ligaveis = new ArrayList<Ligavel>();
	private List<Evento> eventos;
	private List<Ligacao> ligacoes;
	
	// CONSTRUCTOR (overload)
	private Instalacao(ArrayList<Linha> listLinhas, ArrayList<Evento> eventos,  ArrayList<Ligacao> ligacoes) {
		this.listLinhas = listLinhas;
		this.eventos = eventos;
		this.ligacoes = ligacoes;
	}
	
	private Instalacao(ArrayList<Linha> listLinhas, ArrayList<Evento> eventos) {
		this.listLinhas = listLinhas;
		this.eventos = eventos;
	}
	
	private Instalacao(ArrayList<Linha> listLinhas) {
		this.listLinhas = listLinhas;
	}
	
	private Instalacao() {
		this.listLinhas = new ArrayList<Linha>();
		this.eventos = new ArrayList<Evento>();
		this.ligacoes = new ArrayList<Ligacao>();
	}

	/** SINGLETON PATTERN: nao existe mas nenhuma instancia do mesmo */
	public static Instalacao getInstanciaUnica() {
		if (instance == null) {
			instance = new Instalacao();
		}
		return instance;
	}
	
	/** OBSERVER PATTERN: uma classe observa e regista alteracoes de outra */
	public void setChange() {
		//...
	}
	
	public void notifyObserver() {
		//...
	}
	
	/* existe o metodo: public void observadoAddObserver(Observer observer) {}; */

	// GETTERS AND SETTERS
	public ArrayList<Linha> getListLinhas() {
		return listLinhas;
	}

	public void setListLinhas(ArrayList<Linha> listLinhas) {
		this.listLinhas = listLinhas;
	}
	
	public List<Ligavel> getLigaveis() {
		return ligaveis;
	}

	public void setLigaveis(List<Ligavel> ligaveis) {
		this.ligaveis = ligaveis;
	}

	public List<Evento> getEventos() {
		return eventos;
	}

	public void setEventos(List<Evento> eventos) {
		this.eventos = eventos;
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
	public void novaLinha(String string, int numeroTomadas) {
		Linha linha = new Linha(string, numeroTomadas);
		//linha.setNumeroTomadas(numeroTomadas);
		linha.instalarTomadas(numeroTomadas);
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
						System.out.println("ERROR -> NENHUMA TOMADA ESTA LIVRE");
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
					if (tomada.getEstadoLinha() == LinhaTomadaEstado.FREE) {
						// ASSUMIR QUE SO EXISTE UM APARELHO POR TOMADA
						// (estados)
						tomada.setEstadoLinha(LinhaTomadaEstado.USED);
						
						// ADICIONAR A TOMADA
						tomada.setAparelho(aparelho);//DA ERRO NO JUNIT... CAN BE DELETED
						tomada.getListaAparelhos().add(aparelho);
						
						//ADD TO LIST Ligavel
						for (Ligavel ligavelTemp : ligaveis) {
							///VERIFICA SE NA LIST Ligaveis EXISTE ESTA ENTRADA
							if (ligavelTemp.equals(aparelho)) {
								aparelho.setEstadoAparelho(LigavelEstado.EM_ESPERA);
//								// GUARDAR EM QUE TOMADA O APARELHO ESTA LIGADO
//								aparelho.setTomada(tomada);
							}
						 }
						return;
					}
				}
			}
		}
	}
	
	public void ligaAparelhoATomadaLivre(String name, Ligavel ligavel) {
		
		// ADICIONA A LINHA name o APARELHO aparelho
		for (Linha linha : listLinhas) {		
			// ASSUMIR QUE SO EXISTE UMA LINHA COM O MESMO NOME
			if (linha.getNome().equals(name)) {		
				for (Tomada tomada : linha.getListaTomadas()) {
					// COLOCO NA PRIMEIRA TOMADA LIVRE
					if (tomada.getEstadoLinha() == LinhaTomadaEstado.FREE) {
						// ASSUMIR QUE SO EXISTE UM APARELHO POR TOMADA
						// (estados)
						tomada.setEstadoLinha(LinhaTomadaEstado.USED);
						
						// ADICIONAR A TOMADA
						tomada.setLigavel(ligavel);
						
						//ADD TO LIST Ligavel
						for (Ligavel ligavelTemp : ligaveis) {
							///VERIFICA SE NA LIST Ligaveis EXISTE ESTA ENTRADA
							if (ligavelTemp.equals(ligavel)) {
								ligavel.setEstadoAparelho(LigavelEstado.EM_ESPERA);
//								// GUARDAR EM QUE TOMADA O APARELHO ESTA LIGADO
//								ligavel.setTomada(tomada);
							}
						 }
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
	public List<Ligavel> lerAparelhos(JSONArray aparelhos){
		
		for(Object object: aparelhos) {
			JSONObject obj = (JSONObject) object;
			//ADD TO LIST
			ligaveis.add(Aparelho.novoAparelho(obj));	
			
	
		}
		return ligaveis;
	}
	
	/** */
	//OBJ: criar instalacao
	public void init(JSONArray objectos){
		
		for(Object object: objectos) {
			JSONObject obj = (JSONObject) object;
			
			//LE DO JSONObject NOME E NUM_TOMADAS
			String nome = (String) obj.get("nome");
			int tomadas = (int)(long) obj.get("tomadas");
			
			novaLinha(nome, tomadas);
			//Aparelho.novoAparelho(obj);
		}
	}
	
	/** */
	public void lerLigacoes(JSONArray listaLigacoes, List<Ligavel> ligaveis) {


		//LOOP LIST JSONArray
		for (Object object : listaLigacoes) {
			
			//CAST AND SAVE TO STRING
			JSONObject obj = (JSONObject) object;
			String ligavel = (String) obj.get("aparelho");
			String linha = (String) obj.get("ligadoA");
			
			// ADD TO LIST (extra)
			Ligacao ligacao = new Ligacao(ligavel, linha);
			ligacoes.add(ligacao);
			
			//LIGA APARELHO A TOMADA DE UMA LINHA
			for (Ligacao ligacaoTemp1 : ligacoes) {
				
				//PERCORRER A LISTA DE LIGAVEIS
				for (Ligavel ligavel2 : ligaveis) {
					if (ligavel2.getId().equals(ligacaoTemp1.getAparelho())) {
						ligaAparelhoATomadaLivre(ligacaoTemp1.getLigadoA(), ligavel2);
					}
				}	
			}
		}	
		
		// TO PRINT
		 System.out.println("----------------PRINT_03_LIGACOES------------------");
		 for (Ligacao ligacao1 : ligacoes) {
			 System.out.println(ligacao1.toString());
		 }
		 
		// TO PRINT
		System.out.println("----------------PRINT_LINHA------------------");
		for (Linha linha1 : listLinhas) {
			System.out.println(linha1.toString());
		}
	}
	
	/** */
	public void lerEventos(JSONArray listaEventos){
		
		//LOOP LIST JSONArray
		for (Object object : listaEventos) {
			
			//CAST AND SAVE TO STRING
			JSONObject obj = (JSONObject) object;
			
			//READ FROM JSON and SELECT ACTION
			Evento evento = LigavelEstado.executaAccao(obj); //??? void, Ligavel,...	
			eventos.add(evento);
		}
		
		//LIGA LIGAVEL MUDANDO O ESTADO E REGISTANDO TEMPOS (inicio e fim)
		for (Evento evento1 : eventos) {
			//PERCORRER A LISTA DE LIGAVEIS
			for (Ligavel ligavel2 : ligaveis) {
				if (ligavel2.getId().equals(evento1.getIdAparelho())) {
					//MUDAR ESTADO LIGAVEL E TEMPOS INICIO E FIM
					ligavel2.setEstadoAparelho(evento1.getEstado());

				}
			}
		}
		
		//TO DELETE
		System.out.println("----------------PRINT_06_EVENTOS------------------");
		for (Evento evento : eventos) {
			System.out.println(evento.toString());
		}	
	}

	/** */
	public void simula(long fim){
		
		//START THE CLOCK
		int t;
		for (t = 0; t != fim; t++) {
			Relogio.getInstanciaUnica().tique();
		}
		
	}
	
}

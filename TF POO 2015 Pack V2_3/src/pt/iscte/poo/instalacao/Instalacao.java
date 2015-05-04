package pt.iscte.poo.instalacao;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import pt.iscte.poo.graficos.Chart;
import pt.iscte.poo.instalacao.aparelhos.Ligavel;
import pt.iscte.poo.instalacao.aparelhos.Tripla;
import pt.iscte.poo.instalacao.enums.LigavelEstado;
import pt.iscte.poo.instalacao.enums.Ligavel_Tipo;
import pt.iscte.poo.instalacao.enums.LinhaTomadaEstado;
import pt.iscte.poo.instalacao.eventos.Evento;
import pt.iscte.poo.instalacao.ligacoes.Ligacao;

public class Instalacao extends Observable {

	// ATTRIBUTES
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
	public void novaLinha(String string, long numeroTomadas) {
		Linha linha = new Linha(string);
		linha.setNumeroTomadas(numeroTomadas);
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
						aparelho.setEstadoAparelho(LigavelEstado.EM_ESPERA);
		
						// GUARDAR EM QUE TOMADA O APARELHO ESTA LIGADO
						aparelho.setTomada(tomada);
						// ADICIONAR A TOMADA
						tomada.setLigavel(aparelho);
						//tomada.getListaAparelhos().add(aparelho);
						
						// LOOP LISTS aparelhos and triplasLista

//						for (int i = 0; i < Ligavel_Tipo.getAparelhos().size(); i++) {
//							// IF: STRING lig equals STRING ligavel
//							if (Ligavel_Tipo.getAparelhos().get(i).equals(aparelho.getId())) {
//								Ligavel_Tipo.getAparelhos().remove(i);    //remove old
//								Ligavel_Tipo.getAparelhos().add(aparelho);//add new
//							}
//						}
						return;
					}
				}
			}
		}
	}
	
//	//OVERLOAD METHOD
//	public void ligaAparelhoATomadaLivre(String name, Tripla tripla) {
//		
//		// ADICIONA A LINHA name o APARELHO aparelho
//		for (Linha linha : listLinhas) {		
//			// ASSUMIR QUE SO EXISTE UMA LINHA COM O MESMO NOME
//			if (linha.getNome().equals(name)) {		
//				for (Tomada tomada : linha.getListaTomadas()) {
//					// COLOCO NA PRIMEIRA TOMADA LIVRE
//					if (tomada.getEstadoLinha() == LinhaTomadaEstado.FREE) {
//						// ASSUMIR QUE SO EXISTE UM APARELHO POR TOMADA
//						// (estados)
//						tomada.setEstadoLinha(LinhaTomadaEstado.USED);
//						tripla.setEstadoAparelho(LigavelEstado.EM_ESPERA);
//		
//						// GUARDAR EM QUE TOMADA O APARELHO ESTA LIGADO
//						tripla.setTomada(tomada);
//						// ADICIONAR A TOMADA
//						tomada.setLigavel(tripla);
//						//tomada.getListaAparelhos().add(aparelho);
//						
//						// LOOP LISTS aparelhos and triplasLista
//
//						for (int i = 0; i < Ligavel_Tipo.getTriplasLista().size(); i++) {
//							// IF: STRING lig equals STRING ligavel
//							if (Ligavel_Tipo.getTriplasLista().get(i).equals(tripla.getId())) {
//								Ligavel_Tipo.getTriplasLista().remove(i);    //remove old
//								Ligavel_Tipo.getTriplasLista().add(tripla);//add new
//							}
//						}
//						return;
//					}
//				}
//			}
//		}
//	}

	/** */
	public void removeTodasAsLinhas() {
		// REMOVE ALL
		listLinhas.removeAll(listLinhas);
	}

	/** */
	public Aparelho getAparelho(String aparelho) {

		for (Linha linha : listLinhas) {
			for (Tomada tomada : linha.getListaTomadas()) {
				//for (Aparelho aparelho1 : tomada.getListaAparelhos()) {
				if (aparelho.equals(tomada.getLigavel().getId() /*aparelho1.getId()*/ )) {
					//return aparelho1;
					return (Aparelho)tomada.getLigavel();
				}
				//}
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
			long tomadas = (long) obj.get("tomadas");
			
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

			// LOOP LISTS aparelhos and triplasLista
			for (Aparelho aparelho : Ligavel_Tipo.getAparelhos()) {

				// IF: STRING lig equals STRING ligavel
				if (aparelho.getId().equals(ligavel)) {

					// KEEP STRING lig.getId(), APARELHO lig
					ligaAparelhoATomadaLivre(linha, aparelho);
				}
			}
			
//			// LOOP LISTS aparelhos and triplasLista
//			for (Tripla tripla : Ligavel_Tipo.getTriplasLista()) {
//
//				// IF: STRING lig equals STRING ligavel
//				if (tripla.getId().equals(ligavel)) {
//
//					// KEEP STRING lig.getId(), APARELHO lig
//					ligaAparelhoATomadaLivre(linha, tripla);
//				}
//			}
		}
		
		// TO DELETE
		System.out.println("----------------PRINT_03_LIGACOES------------------");
		// TO DELETE (print)
		for (Ligacao ligacaoTemp : ligacoes) {
			System.err.println(ligacaoTemp);
		}
		
//		System.out.println("----------------PRINT_04_TRIPLAS------------------");
//		for (Tripla tripla : Ligavel_Tipo.getTriplasLista()) {
//			System.out.println(tripla);
//		}
		
//		System.out.println("----------------PRINT_05_APARELHOS------------------");
//		for (Aparelho aparelho : Ligavel_Tipo.getAparelhos()) {
//			System.out.println(aparelho);
//		}
			 
			 
			 
//			 // LOOP LIST ligaveis
//			for (Ligavel lig  : ligaveis) {
//
//				//IF: STRING lig equals STRING ligavel
//				if (lig.getId().equals(ligavel)) {
//					
//					//KEEP STRING lig.getId(), APARELHO lig
//					ligaAparelhoATomadaLivre(linha, lig);				
//				}
//			}
		
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

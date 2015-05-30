package pt.iscte.poo.instalacao;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Observable;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import pt.iscte.poo.instalacao.aparelhos.Computador;
import pt.iscte.poo.instalacao.aparelhos.MaquinaLavarRoupa;
import pt.iscte.poo.instalacao.aparelhos.Tripla;
import pt.iscte.poo.instalacao.comparator.EventoTempoComparator;
import pt.iscte.poo.instalacao.comparator.LinhaNomeComparator;
import pt.iscte.poo.instalacao.enums.LigavelEstado;
import pt.iscte.poo.instalacao.enums.Ligavel_Tipo;
import pt.iscte.poo.instalacao.enums.LinhaTomadaEstado;
import pt.iscte.poo.instalacao.eventos.Evento;
import pt.iscte.poo.instalacao.ligacoes.Ligacao;

public class Instalacao extends Observable implements Comparable<Evento>{

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
	
	public List<Ligacao> getLigacoes() {
		return ligacoes;
	}

	public void setLigacoes(List<Ligacao> ligacoes) {
		this.ligacoes = ligacoes;
	}

	// TOSTRING
	@Override
	public String toString() {
		String toReturn = "t = " + Relogio.getInstanciaUnica().getCounter()
				+ "\n";
		for (Linha linha : listLinhas) {
			toReturn += linha.getId() + " " + linha.somaPotenciaLinha()
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
			if (linha.getId().equals(nome)) {
				for (Tomada tomada : linha.getListaTomadas()) {
					if (tomada.getEstadoLinha() == LinhaTomadaEstado.FREE) {
						toReturn = tomada.getId();
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
			if (name.equals(linha.getId())) {
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
			if (linha.getId().equals(name)) {		
				for (Tomada tomada : linha.getListaTomadas()) {
					// COLOCO NA PRIMEIRA TOMADA LIVRE
					if (tomada.getEstadoLinha() == LinhaTomadaEstado.FREE) {
						// ASSUMIR QUE SO EXISTE UM APARELHO POR TOMADA
						// (estados)
						tomada.setEstadoLinha(LinhaTomadaEstado.USED);
						
						// ADICIONAR A TOMADA
						tomada.setAparelho(aparelho);
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
			if (linha.getId().equals(name)) {		
				for (Tomada tomada : linha.getListaTomadas()) {
					// COLOCO NA PRIMEIRA TOMADA LIVRE
					if (tomada.getEstadoLinha() == LinhaTomadaEstado.FREE) {
						// ASSUMIR QUE SO EXISTE UM APARELHO POR TOMADA
						// (estados)
						tomada.setEstadoLinha(LinhaTomadaEstado.USED);
						
						// ADICIONAR A TOMADA
						tomada.setLigavel(ligavel);
						
						if (ligavel.getId().equals(Ligavel_Tipo.TRIPLA.toString())) {
							ligavel.setEstadoAparelho(LigavelEstado.EM_ESPERA);
							System.err.println("FOI ADICIONADO UMA TRIPLA");

						} else { 
							ligavel.setEstadoAparelho(LigavelEstado.EM_ESPERA);
							tomada.getListaAparelhos().add((Aparelho) ligavel);
						}
						
						
//						//ADD TO LIST Ligavel
//						for (Ligavel ligavelTemp : ligaveis) {
//							///VERIFICA SE NA LIST Ligaveis EXISTE ESTA ENTRADA
//							if (ligavelTemp.equals(ligavel)) {
//								ligavel.setEstadoAparelho(LigavelEstado.EM_ESPERA);
////								// GUARDAR EM QUE TOMADA O APARELHO ESTA LIGADO
////								ligavel.setTomada(tomada);
//							}
//						 }
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
	
	/** */
	public List<Ligavel> lerAparelhos(JSONArray aparelhos){
		
		for(Object object: aparelhos) {
			JSONObject obj = (JSONObject) object;
			
			//ADDICIONA A LISTA
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
			String aparelho = (String) obj.get("aparelho");
			String ligadoA = (String) obj.get("ligadoA");
			
			// ADD TO LIST (extra)
			Ligacao ligacaoTemp = new Ligacao(aparelho, ligadoA);
			ligacoes.add(ligacaoTemp);
		}	
		
		//LIGA APARELHO A TOMADA DE UMA LINHA
		for (Ligacao ligacao : ligacoes) {
		
			//PERCORRER A LISTA DE LIGAVEIS
			for (Ligavel ligavel : ligaveis) {
				
				//SE LIGAVEL E LIGACAO EXISTIREM
				if (ligavel.getId().equals(ligacao.getId())) {
					
					//EXISTE UMA TRIPLA (ligavel e ligacao)
					if (ligacao.getId().equals(Ligavel_Tipo.TRIPLA.toString())) {
						//PERCORRER A LISTA DE LINHAS
						for (Linha linha : listLinhas) {
							if (linha.getId().equals(ligacao.getLigadoA())) {
								int nTomadasTripla = (int)procuraTriplaNaLista_nTomadas(ligacao.getId());
								long nTomadasLinha = linha.getNumeroTomadas();
								int total = (int) (nTomadasTripla + nTomadasLinha - 1); //tomada usada pela tripla
								linha.setNumeroTomadas(total);
								
								//ADICIONAR NOVAS TOMADAS COM A INFORMACAO DO ID 
								//para ser mais facil saber na linha a que tomada pertencem
								linha.instalarTomadas((long)nTomadasTripla - 1/*, ligacao.getId()*/);
							}
						}
						//ligaAparelhoATomadaLivre(ligacao.getLigadoA(), ligavel);
					} else {
						ligaAparelhoATomadaLivre(ligacao.getLigadoA(), ligavel);

					}
				}
			}	
		}
		
//		// TO PRINT
//		 System.out.println("----------------PRINT_03_LIGACOES------------------");
//		 for (Ligacao ligacao : ligacoes) {
//			 System.out.println(ligacao.toString());
//		 }
//		 
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
			Evento evento = LigavelEstado.guardaEventos(obj); 	
			eventos.add(evento);
		}
	
//		//TO DELETE
//		System.out.println("----------------PRINT_06_EVENTOS------------------");
//		for (Evento evento : eventos) {
//			System.out.println(evento.toString());
//		}	
		

		
	}
	
	/** */
//	public void executaEventos() {
//		//LIGA LIGAVEL MUDANDO O ESTADO E REGISTANDO TEMPOS (inicio e fim)
//		for (Evento evento1 : eventos) {
//			
//			//PERCORRER A LISTA DE LIGAVEIS
//			for (Ligavel ligavel2 : ligaveis) {
//				
//				//EXISTIR O TEMPO IGUAL TEMPO ACTUAL
//				if (Relogio.getInstanciaUnica().getTempoAtual() == (int)evento1.getTempo()) {
//					
//					//EXISTIR NA LISTA DE EVENTOS O LIGAVEL
//					if (ligavel2.getId().equals(evento1.getIdAparelho())) {
//
//						//MUDAR ESTADO LIGAVEL E TEMPOS INICIO E FIM
//						ligavel2.setEstadoAparelho(evento1.getEstado());
//						
//
////						//TO DELETE
////						System.err.println(ligavel2.getId());
////						System.err.println(evento1.getIdAparelho());
////						System.err.println(Relogio.getInstanciaUnica().getTempoAtual());
////						System.err.println(evento1.getTempo());
////						System.err.println(evento1.getEstado());
//
//						// TO DELETE
//						try {
//							Thread.sleep(250);
//						} catch (InterruptedException e) {
//							// TODO Auto-generated catch block
//							e.printStackTrace();
//						}
//							
//						//local variables
//						Aparelho aparelho = null;
//						MaquinaLavarRoupa maquinaLavarRoupa = null;
//						Ligavel ligavelTemp = null;
//						
//						//ADICIONA STRING COM O PROGRAMA SE A ACCAO FOR PROGRAMA						
//						if (evento1.getIdAparelho().equals(Ligavel_Tipo.MAQLAVARROUPA.toString()) && evento1.getAccao().equals(LigavelEstado.PROGRAMA.toString())) {
//				
//							//ligavelTemp = ligavel2;
//							aparelho = (Aparelho) ligavel2;
//							//ligaveis.remove(ligavel2);
//							maquinaLavarRoupa = (MaquinaLavarRoupa)aparelho;
//							EventoPrograma eventoPrograma = (EventoPrograma)evento1;
//							maquinaLavarRoupa.setProgramaSelecionado(eventoPrograma.getPrograma());
//							maquinaLavarRoupa.setEstadoAparelho(LigavelEstado.LIGA);
//				
//							//ligaveis.add((Ligavel)maquinaLavarRoupa);
//						}
//						
//						//LIGA MAQUINA LAVAR ROUPA COLOCANDO O TEMPO NUMA VARIAVEL
//						if (evento1.getIdAparelho().equals(Ligavel_Tipo.MAQLAVARROUPA.toString()) && evento1.getAccao().equals(LigavelEstado.LIGA.toString())) {
//							
//							//ligavelTemp = ligavel2;
//							aparelho = (Aparelho) ligavel2;
//							//ligaveis.remove(ligavel2);
//							maquinaLavarRoupa = (MaquinaLavarRoupa)aparelho;
//							
//							//TO DELETE
//							System.err.println("I AM HERE");
//							
//							for (Programa programa : maquinaLavarRoupa.getProgramas()) {
//								if (programa.getId().equals(maquinaLavarRoupa.getProgramaSelecionado())) {
//									programa.setTempoInicio(evento1.getTempo());
//								}
//							}
//							maquinaLavarRoupa.setPotenciaActual(maquinaLavarRoupa.potenciaActualMaquina());
//							
//							//ligaveis.add((Ligavel)maquinaLavarRoupa);
//						}
//						
//						//AUMENTA VALOR DO APARELHO
//						if (evento1.getAccao().equals(LigavelEstado.AUMENTA.toString())) {
//							
//							//ligavelTemp = ligavel2;
//							aparelho = (Aparelho) ligavel2;
//							//ligaveis.remove(ligavel2);
//							EventoAumenta eventoAumenta = (EventoAumenta)evento1;
//							aparelho.aumenta((int)eventoAumenta.getAumenta());
//							aparelho.setEstadoAparelho(LigavelEstado.LIGA);//manter ligado, mesmo apos aumentar
//							//ligaveis.add((Ligavel)aparelho);
//
//							//VOLTA A COLOCAR NA LISTA
//							ligavel2 = (Ligavel)aparelho;
//							
////							//TO DELETE
////							System.out.println("----------------PRINT_02_APARELHOS_DONE------------------");
////							System.out.println(ligavel2.toString());
//						}
//						//EXIT LOOP
//						break;
//					}
//				}
//				
//				//EXIT: SE O TEMPO DO EVENTO FOR MAIOR QUE O TEMPO ACTUAL, INTERROMPE O METODO
//				else if (Relogio.getInstanciaUnica().getTempoAtual() < (int)evento1.getTempo()) { 
//					return;
//				} 
//				
//				//EXIT: SE O TEMPO ACTUAL FOR MAIOR QUE O EVENTO, INTERROMPE O CICLO
//				else if (Relogio.getInstanciaUnica().getTempoAtual() > (int)evento1.getTempo()) { 
//					break;
//				} 
//			}
//		}
//	}
	
	/** Search for the nTomadas in a Class Tripla object, kept in a list of triplas */
	public long procuraTriplaNaLista_nTomadas(String id) {
		long nTomadas = 0;
		for (Tripla tripla : Ligavel_Tipo.getListTriplas()) {
			if (id.equals(tripla.getId())) {
				nTomadas = tripla.getnTomadas();
			}
		}
		return nTomadas;
	}

	/** */
public void simula(long fim){
		
//		//LIST PriorityQUEUE and COMPARATOR
//		Comparator<Evento> comparator = new StringLengthComparator();
//        PriorityQueue<Evento> listQueue =  new PriorityQueue<Evento>(20, comparator);
//   
//        //ADD EVENTOS TO QUEUE
//        for (Evento evento : eventos) {
//        	listQueue.add(evento);
//		}
        
//        //ORDENAR A LISTA
//        Collections.sort(listQueue);
       
		//START THE CLOCK
		//TO DELETE, CHANGE CLOCK TO START AT...
		int t = 0;
		Relogio.getInstanciaUnica().setCounter(t);
		
		for (t = 0; t != fim; t++) {
			//VERIFICA OS EVENTOS E ACTUALIZA ESTADOS
			//executaEventos();
			Collections.sort(eventos, new EventoTempoComparator());
			for (Evento evento1 : eventos) {
				LigavelEstado.selecionaNovoEvento(evento1, ligaveis);
			}
			
			for (Ligavel ligavel : ligaveis) {
				if (ligavel.getId().equals(Ligavel_Tipo.MAQLAVARROUPA.toString()) && ligavel.getEstadoAparelho().equals(LigavelEstado.LIGA)) {
					Aparelho aparelho = (Aparelho)ligavel;
					MaquinaLavarRoupa maq = (MaquinaLavarRoupa) aparelho;	
					maq.setPotenciaActual(maq.potenciaActualMaquina());
					ligavel = (Ligavel) maq;
				}
				
				if (ligavel.getId().equals(Ligavel_Tipo.COMPUTADOR.toString())&& ligavel.getEstadoAparelho().equals(LigavelEstado.LIGA)) {
					Aparelho aparelho = (Aparelho)ligavel;
					Computador comp = (Computador) aparelho;	
					double temp = (double)(int)(Math.random()*comp.potenciaAtual());
					comp.setPotenciaActual(temp);
					ligavel = (Ligavel) comp;
					break;
				}
				
				
			}
			//PRINT TO CONSOLE
			System.out.println(this.toString());
			
			
			//PRINT TO SWING: OBSERVER PATTERN: uma classe observa e regista alteracoes de outra 
			Collections.sort(listLinhas, new LinhaNomeComparator());
			Map<String, Double> potencias = new HashMap<>();
			for (Linha linha : listLinhas) {
				potencias.put(linha.getId(), linha.somaPotenciaLinha());
			}
			
			//INCREMENT CLOCK
			Relogio.getInstanciaUnica().tique();
			
			//OBSERVER PATTERN
			this.setChanged(); 
			this.notifyObservers(potencias); 
			
		
		}
		
		//FINAL MESSAGE
		if (t == fim) {
			System.err.println("fim: " + (fim-1) + ";[unidades]");
			System.err.println("END WITH SUCCESS!!!");
		}
	}

	@Override
	public int compareTo(Evento o) {
		for (Evento evento : eventos) {
			if(evento.getTempo() != o.getTempo())
				return ((int)evento.getTempo() - (int)o.getTempo());
		}
		return 0;
		
	}
}

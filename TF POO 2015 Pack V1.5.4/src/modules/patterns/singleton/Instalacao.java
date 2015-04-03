package modules.patterns.singleton;

import java.util.ArrayList;

import pt.iscte.poo.instalacao.Aparelho;
import pt.iscte.poo.instalacao.Linha;
import pt.iscte.poo.instalacao.Tomada;
import pt.iscte.poo.instalacao.aparelhos.Lampada;
import pt.iscte.poo.instalacao.enums.AparelhoEstado;
import pt.iscte.poo.instalacao.enums.LinhaTomadaEstado;

public class Instalacao {

	//ATTRIBUTE is the class itself. Only one that exists
	private static Instalacao instance = null;
	private ArrayList<Linha> listLinhas;
	//private Aparelho aparelho;

	//CONSTRUCTOR
	private Instalacao(ArrayList<Linha> listLinhas) {
		this.listLinhas = listLinhas;
	}
	
	private Instalacao() {
		this.listLinhas = new ArrayList<Linha>();
	}
	
	/** SINGLETON PATTERN: static because we do not have objects */
	public static Instalacao getInstanciaUnica() {
		if (instance == null) {
			instance = new Instalacao();
		}
		return instance;
	}
	
	//GETTERS AND SETTERS
	public ArrayList<Linha> getListLinhas() {
		return listLinhas;
	}

	public void setListLinhas(ArrayList<Linha> listLinhas) {
		this.listLinhas = listLinhas;
	}
	
	//TOSTRING
	@Override
	public String toString() {
		String toReturn = "";
		toReturn += "listLinhas: " + this.listLinhas;
		return toReturn;
	}
	

	//METHODS FROM JUNIT
	/** */
	public void novaLinha(String string, int i) {
		Linha linha = new Linha(string);
		linha.instalarTomadas(i);
		listLinhas.add(linha);
	}

	/** */
	public void ligaAparelho(String string, Lampada lamp1) {

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
	 * Procura na lista de linhas todas as que tem potencia diferente de zero
	 * e acrescenta a uma variavel da class
	 */
	public double potenciaNaLinha(String name) {
		//LIMPAR CONTADOR
		double potenciaNaInstalacao = 0.0;
		for (Linha linha : listLinhas) {
			if (name.equals(linha.getNome())) {
				potenciaNaInstalacao += linha.somaPotenciaLinha();	
			}
		}
		return potenciaNaInstalacao;
	}

	/** Liga aparelho a primeira tomada livre que encontrar da linha name*/
	public void ligaAparelhoATomadaLivre(String name, Aparelho aparelho) {		
		//ADICIONA A LINHA name o APARELHO aparelho
		for (Linha linha : listLinhas) {
			if (linha.getNome().equals(name)) {
				for (Tomada tomada : linha.getListaTomadas()) {
					if (tomada.getEstadoLinha() == LinhaTomadaEstado.FREE) {
//						//TO DELETE
//						System.out.println(tomada.getEstadoLinha());
//						System.out.println(LinhaTomadaEstado.FREE);
						
						//ASSUMIR QUE SO EXISTE UM APARELHO POR TOMADA
						tomada.setEstadoLinha(LinhaTomadaEstado.BEING_USED_ONE_PLUGIN);
						aparelho.setEstadoAparelho(AparelhoEstado.STAND_BY);
						tomada.getListaAparelhos().add(aparelho);
						return;
					}
				}
			}
		}
	}
	
	/** */
	public void removeTodasAsLinhas(){
		//REMOVE ALL 
		listLinhas.removeAll(listLinhas);
	}
	
	/** */
	public Aparelho getAparelho(String aparelho) {
		
		for (Linha linha : listLinhas) {
			for (Tomada tomada : linha.getListaTomadas()) {
				for (Aparelho aparelho1 : tomada.getListaAparelhos()) {
					if (aparelho.equals(aparelho1.getNome())) {
						return aparelho1;
					}
				}
			}
		}
		return null;
	}
}

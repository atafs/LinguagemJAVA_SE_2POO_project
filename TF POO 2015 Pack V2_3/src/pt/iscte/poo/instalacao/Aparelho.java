package pt.iscte.poo.instalacao;

import org.json.simple.JSONObject;

import pt.iscte.poo.instalacao.aparelhos.Ligavel;
import pt.iscte.poo.instalacao.enums.LigavelEstado;
import pt.iscte.poo.instalacao.enums.Ligavel_Potencia;
import pt.iscte.poo.instalacao.enums.Ligavel_Tipo;
import pt.iscte.poo.instalacao.interfaces.Variavel;

public abstract class Aparelho implements Ligavel, Variavel {

	// ATTRIBUTES
	private String nome;
	private double potenciaMaxima;
	private double potenciaActual;
	// ENUM (constantes)
	private LigavelEstado estadoAparelho;
	private Ligavel_Tipo tipoAparelho;
	private Ligavel_Potencia potenciaAparelho;
	// APARELHO SABER A QUE TOMADA PERTENCE
	//private Tomada tomada = null;
	
	// CONSTRUCTOR JUnit requires this constructor
	/** */
	public Aparelho(String nome, double potencia) {
		this.nome = nome;
		this.potenciaMaxima = potencia;
	}
	
	public Aparelho(String nome, double potencia, double potenciaActual, LigavelEstado estadoAparelho, Ligavel_Tipo tipoAparelho, Ligavel_Potencia potenciaAparelho) {
		this.nome = nome;
		this.potenciaMaxima = potencia;
		
		this.estadoAparelho = estadoAparelho;
		this.tipoAparelho = tipoAparelho;
		this.potenciaAparelho = potenciaAparelho;
	}

	// TOSTRING
	@Override
	public String toString() {
		String toReturn = ""/* super.toString() */;
		
		toReturn += "TIPO APARELHO: " + this.tipoAparelho.toString();
		toReturn += "\n-> ID: " + this.nome;
		toReturn += "\n-> POTENCIA MAX: " + potenciaMaxima;
		toReturn += "\n-> POTENCIA ACTUAL: " + potenciaActual;
//		toReturn += "\n-> TOMADA NOME: " + tomada;
		toReturn += "\n-> TIPO ESTADO: " + this.estadoAparelho;
		toReturn += "\n-> TIPO POTENCIA: " + this.potenciaAparelho;
		toReturn += "\n";
		return toReturn;
	}

	// STATIC METHODS
	/**
	 * DESCRICAO: devolve uma aparelho ligavel. Atraves de um objecto JSON,
	 * busca o seu tipo e id (nome). No Enum NovoAparelho_Tipo, sao chamados
	 * dois metodos. Um busca o valor de potencia (seja ele fixa ou variavel). O
	 * outro metodo, a partir de tipo, nome e potencia, cria um aparelho novo.
	 * Esta incluido neste metodo um upperCase(), de forma a tornar o programa
	 * mais robusto (do tipo existente no JSON). E um switch que permite
	 * selecionar que qual o aparelho a ser criado.
	 * 
	 * Este metodo foi desenvolvido com a intensao de simplicar a manutencao e
	 * insercao de novo tipos de aparelho. Permitindo a expansao com facilidade
	 * do objecto JSON.
	 * 
	 * NOTA: JSONObject e uma especie de hashMap.
	 */
	public static Ligavel novoAparelho(JSONObject obj) {

		// NOVO APARELHO TIPO
		return Ligavel_Tipo.selecionaNovoAparelho(obj);
	}

	// INTERFACES METHODS
	/**
	 * DESCRICAO: muda o estado do aparelho para ON. Isso vai ter influencia no
	 * comportamento de metodos, como o de somar o consumo total na linha.
	 */
	@Override
	public void liga() {
		estadoAparelho = LigavelEstado.LIGA;
	}

	/** DESCRICAO: mudo o estado do aparelho para OFF */
	@Override
	public void desliga() {
		estadoAparelho = LigavelEstado.DESLIGA;
	}

	@Override
	public boolean estaLigado() {
		// Se o aparelho estiver ON, return true
		return (estadoAparelho == LigavelEstado.LIGA);
	}

	/**
	 * DESCRICAO: Se o valor que estou a receber em parametro somado ao valor ja
	 * guardado na variavel da classe, for menor ou igual ao valor maximo,
	 * permitido pelo aparelho, entao acrescenta ao valor ja existente no mesmo
	 * o valor em parametro.
	 * 
	 * Caso contrario, coloco o atributo com o valor maximo, evitando assim
	 * danificar o aparelho por permitir um incremento excessivo do mesmo.
	 */
	@Override
	public void aumenta(int potenciaActual) {
		if ((this.potenciaActual + potenciaActual) <= potenciaMaxima) {
			this.potenciaActual += potenciaActual;
		} else {
			this.potenciaActual = potenciaMaxima;
		}
	}

	/**
	 * DESCRICAO: funcionamento equivalente ao aumenta(). Decrementando ate um
	 * valor minimo de 0. Nao permite valores negativos.
	 */
	@Override
	public void diminui(int potenciaActual) {
		if ((this.potenciaActual + potenciaActual) >= 0) {
			this.potenciaActual -= potenciaActual;
		} else {
			this.potenciaActual = 0;
		}
	}
	
	// GETTERS AND SETTERS
	public String getId() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public double potenciaMaxima() {
		return potenciaMaxima;
	}

	public void setPotenciaMaxima(double potenciaMaxima) {
		this.potenciaMaxima = potenciaMaxima;
	}

	public LigavelEstado getEstadoAparelho() {
		return estadoAparelho;
	}

	public void setEstadoAparelho(LigavelEstado estadoAparelho) {
		this.estadoAparelho = estadoAparelho;
	}

//	public Tomada getTomada() {
//		return tomada;
//	}
//
//	public void setTomada(Tomada tomada) {
//		this.tomada = tomada;
//	}

	public double potenciaActual() {
		return potenciaActual;
	}

	public void setPotenciaActual(double potenciaActual) {
		this.potenciaActual = potenciaActual;
	}

	public Ligavel_Tipo getTipoAparelho() {
		return tipoAparelho;
	}

	public void setTipoAparelho(Ligavel_Tipo tipoAparelho) {
		this.tipoAparelho = tipoAparelho;
	}

	public Ligavel_Potencia getPotenciaAparelho() {
		return potenciaAparelho;
	}

	public void setPotenciaAparelho(Ligavel_Potencia potenciaAparelho) {
		this.potenciaAparelho = potenciaAparelho;
	}
	

}

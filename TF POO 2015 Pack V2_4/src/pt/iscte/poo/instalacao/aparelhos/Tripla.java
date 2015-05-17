package pt.iscte.poo.instalacao.aparelhos;

import java.util.ArrayList;

import pt.iscte.poo.instalacao.Ligavel;
import pt.iscte.poo.instalacao.Tomada;
import pt.iscte.poo.instalacao.enums.LigavelEstado;
import pt.iscte.poo.instalacao.enums.Ligavel_Potencia;
import pt.iscte.poo.instalacao.enums.Ligavel_Tipo;

public class Tripla implements Ligavel {

	//ATRIBUTES
	private String id;
	private double potenciaActual;
	private double potenciaMaxima;
	private long nTomadas;
	// ENUM (constantes)
	private LigavelEstado estadoTripla;
	private Ligavel_Tipo tipoTripla;
	private Ligavel_Potencia potenciaTripla;
	// APARELHO SABER A QUE TOMADA PERTENCE
	//private Tomada tomada;
	
	// LISTS
	private ArrayList<Tomada> listaTomadas = new ArrayList<Tomada>();
	
	// GUARDAR TEMPOS DE INICIO E FIM
	private long tempoInicio;
	private long tempoFim;


	//CONSTRUCTOR
	public Tripla(String id, double potenciaMaxima, long nTomadas) {
		this.id = id;
		this.potenciaMaxima = potenciaMaxima;
		this.nTomadas = nTomadas;
		
		//CICLO: INSTANCIAR NUMERO DE TOMADAS
		for (int i = 0; i < nTomadas; i++) {
			listaTomadas.add(new Tomada());
		}
	}
	
	//INTERFACE LIGAVEL
	@Override
	public void liga() {
		estadoTripla = LigavelEstado.LIGA;		
	}

	@Override
	public void desliga() {
		estadoTripla = LigavelEstado.DESLIGA;		
	}

	@Override
	public boolean estaLigado() {
		return (estadoTripla == LigavelEstado.LIGA);
	}
	
	// TOSTRING
	@Override
	public String toString() {
		String toReturn = ""/* super.toString() */;
		toReturn += "TIPO APARELHO: " + this.id;
		toReturn += "\n-> ID: " + this.id;
		toReturn += "\n-> POTENCIA MAX: " + potenciaMaxima;
		toReturn += "\n-> POTENCIA ACTUAL: " + potenciaActual;
//		toReturn += "\n-> TOMADA NOME: " + tomada;
		toReturn += "\n-> TOMADA NUMERO: " + nTomadas;
		toReturn += "\n-> TIPO ESTADO: " + this.estadoTripla;
		toReturn += "\n-> TIPO TRIPLA: " + this.tipoTripla.toString();
		toReturn += "\n-> TIPO POTENCIA: " + this.potenciaTripla;
		toReturn += "\n";
		return toReturn;
	}

	//GETTERS AND SETTERS
	public ArrayList<Tomada> getListaTomadas() {
		return listaTomadas;
	}

	public void setListaTomadas(ArrayList<Tomada> listaTomadas) {
		this.listaTomadas = listaTomadas;
	}
	
	public long getnTomadas() {
		return nTomadas;
	}

	public void setnTomadas(int nTomadas) {
		this.nTomadas = nTomadas;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setPotenciaActual(double potenciaActual) {
		this.potenciaActual = potenciaActual;
	}

	public void setPotenciaMaxima(double potenciaMaxima) {
		this.potenciaMaxima = potenciaMaxima;
	}

	public LigavelEstado getEstadoTripla() {
		return estadoTripla;
	}

	public Ligavel_Tipo getTipoTripla() {
		return tipoTripla;
	}

	public void setTipoTripla(Ligavel_Tipo tipoTripla) {
		this.tipoTripla = tipoTripla;
	}

	public void setPotenciaTripla(Ligavel_Potencia potenciaTripla) {
		this.potenciaTripla = potenciaTripla;
	}

//	public Tomada getTomada() {
//		return tomada;
//	}
//
//	public void setTomada(Tomada tomada) {
//		this.tomada = tomada;
//	}

	public void setnTomadas(long nTomadas) {
		this.nTomadas = nTomadas;
	}
	
	public long getTempoFim() {
		return tempoFim;
	}

	public void setTempoFim(long tempoFim) {
		this.tempoFim = tempoFim;
	}

	public long getTempoInicio() {
		return tempoInicio;
	}

	public void setTempoInicio(long tempoInicio) {
		this.tempoInicio = tempoInicio;
	}

	@Override
	public void setEstadoAparelho(LigavelEstado estadoTripla) {
		this.estadoTripla = estadoTripla;		
	}

	@Override
	public Ligavel_Potencia getPotenciaAparelho() {
		return potenciaTripla;
	}

	@Override
	public double potenciaMaxima() {
		return potenciaMaxima;
	}

	@Override
	public double potenciaActual() {
		return potenciaActual;
	}



}

package pt.iscte.poo.instalacao.aparelhos;

import java.util.ArrayList;

import org.json.simple.JSONObject;

import pt.iscte.poo.instalacao.Relogio;
import pt.iscte.poo.instalacao.aparelhos.maq_lavar.Ciclo;
import pt.iscte.poo.instalacao.aparelhos.maq_lavar.Programa;
import pt.iscte.poo.instalacao.enums.MaqLavarRoupaEstado;

public class MaquinaLavarRoupa extends AparelhoPotenciaVariavel {

	//ATTRIBUTES
	private ArrayList<Programa> programas = new ArrayList<Programa>();
	private String programaSelecionado = null;
	private MaqLavarRoupaEstado estado;
	
	//TEMPOS E PROGRAMA
//	private int iterador;
//	private Programa programaActual;
//	private Ciclo cicloActual;

	
	//CONSTRUCTOR
	public MaquinaLavarRoupa(String nome, double potenciaMaxima) {
		super(nome, potenciaMaxima);
		
//		JSONArray tempPrograma = (JSONArray) obj.get("programas");
//		for (Object o : tempPrograma) {
//			JSONObject p = (JSONObject) o;
//			programaSelecionado = null/*p.selecionado()*/;
//			programas.add(new Programa(p));
//			
//		}
	}

	public MaquinaLavarRoupa(JSONObject obj) {
		super(obj);
		
	}
	
	// TOSTRING
	@Override
	public String toString() {
		String toReturn = "";
		toReturn += "\n-> programas: " + this.programas;
		toReturn += "\n-> programaSelecionado: " + this.programaSelecionado;
		toReturn += "\n-> estado: " + this.estado;
		toReturn += "\n";
		return toReturn;
	}
	
	//AUX METHOD
	public long calcDiferenca() {
		long tempoActual = Relogio.getInstanciaUnica().getTempoAtual();
		long diferenca = tempoActual - /* tempo inicial */;
		return diferenca;
	}
	
	//METHOD
	public double potenciaActualMaquina() {
		
//		//CICLO PARA BUSCAR O PROGRAMA CERTO
//		for (Programa programa : programas) {
//			if (programa.getId().equals(programaSelecionado)) {
//
//				//TEMPOS
//				long diferenca = calcDiferenca();
//				
//				//CICLO PARA BUSCAR A POTENCIA CERTA
//				iterador = 0;
//				for (int i = 0; i < programa.getCiclos().size(); i++) {
//					if (diferenca < cicloActual.getDuracao()) {
//						return programa.getCiclos().get(iterador).getPotencia();
//					} else {
//						cicloActual = programa.getCiclos().get(iterador++);
//						programaActual.setTempoInicio(Relogio.getInstanciaUnica().getTempoAtual());
//					}
//				}
//			}
//		}
		

		
		//CICLO PARA BUSCAR O PROGRAMA CERTO
		for (Programa programa : programas) {
			if (programa.getId().equals(programaSelecionado)) {
				
				//TEMPOS
				long diferenca = calcDiferenca();
				
				for (Ciclo ciclo : programa.getCiclos()) {
					
					if (diferenca < ciclo.getDuracao()) {
						return ciclo.getPotencia();
					}
				}
			}
		}
		
		return 0.0;
		
	
		//String nome Programa
		//se existir, guardo em Programa
		
		//int tempoInicial
		//Relogio.getInstanciUnica = instanciaActual
		//Ti Tf	
	}
	
	//GETTERS AND SETTERS
	public MaqLavarRoupaEstado getEstado() {
		return estado;
	}

	public void setEstado(MaqLavarRoupaEstado estado) {
		this.estado = estado;
	}

	public ArrayList<Programa> getProgramas() {
		return programas;
	}

	public void setProgramas(ArrayList<Programa> programas) {
		this.programas = programas;
	}

	public String getProgramaSelecionado() {
		return programaSelecionado;
	}

	public void setProgramaSelecionado(String programaSelecionado) {
		this.programaSelecionado = programaSelecionado;
	}

//	public Programa getProgramaActual() {
//		return programaActual;
//	}
//
//	public void setProgramaActual(Programa programaActual) {
//		this.programaActual = programaActual;
//	}
//
//	public Ciclo getCicloActual() {
//		return cicloActual;
//	}
//
//	public void setCicloActual(Ciclo cicloActual) {
//		this.cicloActual = cicloActual;
//	}

}

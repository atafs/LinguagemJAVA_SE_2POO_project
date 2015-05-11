package pt.iscte.poo.instalacao.enums;

import org.json.simple.JSONObject;

import pt.iscte.poo.instalacao.Tomada;
import pt.iscte.poo.instalacao.aparelhos.Computador;
import pt.iscte.poo.instalacao.aparelhos.Frigorifico;
import pt.iscte.poo.instalacao.aparelhos.Lampada;
import pt.iscte.poo.instalacao.aparelhos.LampadaVariavel;
import pt.iscte.poo.instalacao.aparelhos.Ligavel;
import pt.iscte.poo.instalacao.aparelhos.MaquinaLavarRoupa;
import pt.iscte.poo.instalacao.aparelhos.MicroOndas;
import pt.iscte.poo.instalacao.aparelhos.Torradeira;
import pt.iscte.poo.instalacao.aparelhos.Tripla;

public enum Ligavel_Tipo {
	LAMPADAVARIAVEL("lampadaVariavel"), MAQLAVARROUPA("maqLavarRoupa"), TRIPLA("tripla"), COMPUTADOR("computador"), FRIGORIFICO("frigorifico"), LAMPADA("lampada"), MICROONDAS("microOndas"), TORRADEIRA("torradeira"), OTHERS("porCriar");;
	
	// ATTRIBUTES
	private String text;
	private static Ligavel_Potencia novoAparelhoPotencia;
	
	// CONSTRUCTOR
	private Ligavel_Tipo(String text) {
		this.text = text;
	}

	// TOSTRING
	@Override
	public String toString() {
		String toReturn = "";
		toReturn += "= " + text;
		return toReturn;
	}
	
	// STATIC METHOD (from the class, not the instance)
	/** Seleccao o tipo de potencia do novo aparelho (fixa ou variavel) */
	public static double selecionaNovoAparelhoPotencia(JSONObject obj) {
		//POWER 
		double potencia = -1;
		
		if(obj.get(Ligavel_Potencia.POTENCIA.toString()) != null) {
			potencia = (double)(obj.get(Ligavel_Potencia.POTENCIA.toString()));
			novoAparelhoPotencia = Ligavel_Potencia.POTENCIA;
			//System.out.println(potencia);
		}
		
		if(obj.get(Ligavel_Potencia.POTENCIA_MAXIMA.toString()) != null) {
			potencia = (double)obj.get(Ligavel_Potencia.POTENCIA_MAXIMA.toString());
			novoAparelhoPotencia = Ligavel_Potencia.POTENCIA_MAXIMA;
			//System.out.println(potencia);
		}
		return potencia;
	}
	
	// STATIC METHOD (from the class, not the instance)
	/** Seleccao do novo aparelho */
	public static Ligavel selecionaNovoAparelho(JSONObject obj) {

		//JSONObject attributes
		String tipo = (String) obj.get("tipo");
		String id = (String) obj.get("id");
		double potencia = selecionaNovoAparelhoPotencia(obj);
		
		
		// .toUpperCase() lets you select type and still match
		String tipoUpperCase = tipo.toUpperCase();
		try {
			// Enum.valueOf() throws an exception if the input is not valid
			Ligavel_Tipo novo = Ligavel_Tipo.valueOf(tipoUpperCase);

			switch (novo) {
			case LAMPADAVARIAVEL:
				LampadaVariavel lampadaVariavel = new LampadaVariavel(id, potencia);	
				lampadaVariavel.setEstadoAparelho(LigavelEstado.DESLIGA);
				lampadaVariavel.setTipoAparelho(novo);
				lampadaVariavel.setPotenciaAparelho(novoAparelhoPotencia);
				return lampadaVariavel;
				
			case MAQLAVARROUPA:
				MaquinaLavarRoupa maqLavarRoupa = new MaquinaLavarRoupa(id, potencia);
				maqLavarRoupa.setEstadoAparelho(LigavelEstado.DESLIGA);
				maqLavarRoupa.setTipoAparelho(novo);
				maqLavarRoupa.setPotenciaAparelho(novoAparelhoPotencia);
				return maqLavarRoupa;
				
			case TRIPLA:
				int nTomadas = (int)(long) obj.get("nTomadas");
				Tripla tripla = new Tripla(id, potencia, nTomadas);
				tripla.setEstadoAparelho(LigavelEstado.DESLIGA);
				tripla.setTipoTripla(novo);
				tripla.setPotenciaTripla(novoAparelhoPotencia);
				return tripla;
			
			case COMPUTADOR:
				Computador computador = new Computador(id, potencia);
				computador.setEstadoAparelho(LigavelEstado.DESLIGA);
				computador.setTipoAparelho(novo);
				computador.setPotenciaAparelho(novoAparelhoPotencia);
				return computador;
				
			case FRIGORIFICO:
				Frigorifico frigorifico = new Frigorifico(id, potencia);
				frigorifico.setEstadoAparelho(LigavelEstado.DESLIGA);
				frigorifico.setTipoAparelho(novo);
				frigorifico.setPotenciaAparelho(novoAparelhoPotencia);
				return frigorifico;
				
			case LAMPADA:
				Lampada lampada = new Lampada(id, potencia);
				lampada.setEstadoAparelho(LigavelEstado.DESLIGA);
				lampada.setTipoAparelho(novo);
				lampada.setPotenciaAparelho(novoAparelhoPotencia);
				return lampada;
				
			case MICROONDAS:
				MicroOndas microOndas =  new MicroOndas(id, potencia);
				microOndas.setEstadoAparelho(LigavelEstado.DESLIGA);
				microOndas.setTipoAparelho(novo);
				microOndas.setPotenciaAparelho(novoAparelhoPotencia);
				return microOndas;
				
			case TORRADEIRA:
				Torradeira torradeira = new Torradeira(id, potencia);
				torradeira.setEstadoAparelho(LigavelEstado.DESLIGA);
				torradeira.setTipoAparelho(novo);
				torradeira.setPotenciaAparelho(novoAparelhoPotencia);
				return torradeira;
				
			case OTHERS:
				return null;
			}
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
			//System.out.println("Invalid color selection!");
		}
		return null;
	}
}

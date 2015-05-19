package pt.iscte.poo.instalacao.enums;

import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import pt.iscte.poo.instalacao.Aparelho;
import pt.iscte.poo.instalacao.Ligavel;
import pt.iscte.poo.instalacao.aparelhos.Computador;
import pt.iscte.poo.instalacao.aparelhos.Frigorifico;
import pt.iscte.poo.instalacao.aparelhos.Lampada;
import pt.iscte.poo.instalacao.aparelhos.LampadaVariavel;
import pt.iscte.poo.instalacao.aparelhos.MaquinaLavarRoupa;
import pt.iscte.poo.instalacao.aparelhos.MicroOndas;
import pt.iscte.poo.instalacao.aparelhos.Torradeira;
import pt.iscte.poo.instalacao.aparelhos.Tripla;
import pt.iscte.poo.instalacao.aparelhos.maq_lavar.Ciclo;
import pt.iscte.poo.instalacao.aparelhos.maq_lavar.Programa;

public enum Ligavel_Tipo {
	LAMPADAVARIAVEL("lampadaVariavel"), MAQLAVARROUPA("maqLavar"), TRIPLA("tripla"), COMPUTADOR("computador"), FRIGORIFICO("frigorifico"), LAMPADA("lampada"), MICROONDAS("microOndas"), TORRADEIRA("torradeira"), OTHERS("porCriar");;
	
	// ATTRIBUTES
	private String text;
	private static Ligavel_Potencia novoAparelhoPotencia;
	
	//LISTS
	private static List<Aparelho> listAparelhos = new ArrayList<Aparelho>();
	private static List<Tripla> listTriplas = new ArrayList<Tripla>();
	
	// CONSTRUCTOR
	private Ligavel_Tipo(String text) {
		this.text = text;
	}

	// TOSTRING
	@Override
	public String toString() {
		String toReturn = "";
		toReturn += text;
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
				lampadaVariavel.setPotenciaActual(potencia);
				lampadaVariavel.setPotenciaAparelho(novoAparelhoPotencia);
				
				listAparelhos.add(lampadaVariavel);
				return lampadaVariavel;
				
			case MAQLAVARROUPA:
				MaquinaLavarRoupa maqLavarRoupa = new MaquinaLavarRoupa(id, potencia);
				
				// NOVO PROGRAMA
				JSONArray programas = (JSONArray) obj.get("programas");
				for(Object object: programas) {
					JSONObject obj1 = (JSONObject) object;
					
					//ADDICIONA 
					String id1 = (String)obj1.get("id");
					Programa programa = new Programa(id1);
					
					JSONArray ciclos = (JSONArray) obj1.get("ciclos");
					
					// NOVO CICLO
					for (Object object1 : ciclos) {
						JSONObject obj2 = (JSONObject) object1;
						
						int duracao = (int)(long)obj2.get("duracao");
						double potencia2 = (double)obj2.get("potencia");
						
						//ADDICIONA 
						Ciclo ciclo = new Ciclo(duracao, potencia2);
						programa.getCiclos().add(ciclo);
					}
					maqLavarRoupa.getProgramas().add(programa);
				}
				
//				//TO DELETE
//				 System.out.println("----------------PRINT_08_PROGRAMA------------------");
//				 for (Programa programa : maqLavarRoupa.getProgramas()) {
//					 System.err.println(programa.toString());
//				 }
				
				maqLavarRoupa.setEstadoAparelho(LigavelEstado.DESLIGA);
				maqLavarRoupa.setTipoAparelho(novo);
				maqLavarRoupa.setPotenciaAparelho(novoAparelhoPotencia);
				
				listAparelhos.add(maqLavarRoupa);
				return maqLavarRoupa;
				
			case TRIPLA:
				int nTomadas = (int)(long) obj.get("nTomadas");
				Tripla tripla = new Tripla(id, potencia, nTomadas);
				tripla.setEstadoAparelho(LigavelEstado.DESLIGA);
				tripla.setTipoAparelho(novo);
				tripla.setPotenciaAparelho(novoAparelhoPotencia);
				
				listTriplas.add(tripla);
				return tripla;
			
			case COMPUTADOR:
				Computador computador = new Computador(id, potencia);
				computador.setEstadoAparelho(LigavelEstado.DESLIGA);
				computador.setTipoAparelho(novo);
				computador.setPotenciaActual(potencia);
				computador.setPotenciaAparelho(novoAparelhoPotencia);
				
				listAparelhos.add(computador);
				return computador;
				
			case FRIGORIFICO:
				Frigorifico frigorifico = new Frigorifico(id, potencia);
				frigorifico.setEstadoAparelho(LigavelEstado.DESLIGA);
				frigorifico.setTipoAparelho(novo);
				frigorifico.setPotenciaActual(potencia);
				frigorifico.setPotenciaAparelho(novoAparelhoPotencia);
				
				listAparelhos.add(frigorifico);
				return frigorifico;
				
			case LAMPADA:
				Lampada lampada = new Lampada(id, potencia);
				lampada.setEstadoAparelho(LigavelEstado.DESLIGA);
				lampada.setTipoAparelho(novo);
				lampada.setPotenciaActual(potencia);
				lampada.setPotenciaAparelho(novoAparelhoPotencia);
				
				listAparelhos.add(lampada);
				return lampada;
				
			case MICROONDAS:
				MicroOndas microOndas =  new MicroOndas(id, potencia);
				microOndas.setEstadoAparelho(LigavelEstado.DESLIGA);
				microOndas.setTipoAparelho(novo);
				microOndas.setPotenciaActual(potencia);
				microOndas.setPotenciaAparelho(novoAparelhoPotencia);
				
				listAparelhos.add(microOndas);
				return microOndas;
				
			case TORRADEIRA:
				Torradeira torradeira = new Torradeira(id, potencia);
				torradeira.setEstadoAparelho(LigavelEstado.DESLIGA);
				torradeira.setTipoAparelho(novo);
				torradeira.setPotenciaActual(potencia);
				torradeira.setPotenciaAparelho(novoAparelhoPotencia);
				
				listAparelhos.add(torradeira);
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
	
	//GETTERS AND SETTERS
	public static List<Aparelho> getListAparelhos() {
		return listAparelhos;
	}

	public static List<Tripla> getListTriplas() {
		return listTriplas;
	}

}

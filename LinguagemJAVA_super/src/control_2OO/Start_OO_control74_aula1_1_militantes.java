package control_2OO;

import java.util.ArrayList;

import pt.progJava.americoLib.control74_aula1_1.Militante;
import pt.progJava.americoLib.control74_aula1_1.Partido;

public class Start_OO_control74_aula1_1_militantes {

	public static void main(String[] args) {

		//addicionar militantes na Collection
		ArrayList<Militante> militantes = new ArrayList<Militante>();
		
		for (int i = 1; i <= 10; i++) {
			Militante militante = new Militante("Americo" + i, 2014, "Sintra");
			militante.setNumero(i);
			militantes.add(militante);
			System.out.println(militantes.toString());
		}
		
		System.out.println("\n");
		System.out.println(militantes.toString());
		
		
		//depois criar o Partido
		Partido partido = new Partido("ISCTE PARTIDO", militantes);
		
		//addicionar militantes
		for (int i = 11; i <= 14; i++) {
			Militante militante = new Militante("Tomas" + i, 2013, "Cascais");
			militante.setNumero(i);
			militantes.add(militante);
		}
		
		System.out.println("\n");
		System.out.println(militantes.toString());
		
		//use methods
		partido.adequaNumeroMilitantes();
		
		partido.retiraMilitante(1);
		System.out.println("\n");
		System.out.println(militantes.toString());
		
		//prints
		System.out.println("\n");
		System.out.println(partido.toString());
		System.out.println("Nome do PARTIDO: " + partido.getNomePartido());
		System.out.println("Numero MINIMO de Habitantes: " + partido.verificaNumeroMilitantesMinimo());
		
		
	}
}



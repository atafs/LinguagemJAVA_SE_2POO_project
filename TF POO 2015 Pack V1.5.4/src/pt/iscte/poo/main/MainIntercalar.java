package pt.iscte.poo.main;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import pt.iscte.poo.instalacao.Aparelho;
import pt.iscte.poo.instalacao.Instalacao;
import pt.iscte.poo.instalacao.Relogio;
import pt.iscte.poo.instalacao.aparelhos.Computador;
import pt.iscte.poo.instalacao.aparelhos.Frigorifico;
import pt.iscte.poo.instalacao.aparelhos.Lampada;
import pt.iscte.poo.instalacao.aparelhos.MicroOndas;
import pt.iscte.poo.instalacao.aparelhos.Torradeira;

public class MainIntercalar {
	
	private static final int END_T = 1000;

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		Instalacao casa = Instalacao.getInstanciaUnica();
		casa.novaLinha("cozinha", 10); // Linha cozinha, 10 tomadas
		casa.novaLinha("quartos", 4); // Linha quartos, 4 tomadas
		casa.novaLinha("sala", 6); // Linha sala, 6 tomadas
		
//		 //TO DELETE: TESTS.
//		 for (Linha linha : casa.getListLinhas()) {
//			 System.out.println("NOME -> " + linha.getNome() + ", TOMADAS -> " +  linha.getListaTomadas().size());
//		 }

		Lampada lamp1 = new Lampada("lamp1", 20); // Lâmpada simples, 20W
		casa.ligaAparelhoATomadaLivre("cozinha", lamp1); // Liga aparelho a uma tomada livre na linha "cozinha"
		
//		 //TO DELETE
//		Lampada lampX = new Lampada("lampX", 40); // Lâmpada simples, 20W
//		System.out.println("NOME: " + casa.getListLinhas().get(0).getNome() + "; POTENCIA NA LINHA: " + casa.potenciaNaLinha(casa.getListLinhas().get(0).getNome()));
//		casa.ligaAparelhoATomadaLivre("cozinha", lampX); // Liga aparelho a uma tomada livre na linha "cozinha"
//		 for (Linha linha : casa.getListLinhas()) {
//			 int i = 0;
//			 System.out.println(linha.getListaTomadas().get(i).toString());
//			 i++;
//		 }
		
		int t = 0;
		System.out.println("t = " + t);
		System.out.println(casa); // Imprime estado da casa (tempo + consumo por linha)
		
		for (; t != END_T / 4; t++) {
			Relogio.getInstanciaUnica().tique(); // Avança uma unidade de tempo	
		}

		lamp1.liga(); // Acende a lâmpada
		
//		 //TO DELETE
//		lampX.liga(); // Acende a lâmpada
//		System.err.println("NOME: " + casa.getListLinhas().get(0).getNome() + "; POTENCIA NA LINHA: " + casa.potenciaNaLinha(casa.getListLinhas().get(0).getNome()));
//		System.err.println("TEMPO=" + t);
//		for (Linha linha : casa.getListLinhas()) {
//			int i = 0;
//			System.err.println(linha.getListaTomadas().get(i).toString());
//			i++;
//		}
		 
		System.out.println("t = " + t);
		System.out.println(casa);
		
		for (; t != END_T / 2; t++) {
			Relogio.getInstanciaUnica().tique();
		}

		Torradeira torradeira = new Torradeira("torradeira1", 500); // Cria torradeira
		casa.ligaAparelhoATomadaLivre("cozinha", torradeira); // Liga a tomada livre
		torradeira.liga(); // Liga a torradeira (On)
		
//		 //TO DELETE
//		System.out.println("TEMPO=" + t);
//		 for (Linha linha : casa.getListLinhas()) {
//			 System.out.println(linha.getListaTomadas().get(0).toString());
//		 }
		
		JSONParser json = new JSONParser();
		JSONObject obj = null;
		try {
			obj = (JSONObject)json.parse(new BufferedReader(new FileReader("frigorifico.json")));
			Frigorifico frigo = (Frigorifico) Aparelho.novoAparelho(obj);

			obj = (JSONObject)json.parse(new BufferedReader(new FileReader("computador.json")));
			Computador computador = (Computador) Aparelho.novoAparelho(obj);
		
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		Lampada lamp2 = new Lampada("lamp2", 30);
		casa.ligaAparelhoATomadaLivre("cozinha", lamp2);
		lamp2.liga();
		
		Lampada lamp3 = new Lampada("lamp3", 40);
		casa.ligaAparelhoATomadaLivre("quartos", lamp3);
		lamp3.liga();
		
//		 //TO DELETE
//		System.out.println("TEMPO=" + t);
//		 for (Linha linha : casa.getListLinhas()) {
//			 System.out.println(linha.getListaTomadas().get(0).toString());
//		 }
		
		System.out.println("t = " + t);
		System.out.println(casa);
		
		for (; t != 3 * END_T / 4; t++) {
			Relogio.getInstanciaUnica().tique();
		}

		torradeira.desliga();
		
		MicroOndas microOndas = new MicroOndas("microOndas", 900); // Cria micro-ondas, com 900W de potência máxima
		casa.ligaAparelhoATomadaLivre("cozinha", microOndas);
		microOndas.aumenta(500); // Regula a potência a que vai cozinhar
		
		lamp2.desliga(); // desliga lâmpada
		System.out.println(casa);
		
		for (; t != END_T; t++) {
			Relogio.getInstanciaUnica().tique();
		}
		
		microOndas.liga(); // Liga micro-ondas
		
//		 //TO DELETE
//		System.out.println("TEMPO=" + t);
//		 for (Linha linha : casa.getListLinhas()) {
//			 System.out.println(linha.getListaTomadas().get(0).toString());
//		 }
		 
		System.out.println("t = " + t);
		System.out.println(casa);
	}
}

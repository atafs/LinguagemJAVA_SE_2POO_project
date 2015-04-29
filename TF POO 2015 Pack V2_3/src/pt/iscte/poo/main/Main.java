package pt.iscte.poo.main;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import javax.swing.JOptionPane;

import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import pt.iscte.poo.graficos.Chart;
import pt.iscte.poo.instalacao.Aparelho;
import pt.iscte.poo.instalacao.Instalacao;
import pt.iscte.poo.instalacao.Linha;
import pt.iscte.poo.instalacao.aparelhos.Ligavel;

public class Main {

	//MAIN ;-)
	public static void main(String[] args) {
		JSONParser json = new JSONParser();
		try {
			Instalacao instalacao = Instalacao.getInstanciaUnica(); 
			
			Chart grafico = new Chart("Potencia por linha");
			
			//TO CREATE
			instalacao.addObserver(grafico);

			JSONArray objectos = (JSONArray) json.parse(new BufferedReader(new FileReader("instalacao.json")));
			instalacao.init(objectos);
			
			JSONArray listaAparelhos = (JSONArray) json.parse(new BufferedReader(new FileReader("aparelhos.json")));
			List<Ligavel> aparelhos = instalacao.lerAparelhos(listaAparelhos);
			
//			//TO DELETE
//			for (Ligavel ligavel : aparelhos) {
//				System.out.println(ligavel.toString());
//			}
			
			JSONArray listaLigacoes = (JSONArray) json.parse(new BufferedReader(new FileReader("ligacoes.json")));
			instalacao.lerLigacoes(listaLigacoes, aparelhos);	
			
			//TO DELETE
			for (Linha linha : instalacao.getListLinhas()) {
				System.out.println(linha.toString());
			}
			
			JSONArray listaEventos = (JSONArray) json.parse(new BufferedReader(new FileReader("eventos.json")));
			//TO CREATE
			instalacao.lerEventos(listaEventos);
			
			long fim = Long.valueOf(JOptionPane.showInputDialog("Please enter the end time"));
			
			grafico.setVisible(true);
			instalacao.simula(fim);
			
			//TO DELETE
			System.err.println("END WITH SUCCESS!!!");

		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();		
		}
		
	}

	


}
